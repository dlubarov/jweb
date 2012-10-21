package jweb.demo.headers;

import java.io.IOException;
import jweb.http.Server;

public class HeadersDemo {
    public static void main(String[] args) throws IOException {
        new Server(8000, new HeadersHandler()).run();
    }
}
