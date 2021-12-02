import java.io.*;
import java.util.Scanner;

public class TheReader {
    private Scanner myReader;

    public TheReader(String fileName,int[] array) {
        try {
            File myObj = new File(fileName);
            myReader = new Scanner(myObj);
            int i=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] lineParts = data.split("=");
                array[i] = Integer.parseInt(lineParts[1]);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

