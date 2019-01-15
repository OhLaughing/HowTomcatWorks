package org.how.tomcat.works.ex01;

import java.io.*;
import java.net.Socket;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 8080;
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "yiwangzhibujian /1.txt abc";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        outputStream.close();
        socket.close();
    }
}
