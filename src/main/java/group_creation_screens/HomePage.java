package group_creation_screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the HomePage which the User who is logged in will see.
 * Here the matching algorithm will be displayed and the user can click
 * the 'Create a group' button to create a new group, through the group
 * creation use case.
 *
 */
public class HomePage extends JPanel implements ActionListener{
    JButton groupCreation = new JButton("Create a group");
    CardLayout cardLayout;
    JPanel screens;
    JLabel title = new JLabel("Welcome to Grouped Up!");

    public HomePage(CardLayout cardLayout, JPanel screens){
        this.cardLayout = cardLayout;
        this.screens = screens;
        groupCreation.addActionListener(this);

        this.add(title);
        this.add(groupCreation);

    }


    /**
     * If the button which is clicked is the group creation button, then the
     * group creation screen will show up.
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == groupCreation) {
            cardLayout.show(screens,"groupRegisterScreen");
        }
    }
}
