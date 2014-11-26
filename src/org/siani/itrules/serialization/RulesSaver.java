package org.siani.itrules.serialization;

import com.google.gson.*;
import org.siani.itrules.model.Rule;
import org.siani.itrules.model.Token;

import java.lang.reflect.Type;
import java.text.DateFormat;

public class RulesSaver {

	private RulesSaver() {
	}

	public static String toJSON(Rule[] rules) {
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
