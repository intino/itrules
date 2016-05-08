package sherpa;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.siani.itrules.TemplateEngine;
import sherpa.Platform.Api;
import spark.Spark;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static com.mashape.unirest.http.Unirest.get;
import static sherpa.Platform.Api.Method.get;

public class Main {
    public static final String template = "sherpa/templates/api-html.itr";

    public static void main(String[] args) {
        Spark.port(8080);
        Spark.get("/help", (req, res) -> {
            System.out.println(new File("./" + template).exists());
            return TemplateEngine.with(template).render(platform());
        });
    }

    private static Platform platform() {
        return new Platform() {{
            name = "Sumus";
            apis = new Api[] { simpleWeather() };
        }};
    }

    private static Api simpleWeather() {
        return new Api() {{
            name = "Simple Weather";

            paths = new Path[]{
                new Path() {{
                    id = "aqui";
                    name = "Air Quality Index";
                    method = get;
                    summary = "Air Quality Index";
                    parameters = new Parameter[] {
                            new Parameter() {{
                                id = "lat";
                                name = "Latitude";
                                type = "String";
                            }},
                            new Parameter() {{
                                id = "lng";
                                name = "Longitude";
                                type = "String";
                            }}
                    };
                    response = new Response() {{
                        type = "String";
                    }};
                }},
                new Path() {{
                    id = "customers";
                    name = "Customers";
                    method = get;
                    response = new Response() {{
                        type = "Json";

                    }};

                }},
                new Path() {{
                    id = "check";
                    name = "check spelling";
                    method = get;
                    summary = "Checks for spelling errors";
                    parameters = new Parameter[] {
                            new Parameter() {{
                                name = "text";
                                type = "String";
                                summary = "English text to be spellchecked";
                            }}
                    };
                    response = new Response() {{
                        type = "SpellChecking";

                    }};

                }}
            };

        }};
    }


    public class Example extends UnirestClient {
        private String url;

        public Example(String url) {
            this.url = url;
        }

        public String aqi(String lat, String lng) throws UnirestException  {
            return _string(get(url + "lat=" + encode(lat) + "&" + "lng=" + encode(lng)).header("Accept", "text/plain").asString());
        }

        public String check(String text) throws UnirestException  {
            return _string(get(url + "text=" + encode(text)).header("Accept", "text/J").asString());
        }

    }

    public abstract class UnirestClient {
        protected String encode(String value) {
            try {
                return URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return "";
            }
        }


        protected String _string(HttpResponse<String> response) throws UnirestException {
            return check(response) ? response.getBody() : null;
        }

        protected Double _double(HttpResponse<Double> response) throws UnirestException {
            return check(response) ? response.getBody() : null;
        }

        private boolean check(HttpResponse<?> response) throws UnirestException {
            if (response.getStatus() != 200) throw new UnirestException(response.getStatus() + ":" + response.getStatusText());
            return true;
        }
    }

}
