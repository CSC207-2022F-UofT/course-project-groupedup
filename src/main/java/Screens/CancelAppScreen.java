package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CancelAppScreen extends JFrame implements ActionListener {

    public CancelAppScreen(String groupName) {

        JLabel title = new JLabel("Cancel Application Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel message = new JLabel("Are you sure you want to cancel your " +
                "application for " + groupName + "?");

        JButton yesCancel = new JButton("Yes, cancel");
        JButton no = new JButton("No");

        JPanel buttons = new JPanel();
        buttons.add(yesCancel);
        buttons.add(no);

        yesCancel.addActionListener(this);
        no.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(message);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click" + evt.getActionCommand());
    }
}
