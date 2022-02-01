package ui;



import ui.panel.ClientPanel;
import ui.panel.MainPanel;
import ui.panel.ServerPanel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {


    private JPanel mainPanel;
    private JPanel clientPanel;
    private JPanel serverPanel;
    private CardLayout cardLayout;
    private JPanel rootPanel;

    public Frame(String title, Dimension dimension) {

        cardLayout = new CardLayout();
        rootPanel = new JPanel();
        rootPanel.setLayout(cardLayout);
        mainPanel = new MainPanel(this);
        clientPanel = new ClientPanel(this);
        serverPanel = new ServerPanel(this);
        this.setTitle(title);
        this.setSize(dimension);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setContentPane(rootPanel);
        rootPanel.add(mainPanel, "main");
        rootPanel.add(clientPanel, "client");
        rootPanel.add(serverPanel, "server");
    }


    public void changePanel(String panelName) {
        switch (panelName) {
            case "main":
                cardLayout.show(rootPanel, "main");
                break;
            case "client":
                cardLayout.show(rootPanel, "client");
                break;
            case "server":
                cardLayout.show(rootPanel, "server");
                break;
        }

    }
}
