package ui.panel;

import compornent.server.ServerC;
import ui.Frame;
import ui.panel.ClientPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerPanel extends JPanel implements ActionListener {

    private Frame frame;
    private ServerC serverC;
    private final String sendButtonName = "Send";
    private final String backButtonName = "戻る";
    private final String listenButtonName = "リッスン";

    private JTextField textField;

    private JButton sendButton;
    private JButton listenButton;
    private JButton backButton;
    public ServerPanel(Frame frame){
        super();
        this.frame = frame;
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(boxLayout);
        GridBagLayout gbLayout = new GridBagLayout();

        GridBagConstraints gbc = new GridBagConstraints();

        sendButton = new JButton(sendButtonName);
        listenButton = new JButton(listenButtonName);
        backButton = new JButton(backButtonName);

        textField = new JTextField();


        this.add(backButton);
        this.add(listenButton);
        this.add(textField);
        this.add(sendButton);

        backButton.setFont(new Font("MSゴシック", Font.BOLD, 20));
        backButton.addActionListener(this);
        listenButton.addActionListener(this);
        sendButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case backButtonName:

                frame.changePanel("main");
                break;

            case listenButtonName:
                 serverC = new ServerC();

                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         serverC.serverDstart();
                     }
                 }).start();

                break;
            case sendButtonName:
                serverC.write(textField.getText());
        }
    }

}
