/* The following code was generated by JFlex 1.4.3 on 30/04/15 9:57 */

package org.siani.itrules.intellij.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.siani.itrules.intellij.lang.psi.ItrulesTypes;


/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 30/04/15 9:57 from the specification file
 * <tt>/Users/oroncal/workspace/itrules/plugin/src/org/siani/itrules/intellij/lang/lexer/itrules.flex</tt>
 */
class ItrulesLexer implements FlexLexer {
    /**
     * lexical states
     */
    public static final int YYINITIAL = 0;
    /**
     * initial size of the lookahead buffer
     */
    private static final int ZZ_BUFFERSIZE = 16384;
    /**
     * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
     * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
     * at the beginning of a line
     * l is of the form l = 2*k, k a non negative integer
     */
    private static final int ZZ_LEXSTATE[] = {
            0, 0
    };

    /**
     * Translates characters to character classes
     */
    private static final String ZZ_CMAP_PACKED =
            "\11\10\1\0\1\0\3\0\16\10\10\0\1\1\10\0\1\10\2\0" +
                    "\12\10\7\0\32\11\1\2\1\0\1\3\1\0\1\11\1\0\3\11" +
                    "\1\4\1\5\1\6\7\11\1\7\14\11\4\0\41\10\2\0\4\11" +
                    "\4\0\1\11\2\0\1\10\7\0\1\11\4\0\1\11\5\0\27\11" +
                    "\1\0\37\11\1\0\u01ca\11\4\0\14\11\16\0\5\11\7\0\1\11" +
                    "\1\0\1\11\21\0\160\10\5\11\1\0\2\11\2\0\4\11\10\0" +
                    "\1\11\1\0\3\11\1\0\1\11\1\0\24\11\1\0\123\11\1\0" +
                    "\213\11\1\0\5\10\2\0\236\11\11\0\46\11\2\0\1\11\7\0" +
                    "\47\11\7\0\1\11\1\0\55\10\1\0\1\10\1\0\2\10\1\0" +
                    "\2\10\1\0\1\10\10\0\33\11\5\0\3\11\15\0\5\10\6\0" +
                    "\1\11\4\0\13\10\5\0\53\11\37\10\4\0\2\11\1\10\143\11" +
                    "\1\0\1\11\10\10\1\0\6\10\2\11\2\10\1\0\4\10\2\11" +
                    "\12\10\3\11\2\0\1\11\17\0\1\10\1\11\1\10\36\11\33\10" +
                    "\2\0\131\11\13\10\1\11\16\0\12\10\41\11\11\10\2\11\4\0" +
                    "\1\11\5\0\26\11\4\10\1\11\11\10\1\11\3\10\1\11\5\10" +
                    "\22\0\31\11\3\10\104\0\1\11\1\0\13\11\67\0\33\10\1\0" +
                    "\4\10\66\11\3\10\1\11\22\10\1\11\7\10\12\11\2\10\2\0" +
                    "\12\10\1\0\7\11\1\0\7\11\1\0\3\10\1\0\10\11\2\0" +
                    "\2\11\2\0\26\11\1\0\7\11\1\0\1\11\3\0\4\11\2\0" +
                    "\1\10\1\11\7\10\2\0\2\10\2\0\3\10\1\11\10\0\1\10" +
                    "\4\0\2\11\1\0\3\11\2\10\2\0\12\10\4\11\7\0\1\11" +
                    "\5\0\3\10\1\0\6\11\4\0\2\11\2\0\26\11\1\0\7\11" +
                    "\1\0\2\11\1\0\2\11\1\0\2\11\2\0\1\10\1\0\5\10" +
                    "\4\0\2\10\2\0\3\10\3\0\1\10\7\0\4\11\1\0\1\11" +
                    "\7\0\14\10\3\11\1\10\13\0\3\10\1\0\11\11\1\0\3\11" +
                    "\1\0\26\11\1\0\7\11\1\0\2\11\1\0\5\11\2\0\1\10" +
                    "\1\11\10\10\1\0\3\10\1\0\3\10\2\0\1\11\17\0\2\11" +
                    "\2\10\2\0\12\10\1\0\1\11\17\0\3\10\1\0\10\11\2\0" +
                    "\2\11\2\0\26\11\1\0\7\11\1\0\2\11\1\0\5\11\2\0" +
                    "\1\10\1\11\7\10\2\0\2\10\2\0\3\10\10\0\2\10\4\0" +
                    "\2\11\1\0\3\11\2\10\2\0\12\10\1\0\1\11\20\0\1\10" +
                    "\1\11\1\0\6\11\3\0\3\11\1\0\4\11\3\0\2\11\1\0" +
                    "\1\11\1\0\2\11\3\0\2\11\3\0\3\11\3\0\14\11\4\0" +
                    "\5\10\3\0\3\10\1\0\4\10\2\0\1\11\6\0\1\10\16\0" +
                    "\12\10\11\0\1\11\7\0\3\10\1\0\10\11\1\0\3\11\1\0" +
                    "\27\11\1\0\12\11\1\0\5\11\3\0\1\11\7\10\1\0\3\10" +
                    "\1\0\4\10\7\0\2\10\1\0\2\11\6\0\2\11\2\10\2\0" +
                    "\12\10\22\0\2\10\1\0\10\11\1\0\3\11\1\0\27\11\1\0" +
                    "\12\11\1\0\5\11\2\0\1\10\1\11\7\10\1\0\3\10\1\0" +
                    "\4\10\7\0\2\10\7\0\1\11\1\0\2\11\2\10\2\0\12\10" +
                    "\1\0\2\11\17\0\2\10\1\0\10\11\1\0\3\11\1\0\51\11" +
                    "\2\0\1\11\7\10\1\0\3\10\1\0\4\10\1\11\10\0\1\10" +
                    "\10\0\2\11\2\10\2\0\12\10\12\0\6\11\2\0\2\10\1\0" +
                    "\22\11\3\0\30\11\1\0\11\11\1\0\1\11\2\0\7\11\3\0" +
                    "\1\10\4\0\6\10\1\0\1\10\1\0\10\10\22\0\2\10\15\0" +
                    "\60\11\1\10\2\11\7\10\4\0\10\11\10\10\1\0\12\10\47\0" +
                    "\2\11\1\0\1\11\2\0\2\11\1\0\1\11\2\0\1\11\6\0" +
                    "\4\11\1\0\7\11\1\0\3\11\1\0\1\11\1\0\1\11\2\0" +
                    "\2\11\1\0\4\11\1\10\2\11\6\10\1\0\2\10\1\11\2\0" +
                    "\5\11\1\0\1\11\1\0\6\10\2\0\12\10\2\0\4\11\40\0" +
                    "\1\11\27\0\2\10\6\0\12\10\13\0\1\10\1\0\1\10\1\0" +
                    "\1\10\4\0\2\10\10\11\1\0\44\11\4\0\24\10\1\0\2\10" +
                    "\5\11\13\10\1\0\44\10\11\0\1\10\71\0\53\11\24\10\1\11" +
                    "\12\10\6\0\6\11\4\10\4\11\3\10\1\11\3\10\2\11\7\10" +
                    "\3\11\4\10\15\11\14\10\1\11\17\10\2\0\46\11\1\0\1\11" +
                    "\5\0\1\11\2\0\53\11\1\0\u014d\11\1\0\4\11\2\0\7\11" +
                    "\1\0\1\11\1\0\4\11\2\0\51\11\1\0\4\11\2\0\41\11" +
                    "\1\0\4\11\2\0\7\11\1\0\1\11\1\0\4\11\2\0\17\11" +
                    "\1\0\71\11\1\0\4\11\2\0\103\11\2\0\3\10\40\0\20\11" +
                    "\20\0\125\11\14\0\u026c\11\2\0\21\11\1\0\32\11\5\0\113\11" +
                    "\3\0\3\11\17\0\15\11\1\0\4\11\3\10\13\0\22\11\3\10" +
                    "\13\0\22\11\2\10\14\0\15\11\1\0\3\11\1\0\2\10\14\0" +
                    "\64\11\40\10\3\0\1\11\3\0\2\11\1\10\2\0\12\10\41\0" +
                    "\3\10\2\0\12\10\6\0\130\11\10\0\51\11\1\10\1\11\5\0" +
                    "\106\11\12\0\35\11\3\0\14\10\4\0\14\10\12\0\12\10\36\11" +
                    "\2\0\5\11\13\0\54\11\4\0\21\10\7\11\2\10\6\0\12\10" +
                    "\46\0\27\11\5\10\4\0\65\11\12\10\1\0\35\10\2\0\13\10" +
                    "\6\0\12\10\15\0\1\11\130\0\5\10\57\11\21\10\7\11\4\0" +
                    "\12\10\21\0\11\10\14\0\3\10\36\11\15\10\2\11\12\10\54\11" +
                    "\16\10\14\0\44\11\24\10\10\0\12\10\3\0\3\11\12\10\44\11" +
                    "\122\0\3\10\1\0\25\10\4\11\1\10\4\11\3\10\2\11\11\0" +
                    "\300\11\47\10\25\0\4\10\u0116\11\2\0\6\11\2\0\46\11\2\0" +
                    "\6\11\2\0\10\11\1\0\1\11\1\0\1\11\1\0\1\11\1\0" +
                    "\37\11\2\0\65\11\1\0\7\11\1\0\1\11\3\0\3\11\1\0" +
                    "\7\11\3\0\4\11\2\0\6\11\4\0\15\11\5\0\3\11\1\0" +
                    "\7\11\16\0\5\10\32\0\5\10\20\0\2\11\23\0\1\11\13\0" +
                    "\5\10\5\0\6\10\1\0\1\11\15\0\1\11\20\0\15\11\3\0" +
                    "\33\11\25\0\15\10\4\0\1\10\3\0\14\10\21\0\1\11\4\0" +
                    "\1\11\2\0\12\11\1\0\1\11\3\0\5\11\6\0\1\11\1\0" +
                    "\1\11\1\0\1\11\1\0\4\11\1\0\13\11\2\0\4\11\5\0" +
                    "\5\11\4\0\1\11\21\0\51\11\u0a77\0\57\11\1\0\57\11\1\0" +
                    "\205\11\6\0\4\11\3\10\2\11\14\0\46\11\1\0\1\11\5\0" +
                    "\1\11\2\0\70\11\7\0\1\11\17\0\1\10\27\11\11\0\7\11" +
                    "\1\0\7\11\1\0\7\11\1\0\7\11\1\0\7\11\1\0\7\11" +
                    "\1\0\7\11\1\0\7\11\1\0\40\10\57\0\1\11\u01d5\0\3\11" +
                    "\31\0\11\11\6\10\1\0\5\11\2\0\5\11\4\0\126\11\2\0" +
                    "\2\10\2\0\3\11\1\0\132\11\1\0\4\11\5\0\51\11\3\0" +
                    "\136\11\21\0\33\11\65\0\20\11\u0200\0\u19b6\11\112\0\u51cd\11\63\0" +
                    "\u048d\11\103\0\56\11\2\0\u010d\11\3\0\20\11\12\10\2\11\24\0" +
                    "\57\11\1\10\4\0\12\10\1\0\31\11\7\0\1\10\120\11\2\10" +
                    "\45\0\11\11\2\0\147\11\2\0\4\11\1\0\4\11\14\0\13\11" +
                    "\115\0\12\11\1\10\3\11\1\10\4\11\1\10\27\11\5\10\20\0" +
                    "\1\11\7\0\64\11\14\0\2\10\62\11\21\10\13\0\12\10\6\0" +
                    "\22\10\6\11\3\0\1\11\4\0\12\10\34\11\10\10\2\0\27\11" +
                    "\15\10\14\0\35\11\3\0\4\10\57\11\16\10\16\0\1\11\12\10" +
                    "\46\0\51\11\16\10\11\0\3\11\1\10\10\11\2\10\2\0\12\10" +
                    "\6\0\27\11\3\0\1\11\1\10\4\0\60\11\1\10\1\11\3\10" +
                    "\2\11\2\10\5\11\2\10\1\11\1\10\1\11\30\0\3\11\2\0" +
                    "\13\11\5\10\2\0\3\11\2\10\12\0\6\11\2\0\6\11\2\0" +
                    "\6\11\11\0\7\11\1\0\7\11\221\0\43\11\10\10\1\0\2\10" +
                    "\2\0\12\10\6\0\u2ba4\11\14\0\27\11\4\0\61\11\u2104\0\u016e\11" +
                    "\2\0\152\11\46\0\7\11\14\0\5\11\5\0\1\11\1\10\12\11" +
                    "\1\0\15\11\1\0\5\11\1\0\1\11\1\0\2\11\1\0\2\11" +
                    "\1\0\154\11\41\0\u016b\11\22\0\100\11\2\0\66\11\50\0\15\11" +
                    "\3\0\20\10\20\0\7\10\14\0\2\11\30\0\3\11\31\0\1\11" +
                    "\6\0\5\11\1\0\207\11\2\0\1\10\4\0\1\11\13\0\12\10" +
                    "\7\0\32\11\4\0\1\11\1\0\32\11\13\0\131\11\3\0\6\11" +
                    "\2\0\6\11\2\0\6\11\2\0\3\11\3\0\2\11\3\0\2\11" +
                    "\22\0\3\10\4\0";

