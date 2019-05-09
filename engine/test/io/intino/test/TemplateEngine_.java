package io.intino.test;

import io.intino.itrules.Adapter;
import io.intino.itrules.Formatter;
import io.intino.itrules.RuleSet;
import io.intino.itrules.TemplateEngine;
import io.intino.itrules.TemplateEngine.Configuration;
import io.intino.test.classes.Team;
import io.intino.test.rulesets.PersonRuleSet;
import org.junit.Test;

import java.util.Locale;

import static io.intino.itrules.TemplateEngine.Configuration.LineSeparator.LF;
import static org.assertj.core.api.Assertions.assertThat;

public class TemplateEngine_ {

    @Test
    public void should_render_primitive_values() {
        assertThat(engine(new RuleSet()).render("Hello world")).isEqualTo("Hello world");
        assertThat(engine(new RuleSet()).render(2)).isEqualTo("2");
        assertThat(engine(new RuleSet()).render(2.0)).isEqualTo("2.0");
        assertThat(engine(new RuleSet()).render(Team.Person.Gender.Male)).isEqualTo("Male");
    }

    @Test
    public void should_render_object() {
        assertThat(engine(new PersonRuleSet().basic()).render(Team.Person.create()))
                .isEqualTo("PAU GASOL was born in Spain on 06/07/1980");
    }

    @Test
    public void should_render_object_using_uppercase_rule() {
        assertThat(engine(new PersonRuleSet().uppercase()).render(Team.Person.create()))
                .isEqualTo("Pau Gasol was born in Spain on 06/07/1980");
    }

    @Test
    public void should_render_object_using_unknown_format() {
        assertThat(engine(new PersonRuleSet().customFormat()).render(Team.Person.create()))
                .isEqualTo("Pau gasol was born in Spain on 06/07/1980");
    }

    @Test
    public void should_render_object_using_custom_format() {
        assertThat(engine(new PersonRuleSet().customFormat()).add("custom",customFormat()).render(Team.Person.create()))
                .isEqualTo("Losag uap was born in Niaps on 06/07/1980");
    }

    private Formatter customFormat() {
        return value -> new StringBuilder().append(value).reverse().toString();
    }

    @Test
    public void should_render_object_using_custom_adapter() {
        assertThat(engine(new PersonRuleSet().basic()).add(Team.Person.class, customAdapter()).render(Team.Person.create()))
                .isEqualTo("NONE was born in None on ");
    }

    private Adapter<Team.Person> customAdapter() {
        return (source, context) -> context.add("name", "None").add("country", "None");
    }

    @Test
    public void should_render_object_with_null_attributes() {
        assertThat(engine(new PersonRuleSet().expression()).render(Team.Person.createSimple()))
                .isEqualTo("Pau Gasol was born in ");
    }

    @Test
    public void should_render_object_with_enum() {
        assertThat(engine(new PersonRuleSet().gender()).render(Team.Person.create()))
                .isEqualTo("Pau Gasol is Male");
    }

    @Test
    public void should_render_object_using_conditional_rule() {
        assertThat(engine(new PersonRuleSet().gender().withTriggerRule()).render(Team.Person.create()))
                .isEqualTo("*Pau Gasol* is Male");
    }

    @Test
    public void should_render_object_with_multiple_attributes() {
        assertThat(engine(new PersonRuleSet().withMultipleAttributes()).render(Team.Person.create().withPets()))
                .isEqualTo("Pau Gasol has 3 pets: Toby, Chip, Chop");
    }

    @Test
    public void should_render_object_with_empty_multiple_attributes() {
        assertThat(engine(new PersonRuleSet().withMultipleAttributes()).render(Team.Person.create()))
                .isEqualTo("Pau Gasol has no pets: ");
    }

    @Test
    public void should_render_object_with_empty_multiple_expression() {
        assertThat(engine(new PersonRuleSet().withMultipleExpression()).render(Team.Person.create()))
                .isEqualTo("Pau Gasol has no pets");
    }

    @Test
    public void should_render_object_with_multiple_attributes_using_indented_attribute() {
        assertThat(engine(new PersonRuleSet().withMultipleIndentedAttributes()).render(Team.Person.create().withPets()))
                .isEqualTo("Pau Gasol has 3 pets\n\tToby\n\t\tDog\n\n\tChip\n\t\tCat\n\n\tChop\n\t\tPig");
    }

    @Test
    public void should_render_object_with_multiple_attributes_using_indented_expression() {
        assertThat(engine(new PersonRuleSet().withMultipleIndentedExpression()).render(Team.Person.create().withPets()))
                .isEqualTo("Pau Gasol has 3 pets\n\tToby\n\t\tDog\n\n\tChip\n\t\tCat\n\n\tChop\n\t\tPig");
    }

    @Test
    public void should_render_object_with_empty_multiple_attributes_using_indented_expression() {
        assertThat(engine(new PersonRuleSet().withMultipleIndentedExpression()).render(Team.Person.create()))
                .isEqualTo("Pau Gasol has no pets");
    }

    @Test
    public void should_render_object_with_empty_multiple_attributes_using_nested_expressions() {
        assertThat(engine(new PersonRuleSet().withNestedExpressions()).render(Team.Person.create()))
                .isEqualTo("Pau Gasol");
        assertThat(engine(new PersonRuleSet().withNestedExpressions()).render(Team.Person.create().withPets()))
                .isEqualTo("Pau Gasol\n" +
                        "\tPets\n" +
                        "\t\tToby\n" +
                        "\t\tChip\n" +
                        "\t\tChop\n");
        assertThat(engine(new PersonRuleSet().withNestedExpressions()).render(Team.Person.create().withTeams()))
                .isEqualTo("Pau Gasol\n" +
                        "\tTeams\n" +
                        "\t\tBarcelona\n" +
                        "\t\tLakers\n" +
                        "\t\tBulls\n");
        assertThat(engine(new PersonRuleSet().withNestedExpressions()).render(Team.Person.create().withPets().withTeams()))
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
        assertThat(engine(new PersonRuleSet().dogs()).render(Team.Person.create().withPets()))
                .isEqualTo("Pau Gasol has the following dogs:\n\tToby");
    }

    @Test
    public void should_render_object_filtering_by_negated_attribute() {
        assertThat(engine(new PersonRuleSet().noDogs()).render(Team.Person.create().withPets()))
                .isEqualTo("Pau Gasol is the owner of Chip, Chop");
    }

    @Test
    public void should_render_object_filtering_all_multiple_attributes() {
        assertThat(engine(new PersonRuleSet().dogs()).render(Team.Person.create()))
                .isEqualTo("Pau Gasol has no dogs");
    }

    private TemplateEngine engine(RuleSet ruleSet) {
        return new TemplateEngine(ruleSet, new Configuration(Locale.ENGLISH, LF));
    }



}
