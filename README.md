# java-forum-libs

Test out some libraries! 
This project performs a very basic task - It reads a list of names, and determines the number of times each 
letter appears in each name and finally in the entire file. It is really super-useful.

# To run the app:

The project runs maven, but it uses the maven helper, to avoid the need to install maven! The correct version 
will automatically be downloaded.

Just run: 
`./mvnw` or `mvnw.cmd`

# Important points:

- The app is built for Java 7, so some of the newer, cooler features aren't there. :(
- The toString method on the Person class is purposefully slow
- The app runs through Spring Boot. This is just done to make the imports and actual running of the app easier. 
You DONT need to know Spring Boot to understand the app. 
- A basic logback configuration file is already configured in the resources folder. Since spring includes Logback
by default, our app will automatically use this as the logging framework.

# Step 1 (logging):

The logging in this application is pretty terrible! Its slow (on purpose) and everything just goes to std out. 
Lets rather use a logging framework to make the logging more controllable and faster!

- Using slf4j to replace the logging messages in the App and Person classes. 
- The logging in the Person class is just for debugging purposes, and so can be emitted at the "debug" level
- Everything else should be at info level 
- Be sure to only construct the logging message itself if the logging is actually going to be emitted. Avoid that 
SLOW toString method on the Person class, if possible.
- Be sure to also get rid of the e.printStackTrace()'s - They should be logged away like everything else. 

# Step 2 (Guava): 

- The preconditions on the method calls are currently pretty long and uninteresting. Replace them with 
a Guava Precondition equivalent
- The outputting of the command line arguments is currently running in a for loop since arrays don't 
get shown very nicely. Lets rather display a list directly. Use the Guava collection utilities found in the Lists 
interface to convert the array to a list, and display that directly.
- Counting occurrences of a particular object is exactly the role that is performed by the Multiset collection 
from Guava. Convert the Person.getCharacterCounts methods to return a Multiset, and use a Multiset instead of a 
simple Map in the main method of the App.

# Step 3 (Commons IO):

- Writing custom code to read a file line by line is ok, but there is already tools out there for this! 
- Use the LineIterator from the commons-io utilities to read all the lines in the file.

# Step 4 (Lombok):

- Getters, Setters, toStrings, equals and hashcode are all pretty boilerplate stuff. Annotate the Person class 
to auto-generate these methods.
- Be sure to include whatever plugins are required for your IDE to avoid it showing you errors all the time.