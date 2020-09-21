package server.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @program: JavaTest
 * @description: ${ServerSocket
 * 1、获取请求协议
 * 2、返回响应协议
 * }
 * @author: Mr.ZeroCamel
 * @create: 2020-08-29 20:47
 **/
public class ServletSocket {

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        ServletSocket servletSocket = new ServletSocket();
        servletSocket.start();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(8080);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败...");
        }

    }

    public void receive()
    {
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接...");

            // 获取请求
            InputStream inputStream = client.getInputStream();
            byte[] datas = new byte[1024*10];
            int len = inputStream.read(datas);
            // 数组越界异常
            String request = new String(datas, 0, len);
            System.out.println(request);

            // 返回响应协议
            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功!");
            content.append("</title>");
            content.append("</head>");
            content.append("<body>");
            content.append("响应体....");
            content.append("</body>");
            content.append("</html>");
            int conLen = content.toString().getBytes().length;

            StringBuilder responseInfo = new StringBuilder();
            String blank =" ";
            String CRLF = "\r\n";
            // 响应行
            responseInfo.append("HTTP/1.1").append(blank);
            responseInfo.append(200).append(blank);
            responseInfo.append("OK").append(CRLF);
            responseInfo.append("Date:").append(new Date()).append(CRLF);
            responseInfo.append("Server:").append("shsxt Server/0.0.1;charset=GBK").append(CRLF);
            responseInfo.append("Content-type:text/html").append(CRLF);
            responseInfo.append("Content-length:").append(conLen).append(CRLF).append(CRLF);

            // 正文
            responseInfo.append(content.toString());

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bufferedWriter.write(responseInfo.toString());
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误...");
        }
    }


    public void receive1()
    {
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接...");

            // 获取请求
            InputStream inputStream = client.getInputStream();
            byte[] datas = new byte[1024*10];
            int len = inputStream.read(datas);
            // 数组越界异常
            String request = new String(datas, 0, len);
            System.out.println(request);

            // 返回响应协议
            Response response = new Response(client);
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功!");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("响应体....");
            response.print("</body>");
            response.print("</html>");


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误...");
        }
    }

    public void stop()
    {

    }
}


