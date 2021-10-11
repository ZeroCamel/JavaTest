package threadandparallel.connectionpool;

import java.io.*;
import java.net.Socket;

/**
 * @program: JavaTest
 * @description: ${HttpServer}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-11 18:30
 **/
public class SimpleHttpServer {
    static ThreadPool<HttpRequestHandle> threadPool = new DefultThreadPool<HttpRequestHandle>();

    static class HttpRequestHandle implements Runnable {
        private Socket socket;

        public HttpRequestHandle(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
