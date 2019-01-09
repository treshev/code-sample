# Charter Enterprise MOTD Sample Project
A small project to help assess candidate experience with webservices and our technology stack.

## Solutions (author - Alexander Treshchev)
Changes in Motd.java:
1) MessageOfTheDay became a class variable.
2) Added two methods to change the message
    a) By PUT request - recommended method, use Request Params newMessageOfTheDay
    b) By GET request - not recommended. But might be used in the case when the user has 
                        the access to the browser only.
    
 p.s. There are several other options like to use Path Variable or Post Request, 
        but from my perspective they less appropriate for this task.
        
  Changes in MotdControllerTest.java
  1) Fix the getMotdTest method
  2) Added two new test method for GET and PUT requests.
  3) Add annotation @DirtiesContext to avoid failed for the getMotdTest method 
        in case if it will run not first.
