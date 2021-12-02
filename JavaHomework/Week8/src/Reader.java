import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader extends ExtractedInformation {
    static ArrayList<String> informationList = new ArrayList<>();
    private Scanner myReader;

    public Reader(String fileName) {
        try {
            File myObj = new File(fileName);
            myReader = new Scanner(myObj);
            gettingTheValues(myReader);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<String> returningInformationList(){
        return informationList;
    }


    private void gettingTheValues(Scanner scanner){
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            informationList.add(data);
        }
    }

}
