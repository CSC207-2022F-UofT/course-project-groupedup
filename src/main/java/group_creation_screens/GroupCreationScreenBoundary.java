package group_creation_screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface GroupCreationScreenBoundary extends ActionListener {
    void actionPerformed(ActionEvent evt);
    void build();
    void switchScreen(String screenName);
    void setView(GroupRegisterController groupRegisterController);
}
