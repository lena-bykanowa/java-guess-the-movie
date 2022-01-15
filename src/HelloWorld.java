import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class HelloWorld{



    public static String getMovieTitle()
    {
        String[] titles = {"dupablada"};

        Random rand = new Random();
        return titles[rand.nextInt(titles.length)];

    }

    public static int printTitle(String title, Vector<Integer> foundIndexes)
    {
        int foundCount = 0;

        for (int i = 0; i < title.length(); i++)
        {
            boolean found = false;

            for (int j = 0; j < foundIndexes.size(); j++)
            {
                if (i == foundIndexes.get(j))
                {
                    System.out.print(title.charAt(foundIndexes.get(j)) + " ");
                    found = true;
                    break;
                }
            }

            if (!found)
                System.out.print("_ ");
            else
                foundCount++;

        }
        System.out.println();

        return foundCount;
    }

    public static void main(String []args)
    {
        // Get random movie title
        String title = getMovieTitle();
        // Create empty indexes of found letters vector
        Vector<Integer> foundIndexes = new Vector<Integer>();
        int tries = 5;

        // Print hidden title
        printTitle(title, foundIndexes);

        // Get user input
        Scanner input = new Scanner(System.in);

        while (tries > 0)
        {

            // This will loop forever until number of characters provided will be equal to tries
            while (!input.hasNext());

            // Get first character of each line provided
            char c = input.next().charAt(0);

            // Check if title contains such character
            int index = title.indexOf(c);
            if (index != -1)
            {
                // Print it and add to vector if contains
                System.out.println("Title contains letter: " + c + " at index: " + index);

            }
            else
            {
                System.out.println("Title doesn't contain letter: " + c);
                tries--;
                continue;
            }

            while (index != -1)
            {
                foundIndexes.add(index);
                index = title.indexOf(c, index + 1);
            }


            if (printTitle(title, foundIndexes) == title.length())
                break;

        }

        if (tries > 0)
            System.out.println("You've won");
        else
            System.out.println("You've lost");
    }
}