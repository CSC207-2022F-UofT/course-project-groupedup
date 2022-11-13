package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeaveGroupFailureScreen extends JFrame implements ActionListener {

    public LeaveGroupFailureScreen() {

        JLabel title = new JLabel("Leave Group Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel message = new JLabel("Oops! You're Group Leader for this group." +
                "Please transfer leadership before leaving.");

        JButton editGroup = new JButton("Edit Group");
        JButton close = new JButton("Close");

        JPanel buttons = new JPanel();
        buttons.add(editGroup);
        buttons.add(close);

        editGroup.addActionListener(this);
        close.addActionListener(this);

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
