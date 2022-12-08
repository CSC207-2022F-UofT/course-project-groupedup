# GroupedUp

This is the repository for group 47 in tutorial 0201. 
The purpose of our application is to create an app for UofT students to find groups! There are 8 features: login/logout, create group, edit user or group profile, Apply/Leave/Cancel/Approve group application, and find groups through our Matching Algorithm.

You can find our **workflow documents** under the Projects tab: where we have our pull request history and backlog.

## Checklist for our Project Setup
- [X] Verify the correct settings for project repository
- [X] Set up Github Projects
- [X] Create the implementation plan using issues and Github Projects
- [X] Create development branches for each feature
- [X] Use pull requests to merge finished features into main branch
- [X] Develop data persistence method: Serialization

## Checklist for Required Actions for Implementation
- [X] Implement use cases corresponding to issues in GitHub
- [X] Conduct code reviews
- [X] Create tests for each use case
- [X] Implement screens for each use case
- [X] Connect screens to have a functional UI
- [X] Organize package structure to abide by Clean Architecture
- [X] Add Javadocs and improve documentation

## Future Extensions
- [ ] Delete Group feature (when the only person in the group requests to leave)
- [ ] Search groups by groupName feature
- [X] Logout use case (currently implemented but not linked and used)

## Instructions
- To run the tests under individual use cases, click the "run test with code coverage" button.
- To run the program for the first time;
  - Navigate to Main.java under src/main/java,
  - Click the Run 'Main.java' button.
- For each subsequent run; 
  - comment the line under "initial call for data access",
  - uncomment the line under "data access call for subsequent runs",
  - Click the Run 'Main.java' button.
  - This is to ensure that the serialization files work properly.
- Once the program is run, the pop-up screen will allow you to register or login. You can navigate within the program to perform other features such as Create Group or Apply/Cancel application.

## Changes made in response to Milestone 4 feedback
-  Functionality: every use case and UI is completely finished. The screens were implemented using CardLayout and JPanels. All the screens between the use cases are connected and the screens are also properly connected to the backend. 
-  Pull Requests: each have descriptions regarding their content
-  Testing: Each use case interactor has tests (see test section of README for coverage details)
-  Code Organization: refactored all the package names to follow convention (lowercases and underscores). Reorganized the packages so they are seperated by layers of clean architecture (entities, use cases, interface adapters, view/database) and then seperated by use case within those layers as well. Removed the gradle files from the repo.
-  Github Features: Added issues for making tests/including Javadoc
-  Clean Architecture: All presenters do not return ResponseModels and they directly change the UI to abide by CA.
-  Code Style and Documentation: Every member included Javadoc on all public classes and methods. Naming conventions were fixed.
-  Design Patterns & Code Smells: Added Javadoc to explain purpose/future extension of Group Factory as suggested by TA in online meeting. Strategy pattern was used for matching algorithm. Hard coded failure/sucess messages were fixed by making a Class which has getter methods for String attribute message. No more hard coded strings in use cases.

## Test Coverage for each feature's use case package
- 


## How we made use of GitHub
- 

## Workflow Documents
With our workflow documents, you can see our many pull requests, their assignees, reviewers, and progress. We use this to see which pull requests are ready for review and which are just to submit progress on features.
## Application Plan:
https://drive.google.com/file/d/18PkmSlkVMP6b8YZGq7eBeu2o6UZ3q98n/view?usp=drivesdk
## UI Design:
https://docs.google.com/document/d/1-kXhyQLfrXeKBL2xqtFvdb_CC7MByZT_Sg_0k9GiqfY/edit?usp=sharing
