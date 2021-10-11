package Client.UI;


import Client.ClientC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    JButton putButton;
    JTextField ipTextField;

    public Frame(String title, Dimension size) {
        super(title);
        this.setSize(size);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        putButton = new JButton("通信開始");
        putButton.addActionListener(this);

        ipTextField = new JTextField();

        Container container = this.getContentPane();
        container.add(putButton);
        container.add(ipTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "通信開始":
                ClientC clientC = new ClientC();
                clientC.run(ipTextField.getText(), 8765);
        }
    }
}
