package org.siani.itrules;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AcceptedCleanLines {

    @Test
    public void testName() throws Exception {
        assertThat(cleanEmptyLines("asd"), is("asd"));
        assertThat(cleanEmptyLines("   asd"), is("   asd"));
        assertThat(cleanEmptyLines("   \\\n"), is(""));
        assertThat(cleanEmptyLines("\t  \t    \\\n"), is(""));
        assertThat(cleanEmptyLines("asd\n\t  \t    \\\nqwe"), is("asd\nqwe"));
        assertThat(cleanEmptyLines("asd\n\t  \t    \\\n"), is("asd"));

    }

    private String cleanEmptyLines(String text) {
        String[] lines = text.split("\n");
        String result = "";
        for (String line : lines) result += cleanEmptyLine(line + "\n");
        return result.isEmpty() ? "" : result.substring(0, result.lastIndexOf("\n"));
    }

    private String cleanEmptyLine(String line) {
        return line.replaceAll("^\\s*\\\\\n", "");
    }


}
