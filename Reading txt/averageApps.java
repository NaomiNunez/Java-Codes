
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class averageApps
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter your fill file name: ");
            String fileName = keyboard.nextLine();
            Scanner file = new Scanner(new File(fileName));
            
            ArrayList<Float> numList = new ArrayList<Float>();
            while (file.hasNext())
            {
                numList.add(file.nextFloat());
            }
            System.out.println("Whole array: " + numList);
            
            System.out.println("Numbers in first column");
            float sum = 0;
            int numIn = 0;
            for (int i = 0; i < numList.size(); i = i + 2 )
            {
                System.out.println(numList.get(i));
                sum += numList.get(i);
                numIn = numIn + 1;
            }
            System.out.println("Average of first column: " + sum/numIn);

            
            System.out.println("Numbers in second column");
            float sum2 = 0;
            int numIn2 = 0;
            for (int i = 1; i < numList.size(); i = i + 2 )
            {
                System.out.println(numList.get(i));
                sum2 += numList.get(i);
                numIn2 = numIn2 + 1;
            }
            System.out.println("Average of second column: " + sum2/numIn2);
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("There was an error");
        }
        finally
        {
            System.out.println("End of file");
        }
    }
}
