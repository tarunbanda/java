import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * Assume that you are developing a feature of an application for a super market.
 * Your feature must manage the customers in a register.
 * Write a program that given the customers in a file, your program
 * process one queue at a time.
 */
public class BrowserNavigation 
{
	public static final boolean SHOW_DETAILS = true;
	
	// Two stacks: one for "Back" button links; another for "Forward" button links
	private StackList<String> backLinks;
	private StackList<String> forwardLinks;
	private String currentLink;
	private boolean first = true;
	
	public BrowserNavigation(String file)
	{
		backLinks = new StackList<String>();
		forwardLinks = new StackList<String>();
		
	}
	
	public void setCurrentLink(String linkName) 
	{
		if (first) {
			currentLink = linkName;
			first = false;
		} else {
			backLinks.push(currentLink);
			currentLink = linkName;
			forwardLinks.clearStackList();
		}

	}

	public void goBack()
	{	
		if(backLinks.isEmpty()) throw new NoSuchElementException("Can't go back any Further");
		forwardLinks.push(currentLink);
		currentLink = backLinks.pop();
	}
	
	public void goForward()
	{
		if(forwardLinks.isEmpty()) throw new NoSuchElementException("Can't go forward");
		backLinks.push(currentLink);
		currentLink = forwardLinks.pop();
	}

	/*
	 * Search both back links and forward links to see if we can find 
	 * the link of interest. 
	 */
	public boolean search(String linkName)
	{
		if (currentLink.contains(linkName))
			return true;
		
		Iterator<String> iterator = backLinks.iterator();		
		while (iterator.hasNext())
		{
			String walker = iterator.next();
			if (walker.equals(linkName))
				return true;
		}
	
		iterator = forwardLinks.iterator();		
		while (iterator.hasNext())
		{
			String walker = iterator.next();
			if (walker.equals(linkName))
				return true;
		}
		return false;
	}
	
	/*
	 * print both back and forward links
	 */
	public void printLinks(String message)
	{
		System.out.println("\n" + message);
		System.out.println("Current Link: " + currentLink);
		System.out.println("back:\n" + backLinks);
		System.out.println("forward:\n" + forwardLinks);
	}

	public static void main(String[] args) 
	{
		final String FILENAME = "resources/links.txt";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\links.txt";	// Directory path for Windows OS (i.e. Operating System)

		BrowserNavigation navigator = new BrowserNavigation(FILENAME);

		File infile = new File(FILENAME);
		try 
		{
			Scanner input = new Scanner(infile);

			String line = "";
			int lineNum = 0;
			while (input.hasNextLine()) 
			{
				lineNum++;
				line = input.nextLine(); 
				String [] tokens = line.split(" ");

				// Note: Once we see a new link. The forward link stack is not valid.
				//       So, need to clear the forward links
				if (line.contains("link"))
				{
					String linkName = tokens[1];
					navigator.setCurrentLink(linkName);
					
					if (SHOW_DETAILS)
						navigator.printLinks("At line #" + lineNum + ": " + line);
					continue;
				}

				// Note: Need to check if there are any back links left
				if (line.contains("back"))
				{
					navigator.goBack();
					
					if (SHOW_DETAILS)
						navigator.printLinks("At line #" + lineNum + ": " + line);
					continue;
				}

				// Note: Need to check if there are any forward links left
				if (line.contains("forward"))
				{					
					navigator.goForward();
					
					if (SHOW_DETAILS)
						navigator.printLinks("At line #" + lineNum + ": " + line);
					continue;
				}
				
				// search for a link
				if (line.contains("contains"))
				{
					String linkName = tokens[1];
					boolean found = navigator.search(linkName);
					if (found)
						System.out.printf("\nLink %s found\n", linkName);
					else
						System.out.printf("\nLink %s NOT found\n", linkName);
				}
			}			
			input.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("\nCan't do that action");
		}

		navigator.printLinks("At the EOF");
	}
}
