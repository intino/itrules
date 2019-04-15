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

import io.intino.itrules.model.Rule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RuleSet implements Iterable<Rule> {

    private final List<Rule> rules = new ArrayList<>();

    public RuleSet() {
    }

    public RuleSet(List<Rule> rules) {
        this.rules.addAll(0, rules);
    }

    public void add(RuleSet ruleSet) {
        add(ruleSet.rules);
    }

    public void add(List<Rule> rules) {
        this.rules.addAll(0, rules);
    }

    public void add(Rule rule) {
        rules.add(0, rule);
    }

    @Override
    public Iterator<Rule> iterator() {
        return rules.iterator();
    }
}
