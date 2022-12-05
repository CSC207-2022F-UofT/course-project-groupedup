package cancel_application_screens;

// TODO: throw runtime exception in interactor instead, not as a screen
public class CancelApplicationFailed extends RuntimeException {
    public CancelApplicationFailed(String error) {
        super(error);
    }
}
