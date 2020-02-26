package io.intino.itrules.cases;

public class Message {
    private String from;
    private String[] to;
    private String subject;
    private String[] body;

    public Message(String from, String[] to, String subject, String[] body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public static String from(String recipient) {
        return recipient;
    }

    public static String[] to(String... recipient) {
        return recipient;
    }

    public static String subject(String text) {
        return text;
    }

    public static String[] text(String... text) {
        return text;
    }


}
