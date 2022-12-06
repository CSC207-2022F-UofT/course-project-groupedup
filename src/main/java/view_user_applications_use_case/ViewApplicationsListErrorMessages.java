package view_user_applications_use_case;

/**
 * This is a class which contains the error messages that the
 * ViewApplicationsListInteractor uses to get rid of hard coded error messages.
 * The messages are accessible by getter methods.
 */
public class ViewApplicationsListErrorMessages {
    private final String userDoesNotExist = "This user does not exist";

    public String getUserDoesNotExist() {
        return userDoesNotExist;
    }
}
