package matching_algorithm_screens;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 * Boundary between Matching Algorithm View and Home Screen
 */
public interface HomeMatchesBoundary extends ListSelectionListener {

    void setMatches(JList<String> matches);
    void setMatchingAlgorithmController(MatchingAlgorithmController matchingAlgorithmController);
    void buildScrollPane();
}
