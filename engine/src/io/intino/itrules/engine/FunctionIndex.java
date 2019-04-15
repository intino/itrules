/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of itrules Project
 *
 * itrules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * itrules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.engine;

import io.intino.itrules.engine.functions.AttributeFunction;
import io.intino.itrules.engine.functions.TriggerFunction;
import io.intino.itrules.engine.functions.TypeFunction;
import io.intino.itrules.Function;
import io.intino.itrules.model.Condition;

import java.util.HashMap;
import java.util.Map;

public final class FunctionIndex {

    private Map<String, Function> map = new HashMap<>();

    public FunctionIndex() {
        add("Type", new TypeFunction());
        add("Trigger", new TriggerFunction());
        add("Attribute", new AttributeFunction());
        add("Primitive", primitiveFunction());
    }


    public Function get(Condition condition) {
        return exists(condition.name()) ? createFunction(condition) : unknownFunction(condition);
    }

    private Function createFunction(Condition condition) {
        Function function = map.get(condition.name().toLowerCase());
        return condition.negated() ? negatedFunction(function) : function;
    }

    private boolean exists(String function) {
        return map.containsKey(function.toLowerCase());
    }

    private Function negatedFunction(final Function function) {
        return (trigger, parameter) -> !function.match(trigger, parameter);
    }

    private Function unknownFunction(final Condition condition) {
        throw new RuntimeException("Function " + condition.name() + " doesn't exists");
    }

    private Function primitiveFunction() {
        return (trigger, parameter) -> trigger.frame().isPrimitive();
    }

    public void add(String name, Function function) {
        map.put(name.toLowerCase(), function);
    }
}
