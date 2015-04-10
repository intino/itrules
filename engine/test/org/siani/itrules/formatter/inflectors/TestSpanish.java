package org.siani.itrules.formatter.inflectors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestSpanish {

    private SpanishInflector inflector;

    @Before
    public void setUp() {
        inflector = new SpanishInflector();
    }

    @Test
    public void endingInConsonant() {
        assertEquals("Arboles", plural("Arbol"));
        assertEquals("Matrices", plural("Matriz"));
        assertEquals("Climax", plural("Climax"));
        assertEquals("Clanes", plural("Clan"));
        assertEquals("Gafas", plural("Gafas"));
        assertEquals("sesos", plural("sesos"));
        assertEquals("sesiones", plural("sesion"));
    }

    @Test
    public void endingInVowel() {
        assertEquals("copas", plural("copa"));
        assertEquals("cafes", plural("cafe"));
        assertEquals("taxis", plural("taxi"));
        assertEquals("colibris", plural("colibri"));
        assertEquals("amigos", plural("amigo"));
        assertEquals("platos", plural("plato"));
    }


    private String plural(String word) {
        return inflector.plural(word);
    }
}
