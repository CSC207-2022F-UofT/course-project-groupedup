package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeaveGroupScreen extends JFrame implements ActionListener {

    public LeaveGroupScreen(String groupName) {

        JLabel title = new JLabel("Leave Group Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel message = new JLabel("Are you sure you want to leave " +
                groupName + "?");

        JButton Leave = new JButton("Leave");
        JButton Stay = new JButton("Stay");

        JPanel buttons = new JPanel();
        buttons.add(Leave);
        buttons.add(Stay);

        Leave.addActionListener(this);
        Stay.addActionListener(this);

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
