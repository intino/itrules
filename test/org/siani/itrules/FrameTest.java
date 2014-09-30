package org.siani.itrules;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class FrameTest {

	@Test
	public void testName() throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		String userVar[] = {"a = true", "b = true", "c = false"};
		for (String s : userVar) engine.eval(s);
		String expr = "13>15 & true";
		System.out.println(engine.eval(expr));

	}



}
