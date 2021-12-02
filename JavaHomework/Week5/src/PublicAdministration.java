import java.util.Random;
import java.util.Scanner;

public class PublicAdministration {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static byte arrayLen = 101;
    static byte [] publicAdministration = new byte[arrayLen];

    public static void main(String[] args) {
        /**
         * Навсякъде съм сложил метода "visualizingArrayElements()"
         * така че да е по-лесно да се вижда как работи програмата
         */

        publicAdministrat();
    }

    public static void publicAdministrat(){
        choosingArrayLength();
        enteringValueOfNumbers(arrayLen);
        optionsMenu();

        while(true){
            System.out.print("Please enter the option you'd like to use: ");
            byte choiceOfUser = scanner.nextByte();
            if(choosingAnOptionFromTheOptionMenu(choiceOfUser)) break;
        }
    }

    public static void choosingArrayLength(){
        while(true){
            System.out.print("Enter a number of elements: ");
            arrayLen = scanner.nextByte();
            if(arrayLen < 0 || arrayLen > 100) {
                System.out.println("Please enter a valid number (more than 0)!");
                continue;
            }
            System.out.printf("An array with %d elements will be created\n", arrayLen);
            break;
        }
    }

    public static void enteringValueOfNumbers(byte arrayLen){
        for(int i = 0; i < arrayLen; i++){
            System.out.printf("Please enter element %d: ", (i+1));
            publicAdministration[i] = scanner.nextByte();
        }
    }

    public static void optionsMenu(){
        System.out.println();
        System.out.println("Меню с опции:\n" +
                "1. Сортиране на въведените числа във възходящ ред\n" +
                "2. Сортиране на въведените числа в низходящ ред\n" +
                "3. Търсене на позиция на конкретно число\n" +
                "4. Разбъркване на числата\n" +
                "5. Изчисляване на сбора на всички числа\n" +
                "6. Намиране на най-голямото число\n" +
                "7. Намиране на най-малкото число\n" +
                "8. Намиране средно-аритметично на числата\n" +
                "9. Проверка за симетричност на масива от числа\n" +
                "10. Обръщане на масива от числа\n" +
                "11. Визуализирай въведените числа\n" +
                "12. Изход\n");
    }

    public static void switchingPlaces(int indexOfFirst, int indexOfSecond){
        byte temp = publicAdministration[indexOfFirst];
        publicAdministration[indexOfFirst] = publicAdministration[indexOfSecond];
        publicAdministration[indexOfSecond] = temp;
    }

    public static void sortingToTheHighest(){
        for (int i = 0; i < arrayLen-1; i++) {
            for (int j = 0; j < arrayLen - 1 - i; j++) {
                if (publicAdministration[j] > publicAdministration[j+1]) {
                    switchingPlaces(j, j+1);
                }
            }
        }
        System.out.println("Sorted list from lowest to highest:");
        visualizingArrayElements();
    }

    public static void sortingToTheLowest(){
        for (int i = 0; i < arrayLen - 1; i++) {
            for (int j = 0; j < arrayLen - 1 - i; j++) {
                if (publicAdministration[j] < publicAdministration[j+1]) {
                    switchingPlaces(j, j+1);
                }
            }
        }
        System.out.println("Sorted list from highest to lowest:");
        visualizingArrayElements();
    }

    public static void returningIfNumberIsPresent(){
        System.out.print("Please tell me the number you're looking for: ");
        byte numberWeLookFor = scanner.nextByte();

        byte result = searchingForANumber(publicAdministration, numberWeLookFor);

        if(result == -1)
            System.out.println("The number isn't present");
        else
            System.out.printf("The number %d is present at index %d\n", numberWeLookFor, result);
    }

