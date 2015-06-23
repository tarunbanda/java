import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs1c.TimeConverter;

/*
 * Reads an input file that contains the prices (whole numbers) of the different items.
 * Then stores and outputs a list of items we can buy
 * given the condition of how much money you have in your wallet.
 * We're at a cash only store. So, no checks or on credit purchases!
 * 
 * example output:
 Groceries wanted:
 [3, 4, 6, 2, 15, 7, 5, 1, 11]
 Enter how much cash you have:
 25

 Purchased grocery prices are:
 [15, 7, 2]

 Algorithm Elapsed Time: 0 hrs : 0 mins : 0 sec : 2 ms : 155000 ns : ,  seconds.
 */
public class ShoppingBag //implements Comparable<ArrayList<Integer>>
{
    public static ArrayList<Integer> priceOfGroceries;
    public static ArrayList<ArrayList<Integer>> collection;

    public ShoppingBag(String filename) throws FileNotFoundException,
            NoSuchElementException, IOException
    {
        
        priceOfGroceries = new ArrayList<Integer>(); // initialize priceOfGroceries
        collection = new ArrayList<ArrayList<Integer>>(); // initialize collection
        collection.add(new ArrayList<Integer>()); 

        // open scanner to read file
        final Scanner fileScanner = new Scanner(new File(filename));
        String line = fileScanner.nextLine();

        // parse file and write integers to Array
        while (line != null)
        {
            final String[] tokens = line.split(" ");
            priceOfGroceries.add(Integer.parseInt(tokens[1]));
            if(fileScanner.hasNext())
                  line = fileScanner.nextLine();
            else
                break;
        }
        fileScanner.close();
    }

    // accessor to get priceOfGroceries
    public ArrayList<Integer> getPriceOfGroceries()
    {
        return priceOfGroceries;
    }

    // takes budget as in input and finds subset sum of price of groceries
    public ArrayList<Integer> findSubset(int budget)
    {
        if (budget >= sumArray(priceOfGroceries))
            return priceOfGroceries;
        for (int i = 0; i < priceOfGroceries.size(); i++)
        {
            final int size = collection.size();

            for (int k = 0; k < size; k++)
            {
                final ArrayList<Integer> colItem= new ArrayList<>(collection.get(k));

                if (sumArray(colItem) + priceOfGroceries.get(i) < budget)
                {
                    colItem.add(priceOfGroceries.get(i));
                    collection.add(colItem);
                }
                else if (sumArray(colItem) + priceOfGroceries.get(i) == budget)
                {
                    colItem.add(priceOfGroceries.get(i));
                    collection.add(colItem);
                    return colItem;
                }
            }
        }
        return collection.get(findMaxSubset());
    }
    
    // helper to find maxSubset
    private int findMaxSubset()
    {
        int maxSubset = 0;
        int maxSubsetIndex = 0;

        for (int i = 0; i < collection.size(); i++)
        {
            if(sumArray(collection.get(i)) > maxSubset)
            {
                maxSubset = sumArray(collection.get(i));
                maxSubsetIndex = i;
            }
        }
        return maxSubsetIndex;
    }

    // helper class to sum arrays
    private int sumArray(ArrayList<Integer> array)
    {
        int sum = 0;
        for (int i = 0; i < array.size(); i++)
            sum += array.get(i);
        return sum;
    }

    public static void main(String[] args)
    {
        final String FILENAME = "resources/groceries.txt"; // Directory path for Mac OS X
        // final String FILENAME = "resources\groceries.txt"; // Directory path for Windows OS (i.e. Operating System)
        
        try
        {

            final ShoppingBag bag = new ShoppingBag(FILENAME);
            final ArrayList<Integer> shoppingList = bag.getPriceOfGroceries();
            System.out.println("Groceries wanted:");
            System.out.println(shoppingList);

            System.out.println("Enter how much cash you have:");
            final Scanner keyboard = new Scanner(System.in);
            final int budget = Integer.parseInt(keyboard.next());
            keyboard.close();

            long startTime, estimatedTime;

            // capture start time
            startTime = System.nanoTime();

            // implement finding subset of groceries that is closest to meeting
            // budget
            // NOTE: In this part, you only need to keep track of the price of
            // each
            // item,
            // and not the name of the item you are buying.
            final ArrayList<Integer> purchases = bag.findSubset(budget);

            // stop and calculate elapsed time
            estimatedTime = System.nanoTime() - startTime;

            // output the result
            System.out.println("Purchased grocery prices are:");
            System.out.println(purchases);

            // report algorithm time
            System.out.println("\nAlgorithm Elapsed Time: "
                    + TimeConverter.convertTimeToString(estimatedTime) + ", "
                    + " seconds.\n");

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (NoSuchElementException e)
        {
        } catch (IOException e)
        {

        }
    }
}