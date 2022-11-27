package group_creation_screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGroupPageScreen implements ActionListener {
    JFrame frame = new JFrame();
    String groupname;
    JButton homePage = new JButton("Home Page");
    JButton editGroup = new JButton("Edit Group Information");
    JButton pendingList = new JButton("Pending Group List");
    JLabel groupNameText = new JLabel();
    GroupRegisterController groupRegisterController;


    /**
     * After successful creation of a group, this page will display the newly created Group.
     * The User can then click on the 'Edit Group Information' button if they want to edit
     * the group's profile and add more details. Otherwise, they can click the 'Home Page'
     * button and go back to the home page.
     */
    public NewGroupPageScreen(String groupname, GroupRegisterController groupRegisterController) {
        this.groupname = groupname;
        this.groupRegisterController = groupRegisterController;

        groupNameText.setText("Group's name: " + groupname);
        groupNameText.setBounds(100, 50, 200, 40);
        //groupNameText.setBounds(100, 20, 200, 40);

        homePage.setBounds(100, 150, 200, 40);
        homePage.setFocusable(false);
        homePage.addActionListener(this);

        editGroup.setBounds(100, 200, 200, 40);
        editGroup.addActionListener(this);

        pendingList.setBounds(100, 250, 200, 40);
        pendingList.addActionListener(this);

        frame.add(groupNameText);
        frame.add(homePage);
        frame.add(editGroup);
        frame.add(pendingList);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

        System.out.println("Click " + evt.getActionCommand());
        if (evt.getSource() == homePage){
            try {
                HomePage nextScreen = new HomePage(groupRegisterController);
                frame.dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }
        else if (evt.getSource() == editGroup){

        }
        else if (evt.getSource() == pendingList){

        }
    }
}
