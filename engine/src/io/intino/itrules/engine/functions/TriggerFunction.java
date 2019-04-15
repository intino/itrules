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

package io.intino.itrules.engine.functions;

import io.intino.itrules.Function;
import io.intino.itrules.engine.Trigger;

public final class TriggerFunction implements Function {

    @Override
    public boolean match(Trigger trigger, String parameter) {
        return matchMark(trigger.mark().name(), parameter) || matchOptions(trigger.mark().options(), parameter);
    }

    private boolean matchMark(String mark, String parameter) {
        return mark.equalsIgnoreCase(parameter);
    }

    private boolean matchOptions(String[] options, String parameter) {
        for (String option : options)
            if (matchOption(option, parameter)) return true;
        return false;
    }

    private boolean matchOption(String option, String parameter) {
        return option.equalsIgnoreCase(parameter);
    }
}
