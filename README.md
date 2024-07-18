Ceilingfan project contains both front end and backend code written with react and springboot frameworks
ceiling-fan is backend project, where fan-unit is frontend 
Java version used is 17 and Node.js should be installed while executing the code. npm packages are not added to the project.
Ceiling fan front end UI has two cords to pull, while first one changes the speed setting and second one changes the direction of the fan.
Refreshing of the UI screen resets the fan settings to OFF and FORWARD direction, where the attributes of the fan bean are reset during page refresh in the browser
Ports used for frontend is 3000 and backend is 8080
Unit test cases are written for backend functionalities of pulling cord1 and cord2

Problem Statement: 
·  The unit has 2 pull cords:

o    One increases the speed each time it is pulled.  There are 3 speed settings, and an “off” (speed 0) setting. 

§  If the cord is pulled on speed 3, the fan returns to the “off” setting.

o    One reverses the direction of the fan at the current speed setting.

§  Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.

·   You can assume the unit is always powered (no wall switch)

Include  Unit Test cases as well in the deliverable. 

