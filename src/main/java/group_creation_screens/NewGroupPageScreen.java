package group_creation_screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGroupPageScreen extends JFrame implements ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField groupname = new JTextField(15);
    /**
     * A window with a title and a JButton.
     */
    public NewGroupPageScreen() {

        JLabel title = new JLabel("New Group");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton homePage = new JButton("HomePage");
        JButton editGroup = new JButton("Edit Group Information");

        groupname.setEditable(false);

        JPanel buttons = new JPanel();
        buttons.add(homePage);
        buttons.add(editGroup);

        homePage.addActionListener(this);
        editGroup.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(new JLabel("Group name"));
        main.add(groupname);
        main.add(buttons);

        this.setContentPane(main);
        this.pack();

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
