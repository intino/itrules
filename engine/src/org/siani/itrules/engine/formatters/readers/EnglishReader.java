package org.siani.itrules.engine.formatters.readers;

import org.siani.itrules.engine.formatters.LetterReader;

public class EnglishReader implements LetterReader {

    @Override
    public String read(int value) {
        int n = ((Number) value).intValue();
        return (words(n / 1000000, " million " + and(n % 1000000)) +
                words((n % 1000000) / 1000, " thousand " + and(n % 1000)) + words(n % 1000, "")).replace("  ", " ").trim();
    }

    private String words(int n, String ending) {
        String[] first = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tenSet = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        return (n == 0) ? "" : ((n >= 100) ? first[n / 100] + " hundred" + and(n % 100) : "") +
                (((n % 100) >= 20) ? tenSet[(n % 100) / 10] + " " + first[n % 10] : first[n % 20]) + ending;
    }

    private String and(int number) {
        return ((number > 0) && (number < 100)) ? " and " : "";

    }

}
