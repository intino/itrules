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

package org.siani.itrules.reader.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.model.Rule;
import org.siani.itrules.model.Token;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public final class RuleSetReader implements org.siani.itrules.RuleSetReader {

	private final InputStream stream;

	public RuleSetReader(InputStream stream) {
		this.stream = stream;
	}

	public RuleSet read() {
        return new RuleSet(rules(gsonBuilder()));
    }

    private GsonBuilder gsonBuilder() {
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(Token.class, new TokenAdapter());
        return gb;
    }

    private List<Rule> rules(GsonBuilder gb) {
        return gb.create().fromJson(new InputStreamReader(stream), getType());
    }

    private static Type getType() {
		return new TypeToken<Collection<Rule>>() {
		}.getType();
	}

	private static class TokenAdapter implements JsonDeserializer<Token> {
		public Token deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
			JsonObject jsonObject = json.getAsJsonObject();
			String type = jsonObject.get("tokenType").getAsString();
			JsonElement element = jsonObject.get("data");
			try {
				return context.deserialize(element, Class.forName("org.siani.itrules.model." + type));
			} catch (ClassNotFoundException cnfe) {
				throw new JsonParseException("Unknown element type: " + type, cnfe);
			}
		}
	}
}
