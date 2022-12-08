package view_and_data_access.screens.group_list_screens;

import interface_adapters.cancel_application_adapters.ApplicationsListScreenBoundary;
import interface_adapters.cancel_application_adapters.CancelApplicationController;
import interface_adapters.view_group_profile_adapters.ViewGroupProfileController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The user's applications list screen.
 */
public class ApplicationsListScreen extends JPanel implements ApplicationsListScreenBoundary, ListSelectionListener {

    JList<String> userApplications = new JList<>();
    CancelApplicationController cancelApplicationController;
    ViewGroupProfileController viewGroupProfileController;
    DefaultListModel<String> userApplicationsModel = new DefaultListModel<>();
    JButton cancelApplicationButton;
    JButton viewGroupButton;
    JButton backToHomePage;
    String username;
    JScrollPane applicationsScrollPane = new JScrollPane();

    CardLayout cardLayout;

    JPanel screens;
    static String TITLE = "My Applications";
    static int SCREEN_WIDTH = 500;
    static int SCREEN_HEIGHT = 500;



    /**
     * Initializes an empty applications list for the current user.
     */
    public ApplicationsListScreen(String username, CardLayout cardLayout, JPanel screens) {
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.setBackground(new Color(182,202,218));
        this.username = username;
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.add(new JLabel(TITLE));

        this.buildButtons();
        this.buildScrollPane();

    }

    /**
     * Allows user to select the group application they want to cancel. Disables button when there is no selection.
     * @param e the event that characterizes the change
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (userApplications.getSelectedIndex() == -1) {
                cancelApplicationButton.setEnabled(false);
                viewGroupButton.setEnabled(false);
            } else {
                cancelApplicationButton.setEnabled(true);
                viewGroupButton.setEnabled(true);
            }
        }
    }

    @Override
    public void setUserApplications(JList<String> userApplications) {
        this.userApplications = userApplications;
        this.applicationsScrollPane.setViewportView(userApplications);
    }

    @Override
    public void setUserApplicationsModel(DefaultListModel<String> userApplicationsModel) {
        this.userApplicationsModel = userApplicationsModel;
    }

    @Override
    public void setViewGroupController(ViewGroupProfileController viewGroupProfileController) {
        this.viewGroupProfileController = viewGroupProfileController;
    }

    @Override
    public void setCancelApplicationController(CancelApplicationController cancelApplicationController) {
        this.cancelApplicationController = cancelApplicationController;
    }



    @Override
    public void buildButtons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        this.viewGroupButton = new JButton("View Group");
        this.cancelApplicationButton = new JButton("Cancel Application");
        this.backToHomePage = new JButton("Home Page");

        this.backToHomePage.addActionListener(new ViewOrLeave());
        this.viewGroupButton.addActionListener(new ViewOrLeave());
        this.cancelApplicationButton.addActionListener(new ViewOrLeave());

        if (this.userApplicationsModel.size() == 0) {
            cancelApplicationButton.setEnabled(false);
            viewGroupButton.setEnabled(false);
        }
        buttons.add(backToHomePage);
        buttons.add(viewGroupButton);
        buttons.add(cancelApplicationButton);
        buttons.add(new JSeparator(SwingConstants.VERTICAL));
        buttons.add(Box.createHorizontalStrut(5));
        buttons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttons, BorderLayout.PAGE_END);
    }

    @Override
    public void buildScrollPane() {
        this.add(applicationsScrollPane, BorderLayout.CENTER);
    }

    private class ViewOrLeave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int index = userApplications.getSelectedIndex();
            String groupName = userApplications.getSelectedValue();

            if (evt.getSource() == viewGroupButton) {
                viewGroupProfileController.viewGroup(groupName);
                cardLayout.show(screens, "groupProfileScreen");
            } else if (evt.getSource() == cancelApplicationButton) {
                userApplicationsModel.remove(index);
                int numApplications = userApplicationsModel.getSize();

                if (numApplications == 0) {
                    cancelApplicationButton.setEnabled(false);
                    viewGroupButton.setEnabled(false);
                } else if (index == numApplications) {
                    index--;
                }

                userApplications.setSelectedIndex(index);
                userApplications.ensureIndexIsVisible(index);
                cancelApplicationController.cancelApplication(username, groupName);
            } else if (evt.getSource() == backToHomePage){
                cardLayout.show(screens,"homepage");
            }
        }
    }
}
