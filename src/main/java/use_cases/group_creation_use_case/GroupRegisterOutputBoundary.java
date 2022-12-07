package use_cases.group_creation_use_case;

/**
 * This is an interface between the interacter and the presenter.
 * The presenter implements this interface to create dependency between these two
 * layers. Since the interacter (inner layer) needs to communicate what should be presented
 * in the UI (outer layer).
 */
public interface GroupRegisterOutputBoundary {
    void prepareSuccessView(GroupRegisterResponseModel groupResponseModel);

    void prepareFailView(String error);

}
