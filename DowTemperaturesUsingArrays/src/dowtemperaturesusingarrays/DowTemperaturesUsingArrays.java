//Ahmad Rasoulpour
package dowtemperaturesusingarrays;

import java.util.Arrays;

public class DowTemperaturesUsingArrays
{

    public static void main(String[] args)
    { //start
        //initialization
        int dow = 0;
        int temp = 0;
        //create 4 arrays of integers with size 8 ( 0 - 7 )
        int[] high = new int[8];
        int[] low = new int[8];
        int[] count = new int[8];
        int[] total = new int[8];
        
        ////print out status output. telling user that program strating to calculate
        System.out.println("DOW Temperature Started. Please wait....");
        //while loop for checking dow (it should be between 0 - 7 )

        while (dow < 8)
        {
            high[dow] = -999;
            low[dow] = 999;
            count[dow] = 0;
            total[dow] = 0;
            dow = dow + 1;

        }
        // using class InputFile and create inDow object 
        InputFile inDow = new InputFile("input.txt");
        // using class OutputFile and create out object
        OutputFile out = new OutputFile("output.txt");
        
        //while loop for checking if we are end of file or not
        while (!inDow.eof())
        {
            //read amounts from input file
            dow = inDow.readInt();
            temp = inDow.readInt();
            //compare variable temp with amount in high[dow] for reaching highest temperature
            if (temp > high[dow])
            {
                high[dow] = temp;
            }
            //compare variable temp with amount in low[dow] for reaching lowest temperature
            if (temp < low[dow])
            {
                low[dow] = temp;
            }
            
            //calculate count and total
            count[dow] = count[dow] + 1;
            total[dow] = total[dow] + temp;

        }
        //print out our four arrays on the display
        System.out.println(Arrays.toString(high));
        System.out.println(Arrays.toString(low));
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(total));

        //using for loop, for write the results in the output file.
        for (dow = 1; dow < 8; dow++)
        {
            if (count[dow] > 0)
            {
                out.writeInt(dow);
                out.writeInt(high[dow]);
                out.writeInt(low[dow]);
                out.writeInt(total[dow] / count[dow]);
                out.writeEOL();
                

            }
        }
        out.close();
        //print out end status output. telling user that program was success.
        System.out.println("DOW Temperature Completed Successfully.");
    }

}
