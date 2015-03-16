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

package org.siani.itrules;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.model.Rule;
import org.siani.itrules.model.Token;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

public final class JsonRulesReader implements RulesReader {


	private final InputStream stream;

	public JsonRulesReader(InputStream stream) {
		this.stream = stream;
	}

	public static RuleSet read(InputStream inputStream) {
		return new JsonRulesReader(inputStream).read();
	}

	private static ByteArrayInputStream StringToInputStream(String rules) {
		return new ByteArrayInputStream(rules.getBytes(StandardCharsets.UTF_8));
	}

	@Override
	public RuleSet read() {
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(Token.class, new TokenAdapter());
		List<Rule> rules = gb.create().fromJson(new InputStreamReader(stream), getType());
		return new RuleSet(rules.toArray(new Rule[rules.size()]));
	}


	private static Type getType() {
		return new TypeToken<Collection<Rule>>() {
		}.getType();
	}

	private static class TokenAdapter implements JsonDeserializer<Token> {
		@Override
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
