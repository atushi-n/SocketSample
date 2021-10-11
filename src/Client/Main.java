package Client;


import Client.UI.Frame;

import java.awt.*;
import java.io.IOException;

class Main {
    public static void main(String[] args) {

        //UI設定と画面表示
        //Frame frame = new Frame("ソケット通信クライアント", new Dimension(500, 500));
        //frame.setVisible(true);

        byteClientCrun();



    }


    static void clientCrun(){
        ClientC c = new ClientC();
        c.run("192.168.11.4", 8765);
    }

    static void byteClientCrun(){
        ByteClientC c = new ByteClientC();
        try {
            c.run("192.168.11.4", 8765);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}