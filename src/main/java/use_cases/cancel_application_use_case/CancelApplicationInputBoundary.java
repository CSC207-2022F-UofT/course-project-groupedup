package use_cases.cancel_application_use_case;

/**
 * The input boundary interface for the cancel application use case.
 */
public interface CancelApplicationInputBoundary {
    void cancelApplication(CancelApplicationRequestModel requestModel);
}
