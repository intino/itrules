/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.test;

import io.intino.itrules.*;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;
import io.intino.test.classes.Team;
import io.intino.test.rulesets.PersonRuleSets;
import org.junit.Test;

import java.util.List;
import java.util.Locale;

import static io.intino.itrules.template.Template.Configuration.LineSeparator.LF;
import static org.assertj.core.api.Assertions.assertThat;

public class TemplateEngineTest {

	@Test
	public void should_render_primitive_values() {
		assertThat(engine(List.of()).render("Hello world")).isEqualTo("Hello world");
		assertThat(engine(List.of()).render(2)).isEqualTo("2");
		assertThat(engine(List.of()).render(2.0)).isEqualTo("2.0");
		assertThat(engine(List.of()).render(Team.Person.Gender.Male)).isEqualTo("Male");
	}

	@Test
	public void should_render_object() {
		assertThat(engine(PersonRuleSets.basic()).render(Team.Person.create()))
				.isEqualTo("PAU GASOL was born in Spain on 06/07/1980");
	}

	@Test
	public void should_render_object_using_uppercase_rule() {
		assertThat(engine(PersonRuleSets.uppercase()).render(Team.Person.create()))
				.isEqualTo("Pau Gasol was born in Spain on 06/07/1980");
	}

	@Test
	public void should_render_object_using_unknown_format() {
		assertThat(engine(PersonRuleSets.customFormat()).render(Team.Person.create()))
				.isEqualTo("Pau gasol was born in Spain on 06/07/1980");
	}

	@Test
	public void should_render_object_using_custom_format() {
		assertThat(engine(PersonRuleSets.customFormat()).add("custom", customFormat()).render(Team.Person.create()))
				.isEqualTo("Losag uap was born in Niaps on 06/07/1980");
	}

	private Formatter customFormat() {
		return value -> new StringBuilder().append(value).reverse().toString();
	}

	@Test
	public void should_render_object_using_custom_adapter() {
		assertThat(engine(PersonRuleSets.basic()).add(Team.Person.class, customAdapter()).render(Team.Person.create()))
				.isEqualTo("NONE was born in None on ");
	}

	private Adapter<Team.Person> customAdapter() {
		return (source, context) -> context.add("name", "None").add("country", "None");
	}

	@Test
	public void should_render_object_with_null_attributes() {
		assertThat(engine(PersonRuleSets.expression()).render(Team.Person.createSimple()))
				.isEqualTo("Pau Gasol was born in ");
	}

	@Test
	public void should_render_object_with_enum() {
		assertThat(engine(PersonRuleSets.gender()).render(Team.Person.create()))
				.isEqualTo("Pau Gasol is Male");
	}

	@Test
	public void should_render_object_using_conditional_rule() {
		List<Rule> gender = PersonRuleSets.gender();
		gender.addAll(PersonRuleSets.withTriggerRule());
		assertThat(engine(gender).render(Team.Person.create()))
				.isEqualTo("*Pau Gasol* is Male");
	}

	@Test
	public void should_render_object_with_multiple_attributes() {
		assertThat(engine(PersonRuleSets.withMultipleAttributes()).render(Team.Person.create().withPets()))
				.isEqualTo("Pau Gasol has 3 pets: Toby, Chip, Chop");
	}

	@Test
	public void should_render_object_with_empty_multiple_attributes() {
		assertThat(engine(PersonRuleSets.withMultipleAttributes()).render(Team.Person.create()))
				.isEqualTo("Pau Gasol has no pets: ");
	}

	@Test
	public void should_render_object_with_empty_multiple_expression() {
		assertThat(engine(PersonRuleSets.withMultipleExpression()).render(Team.Person.create()))
				.isEqualTo("Pau Gasol has no pets");
	}

	@Test
	public void should_render_object_with_multiple_attributes_using_indented_attribute() {
		assertThat(engine(PersonRuleSets.withMultipleIndentedAttributes()).render(Team.Person.create().withPets()))
				.isEqualTo("Pau Gasol has 3 pets\n\tToby\n\t\tDog\n\n\tChip\n\t\tCat\n\n\tChop\n\t\tPig");
	}

	@Test
	public void should_render_object_with_multiple_attributes_using_indented_expression() {
		assertThat(engine(PersonRuleSets.withMultipleIndentedExpression()).render(Team.Person.create().withPets()))
				.isEqualTo("Pau Gasol has 3 pets\n\tToby\n\t\tDog\n\n\tChip\n\t\tCat\n\n\tChop\n\t\tPig");
	}

	@Test
	public void should_render_object_with_empty_multiple_attributes_using_indented_expression() {
		assertThat(engine(PersonRuleSets.withMultipleIndentedExpression()).render(Team.Person.create()))
				.isEqualTo("Pau Gasol has no pets");
	}

	@Test
	public void should_render_object_with_multiple_attributes_that_matches_to_no_rules() {
		assertThat(engine(PersonRuleSets.withMarkThatMatchesNoRules()).render(Team.Person.create().withPets()))
				.isEqualTo("Pau Gasol has 3 pets");
	}


	@Test
	public void should_render_object_with_empty_multiple_attributes_using_nested_expressions() {
		assertThat(engine(PersonRuleSets.withNestedExpressions()).render(Team.Person.create()))
				.isEqualTo("Pau Gasol");
		assertThat(engine(PersonRuleSets.withNestedExpressions()).render(Team.Person.create().withPets()))
				.isEqualTo("Pau Gasol\n" +
						"\tPets\n" +
						"\t\tToby\n" +
						"\t\tChip\n" +
						"\t\tChop\n");
		assertThat(engine(PersonRuleSets.withNestedExpressions()).render(Team.Person.create().withTeams()))
				.isEqualTo("Pau Gasol\n" +
						"\tTeams\n" +
						"\t\tBarcelona\n" +
						"\t\tLakers\n" +
						"\t\tBulls\n");
		assertThat(engine(PersonRuleSets.withNestedExpressions()).render(Team.Person.create().withPets().withTeams()))
				.isEqualTo("Pau Gasol\n" +
						"\tPets\n" +
						"\t\tToby\n" +
						"\t\tChip\n" +
						"\t\tChop\n" +
						"\tTeams\n" +
						"\t\tBarcelona\n" +
						"\t\tLakers\n" +
						"\t\tBulls\n");
	}

	@Test
	public void should_render_object_filtering_by_attribute() {
		assertThat(engine(PersonRuleSets.dogs()).render(Team.Person.create().withPets()))
				.isEqualTo("Pau Gasol has the following dogs:\n\tToby");
	}

	@Test
	public void should_render_object_filtering_by_negated_attribute() {
		assertThat(engine(PersonRuleSets.noDogs()).render(Team.Person.create().withPets()))
				.isEqualTo("Pau Gasol is the owner of Chip, Chop");
	}

	@Test
	public void should_render_object_filtering_all_multiple_attributes() {
		assertThat(engine(PersonRuleSets.dogs()).render(Team.Person.create()))
				.isEqualTo("Pau Gasol has no dogs");
	}

	private Engine engine(List<Rule> ruleSet) {
		return new Engine(ruleSet, new Template.Configuration(Locale.ENGLISH, LF));
	}


}
