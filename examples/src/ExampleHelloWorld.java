import io.intino.itrules.TemplateEngine;

public class ExampleHelloWorld {
    public static void main(String[] args) {
        TemplateEngine engine = new TemplateEngine();
        System.out.println(engine.render("Hello world!"));
    }

}