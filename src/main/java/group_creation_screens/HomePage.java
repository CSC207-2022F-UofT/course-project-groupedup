package group_creation_screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    // Make the button work
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == groupCreation) {
            cardLayout.show(screens,"groupRegisterScreen");
        }
    }
}
