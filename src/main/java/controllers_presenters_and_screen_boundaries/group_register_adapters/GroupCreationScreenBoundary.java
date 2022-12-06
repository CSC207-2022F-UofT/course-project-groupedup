package controllers_presenters_and_screen_boundaries.group_register_adapters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is an interface which the Group Creation Screen implements.
 * It creates dependency inversion between the presenter and the UI
 * so the presenter references this interface instead of the UI
 * directly.
 */
public interface GroupCreationScreenBoundary extends ActionListener {
    /**
     * Method for reacting to button clicks
     *
     * @param evt the event to be processed
     */
    void actionPerformed(ActionEvent evt);

    /**
     * This method will build the screen by initializing all its
     * components and adding them to the JPanel.
     */
    void build();

    /**
     * Will switch the screen to the given screen name on the cardLayout stack.
     *
     * @param screenName
     */
    void switchScreen(String screenName);

    /**
     * This method is to pass in and set the controller of the screen and
     * also put this screen on the cardLayout stack.
     *
     * @param groupRegisterController
     */
    void setView(GroupRegisterController groupRegisterController);

    /**
     * Will initialize a pop-up message to indicate that the use case failed.
     *
     * @param error
     */
    void prepareFailView(String error);
}
