package compornent.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ソケット通信(サーバー側)
 */
public class ServerC {


    private ServerSocket sSocket;
    private Socket socket;

    private BufferedReader reader;
    private PrintWriter writer;

    public ServerC() {


        sSocket = null;
        socket = null;
        reader = null;

        try {
            //IPアドレスとポート番号を指定してサーバー側のソケットを作成
            sSocket = new ServerSocket();
            sSocket.bind(new InetSocketAddress
                    ("192.168.11.9", 8765));

            System.out.println("クライアントからの入力待ち状態");

            //クライアントからの要求を待ち続けます
            socket = sSocket.accept();

            //クライアントからの受取用
            reader = new BufferedReader(
                    new InputStreamReader
                            (socket.getInputStream()));

            //サーバーからクライアントへの送信用
            writer = new PrintWriter(
                    socket.getOutputStream(), true);

            //無限ループ　byeの入力でループを抜ける
            String line;
            while (true) {
                System.out.println("ss");
                //ソケットのインプットストリームに入力されたら読まれる
                line = reader.readLine();

                System.out.println(line);

                writer.println("<<<" + line + ">>>");
                System.out.println("aa");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (sSocket != null) {
                    sSocket.close();
                }
                System.out.println("サーバー側終了です");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
