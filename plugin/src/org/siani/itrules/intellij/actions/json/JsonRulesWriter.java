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

package org.siani.itrules.intellij.actions.json;

import com.google.gson.*;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.model.Token;

import java.lang.reflect.Type;
import java.text.DateFormat;

public class JsonRulesWriter {

	private JsonRulesWriter() {
	}

	public static String toJSON(RuleSet rules) {
		GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).setPrettyPrinting();
		gsonBuilder.registerTypeAdapter(Token.class, new TokenAdapter());
		return gsonBuilder.create().toJson(rules);
	}


	private static class TokenAdapter implements JsonSerializer<Token> {
		@Override
		public JsonElement serialize(Token src, Type typeOfSrc, JsonSerializationContext context) {
			JsonObject object = new JsonObject();
			object.add("tokenType", new JsonPrimitive(src.getClass().getSimpleName()));
			object.add("data", context.serialize(src, src.getClass()));
			return object;
		}
	}
}