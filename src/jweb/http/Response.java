package jweb.http;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import jweb.front.elem.HTML;

public class Response {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public final int code;
    public final Map<String, String> headers;
    public final byte[] body;

    public Response(int code, Map<String, String> headers, byte[] body) {
        this.code = code;
        this.headers = headers;
        this.body = body;
        addHeaderIfMissing("Content-Length", Integer.toString(body.length));
        addHeaderIfMissing("Connection", "Close");
    }

    public Response(int code, Map<String, String> headers, String text, String type) {
        this(code, headers, text.getBytes(UTF8));
        addHeaderIfMissing("Content-Type", "text/" + type + "; charset=utf-8");
    }

    public Response(String text) {
        this(200, new HashMap<String, String>(), text, "plain");
    }

    public Response(HTML html) {
        this(200, new HashMap<String, String>(), html.toString(), "html");
    }

    private void addHeaderIfMissing(String header, String value) {
        if (!headers.containsKey(header))
            headers.put(header, value);
    }

    private String statusLine() {
        StringBuilder sb = new StringBuilder("HTTP/1.0 ").append(code).append(' ');
        switch (code) {
            case 200: sb.append("OK"); break;
            default: throw new RuntimeException("Unrecognized code: " + code);
        }
        return sb.append("\r\n").toString();
    }

    public void writeTo(OutputStream os) throws IOException {
        os.write(statusLine().getBytes());
        for (String header : headers.keySet()) {
            String line = header + ": " + headers.get(header) + "\r\n";
            os.write(line.getBytes());
        }
        os.write("\r\n".getBytes());
        os.write(body);
    }
}
