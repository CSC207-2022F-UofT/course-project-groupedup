package cancel_application_screens;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationsListScreen extends JFrame implements ApplicationsListScreenBoundary, ListSelectionListener {

    JList<String> userApplications;
    CancelApplicationController cancelApplicationController;
    ViewApplicationsListController viewApplicationsListController;
    DefaultListModel<String> userApplicationsModel;
    JButton cancelApplicationButton;
    String username;

    public ApplicationsListScreen(String username) {

        setTitle("My Applications");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.username = username;
        setVisible(false);
    }

    /** Allows user to select the group application they want to cancel. Disables button when there is no selection.
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            cancelApplicationButton.setEnabled(userApplications.getSelectedIndex() != -1);
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
    public void setCancelApplicationController(CancelApplicationController cancelApplicationController) {
        this.cancelApplicationController = cancelApplicationController;
    }

    @Override
    public void setViewApplicationsListController(ViewApplicationsListController viewApplicationsListController) {
        this.viewApplicationsListController = viewApplicationsListController;
        viewApplicationsListController.viewApplicationsList(username);
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

        this.cancelApplicationButton = new JButton("Cancel Application");
        this.cancelApplicationButton.addActionListener(new Clicked());

        buttons.add(cancelApplicationButton);
        buttons.add(new JSeparator(SwingConstants.VERTICAL));
        buttons.add(Box.createHorizontalStrut(5));
        buttons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttons, BorderLayout.PAGE_END);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void buildScrollPane() {
        JScrollPane applicationsScrollPane = new JScrollPane(userApplications);
        this.add(applicationsScrollPane, BorderLayout.CENTER);
    }

    private class Clicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int index = userApplications.getSelectedIndex();
            String groupName = userApplications.getSelectedValue();
            // removes group from applications list UI
            userApplicationsModel.remove(index);
            int numApplications = userApplicationsModel.getSize();

            // changes the selected group to the last group on the applications list if the previously cancelled
            // group application was at the end of the list
            if (numApplications == 0) {
                cancelApplicationButton.setEnabled(false);
            } else if (index == numApplications) {
                index--;
            }
            userApplications.setSelectedIndex(index);
            userApplications.ensureIndexIsVisible(index);

            // triggers the cancelApplication use case
            if (evt.getSource() == cancelApplicationButton) {
                cancelApplicationController.cancelApplication(username, groupName);
            }
        }
    }
}
