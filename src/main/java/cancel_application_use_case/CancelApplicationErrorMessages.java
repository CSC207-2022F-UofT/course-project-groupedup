package cancel_application_use_case;

/**
 * This is a class which contains the error messages that the
 * CancelApplicationInteractor uses to get rid of hard coded error messages.
 * The messages are accessible by getter methods.
 */
public class CancelApplicationErrorMessages {
    private final String groupDoesNotExist = "This group does not exist.";
    private final String groupRejectedApplication = "The group has already rejected your application.";
    private final String groupNotInUser = "Group is not in user's applications list.";

    public String getGroupDoesNotExist() {
        return groupDoesNotExist;
    }

    public String getGroupRejectedApplication() {
        return groupRejectedApplication;
    }

    public String getGroupNotInUser() {
        return groupNotInUser;
    }
}