    /**
     * Translates characters to character classes
     */
    private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);
    private static final String ZZ_ACTION_PACKED_0 =
            "\1\0\2\1\1\2\1\3\2\1\1\4\1\5\2\0" +
                    "\1\6\1\7";
    /**
     * Translates DFA states to action switch labels.
     */
    private static final int[] ZZ_ACTION = zzUnpackAction();
    private static final String ZZ_ROWMAP_PACKED_0 =
            "\0\0\0\12\0\24\0\12\0\12\0\36\0\50\0\62" +
                    "\0\12\0\74\0\106\0\12\0\12";
    /**
     * Translates a state to a row index in the transition table
     */
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
    private static final String ZZ_TRANS_PACKED_0 =
            "\1\2\1\3\1\4\1\5\1\6\1\7\4\2\13\0" +
                    "\1\10\2\11\4\10\1\0\1\10\5\0\1\12\13\0" +
                    "\1\13\3\0\1\10\2\0\6\10\6\0\1\14\7\0" +
                    "\1\15\5\0";
    /**
     * The transition table of the DFA
     */
    private static final int[] ZZ_TRANS = zzUnpackTrans();
    /* error codes */
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final char[] EMPTY_BUFFER = new char[0];
    private static final int YYEOF = -1;
    /* error messages for the codes above */
    private static final String ZZ_ERROR_MSG[] = {
            "Unkown internal scanner error",
            "Error: could not match input",
            "Error: pushback value was too large"
    };
    private static final String ZZ_ATTRIBUTE_PACKED_0 =
            "\1\0\1\11\1\1\2\11\3\1\1\11\2\0\2\11";
    /**
     * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
     */
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
    private static java.io.Reader zzReader = null; // Fake
    /**
     * the current state of the DFA
     */
    private int zzState;
    /**
     * the current lexical state
     */
    private int zzLexicalState = YYINITIAL;
    /**
     * this buffer contains the current text to be matched and is
     * the source of the yytext() string
     */
    private CharSequence zzBuffer = "";
    /**
     * this buffer may contains the current text array to be matched when it is cheap to acquire it
     */
    private char[] zzBufferArray;
    /**
     * the textposition at the last accepting state
     */
    private int zzMarkedPos;
    /**
     * the textposition at the last state to be included in yytext
     */
    private int zzPushbackPos;
    /**
     * the current text position in the buffer
     */
    private int zzCurrentPos;
    /**
     * startRead marks the beginning of the yytext() string in the buffer
     */
    private int zzStartRead;
    /**
     * endRead marks the last character in the buffer, that has been read
     * from input
     */
    private int zzEndRead;
    /**
     * zzAtBOL == true <=> the scanner is currently at the beginning of a line
     */
    private boolean zzAtBOL = true;
    /**
     * zzAtEOF == true <=> the scanner is at the EOF
     */
    private boolean zzAtEOF;

    ItrulesLexer(java.io.Reader in) {
        this.zzReader = in;
    }

    /**
     * Creates a new scanner.
     * There is also java.io.Reader version of this constructor.
     *
     * @param in the java.io.Inputstream to read input from.
     */
    ItrulesLexer(java.io.InputStream in) {
        this(new java.io.InputStreamReader(in));
    }

    private static int[] zzUnpackAction() {
        int[] result = new int[13];
        int offset = 0;
        offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAction(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    private static int[] zzUnpackRowMap() {
        int[] result = new int[13];
        int offset = 0;
        offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackRowMap(String packed, int offset, int[] result) {
        int i = 0;  /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int high = packed.charAt(i++) << 16;
            result[j++] = high | packed.charAt(i++);
        }
        return j;
    }

    private static int[] zzUnpackTrans() {
        int[] result = new int[80];
        int offset = 0;
        offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackTrans(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            value--;
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    private static int[] zzUnpackAttribute() {
        int[] result = new int[13];
        int offset = 0;
        offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAttribute(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    /**
     * Unpacks the compressed character translation table.
     *
     * @param packed the packed character translation table
     * @return the unpacked character translation table
     */
    private static char[] zzUnpackCMap(String packed) {
        char[] map = new char[0x10000];
        int i = 0;  /* index in packed string  */
        int j = 0;  /* index in unpacked array */
        while (i < 2166) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);
            do map[j++] = value; while (--count > 0);
        }
        return map;
    }

    public final int getTokenStart() {
        return zzStartRead;
    }

    public final int getTokenEnd() {
        return getTokenStart() + yylength();
    }

    public void reset(CharSequence buffer, int start, int end, int initialState) {
        zzBuffer = buffer;
        zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
        zzCurrentPos = zzMarkedPos = zzStartRead = start;
        zzPushbackPos = 0;
        zzAtEOF = false;
        zzAtBOL = true;
        zzEndRead = end;
        yybegin(initialState);
    }

    /**
     * Refills the input buffer.
     *
     * @return <code>false</code>, iff there was new input.
     * @throws java.io.IOException if any I/O-Error occurs
     */
    private boolean zzRefill() throws java.io.IOException {
        return true;
    }


    /**
     * Returns the current lexical state.
     */
    public final int yystate() {
        return zzLexicalState;
    }


    /**
     * Enters a new lexical state
     *
     * @param newState the new lexical state
     */
    public final void yybegin(int newState) {
        zzLexicalState = newState;
    }


    /**
     * Returns the text matched by the current regular expression.
     */
    public final CharSequence yytext() {
        return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
    }


    /**
     * Returns the character at position <tt>pos</tt> from the
     * matched text.
     * <p>
     * It is equivalent to yytext().charAt(pos), but faster
     *
     * @param pos the position of the character to fetch.
     *            A value from 0 to yylength()-1.
     * @return the character at position pos
     */
    public final char yycharat(int pos) {
        return zzBufferArray != null ? zzBufferArray[zzStartRead + pos] : zzBuffer.charAt(zzStartRead + pos);
    }


    /**
     * Returns the length of the matched text region.
     */
    public final int yylength() {
        return zzMarkedPos - zzStartRead;
    }


    /**
     * Reports an error that occured while scanning.
     * <p>
     * In a wellformed scanner (no or only correct usage of
     * yypushback(int) and a match-all fallback rule) this method
     * will only be called with things that "Can't Possibly Happen".
     * If this method is called, something is seriously wrong
     * (e.g. a JFlex bug producing a faulty scanner etc.).
     * <p>
     * Usual syntax/scanner level error handling should be done
     * in error fallback rules.
     *
     * @param errorCode the code of the errormessage to display
     */
    private void zzScanError(int errorCode) {
        String message;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException e) {
            message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
        }

        throw new Error(message);
    }


    /**
     * Pushes the specified amount of characters back into the input stream.
     * <p>
     * They will be read again by then next call of the scanning method
     *
     * @param number the number of characters to be read again.
     *               This number must not be greater than yylength()!
     */
    public void yypushback(int number) {
        if (number > yylength())
            zzScanError(ZZ_PUSHBACK_2BIG);

        zzMarkedPos -= number;
    }


    /**
     * Resumes scanning until the next regular expression is matched,
     * the end of input is encountered or an I/O-Error occurs.
     *
     * @return the next token
     * @throws java.io.IOException if any I/O-Error occurs
     */
    public IElementType advance() throws java.io.IOException {
        int zzInput;
        int zzAction;

        // cached fields:
        int zzCurrentPosL;
        int zzMarkedPosL;
        int zzEndReadL = zzEndRead;
        CharSequence zzBufferL = zzBuffer;
        char[] zzBufferArrayL = zzBufferArray;
        char[] zzCMapL = ZZ_CMAP;

        int[] zzTransL = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL = ZZ_ATTRIBUTE;

        while (true) {
            zzMarkedPosL = zzMarkedPos;

            zzAction = -1;

            zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

            zzState = ZZ_LEXSTATE[zzLexicalState];


            zzForAction:
            {
                while (true) {

                    if (zzCurrentPosL < zzEndReadL)
                        zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
                    else if (zzAtEOF) {
                        zzInput = YYEOF;
                        break zzForAction;
                    } else {
                        // store back cached positions
                        zzCurrentPos = zzCurrentPosL;
                        zzMarkedPos = zzMarkedPosL;
                        boolean eof = zzRefill();
                        // get translated positions and possibly new buffer
                        zzCurrentPosL = zzCurrentPos;
                        zzMarkedPosL = zzMarkedPos;
                        zzBufferL = zzBuffer;
                        zzEndReadL = zzEndRead;
                        if (eof) {
                            zzInput = YYEOF;
                            break zzForAction;
                        } else {
                            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
                        }
                    }
                    int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
                    if (zzNext == -1) break zzForAction;
                    zzState = zzNext;

                    int zzAttributes = zzAttrL[zzState];
                    if ((zzAttributes & 1) == 1) {
                        zzAction = zzState;
                        zzMarkedPosL = zzCurrentPosL;
                        if ((zzAttributes & 8) == 8) break zzForAction;
                    }

                }
            }

            // store back cached position
            zzMarkedPos = zzMarkedPosL;

            switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
                case 6: {
                    return ItrulesTypes.DEFRULE;
                }
                case 8:
                    break;
                case 4: {
                    return ItrulesTypes.MARK;
                }
                case 9:
                    break;
                case 5: {
                    return ItrulesTypes.SCAPED_CHAR;
                }
                case 10:
                    break;
                case 3: {
                    return ItrulesTypes.RIGHT_SQUARE;
                }
                case 11:
                    break;
                case 1: {
                    return ItrulesTypes.TEXT;
                }
                case 12:
                    break;
                case 7: {
                    return ItrulesTypes.ENDRULE;
                }
                case 13:
                    break;
                case 2: {
                    return ItrulesTypes.LEFT_SQUARE;
                }
                case 14:
                    break;
                default:
                    if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
                        zzAtEOF = true;
                        return null;
                    } else {
                        zzScanError(ZZ_NO_MATCH);
                    }
            }
        }
    }


}
