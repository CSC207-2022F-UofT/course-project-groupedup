package apply_to_group_screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ApplyToGroupScreen extends JFrame implements ActionListener {
    ApplyToGroupController applyToGroupController;

    public ApplyToGroupScreen(ApplyToGroupController controller){
        this.applyToGroupController = controller;

        JLabel title = new JLabel("Apply to Groups");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel message = new JLabel("Are you sure you want to apply to this group?");
        message.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton yesApply = new JButton("Yes, apply!");
        JButton no = new JButton("No");

        JPanel buttons = new JPanel();
        buttons.add(yesApply);
        buttons.add(no);

        yesApply.addActionListener(this);
        no.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(title);
        main.add(message);
        main.add(buttons);

        this.setContentPane(main);
        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

    }
}
