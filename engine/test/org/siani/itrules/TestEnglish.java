package org.siani.itrules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.siani.itrules.engine.formatters.inflectors.EnglishInflector;

import static org.junit.Assert.assertEquals;


public class TestEnglish {

    private EnglishInflector inflector;

    @Before
    public void setUp() {
        inflector = new EnglishInflector();
    }

    @Test
    public void testNouns() throws Exception {
        assertEquals("cars", plural("car"));
        assertEquals("houses", plural("house"));
        assertEquals("books", plural("book"));
        assertEquals("birds", plural("bird"));
        assertEquals("pencils", plural("pencil"));

    }
    @Test
    public void endingInSS() throws Exception {
        assertEquals("kisses", plural("kiss"));
        assertEquals("bosses", plural("boss"));
        assertEquals("addresses", plural("address"));
        assertEquals("classes", plural("class"));
        assertEquals("dresses", plural("dress"));

    }

    @Test
    public void endingInSH() throws Exception {
        assertEquals("whishes", plural("whish"));
        assertEquals("fishes", plural("fish"));
        assertEquals("brushes", plural("brush"));
        assertEquals("flashes", plural("flash"));
    }

    @Test
    public void endingInCH() throws Exception {
        assertEquals("matches", plural("match"));
        assertEquals("beaches", plural("beach"));
        assertEquals("clutches", plural("clutch"));
        assertEquals("peaches", plural("peach"));
        assertEquals("inches", plural("inch"));
        assertEquals("branches", plural("branch"));
        assertEquals("speeches", plural("speech"));
    }

    @Test
    public void endingInX() throws Exception {
        assertEquals("foxes", plural("fox"));
        assertEquals("boxes", plural("box"));
        assertEquals("suffixes", plural("suffix"));
        assertEquals("prefixes", plural("prefix"));
    }

    @Test
    public void endingInZZ() throws Exception {
        assertEquals("buzzes", plural("buzz"));
    }

    @Test
    public void endingInVowelY() throws Exception {
        assertEquals("boys", plural("boy"));
        assertEquals("holidays", plural("holiday"));
        assertEquals("keys", plural("key"));
        assertEquals("guys", plural("guy"));
    }

    @Test
    public void endingInConsonantY() throws Exception {
        assertEquals("parties", plural("party"));
        assertEquals("ladies", plural("lady"));
        assertEquals("stories", plural("story"));
        assertEquals("nannies", plural("nanny"));
        assertEquals("cities", plural("city"));
    }

    @Test
    public void endingInFE() throws Exception {
        assertEquals("lives", plural("life"));
        assertEquals("wives", plural("wife"));
    }

    @Test
    public void endingInF() throws Exception {
        assertEquals("leaves", plural("leaf"));
        assertEquals("thieves", plural("thief"));
    }

    @Test
    public void endingInIs() throws Exception {
        assertEquals("analyses", plural("analysis"));
        assertEquals("bases", plural("basis"));
        assertEquals("crises", plural("crisis"));
    }

    @Test
    public void endingInO() throws Exception {
        assertEquals("potatoes", plural("potato"));
        assertEquals("echoes", plural("echo"));
        assertEquals("tomatoes", plural("tomato"));
        assertEquals("heroes", plural("hero"));
        assertEquals("torpedoes", plural("torpedo"));
        assertEquals("mosquitos", plural("mosquito"));
   }

    @Test
    public void irregular() throws Exception {
        assertEquals("men", plural("man"));
        assertEquals("women", plural("woman"));
        assertEquals("children", plural("child"));
        assertEquals("feet", plural("foot"));
        assertEquals("teeth", plural("tooth"));
        assertEquals("geese", plural("goose"));
        assertEquals("mice", plural("mouse"));
        assertEquals("sheep", plural("sheep"));
        assertEquals("deer", plural("deer"));
        assertEquals("moose", plural("moose"));
        assertEquals("aircraft", plural("aircraft"));
    }

