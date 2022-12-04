package group_creation_screens;

import matching_algorithm_screens.HomeMatchesBoundary;
import matching_algorithm_screens.MatchingAlgorithmController;
import matching_algorithm_screens.MatchingAlgorithmView;
import matching_algorithm_use_case.MatchingAlgorithmResponseModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends JPanel implements ActionListener, HomeMatchesBoundary, ListSelectionListener {
    String username;
    MatchingAlgorithmController matchingAlgorithmController;
    JList<String> matches = new JList<>();
    JScrollPane matchesScrollPane = new JScrollPane();
    JButton refreshMatches = new JButton("Refresh Matches");
    JLabel matchesLabel = new JLabel("My Matches: ");

    JButton groupCreation = new JButton("Create a group");
    CardLayout cardLayout;
    JPanel screens;
    JLabel title = new JLabel("Welcome to Grouped Up!");

    public HomePage(CardLayout cardLayout, JPanel screens){
        this.cardLayout = cardLayout;
        this.screens = screens;
        buildScreen();
    }

    public void buildScreen(){
        this.setBackground(new Color(151, 175, 136));
        groupCreation.addActionListener(this);
        refreshMatches.addActionListener(this);
        this.add(title);
        this.add(groupCreation);

        this.add(matchesLabel);
        buildScrollPane();
        this.add(refreshMatches);
    }

    public void setMatches(JList<String> matches) {
        this.matches = matches;
        matchesScrollPane.setViewportView(matches);
    }

    public void setMatchingAlgorithmController(MatchingAlgorithmController matchingAlgorithmController){
        this.matchingAlgorithmController = matchingAlgorithmController;
    }

    public void buildScrollPane(){
        matchesScrollPane = new JScrollPane(matches);
        matchesScrollPane.setPreferredSize(new Dimension(200,200));

        this.add(matchesScrollPane);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == groupCreation) {
            cardLayout.show(screens,"groupRegisterScreen");
        }
        if (e.getSource() == refreshMatches){

//            I have this part for testing
            List<String> groups = new ArrayList<>();
            groups.add("CSC206: Group 3");
            groups.add("CSC235: Group 5");
            groups.add("CSC252: Group 2");
            groups.add("CSC207: Group 1");
            groups.add("CSC223: Group 51");
            groups.add("CSC258: Group 62");
            MatchingAlgorithmResponseModel responseModel = new MatchingAlgorithmResponseModel(
                     groups);


            MatchingAlgorithmView matchingAlgorithmView = new MatchingAlgorithmView(this);
            matchingAlgorithmView.displaySuccess(responseModel);
            //matchingAlgorithmController.matchingAlgorithm(username);
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
            } else if (x == 1){
                JOptionPane.showMessageDialog(null, "Applied to Group!");
            }
        }
    }
}
