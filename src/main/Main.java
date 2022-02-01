package main;

import ui.Frame;

import java.awt.*;

public class Main {
    public static ui.Frame frame;

    public static void main(String... args) {
        frame = new Frame("サンプル", new Dimension(500, 500));
        frame.setVisible(true);

//        InetAddress ip = null;
//        try {
//            ip = InetAddress.getLocalHost();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Current IP address : " + ip.getHostAddress());

    }
}
