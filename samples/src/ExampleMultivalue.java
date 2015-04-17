import org.siani.itrules.TemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class ExampleMultivalue {

    public static class Message {
        private String from;
        private String[] to;
        private String subject;
        private List<String> body = new ArrayList<>();

        public Message(String from, String... to) {
            this.from = from;
            this.to = to;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void addLine(String line) {
            body.add(line);
        }
    }

    public static void main(String[] args) {
        Message message = new Message("frodo@hobbiton.me", "gandalf@elrond.me", "bilbo@hobbiton.me");
        message.setSubject("The ring");
        message.addLine("I wish the Ring had never come to me.");
        message.addLine("I wish none of this had happened.");

        TemplateEngine engine = new TemplateEngine().use("samples/templates/Multivalue.itr");
        System.out.println(engine.render(message));
    }

}
