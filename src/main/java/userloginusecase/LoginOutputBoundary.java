package userloginusecase;


public interface LoginOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
