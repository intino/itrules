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

package org.siani.itrules.formatter;

import java.util.HashMap;
import java.util.Map;

public abstract class Inflector {

    private Map<String, String> irregulars = new HashMap<>();
    private Map<String, String> replaces = new HashMap<>();

    public Inflector() {
        setIrregulars();
        setReplaces();
    }

    public abstract String plural(String word);

    protected abstract void setReplaces();
    protected abstract void setIrregulars();

    protected void addReplace(String from, String to) {
        replaces.put(from, to);
    }

    protected void addIrregular(String from, String to) {
        irregulars.put(from, to);
    }

    protected String doReplaces(String word) {
        for (String ending : replaces.keySet()) {
            if (!word.endsWith(ending)) continue;
            return replaceLast(word, ending);
        }
        return word;
    }

    protected char[] consonants() {
        return "bcdfghjklmnpqrstvwxyz".toCharArray();
    }

    protected boolean isIrregular(String word) {
        return irregulars.containsKey(word);
    }

    protected String irregularPlural(String word) {
        return irregulars.get(word);
    }

    private String replaceLast(String word, String ending) {
        return removeEnding(word, ending) + replaces.get(ending);
    }

    private String removeEnding(String word, String ending) {
        return word.substring(0, word.length() - ending.length());
    }


}
