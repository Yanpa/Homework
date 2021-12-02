import java.util.Scanner;

public class TheMostBoringJob {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reader myReader = new Reader("Data.txt");

        String[] temp = myReader.returningInformationList().toArray(new String[0]);

        Decoding decoding = new Decoding(temp);

        System.out.print("Choose an option (Only one works for the time being and is Select): ");
        String answer = scanner.nextLine().toLowerCase().trim();
        if(answer.equals("select")) {
            decoding.exInfForP1.getAll();
            System.out.println();
            decoding.exInfForP2.getAll();
            System.out.println();
            decoding.exInfForP3.getAll();
        }
    }
}