    @Test
    public void testReward() throws Exception {
        assertEquals("ants", plural("ant"));
        assertEquals("locks", plural("lock"));
        assertEquals("bananas", plural("banana"));
        assertEquals("magazines", plural("magazine"));
        assertEquals("bicycles", plural("bicycle"));
        assertEquals("mongooses", plural("mongoose"));
        assertEquals("cows", plural("cow"));
        assertEquals("noses", plural("nose"));
        assertEquals("daughters", plural("daughter"));
        assertEquals("oranges", plural("orange"));
        assertEquals("eggs", plural("egg"));
        assertEquals("pictures", plural("picture"));
        assertEquals("flowers", plural("flower"));
        assertEquals("roses", plural("rose"));
        assertEquals("grapes", plural("grape"));
        assertEquals("spoonfuls", plural("spoonful"));
        assertEquals("humans", plural("human"));
        assertEquals("toys", plural("toy"));
        assertEquals("jugs", plural("jug"));
        assertEquals("vases", plural("vase"));
        assertEquals("kings", plural("king"));
        assertEquals("wells", plural("well"));
        assertEquals("addresses", plural("address"));
        assertEquals("fishes", plural("fish"));
        assertEquals("batches", plural("batch"));
        assertEquals("inches", plural("inch"));
        assertEquals("beaches", plural("beach"));
        assertEquals("itches", plural("itch"));
        assertEquals("bosses", plural("boss"));
        assertEquals("kisses", plural("kiss"));
        assertEquals("boxes", plural("box"));
        assertEquals("lenses", plural("lens"));
        assertEquals("branches", plural("branch"));
        assertEquals("lunches", plural("lunch"));
        assertEquals("brushes", plural("brush"));
        assertEquals("matches", plural("match"));
        assertEquals("buses", plural("bus"));
        assertEquals("minuses", plural("minus"));
        assertEquals("buzzes", plural("buzz"));
        assertEquals("patches", plural("patch"));
        assertEquals("catches", plural("catch"));
        assertEquals("peaches", plural("peach"));
        assertEquals("churches", plural("church"));
        assertEquals("pluses", plural("plus"));
        assertEquals("classes", plural("class"));
        assertEquals("prefixes", plural("prefix"));
        assertEquals("clutches", plural("clutch"));
        assertEquals("prospectuses", plural("prospectus"));
        assertEquals("coaches", plural("coach"));
        assertEquals("quizzes", plural("quiz"));
        assertEquals("complexes", plural("complex"));
        assertEquals("sixes", plural("six"));
        assertEquals("crosses", plural("cross"));
        assertEquals("slashes", plural("slash"));
        assertEquals("dishes", plural("dish"));
        assertEquals("speeches", plural("speech"));
        assertEquals("dresses", plural("dress"));
        assertEquals("suffixes", plural("suffix"));
        assertEquals("eyelashes", plural("eyelash"));
        assertEquals("taxes", plural("tax"));
        assertEquals("flashes", plural("flash"));
        assertEquals("thrushes", plural("thrush"));
        assertEquals("foxes", plural("fox"));
        assertEquals("viruses", plural("virus"));
        assertEquals("gases", plural("gas"));
        assertEquals("watches", plural("watch"));
        assertEquals("glasses", plural("glass"));
        assertEquals("wishes", plural("wish"));
        assertEquals("armies", plural("army"));
        assertEquals("enemies", plural("enemy"));
        assertEquals("babies", plural("baby"));
        assertEquals("fairies", plural("fairy"));
        assertEquals("beauties", plural("beauty"));
        assertEquals("families", plural("family"));
        assertEquals("berries", plural("berry"));
        assertEquals("ladies", plural("lady"));
        assertEquals("cherries", plural("cherry"));
        assertEquals("libraries", plural("library"));
        assertEquals("cities", plural("city"));
        assertEquals("nappies", plural("nappy"));
        assertEquals("countries", plural("country"));
        assertEquals("skies", plural("sky"));
        assertEquals("cries", plural("cry"));
        assertEquals("spies", plural("spy"));
        assertEquals("curries", plural("curry"));
        assertEquals("stories", plural("story"));
        assertEquals("diaries", plural("diary"));
        assertEquals("strawberries", plural("strawberry"));
        assertEquals("discoveries", plural("discovery"));
        assertEquals("territories", plural("territory"));
        assertEquals("duties", plural("duty"));
        assertEquals("theories", plural("theory"));
        assertEquals("alloys", plural("alloy"));
        assertEquals("joys", plural("joy"));
        assertEquals("bays", plural("bay"));
        assertEquals("keys", plural("key"));
        assertEquals("boys", plural("boy"));
        assertEquals("kidneys", plural("kidney"));
        assertEquals("chimneys", plural("chimney"));
        assertEquals("monkeys", plural("monkey"));
        assertEquals("days", plural("day"));
        assertEquals("plays", plural("play"));
        assertEquals("decoys", plural("decoy"));
        assertEquals("rays", plural("ray"));
        assertEquals("delays", plural("delay"));
        assertEquals("toys", plural("toy"));
        assertEquals("donkeys", plural("donkey"));
        assertEquals("trays", plural("tray"));
        assertEquals("guys", plural("guy"));
        assertEquals("trolleys", plural("trolley"));
        assertEquals("jerseys", plural("jersey"));
        assertEquals("valleys", plural("valley"));
        assertEquals("journeys", plural("journey"));
        assertEquals("ways", plural("way"));
        assertEquals("beeves", plural("beef"));
        assertEquals("loaves", plural("loaf"));
        assertEquals("calves", plural("calf"));
        assertEquals("selves", plural("self"));
        assertEquals("halves", plural("half"));
        assertEquals("sheaves", plural("sheaf"));
        assertEquals("housewives", plural("housewife"));
        assertEquals("shelves", plural("shelf"));
        assertEquals("knives", plural("knife"));
        assertEquals("thieves", plural("thief"));
        assertEquals("leaves", plural("leaf"));
        assertEquals("wives", plural("wife"));
        assertEquals("lives", plural("life"));
        assertEquals("wolves", plural("wolf"));
        assertEquals("bamboos", plural("bamboo"));
        assertEquals("ratios", plural("ratio"));
        assertEquals("casinos", plural("casino"));
        assertEquals("scenarios", plural("scenario"));
        assertEquals("commandos", plural("commando"));
        assertEquals("silos", plural("silo"));
        assertEquals("discos", plural("disco"));
        assertEquals("shampoos", plural("shampoo"));
        assertEquals("duos", plural("duo"));
        assertEquals("solos", plural("solo"));
        assertEquals("dynamos", plural("dynamo"));
        assertEquals("stereos", plural("stereo"));
        assertEquals("ghettos", plural("ghetto"));
        assertEquals("studios", plural("studio"));
        assertEquals("kangaroos", plural("kangaroo"));
        assertEquals("tattoos", plural("tattoo"));
        assertEquals("kilos", plural("kilo"));
        assertEquals("trios", plural("trio"));
        assertEquals("photos", plural("photo"));
        assertEquals("videos", plural("video"));
        assertEquals("pianos", plural("piano"));
        assertEquals("zeros", plural("zero"));
        assertEquals("radios", plural("radio"));
        assertEquals("zoos", plural("zoo"));
        assertEquals("buffaloes", plural("buffalo"));
        assertEquals("potatoes", plural("potato"));
        assertEquals("echoes", plural("echo"));
        assertEquals("tomatoes", plural("tomato"));
        assertEquals("heroes", plural("hero"));
        assertEquals("torpedoes", plural("torpedo"));
  }

    private String plural(String word) {
        return inflector.plural(word);
    }
}
