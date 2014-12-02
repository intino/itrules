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

import java.io.InputStream;

import static junit.framework.Assert.assertEquals;

public class BuildingTest {

	@org.junit.Test
	public void testBuilding() throws Exception {
		Frame toRender = new Frame("model") {{
			addFrame("building", new Frame("building") {{
				addFrame("id", "B0001");
				addFrame("area", 230);
				addFrame("town", "01001");
				addFrame("district", "01002");
				addFrame("xCoordinate", 21.0);
				addFrame("yCoordinate", -22.0);
				addFrame("household", new Frame("household") {{
					addFrame("energybox", new Frame("energybox") {{
						addFrame("id", "B0001EB");
					}});
				}});
				addFrame("mockload", new Frame("mockload") {{
					addFrame("id", "B0001ML");
					addFrame("feeder", "Rose De Vents");
				}});
			}});
		}};
		String expected =
			"Building B0001\r\n" +
				"    Area(230)\r\n" +
				"    Place(T01001.D01002)\r\n" +
				"    Location(21.0 -22.0)\r\n" +
				"    Household\r\n" +
				"        EnergyBox B0001EB is Control\r\n" +
				"    GenericDevice B0001ML > is Electrical(from = Source.Power.RoseDeVents.B0001ML)\r\n" +
				"    PowerBus(B0001PB) is Electrical\r\n";
		Document document = new Document();
		createRuleEngine().render(toRender, document);
		assertEquals(expected, document.content());
	}

	public RuleEngine createRuleEngine() {
		RuleEngine ruleEngine;
		ruleEngine = new RuleEngine(new TemplateReader(findResource()));
		ruleEngine.register("SnakeCase", new Formatter() {
			@Override
			public Object format(Object o) {
				return ((String) o).replaceAll("\\W", "_");
			}
		});
		ruleEngine.register("Town", new Formatter() {
			@Override
			public Object format(Object o) {
				return "T" + o;
			}
		});
		ruleEngine.register("District", new Formatter() {
			@Override
			public Object format(Object o) {
				return "D" + o;
			}
		});
		ruleEngine.register("PrefixNumber", new Formatter() {
			@Override
			public Object format(Object o) {
				return ((String) o).replaceAll("^([0-9])", "_$1");
			}
		});
		ruleEngine.register("Building", new Formatter() {
			@Override
			public Object format(Object building) {
				String buildingId = (String) building;
				if (buildingId.startsWith("2020_")) buildingId = buildingId.replace("2020_BATIMENT", "F");
				else buildingId = buildingId.replace("BATIMENT", "B");
				return buildingId.replaceAll("000000000", "");
			}
		});
		ruleEngine.register("Transformer", new Formatter() {
			@Override
			public Object format(Object o) {
				return "T" + o;
			}
		});
		return ruleEngine;
	}

	private InputStream findResource() {
		return this.getClass().getResourceAsStream("/millener.itr");
	}
}
