package Client;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ByteClientC {

    public ByteClientC() {

    }

    public void run(String serverIP, int port) throws IOException {

        Socket socket = new Socket(serverIP, port);//ソケットクライアント
        OutputStream os = socket.getOutputStream();//送信用バイトストリーム取得
        InputStream is = socket.getInputStream();//受信用バイトストリーム取得


        for (; ; ) {
            System.out.println("キー入力>");
            String keyStr = new Scanner(System.in).nextLine();

            //１行の keyStr文字列送信
            byte[] data = keyStr.getBytes("UTF-8");//バイト列に変換
            System.out.println(Arrays.toString(data));

            if (keyStr.equals("ctrl")) {//ctrlが打たれたら通信終了
                break;
            }


            //FileInputStream fileInputStream = new java.io.FileInputStream("C:\\works\\IntellijWork\\SocketSample\\src\\Client\\a.png");
            //System.out.println(fileInputStream.readAllBytes().length);
            //os.write(fileInputStream.readAllBytes());
            os.write(data);//接続相手にバイト出力
            os.flush();//未出力データを、残らず出す。


            byte[] rData = new byte[1024];
            int readSize = is.read(rData);
            rData = Arrays.copyOf(rData, readSize);

            byte[] buf = new byte[1028];//受信バイト列蓄え用
            int n = 0;
            System.out.println("『" + new String(rData, "UTF-8") + "』の文字列受信");
        }
        //接続を閉じる
        os.close();//閉じる
        is.close();
        socket.close();
    }

}
