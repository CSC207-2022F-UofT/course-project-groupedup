package cancel_application_screens;

public class CancelApplicationFailed extends RuntimeException {
    public CancelApplicationFailed(String error) {
        super(error);
    }
}
