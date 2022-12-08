package matching_algorithm_tests;

import entities.InteractorMessages;
import interface_adapters.matching_algorithm_adapters.MatchingAlgorithmController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.matching_algorithm_use_case.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test for the matching algorithm use case feature 6
 */
public class MatchingAlgorithmUseCaseTest {
    /**
     * Test a successful implementation using the mock repository from in InMemomoryMatchesSuccess.
     * A successful result will remove any groups that either do not have the same course code, the user is
     * a part of, or has already requested to join. Furthermore, we test the success message if it is correct
     */
    @Test
    public void matchingAlgorithmInteractorSuccessTest(){
        MatchingAlgorithmDsGateWay matchingAlgorithmDsGateWay = new InMemoryMatchesSuccess();

        MatchingAlgorithmOutputBoundary matchesPresenter = new MatchingAlgorithmOutputBoundary(){
            @Override
            public void prepareSuccessView(MatchingAlgorithmResponseModel responseModel){
                List<String> expected = new ArrayList<>();
                expected.add("csc236: group2");
                expected.add("csc207: group1");
                assertEquals(InteractorMessages.MATCHES_UPDATED, responseModel.getMatchesUpdatedMessage());
                assertEquals(expected, responseModel.getGroups());
            }

            @Override
            public void prepareFailView(String error){
                Assertions.fail("Unexpected fail");
            }
        };

        String username = "username";

        MatchingAlgorithmInputBoundary matchingAlgorithmInputBoundary =
                new MatchingAlgorithmInteractor(matchesPresenter, matchingAlgorithmDsGateWay);

        MatchingAlgorithmController controller = new MatchingAlgorithmController(matchingAlgorithmInputBoundary);
        controller.matchingAlgorithm(username);
    }

    /**
     * Test whether the interactor reports that there is a failure if the user has no matches, meaning there is are
     * no groups in the repository
     */
    @Test
    public void matchingAlgorithmInteractorFailTest(){
        MatchingAlgorithmDsGateWay matchingAlgorithmDsGateWay = new InMemoryMatchesFail();

        MatchingAlgorithmOutputBoundary matchesPresenter = new MatchingAlgorithmOutputBoundary(){
            @Override
            public void prepareSuccessView(MatchingAlgorithmResponseModel responseModel){
                List<String> expected = new ArrayList<>();
                expected.add("csc236: group2");
                expected.add("csc207: group1");
                Assertions.fail("Unexpected Success");
            }

            @Override
            public void prepareFailView(String error){assertEquals(InteractorMessages.NO_MATCHES, error);

            }
        };

        String username = "username";

        MatchingAlgorithmInputBoundary matchingAlgorithmInputBoundary =
                new MatchingAlgorithmInteractor(matchesPresenter, matchingAlgorithmDsGateWay);

        MatchingAlgorithmController controller = new MatchingAlgorithmController(matchingAlgorithmInputBoundary);
        controller.matchingAlgorithm(username);
    }

}
