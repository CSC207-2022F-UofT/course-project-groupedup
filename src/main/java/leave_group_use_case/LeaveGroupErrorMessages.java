package leave_group_use_case;

/**
 * This is a class which contains the error messages that the
 * LeaveGroupInteractor uses to get rid of hard coded error messages.
 * The messages are accessible by getter methods.
 */
public class LeaveGroupErrorMessages {
    private final String groupDoesNotExist = "This group does not exist.";
    private final String userNotInGroup = "User is not in group.";
    private final String groupNotInUser = "The group has already removed you from their members' list";

    public String getGroupDoesNotExist() {
        return groupDoesNotExist;
    }

    public String getUserNotInGroup() {
        return userNotInGroup;
    }

    public String getGroupNotInUser() {
        return groupNotInUser;
    }
}
