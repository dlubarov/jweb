package jweb.http;

public interface Handler {
    public Response handle(Request req);
}
