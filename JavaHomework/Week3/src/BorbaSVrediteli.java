import java.util.Random;
import java.util.Scanner;

public class BorbaSVrediteli {
    public static void main(String[] args) {
        objectsAndRobots();

        while(true) {
            isMouseInFrontOfUs();
            isBatteryFullyCharged();

            //funkciqHmm();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Is there any more mouses? (Yes or No): ");
            String customerAnswer = scanner.nextLine().trim().toLowerCase();

            while (!customerAnswer.equals("yes") && !customerAnswer.equals("no")) {
                System.out.println("Invalid answer");
                System.out.print("Is there any more mouses? (Yes or No): ");
                customerAnswer = scanner.nextLine().trim().toLowerCase();
                if(customerAnswer.equals("yes") || customerAnswer.equals("no"))
                    break;
            }

            if (customerAnswer.equals("yes"))
                continue;

            if (customerAnswer.equals("no")) {
                for (int i = 10; i >= 1; --i) {
                    if (i % 2 == 0) {
                        System.out.println(i + " I am Robotttt");
                        continue;
                    }
                    System.out.println(i);
                }
                break;
            }
        }
    }

    public static void objectsAndRobots() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Object in front of the robot (стол, стена, нищо): ");
            String objectInFrontOfTheRobot = scanner.nextLine().trim();
            objectInFrontOfTheRobot.toLowerCase();

            if (objectInFrontOfTheRobot.equals("стол")) {
                System.out.println("Robot Jumps over it"); //returns "Robot Jumps over it"
                break;
            }
            if (objectInFrontOfTheRobot.equals("стена")) {
                System.out.println("Robot goes sideways"); //returns "Robot goes sideways"
                break;
            }
            if (objectInFrontOfTheRobot.equals("нищо")) {
                System.out.println("Robot goes Forward"); //returns "Robot goes Forward"
                break;
            }
            System.out.println("Invalid object!");
        }
    }

    public static void isMouseInFrontOfUs() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please say how much pixels are on the screen: ");
            int numberOfPixelsOnTheScreen = scanner.nextInt();
            boolean isPixelsAnEvenNumber = (numberOfPixelsOnTheScreen % 2 == 0);
            if (isPixelsAnEvenNumber) {
                System.out.println("There it is! Go for the kill!");
                break;
            }
            if (!isPixelsAnEvenNumber) {
                System.out.println("The mouse wasn't found...");
                objectsAndRobots();
            }
        }
    }

    public static void canWeSaveTheFurniture() {
        Random random = new Random();
        int theHolyNumber = random.nextInt(10) + 1;
        if (theHolyNumber == 5) {
            System.out.println("We have good news and bad news. Bad news: your furniture is gone.\n" +
                    " Good news: We don't have to buy you a new furniture, look at the contract.\n" +
                    " The sentences with the small letters are important! ");
        } else System.out.println("The mouse is gone and the furniture is save!");
    }

    public static void processOfChargingTheBattery() {
        while(true){
            Random random = new Random();
            int firstRandomNumber = random.nextInt(1000) + 1;
            int secondRandomNumber = random.nextInt(1000) + 1;

            if(firstRandomNumber > secondRandomNumber){
                System.out.println("There is electricity in this socket! Charging... and POW!");
                break;
            } if(firstRandomNumber < secondRandomNumber){
                System.out.println("There is no electricity! Looking for new socket...");
            }
        }
    }

    public static void isBatteryFullyCharged() {
        byte numberOfPunchesLeft = 4;
        while (numberOfPunchesLeft != 0) {
            System.out.println("We can make the punch!");
            canWeSaveTheFurniture();
            --numberOfPunchesLeft;
            isMouseInFrontOfUs();
        }
        System.out.println("We need to charge the battery...");
        processOfChargingTheBattery();
        numberOfPunchesLeft = 4;
    }

    public static boolean funkciqHmm(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Is there any more mouses? (Yes or No): ");
        String customerAnswer = scanner.nextLine().trim().toLowerCase();

        while (!customerAnswer.equals("yes") && !customerAnswer.equals("no")) {
            System.out.println("Invalid answer");
            System.out.print("Is there any more mouses? (Yes or No): ");
            customerAnswer = scanner.nextLine().trim().toLowerCase();
            if(customerAnswer.equals("yes") || customerAnswer.equals("no"))
                break;
        }

        if (customerAnswer.equals("yes"))
            return false;

        if (customerAnswer.equals("no")) {
            for (int i = 10; i >= 1; --i) {
                if (i % 2 == 0) {
                    System.out.println(i + " I am Robotttt");
                    continue;
                }
                System.out.println(i);
            }
            return true;
        }

        return false;
    }
}
