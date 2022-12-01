package pending_list_screens;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PendingListScreen extends JFrame implements PendingListScreenBoundary, ListSelectionListener {

    JList<String> memberRequests;
    EditPendingListController editPendingListController;
    ViewPendingListController viewPendingListController;
    DefaultListModel<String> memberRequestsModel;
    JButton acceptButton, rejectButton;
    String groupName;

//    public PendingListScreen(EditPendingListController editPendingListController,
//                             ViewPendingListController viewPendingListController, String groupName) {
        public PendingListScreen(String groupName) {

        setTitle("Member Requests");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.groupName = groupName;
        this.setVisible(false);

//        this.editPendingListController = editPendingListController;
//        this.viewPendingListController = viewPendingListController;

//        this.memberRequestsModel = new DefaultListModel<>();
//        ArrayList<String> usernames = viewPendingListController.getUsernames(groupName).getUsernamesList();
//        for (String username: usernames) {
//            memberRequestsModel.addElement(username);
//        }
//
//        this.memberRequests = new JList<>(memberRequestsModel);
//        memberRequests.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        memberRequests.setSelectedIndex(0);
//        memberRequests.addListSelectionListener(this);
//        memberRequests.setVisibleRowCount(5);
//        JScrollPane requestsScrollPane = new JScrollPane(memberRequests);
//
//        this.add(requestsScrollPane, BorderLayout.CENTER);
//        viewPendingListController.getUsernames(groupName);


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
    public void setMemberRequests(JList<String> memberRequestsList) {
        this.memberRequests = memberRequestsList;
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
        viewPendingListController.getUsernames(groupName);
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

        this.acceptButton = new JButton("Accept");
        this.rejectButton = new JButton("Reject");

        this.acceptButton.addActionListener(new AcceptOrReject());
        this.rejectButton.addActionListener(new AcceptOrReject());

        buttons.add(acceptButton);
        buttons.add(new JSeparator(SwingConstants.VERTICAL));
        buttons.add(Box.createHorizontalStrut(5));
        buttons.add(rejectButton);
        buttons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttons, BorderLayout.PAGE_END);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void buildScrollPane() {
        JScrollPane requestsScrollPane = new JScrollPane(memberRequests);
        this.add(requestsScrollPane, BorderLayout.CENTER);
    }

    private class AcceptOrReject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int index = memberRequests.getSelectedIndex();
            String username = memberRequests.getSelectedValue();
            // removes accepted member from the pending list UI
            memberRequestsModel.remove(index);
            int numRequests = memberRequestsModel.getSize();

            // changes the selected user to the last user on the pending list if the previously removed user was at
            // the end of the list
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

            // triggers the editPendingList use case
            if (evt.getSource() == acceptButton) {
                editPendingListController.rejectOrAcceptUser(username, groupName, true);

            } else if (evt.getSource() == rejectButton) {
                editPendingListController.rejectOrAcceptUser(username, groupName, false);
            }
        }
    }

}
