package server.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @program: JavaTest
 * @description: 封装响应信息
 * @author: zeroCamel
 * @create: 2020-08-31 10:09
 **/
public class Response {
    private BufferedWriter bw;

    private StringBuilder content;

    private StringBuilder headInfo;

    private int len;

    private final String BLANK = "";
    private final String CRLF = "\r\n";

    private Response() {
        content = new StringBuilder();
        headInfo = new StringBuilder();
        len = 0;
    }

    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    // 动态添加内容
    // 流模式 返回自身
    public Response print(String info) {
        content.append(info);
        len += info.getBytes().length;
        return this;
    }

    /**
     * @param info
     * @return
     */
    public Response println(String info)
    {
        content.append(info);
        len += (info+CRLF).getBytes().length;
        return this;
    }



    // 构建头信息
    private void createHeadInfo(int code) {

        headInfo.append("HTTP/1.1").append(BLANK);
        headInfo.append(200).append(BLANK);
        switch (code) {
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 505:
                headInfo.append("Server Error").append(CRLF);
                break;
            default:
                    break;
        }

        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("shsxt Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text/html").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF).append(CRLF);
        headInfo.append(CRLF);
    }


}