    public static byte searchingForANumber(byte[] array, byte searchedNumber){
        byte firstIndexOfArray = 0;
        byte lastIndexOfArray = (byte)(arrayLen - 1);

        System.out.println("The array is being sorted from lowest to highest for this method to work!");
        sortingToTheHighest();

        while (firstIndexOfArray <= lastIndexOfArray) {
            byte middleIndexOfArray = (byte) (firstIndexOfArray + (lastIndexOfArray - firstIndexOfArray) / 2);
            if(array[middleIndexOfArray] == searchedNumber)
                return middleIndexOfArray;
            if(array[middleIndexOfArray] < searchedNumber)
                firstIndexOfArray = (byte) (middleIndexOfArray + 1);
            else
                lastIndexOfArray = (byte) (middleIndexOfArray - 1);
        }

        return -1;
    }

    public static byte highestNumberInArray(){
        byte max = publicAdministration[0];
        for(int i = 0; i < arrayLen - 1; i++){
            if(publicAdministration[i] < publicAdministration[i+1]) max = publicAdministration[i+1];
        }
        return max;
    }

    public static byte lowestNumberInArray(){
        byte low = publicAdministration[0];
        for(int i = 0; i < arrayLen - 1; i++){
            if(publicAdministration[i] > publicAdministration[i+1]) low = publicAdministration[i+1];
        }
        return low;
    }

    public static int calculatingSumOfArray(){
        int sumOfAllNumbers = 0;
        for(int i = 0; i < arrayLen; i++)
            sumOfAllNumbers += publicAdministration[i];
        return sumOfAllNumbers;
    }

    public static int findingSumsAverageOfTheArray(){
        int sum = calculatingSumOfArray();
        return sum/arrayLen;
    }

    public static boolean isTheArraySymmetrical(){
            for(int j = arrayLen -1, x = 0; j >= 0 ; j--, x++){
                if(publicAdministration[x] != publicAdministration[j])
                    return false;
            }
        return true;
    }

    public static void mirrorTheArray(){
        for(int i =0, j = arrayLen - 1; i < arrayLen/2; i++, j--)
            switchingPlaces(i, j);

        System.out.println("This is the mirrored array you've created: ");
        visualizingArrayElements();
    }

    public static void randomizeTheNumbersInTheArray(){
        for(int i = 0; i < arrayLen; i++) {
            int theNewPosition = random.nextInt(arrayLen);
            switchingPlaces(i, theNewPosition);
        }

        visualizingArrayElements();
    }

    public static boolean choosingAnOptionFromTheOptionMenu(byte choice){
        switch (choice){
            case 1:
                sortingToTheHighest();
                optionsMenu();
                return false;
            case 2:
                sortingToTheLowest();
                optionsMenu();
                return false;
            case 3:
                returningIfNumberIsPresent();
                optionsMenu();
                return false;
            case 4:
                randomizeTheNumbersInTheArray();
                optionsMenu();
                return false;
            case 5:
                System.out.println("The sum of all elements in the array is: " + calculatingSumOfArray());
                optionsMenu();
                return false;
            case 6:
                System.out.println("The highest number in the array is: " + highestNumberInArray());
                optionsMenu();
                return false;
            case 7:
                System.out.println("The lowest number in the array is: " + lowestNumberInArray());
                optionsMenu();
                return false;
            case 8:
                System.out.println("Average of the array: " + findingSumsAverageOfTheArray());
                optionsMenu();
                return false;
            case 9:
                System.out.println(isTheArraySymmetrical() ? "The array is symmetrical" : "The array isn't symmetrical");
                optionsMenu();
                return false;
            case 10:
                mirrorTheArray();
                optionsMenu();
                return false;
            case 11:
                visualizingArrayElements();
                optionsMenu();
                return false;
            case 12:
                System.out.println("Thank you for using our services");
                return true;
            default:
                System.out.println("There is no such option. Try again!");
                return false;
        }
    }

    public static void visualizingArrayElements(){
        for(int i = 0; i < arrayLen; i++){
            System.out.printf("This is the %d element of the array: %d\n", i+1, publicAdministration[i]);
        }
        System.out.println();
    }
}
