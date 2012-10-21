package jweb.http;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import jweb.Logger;

public class Server {
    private final ExecutorService executor;
    private final ServerSocket serverSock;
    private final Handler[] handlers;

    public Server(int port, Handler... handlers) throws IOException {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        serverSock = new ServerSocket(port);
        this.handlers = handlers;
    }

    public void run() throws IOException {
        for (;;) {
            Socket sock = serverSock.accept();
            Worker w = new Worker(sock);
            executor.submit(w);
        }
    }

    private class Worker implements Runnable {
        private final Socket sock;

        public Worker(Socket sock) {
            this.sock = sock;
        }

        private Map<String, String> readHeaders(BufferedReader lineReader) throws IOException {
            Map<String, String> headers = new HashMap<String, String>();
            for (;;) {
                String line = lineReader.readLine();
                if (line.isEmpty()) {
                    break;
                }
                String[] parts = line.split(":");
                String header = parts[0], value = parts[1];
                headers.put(header, value);
            }
            return headers;
        }

        @Override
        public void run() {
            try {
                InputStream is = sock.getInputStream();
                BufferedReader lineReader = new BufferedReader(new InputStreamReader(is));

                // Read the request line.
                String requestLine = lineReader.readLine();
                Logger.info("Request line: %s", requestLine);
                String[] requestLineParts = requestLine.split(" ");
                String methodName = requestLineParts[0];
                Method method = Method.valueOf(methodName);
                String resource = requestLineParts[1];
                //String protocolDecl = requestLineParts[2];

                // Read any headers.
                Map<String, String> headers = readHeaders(lineReader);

                // Read the body.
                /*ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] data = new byte[16384];
                while ((nRead = is.read(data, 0, data.length)) != -1)
                  buffer.write(data, 0, nRead);
                buffer.flush();
                byte[] body = buffer.toByteArray();*/
                byte[] body = new byte[0];

                Request req = new Request(method, resource, headers, body);
                Response resp = null;
                for (Handler hand : handlers)
                    if ((resp = hand.handle(req)) != null)
                        break;
                if (resp == null)
                    throw new RuntimeException("FIXME: serve a 404");

                OutputStream os = sock.getOutputStream();
                resp.writeTo(os);
                os.flush(); os.close();
                sock.close();
            } catch (IOException e) {
                Logger.error("Error in worker.", e);
            }
        }
    }
}
