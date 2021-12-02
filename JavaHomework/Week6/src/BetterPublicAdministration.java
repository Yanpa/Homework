import java.util.ArrayList;
import java.util.Scanner;

public class BetterPublicAdministration {

    static Scanner scanner = new Scanner(System.in);

    static int numberOfElementsInArrayList = 10_000;
    static ArrayList <String> stringArrayList = new ArrayList<>(numberOfElementsInArrayList);
    static int [] integerArray = new int[numberOfElementsInArrayList];


    public static void main(String[] args) {
        choosingAnOption();
    }

    public static void mainMenu(){
        System.out.println("Моля изберете опция\n1. Работа с числа\n" +
                "2. Работа с думи\n" +
                "3. Изход от програмата\n");
        System.out.print("Вашият отговор: ");
    }

    public static void menuForWorkingWithNumbersOption(){
        System.out.println("Меню с опции:\n" +
                "1. Извеждане само на простите числа от масива\n" +
                "2. Извеждане на най-често срещан елемент в масива\n" +
                "3. Извеждане на максимална редица от нарастващи елементи в масива\n" +
                "4. Извеждане на максимална редица от намаляващи елементи в масива\n" +
                "5. Извеждане на максимална редица от еднакви елементи в масива\n" +
                "6. Извеждане на последователност от числа от масива, които имат сума\n" +
                "равна на число, генерирано на случаен принцип\n" +
                "7. Връщане назад към основното меню");
    }

    public static void menuForWorkingWithStringsOption(){
        System.out.println("Меню с опции:\n" +
                "1. Обърнете буквите на думите от масива наобратно и ги\n" +
                "визуализирайте в конзолата\n" +
                "2. Изведете броя на повтарящите се символи за всяка една от думите в\n" +
                "масива\n" +
                "3. Изведете броя на символите за всяка една от думите в масива\n" +
                "4. Изведете броя на повтарящите се думи от масива\n" +
                "5. Връщане назад към основното меню");
    }

    public static void choosingAnOption(){
        while(true) {
            mainMenu();
            byte answer = scanner.nextByte();

            if (answer == 1) {
                workingWithNumbers();
                continue;
            }
            if (answer == 2) {
                workingWithStrings();
                continue;
            }

            if (answer == 3) {
                System.out.println("You're exiting the program");
                break;
            }
            else {
                System.out.println("You're entering wrong number that's not an option!");
                continue;
            }
        }
    }

    public static void workingWithNumbers(){
        while (true) {
            System.out.print("Please enter a number of the elements you want to create (0 - 10 000): ");
            numberOfElementsInArrayList = scanner.nextInt();
            if(numberOfElementsInArrayList > 10000 || numberOfElementsInArrayList < 0){
                System.out.println("You're out of range, please enter a valid number!");
                continue;
            }
            else break;
        }
        System.out.println("A list with " + numberOfElementsInArrayList + " elements was created.");
        for(int i = 0; i < numberOfElementsInArrayList; ){
            System.out.print("Please enter the " + (i + 1) + " element in the array (0 - 10 000): ");
            integerArray[i] = scanner.nextInt();
            if(integerArray[i] < 0 || integerArray[i] > 10_000){
                System.out.println("This number is out of range! Please enter a valid number.");
                continue;
            }
            i++;
        }

        while(true) {
            menuForWorkingWithNumbersOption();
            System.out.print("Please enter the option you'd like to try: ");
            byte choice = scanner.nextByte();
            if(choice < 0 || choice > 7) continue;
            if(anOptionForWorkingWithNumbers(choice)) break;

        }
    }

    public static boolean anOptionForWorkingWithNumbers(byte theChoice){
        switch(theChoice){
            case 1:
                returningThePrimeNumbers();
                return false;
            case 2:
                returningTheMostCommonNumber();
                return false;
            case 3:
                return false;
            case 4:
                return false;
            case 5:
                return false;
            case 6:
                return false;
            case 7:
                return true;
        }
        return false;
    }

    public static void returningThePrimeNumbers(){
        int count = 0, flag = 0;
        for(int i = 0; i < numberOfElementsInArrayList; i++){
           for(int j = 2; j < integerArray[i]; j++){
               if(integerArray[i] % j == 0){
                   flag = 1;
                   break;
               }
               count++;
           }
           if(flag == 0) System.out.print(integerArray[i] + " ");
           flag = 0;
        }
        if(count == 0) System.out.println("There is no prime numbers");
        System.out.println();
    }

    public static void returningTheMostCommonNumber(){
        int theNumber = 0, count = 0, theMostCommonNumber;
        int[] tempArray = new int[numberOfElementsInArrayList];
        for(int j = 0; j < numberOfElementsInArrayList; j++) {
            for (int i = 0; i < numberOfElementsInArrayList; i++) {
                if(integerArray[j] == integerArray[i]) count++;
            }
            tempArray[j] = count;
            if (j < numberOfElementsInArrayList - 1) count = 0;
        }

        theMostCommonNumber = tempArray[0];

        for(int i = 0; i < numberOfElementsInArrayList; i++){
            if(theMostCommonNumber < tempArray[i]) theMostCommonNumber = tempArray[i];
        }

        for(int i = 0; i < numberOfElementsInArrayList; i++){
            if(theMostCommonNumber == tempArray[i]){
                theNumber = integerArray[i];
            }
        }

        System.out.println("The number " + theNumber + " is found " + theMostCommonNumber + " times");
    }

    public static void workingWithStrings(){

    }
}
