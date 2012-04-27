package jweb.http;

import java.util.Map;

public class Request {
    public final Method method;
    public final String resource;
    public final Map<String, String> headers;
    public final byte[] body;

    public Request(Method method, String resource, Map<String, String> headers, byte[] body) {
        this.method = method;
        this.resource = resource;
        this.headers = headers;
        this.body = body;
    }
}
