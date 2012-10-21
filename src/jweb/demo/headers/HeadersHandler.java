package jweb.demo.headers;

import jweb.front.elem.Body;
import jweb.front.elem.HTML;
import jweb.front.elem.Head;
import jweb.front.elem.Paragraph;
import jweb.http.Handler;
import jweb.http.Method;
import jweb.http.Request;
import jweb.http.Response;

public class HeadersHandler implements Handler {
    @Override
    public Response handle(Request req) {
        if (req.method != Method.GET)
            return null;
        HTML html = new HTML(new Head(), getBody(req));
        return new Response(html);
    }

    public Body getBody(Request req) {
        Body body = new Body();
        for (String header : req.headers.keySet()) {
            String value = req.headers.get(header);
            String line = String.format("%s: %s", header, value);
            body.getContent().add(new Paragraph(line));
        }
        return body;
    }
}
