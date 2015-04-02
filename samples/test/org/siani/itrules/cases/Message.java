package org.siani.itrules.cases;

public class Message {
    private String from;
    private String[] to;
    private String subject;
    private String[] text;

    public Message(String from, String[] to, String subject, String[] text) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
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
