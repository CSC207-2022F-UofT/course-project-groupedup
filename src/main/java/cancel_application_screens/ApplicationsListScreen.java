package cancel_application_screens;

import view_group_profile_screens.ViewGroupProfileController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The user's applications list screen.
 */
public class ApplicationsListScreen extends JFrame implements ApplicationsListScreenBoundary, ListSelectionListener {

    JList<String> userApplications;
    CancelApplicationController cancelApplicationController;
    ViewGroupProfileController viewGroupProfileController;
    DefaultListModel<String> userApplicationsModel;
    JButton cancelApplicationButton;
    JButton viewGroupButton;
    String username;

    /**
     * Initializes an empty applications list for the current user.
     * @param username the username of the current user
     */
    public ApplicationsListScreen(String username) {
        this.username = username;

        this.setSize(400, 500);
        setTitle("My Applications");
        setVisible(false);
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
    public void view() {
        this.buildButtons();
        this.buildScrollPane();
        this.setVisible(true);
    }

    @Override
    public void buildButtons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        this.viewGroupButton = new JButton("View Group");
        this.cancelApplicationButton = new JButton("Cancel Application");

        this.viewGroupButton.addActionListener(new ViewOrLeave());
        this.cancelApplicationButton.addActionListener(new ViewOrLeave());

        buttons.add(viewGroupButton);
        buttons.add(cancelApplicationButton);
        buttons.add(new JSeparator(SwingConstants.VERTICAL));
        buttons.add(Box.createHorizontalStrut(5));
        buttons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttons, BorderLayout.PAGE_END);
    }

    @Override
    public void buildScrollPane() {
        JScrollPane applicationsScrollPane = new JScrollPane(userApplications);
        this.add(applicationsScrollPane, BorderLayout.CENTER);
    }

    private class ViewOrLeave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int index = userApplications.getSelectedIndex();
            String groupName = userApplications.getSelectedValue();

            if (evt.getSource() == viewGroupButton) {
                viewGroupProfileController.viewGroup(groupName);
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
            }
        }
    }
}
