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

import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.model.Frame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class    NestedInterfaces {
    private static final String FILE_ITR = "/nested_interfaces.itr.json";
    private static final File TEST = new File("res_test", FILE_ITR);

	static {
//		TEST.getParentFile().mkdirs();
	}

	@Test
	public void testNestedInterfaces() throws Exception {
        Document document = new Document();
        RuleEngine ruleEngine = new RuleEngine(JsonRulesReader.read(new FileInputStream(TEST)));
        ruleEngine.render(buildFrame(), document);
        Assert.assertEquals(EXPECTED, document.content());
	}

	private Frame buildFrame() {
		final Frame frame = new Frame("class");
		frame.addFrame("package", "org.sample");
		frame.addFrame("concept", new Frame("concept") {{
			addFrame("name", "Form");
			addFrame("concept", new Frame("concept", "action") {{
				addFrame("name", "Handler");
				addFrame("parent", "org.sample.Handler");
			}});
			addFrame("concept", new Frame("concept") {{
				addFrame("name", "Field");
				addFrame("concept", new Frame("concept", "action") {{
					addFrame("name", "Handler");
					addFrame("parent", "org.sample.Form.Handler");
				}});
			}});
			addFrame("concept", new Frame("concept") {{
				addFrame("name", "TextField");
				addFrame("parent", "Field");
				addFrame("concept", new Frame("concept", "action") {{
					addFrame("name", "Handler");
					addFrame("parent", "org.sample.Form.Handler");
				}});
			}});
		}});
		frame.addFrame("concept", new Frame("concept", "action", "private") {{
			addFrame("name", "Handler");
		}});
		frame.addFrame("concept", new Frame("concept") {{
			addFrame("name", "Collection");
			addFrame("concept", new Frame("concept") {{
				addFrame("name", "Item");
			}});
		}});
		return frame;
	}

	public InputStream getRules() {
		return this.getClass().getResourceAsStream(FILE_ITR);
	}

	public InputStream getJsonRules() {
		try {
			return new FileInputStream(TEST);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static final String EXPECTED = "package org.sample;\n" +
		"\n" +
		"public interface Form {\n" +
		"\n" +
		"    public interface Handler extends org.sample.Handler {\n" +
		"    }\n" +
		"\n" +
		"    public interface Field {\n" +
		"\n" +
		"        public interface Handler extends org.sample.Form.Handler {\n" +
		"        }\n" +
		"    }\n" +
		"\n" +
		"    public interface TextField extends Field {\n" +
		"\n" +
		"        public interface Handler extends org.sample.Form.Handler {\n" +
		"        }\n" +
		"    }\n" +
		"}\n" +
		"\n" +
		"public interface Handler {\n" +
		"}\n";
}
