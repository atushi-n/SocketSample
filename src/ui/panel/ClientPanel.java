package ui.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientPanel extends JPanel implements ActionListener {

    private ui.Frame frame;
    private final String backButtonName = "戻る";
    private JButton backButton;

    public ClientPanel(ui.Frame frame) {
        super();
        this.frame = frame;
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(boxLayout);
        GridBagLayout gbLayout = new GridBagLayout();

        GridBagConstraints gbc = new GridBagConstraints();

        backButton = new JButton(backButtonName);


        this.add(backButton);


        backButton.setFont(new Font("MSゴシック", Font.BOLD, 20));
        backButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case backButtonName:

                frame.changePanel("main");
                break;
        }
    }

}
