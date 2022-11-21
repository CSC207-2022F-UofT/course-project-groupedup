package group_creation_screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGroupPageScreen extends JFrame implements ActionListener {
    JTextField groupname = new JTextField(15);
    /**
     * After successful creation of a group, this page will display the newly created Group.
     * The User can then click on the 'Edit Group Information' button if they want to edit
     * the group's profile and add more details. Otherwise, they can click the 'Home Page'
     * button and go back to the home page.
     */
    public NewGroupPageScreen() {

        JLabel title = new JLabel("New Group");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton homePage = new JButton("Home Page");
        JButton editGroup = new JButton("Edit Group Information");
        JButton pendingList = new JButton("Pending group list");

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
