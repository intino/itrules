package org.siani.itrules.reader.itr;

import java.util.Arrays;

public class DedentContainer {
    private final String headerToken;
    private final String footerToken;
    private Block block;
    private String content = "";

    public DedentContainer(String headerToken, String footerToken) {
        this.headerToken = headerToken;
        this.footerToken = footerToken;
    }

    public void put(String line) {
        if (line.startsWith(headerToken)) block = new Block(line);
        else if (line.startsWith(footerToken)) block.close(line);
        else block.body(line);
    }

    public byte[] content() {
        return content.trim().getBytes();
    }


    private class Block {
        private String header;
        private String[] body = {};
        private int indentation = Integer.MAX_VALUE;

        public Block(String header) {
            this.header = header;
        }

        public void body(String line) {
            body = Arrays.copyOf(body, body.length + 1);
            body[body.length-1] = analyze(normalize(line));
        }

        private void close(String line) {
            content = content + header + "\n" + body() + line + "\n" + "\n";
        }

        private String body() {
            String body = "";
            for (String line : this.body)
                body += (line.isEmpty() ? "" : line.substring(indentation > 0 ? 1 : 0)) + "\n";
            return body;
        }

        private String analyze(String line) {
            if (!line.isEmpty())
                indentation = Math.min(indentation, line.length() - line.replaceAll("^\\s+","").length());
            return line;
        }

        private String normalize(String line) {
            return line.replaceAll("    ", "\t");
        }
    }
}
