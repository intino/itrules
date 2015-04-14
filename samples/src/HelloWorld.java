import org.siani.itrules.TemplateEngine;

public class HelloWorld {
    public static void main(String[] args) {
        TemplateEngine engine = new TemplateEngine();
        System.out.println(engine.render("Hello world!"));
    }

}