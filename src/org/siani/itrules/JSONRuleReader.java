package org.siani.itrules;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.siani.itrules.model.Rule;
import org.siani.itrules.model.Token;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public final class JSONRuleReader implements RuleReader {


	private final InputStream stream;

	public JSONRuleReader(InputStream stream) {
		this.stream = stream;
	}

	@Override
	public Rule[] read() {
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(Token.class, new TokenAdapter());
		List<Rule> rules = gb.create().fromJson(new InputStreamReader(stream), getType());
		return rules.toArray(new Rule[rules.size()]);
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
