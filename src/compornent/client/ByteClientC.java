package compornent.client;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ByteClientC {
    Socket socket;
    public OutputStream os;
    InputStream is;
    PrintWriter writer = null;

    public ByteClientC() {

    }

    public void send(String text){



        //送信用の文字を送信
        writer.println(text);

    }
    public void run(String serverIP, int port) {


        Socket cSocket = null;
        BufferedReader csInput = null;

        BufferedReader reader = null;

        try {
            //IPアドレスとポート番号を指定してクライアント側のソケットを作成
            cSocket = new Socket(serverIP, port);

            //クライアント側での入力用
            csInput = new BufferedReader
                    (new InputStreamReader(System.in));

            //クライアント側からサーバへの送信用
            writer = new PrintWriter
                    (cSocket.getOutputStream(), true);

            //サーバ側からの受取用
            reader = new BufferedReader
                    (new InputStreamReader
                            (cSocket.getInputStream()));

            //無限ループ　byeの入力でループを抜ける
            String line = null;
            while (true) {
                System.out.println("-------------------");
                System.out.println("偶数の数値を入力して下さい");
                System.out.println("-------------------");

                //サーバ側からの受取の結果を表示
                System.out.println(reader.readLine());
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
                if (csInput != null) {
                    csInput.close();
                }
                if (cSocket != null) {
                    cSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("クライアント側終了です");
        }
    }


}
