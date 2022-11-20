package group_creation_use_case;

public interface GroupRegisterOutputBoundary {
    GroupRegisterResponseModel prepareSuccessView(GroupRegisterResponseModel group);

    GroupRegisterResponseModel prepareFailView(String error);

}
