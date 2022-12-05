package leave_group_screens;

// TODO: throw runtime exception in interactor instead, not as a screen
public class LeaveGroupFailed extends RuntimeException {
    public LeaveGroupFailed(String error) {
        super(error);
    }
}
