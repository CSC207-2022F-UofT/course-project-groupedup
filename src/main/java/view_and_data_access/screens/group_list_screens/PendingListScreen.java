package view_and_data_access.screens.group_list_screens;

import interface_adapters.pending_list_adapters.EditPendingListController;
import interface_adapters.pending_list_adapters.PendingListScreenBoundary;
import interface_adapters.pending_list_adapters.ViewPendingListController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The pending list screen.
 */

public class PendingListScreen extends JPanel implements PendingListScreenBoundary, ListSelectionListener {

    JList<String> memberRequests = new JList<>();
    EditPendingListController editPendingListController;
    ViewPendingListController viewPendingListController;
    DefaultListModel<String> memberRequestsModel = new DefaultListModel<>();
    JButton acceptButton, rejectButton;
    String groupName;

    JScrollPane requestsScrollPane = new JScrollPane();
    CardLayout cardLayout;
    JPanel screens;

    JButton backToGroupProfile;
    public PendingListScreen(CardLayout cardLayout, JPanel screens) {
        this.setBackground( new Color(197,180,227));
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.add(new JLabel("Member Requests"));
        setSize(500, 500);
        this.buildButtons();
        this.buildScrollPane();
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // allows group leaders select the user they want to accept/reject, disables buttons when there is no selection
        if (!e.getValueIsAdjusting()) {
            if (memberRequests.getSelectedIndex() == -1) {
                acceptButton.setEnabled(false);
                rejectButton.setEnabled(false);
            } else {
                acceptButton.setEnabled(true);
                rejectButton.setEnabled(true);
            }
        }
    }

    @Override
    public void setGroupName(String groupName) { this.groupName = groupName;
    }

    @Override
    public void setMemberRequests(JList<String> memberRequestsList) {
        this.memberRequests = memberRequestsList;
        this.requestsScrollPane.setViewportView(memberRequestsList);
    }

    @Override
    public void setMemberRequestsModel(DefaultListModel<String> memberRequestsModel) {
        this.memberRequestsModel = memberRequestsModel;
    }

    public void setEditPendingListController(EditPendingListController editPendingListController) {
        this.editPendingListController = editPendingListController;
    }

    @Override
    public void setViewPendingListController(ViewPendingListController viewPendingListController) {
        this.viewPendingListController = viewPendingListController;
    }


    @Override
    public void buildButtons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        this.backToGroupProfile = new JButton("Back to Group Profile");
        this.acceptButton = new JButton("Accept");
        this.rejectButton = new JButton("Reject");

        this.acceptButton.addActionListener(new AcceptOrReject());
        this.rejectButton.addActionListener(new AcceptOrReject());
        this.backToGroupProfile.addActionListener(new buttonPress());
        buttons.add(backToGroupProfile);
        buttons.add(acceptButton);
        buttons.add(new JSeparator(SwingConstants.VERTICAL));
        buttons.add(Box.createHorizontalStrut(5));
        buttons.add(rejectButton);
        buttons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttons, BorderLayout.PAGE_END);

        if (memberRequestsModel.size() == 0) {
            acceptButton.setEnabled(false);
            rejectButton.setEnabled(false);
        }
    }

    @Override
    public void buildScrollPane() {
        this.add(requestsScrollPane, BorderLayout.CENTER);
    }

    private class AcceptOrReject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int index = memberRequests.getSelectedIndex();
            String username = memberRequests.getSelectedValue();

            memberRequestsModel.remove(index);
            int numRequests = memberRequestsModel.size();

            if (numRequests == 0) {
                acceptButton.setEnabled(false);
                rejectButton.setEnabled(false);
            } else {
                if (index == numRequests) {
                    index--;
                }
            }
            memberRequests.setSelectedIndex(index);
            memberRequests.ensureIndexIsVisible(index);

            if (evt.getSource() == acceptButton) {
                editPendingListController.rejectOrAcceptUser(username, groupName, true);

            } else if (evt.getSource() == rejectButton) {
                editPendingListController.rejectOrAcceptUser(username, groupName, false);
            }
        }
    }

    private class buttonPress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backToGroupProfile) {
                cardLayout.show(screens,"newGroupPageScreen");
            }
        }
    }
}