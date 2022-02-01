package ui.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {


    private ui.Frame frame;
    final String clientButtonName = "CLIENT";
    final String serverButtonName = "SERVER";
    final String exitButtonName = "終了";
    JButton clientButton;




    public MainPanel(ui.Frame frame) {
        super();
        this.frame = frame;
        GridBagLayout gbLayout = new GridBagLayout();

        GridBagConstraints gbc = new GridBagConstraints();


        this.setLayout(gbLayout);

        clientButton = new JButton("CLIENT");
        clientButton.setFont(new Font("MSゴシック", Font.BOLD, 20));
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbLayout.setConstraints(clientButton, gbc);

        JButton serverButton = new JButton("SERVER");
        serverButton.setFont(new Font("MSゴシック", Font.BOLD, 20));
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbLayout.setConstraints(serverButton, gbc);

        JButton exitButton = new JButton("終了");
        exitButton.setFont(new Font("MSゴシック", Font.BOLD, 20));
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbLayout.setConstraints(exitButton, gbc);


        this.add(clientButton);
        this.add(serverButton);
        this.add(exitButton);



        clientButton.addActionListener(this);
        serverButton.addActionListener(this);
        exitButton.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case clientButtonName:
                frame.changePanel("client");
                break;

            case serverButtonName:
                frame.changePanel("server");
                break;

            case exitButtonName:
                frame.setVisible(false);
                frame.dispose(); //フレームをデストロイするが,
                // 他にデーモンスレッドが走っている場合はこれだけでは不十分
                break;
        }
    }
}
