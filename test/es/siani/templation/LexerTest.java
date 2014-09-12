package es.siani.templation;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LexerTest {

    public static String[] ruleNamesList;

    @Test
    public void MarkKeyTest(){
        String expectedType = "MARK_KEY";
        String[] receivedTypes = lexerTest(":");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }

    @Test
    public void markIDTest(){
        String expectedType = "MARK_ID";
        String[] receivedTypes = lexerTest(":markca");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }


	@Test
    public void leftSquareTest(){
        String expectedType = "LEFT_SQ";
        String[] receivedTypes = lexerTest("[");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }

    @Test
    public void rightSquareTest(){
        String expectedType = "RIGHT_SQ";
        String[] receivedTypes = lexerTest("]");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }

    @Test
    public void openAnnotationTest(){
        String expectedType = "LIST";
        String[] receivedTypes = lexerTest("...");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }

    @Test
    public void closeAnnotationTest(){
        String expectedType = "TAG";
        String[] receivedTypes = lexerTest("+");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }

    @Test
    public void markTest(){
        String expectedType = "MARK_KEY";
        String[] receivedTypes = lexerTest("$");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }

    @Test
    public void stringTest(){
        String expectedType = "STRING";
        String[] receivedTypes = lexerTest("String");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }

    @Test
    public void doubleTest(){
        String expectedType = "DOUBLE";
        String[] receivedTypes = lexerTest("Double");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }
    @Test
    public void integerTest(){
        String expectedType = "INTEGER";
        String[] receivedTypes = lexerTest("Integer");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }
    @Test
    public void idTest(){
        String expectedType = "ID";
        String[] receivedTypes = lexerTest("Name");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }

    @Test
    public void mark(){
        String expectedType = "MARK";
        String[] receivedTypes = lexerTest(" \t \t   \t\t$m  ");
        Assert.assertTrue(receivedTypes[0].equals(expectedType));
    }
	@Test
	public void OtherWithMark() {
		String expectedType = "MARK";
		String[] receivedTypes = lexerTest("public class $name alalasda $other");
		Assert.assertEquals(expectedType, receivedTypes[1]);
		Assert.assertEquals(4, receivedTypes.length);
	}


	public static void setRulesNameList(String[] list){
        ruleNamesList = list;
    }
    public static String getRulesNameList(int index){
        return ruleNamesList[index];
    }

    public static String[] lexerTest(String query) {
        try{
            String receivedToken;
            ArrayList<String> receivedTypes = new ArrayList<>();
            CharStream stream = new ANTLRInputStream(query);
            TemplationLexer lexer = new TemplationLexer(stream);
            lexer.reset();
            setRulesNameList(lexer.getRuleNames());
            Token currentToken = lexer.nextToken();
            while (currentToken.getType() != Token.EOF){
                receivedToken = getRulesNameList(currentToken.getType()-1);
                receivedTypes.add(receivedToken);
                currentToken = lexer.nextToken();
            }
            String[] list = new String[receivedTypes.size()];
            return receivedTypes.toArray(list);
        }
        catch (RecognitionException error){
            System.err.println("Error on query: "+query);
            return (new String[0]);
        }
    }
}
