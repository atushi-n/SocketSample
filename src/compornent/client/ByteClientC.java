package compornent.client;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ByteClientC {
    Socket socket;
    public OutputStream os;
    InputStream is;

    public ByteClientC() {

    }

    public void run(String serverIP, int port) throws IOException {
        socket = new Socket(serverIP, port);//ソケットクライアント
        os = socket.getOutputStream();//送信用バイトストリーム取得
        is = socket.getInputStream();//受信用バイトストリーム取得


        for (; ; ) {



            byte[] rData = new byte[1024];
            int readSize = is.read(rData);
            rData = Arrays.copyOf(rData, readSize);

            byte[] buf = new byte[1028];//受信バイト列蓄え用
            int n = 0;
            System.out.println("『" + new String(rData, "UTF-8") + "』の文字列受信");
        }
        //接続を閉じる
//        os.close();//閉じる
//        is.close();
//        socket.close();
    }

}
