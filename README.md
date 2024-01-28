# IvanM_BC_TechAssignment
TestScenariosForTheBettingExpertLoginForm

# Overview
The idea behind writing test scenarios for this login form was to make quality functional and UI tests for it. All tests are parametarised so you can easily change Emails, usernames 
and passwords and use your own for the purpose of testing. 
Few reminders:
* Tests like NewPasswordLoginTest from the LoginTestSuite can be ran successfully only once, after that you will have to change old password to a newly created one in order to run it 
successfully again. 
* BlockedUserMsgTest blocks the real user for a day with the username: cy  (username should be changed to avoid that) *I will refer to this later in the Conclusion
* InactiveUserMsgTest will fail if you dont use credentials of a newly created unregistered user
# Key Topics
Tests are divided into three suites:
* <b>LoginTestsSuite</b> testing successful and unsuccessful login scenarios, NewPasswordLoginTest changes password and checks if a user successfuly logs in with a new one 
* <b>RedirectionsTestSuites</b> (with screenshots) testing all the links on a login form, I made methods that take screenshots of the BC homepage, Facebook and Google page I thought it
would be nice to have that as a validator in test.
* <b>WarningMessagesTestSuite</b> containing tests validating warning messages and some other funcionalities on the login form, BlockedUserTest also successfully checks remember me functionality
* GetPasswordLengthTest and SpecialCharactersAcceptanceTest are 2 individual Tests  
# Conclusion
InvalidPasswordMsgTest and InvalidUserMsgTest can be used as Boundary tests for maximum and minumum allowed characters in the text fields, with only changing parameters in the test class
I didn't make BoundaryTestSuite when it was clear to me minimum characters for the username is 2 and 8 for the password. In addition to that I made GetPasswordLengthTest to check if there
is characters no. limitations and it seems there isn't, also checked with the HTML.

SpeciaCharactersAndNumbersAcceptanceTest can be used for a penetrations test (For the SQL injection or JSinjection) as the text fields accept special characters.

*This would be the good place to refer to a previous mark: <strong> I think big lack of the app is that it allows the user to register with only 2 characters, that way I blocked the real user 
with username: cy in the first day of testing, thus it allows anyone to either accidentally or on purpose block other users. </strong>
# Instructions
Clone the project and run it on your local machine in the program of preference (I used IntellijIdea), essential folders for this are in the project: src, target, pom.xml

Git workflow
* git clone
* git add
* git commit
* git branch
* git push  (contributions are welcome:)
* git pull



