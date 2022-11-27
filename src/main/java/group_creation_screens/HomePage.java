package group_creation_screens;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage implements ActionListener{
    JFrame frame = new JFrame();
    JButton groupCreation = new JButton("Create a group");
    GroupRegisterController groupRegisterController;

    public HomePage(GroupRegisterController groupRegisterController){
        this.groupRegisterController = groupRegisterController;

        // making the button and adding it to the screen
        groupCreation.setBounds(100, 150, 200, 40);
        groupCreation.setFocusable(false);
        groupCreation.addActionListener(this);
        frame.add(groupCreation);

        // Create the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // Make the button work
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == groupCreation) {
            frame.dispose();      // get rid of the current screen/frame
            GroupRegisterScreen newScreen = new GroupRegisterScreen(groupRegisterController);    // Create an instance of our new window
        }
    }
}
