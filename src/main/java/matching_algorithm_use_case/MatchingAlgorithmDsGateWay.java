package matching_algorithm_use_case;

import Entities.Group;

import java.util.List;

public interface MatchingAlgorithmDsGateWay {
    //This is under the assumption of serialization! otherwise it would be a List<String>
    List<Group> getGroups();

}
