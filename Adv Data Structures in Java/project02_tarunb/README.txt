project folder:
project01_tarunb

Brief description of submitted files:

src/SuperMarket.java
    - Includes main.
    - One object of class SuperMarket stores multiple Queues<String> which 
    	represent customers in a line at a register
    
src/MyTunes.java
	- Includes main.
	- class MyTunes which takes in input of a .json file path and stores it in an ArrayList
	- MyTunes calls FoothllTunesStore to populate the ArrayList of songs 
	- MyTunes also instantiates JukeBox which stores songs as users pay for them
	
src/JukeBox.java
	- One object of JukeBox contains a Queue<SongEntry> and a Stack<SongEntry>
	- Queue stores songs which are paid for with the regular amount
	- Songs which are paid for with a higher amount are stored in the Stack called vipPL
	
src/Queue.java
	- One object of Queue contains a node which has a head and a tail pointer
	- Queue has a enqueue method to add to the tail and a dequeue method to remove node from the head
	- Queue implements iterator to loop through the node objects
	
src/StackList.java
	- One object of StackList contains a top pointer, as well has a node which has a next pointer
	- StackList had three methods pop, push, and peek
	- push adds node objects to the top of the stack
	- pop returns the object that the top of the stack, and removes it
	- peek returns the object at the top of the stack without removing it
	
src/cs1c/FoothillTunesStore
	- Parses json object and populates tunes, an ArrayList of SongEntry
	- groups songs as populates genres, an ArrayList of SongsInGenre
	
src/cs1c/SongsInGenre
	- Helper class that stores genreName and #of songs in the set which belong to the genre

RUN.txt
    - console output for SuperMarket.java
    - console output for MyTunes.java
    - console output for BrowserNavigation.java

README.txt
    - description of submitted files
