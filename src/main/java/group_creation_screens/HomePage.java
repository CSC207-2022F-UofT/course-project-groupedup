package group_creation_screens;

import apply_to_group_screens.ApplyToGroupController;
import cancel_application_screens.ViewApplicationsListController;
import leave_group_screens.ViewMyGroupsController;
import matching_algorithm_screens.HomeMatchesBoundary;
import matching_algorithm_screens.MatchingAlgorithmController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
public class HomePage extends JPanel implements ActionListener, HomeMatchesBoundary,ListSelectionListener {
    JButton groupCreation = new JButton("Create a group");
    JButton myApplications = new JButton("My Applications");
    JButton myGroups = new JButton("My Groups");
    String username;

    MatchingAlgorithmController matchingAlgorithmController;

    ApplyToGroupController applyToGroupController;
    JList<String> matches = new JList<>();
    JScrollPane matchesScrollPane = new JScrollPane();
    JButton refreshMatches = new JButton("Refresh Matches");
    JLabel matchesLabel = new JLabel("My Matches: ");

    ViewApplicationsListController viewApplicationsListController;
    ViewMyGroupsController viewMyGroupsController;
    CardLayout cardLayout;
    JPanel screens;
    JLabel title = new JLabel("Welcome to Grouped Up!");

    public HomePage(CardLayout cardLayout, JPanel screens, String username) {

        this.cardLayout = cardLayout;
        this.screens = screens;
        this.username = username;

        buildScreen();
    }


    public void buildScreen(){

        groupCreation.addActionListener(this);
        myApplications.addActionListener(this);
        myGroups.addActionListener(this);
        refreshMatches.addActionListener(this);

        this.add(title);
        this.add(groupCreation);
        this.add(myApplications);
        this.add(myGroups);

        this.setSize(500, 500);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setBackground(new Color(151, 175, 136));

        this.add(title);
        this.add(groupCreation);
        this.add(myApplications);
        this.add(myGroups);
        this.add(refreshMatches);

        this.add(matchesLabel);
        buildScrollPane();
        this.add(refreshMatches);
    }
    public void setMatches(JList<String> matches) {
        this.matches = matches;
        matchesScrollPane.setViewportView(matches);
    }

    public void buildScrollPane() {
        matchesScrollPane = new JScrollPane(matches);
        matchesScrollPane.setPreferredSize(new Dimension(200, 200));

        this.add(matchesScrollPane);
    }

    /**
     * If the button which is clicked is the group creation button, then the
     * group creation screen will show up.
     *
     * @param evt the event to be processed
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        if (evt.getSource() == groupCreation) {
            this.cardLayout.show(screens, "groupRegisterScreen");
        } else if (evt.getSource() == myApplications) {
            viewApplicationsListController.viewApplicationsList(username);
        } else if (evt.getSource() == myGroups) {
            viewMyGroupsController.viewMyGroups(username);
        } else if (evt.getSource() == refreshMatches) {
            matchingAlgorithmController.matchingAlgorithm(username);
            JOptionPane.showMessageDialog(null, "Matches Updated");
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            JList<String> list = (JList<String>) e.getSource();
            String matchTitle = list.getSelectedValue();
            int index = matchTitle.indexOf(':');
            String groupName = matchTitle.substring(index + 2);
            //Present group view screen based off of group name

            String[] options = {"view", "apply"};
            int x = JOptionPane.showOptionDialog(null, groupName,
                    "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (x == 0){
                JOptionPane.showMessageDialog(null, "Group Info");
                //Aarya's stuff
            } else if (x == 1){
                applyToGroupController.applyToGroup(username, groupName);
            }
        }
    }

    public void setViewApplicationsListController(ViewApplicationsListController viewApplicationsListController) {
        this.viewApplicationsListController = viewApplicationsListController;
    }

    public void setViewMyGroupsController(ViewMyGroupsController viewMyGroupsController) {
        this.viewMyGroupsController = viewMyGroupsController;
    }

    public void setMatchingAlgorithmController(MatchingAlgorithmController matchingAlgorithmController){
        this.matchingAlgorithmController = matchingAlgorithmController;
    }

    public void applyToGroupController(ApplyToGroupController applyToGroupController){
        this.applyToGroupController = applyToGroupController;
    }

}
