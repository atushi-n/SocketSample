package ui.panel;

import compornent.client.ByteClientC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class ClientPanel extends JPanel implements ActionListener {

    private ui.Frame frame;

    private ByteClientC byteClientC;
    private JButton backButton;
    private JButton sendButton;
    private JButton connectButton;

    private JTextField ipField;
    private JTextField portField;
    private JTextField textField;
    private final String backButtonName = "戻る";
    private final String sendButtonName = "Send";
    private final String connectButtonName = "コネクト";



    public ClientPanel(ui.Frame frame) {
        super();
        this.frame = frame;
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(boxLayout);
        GridBagLayout gbLayout = new GridBagLayout();

        GridBagConstraints gbc = new GridBagConstraints();


        sendButton = new JButton(sendButtonName);
        connectButton = new JButton(connectButtonName);
        backButton = new JButton(backButtonName);

        textField = new JTextField();
        ipField = new JTextField();
        portField = new JTextField();
        this.add(backButton);
        this.add(ipField);
        this.add(portField);
        this.add(textField);
        this.add(sendButton);
        this.add(connectButton);


        backButton.setFont(new Font("MSゴシック", Font.BOLD, 20));
        connectButton.addActionListener(this);
        sendButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case backButtonName:

                frame.changePanel("main");
                break;

            case connectButtonName:
                byteClientC = new ByteClientC();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            byteClientC.run(ipField.getText(), Integer.parseInt(portField.getText()));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }).start();

            case sendButtonName:
                //１行の keyStr文字列送信
                byte[] data = new byte[0];//バイト列に変換
                try {
                    data = textField.getText().getBytes("UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
                System.out.println(Arrays.toString(data));

                //FileInputStream fileInputStream = new java.io.FileInputStream("C:\\works\\IntellijWork\\SocketSample\\src\\compornent.Client\\a.png");
                //System.out.println(fileInputStream.readAllBytes().length);
                //os.write(fileInputStream.readAllBytes());
                try {
                    byteClientC.os.write(data);//接続相手にバイト出力
                    byteClientC.os.flush();//未出力データを、残らず出す。
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

        }
    }

}
