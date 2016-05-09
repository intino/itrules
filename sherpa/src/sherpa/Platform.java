package sherpa;

public class Platform {
    public String name;
    public Api[] apiList;

    public static class Api {
        public String name;
        public String summary;
        public String consumes;
        public String produces;
        public Path[] paths;

        public static class Path {
            public String id;
            public String name;
            public String summary;
            public Method method;
            public String operation;
            public Parameter[] parameterList;
            public Response response;
        }

        public static class Parameter {
            public String id;
            public String name;
            public String summary;
            public String type;
            public In in;
            public String schema;
        }

        public static class Response {
            public String type;
        }

        public enum In { query, header, path, form, body}
        public enum Method { get, post, put, delete }
    }
}
