package use_cases.view_my_groups_use_case;

/**
 * This is a class which contains the error messages that the
 * ViewMyGroupsInteractor uses to get rid of hard coded error messages.
 * The messages are accessible by getter methods.
 */
public class ViewMyGroupsErrorMessages {
    private final String userDoesNotExist = "This user does not exist";

    public String getUserDoesNotExist() {
        return userDoesNotExist;
    }
}
