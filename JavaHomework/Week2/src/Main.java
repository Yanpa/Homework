import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Side A: ");
        double sideAOfQuadrilateral = scanner.nextDouble();
        System.out.print("Side B: ");
        double sideBOfQuadrilateral = scanner.nextDouble();

        /*
         * Не измислих начин как да вкарам Scanner в методите на
         * първа задача, а в условието пишеше, че те трябва да са два,
         * затова вместо да ми се налага да давам стойности на страните
         * 2 пъти, го сложих в main.
         */


        perimeterOfQuadrilateral(sideAOfQuadrilateral, sideBOfQuadrilateral);   //Задача №1
        areaOfQuadrilateral(sideAOfQuadrilateral, sideBOfQuadrilateral);        //Задача №1


        monthDetector();          //Задача №2
        betterMonthDetector();    //Задача №2.1

        fallingFromHigh();        //Задача №3
    }

    public static void perimeterOfQuadrilateral(double sideAOfQuadrilateral, double sideBOfQuadrilateral) {
        double perimeter = (sideAOfQuadrilateral + sideBOfQuadrilateral)*2;

        System.out.println("Perimeter: " + perimeter + " см");
    }

    public static void areaOfQuadrilateral(double sideAOfQuadrilateral, double sideBOfQuadrilateral) {
        double areaOfQuadrilateral = sideAOfQuadrilateral * sideBOfQuadrilateral;

        System.out.println("Area: " + areaOfQuadrilateral + " кв.см");
        System.out.println();
    }

    public static void monthDetector() {
        String monthName = "юни";
        if(monthName.equals("януари") || monthName.equals("март") || monthName.equals("май") || monthName.equals("юли")
                || monthName.equals("август") || monthName.equals("октомври") || monthName.equals("декември")) {
            System.out.println("Месец " + monthName + " има 31 дни!\n");
        }
        else if(monthName.equals("април") || monthName.equals("юни") || monthName.equals("септември") || monthName.equals("ноември")) {
            System.out.println("Месец " + monthName + " има 30 дни!\n");
        }
        else if(monthName.equals("февруари")) {
            System.out.println("Месец " + monthName + " има 28 дни (29 при високосна година)!\n");
        }
        else {
            System.out.println("Неразпознат месец!\n");
        }
    }

    public static void betterMonthDetector() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Име на месец (кирилица): ");
        String monthName = scanner.nextLine().trim();
        monthName = monthName.toLowerCase();

        if(monthName.equals("януари") || monthName.equals("март") || monthName.equals("май") || monthName.equals("юли")
                || monthName.equals("август") || monthName.equals("октомври") || monthName.equals("декември")) {
            System.out.println("Месец " + monthName + " има 31 дни!");
            System.out.println();
        }
        else if(monthName.equals("април") || monthName.equals("юни") || monthName.equals("септември") || monthName.equals("ноември")){
            System.out.println("Месец " + monthName + " има 30 дни!");
            System.out.println();
        }
        else if(monthName.equals("февруари")){
            System.out.println("Месец " + monthName + " има 28 дни (29 при високосна година)!\n");
        }
        else{
            System.out.println("Неразпознат месец!\n");
        }
    }

    /*
     *  Не разбрах условието на задача №3, затова я правя по този начин!
     *  Ако трябва да работи като цикъл, поздравявайки всяка жена една по една,
     *  всички "//break;" остават така, но ако трябва да поздравява само жената
     *  на етажа от който скача,трябва да се поставят "break;" във всеки case.
     */

    public static void fallingFromHigh() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTheFloor;
        do {
            System.out.print("Number of the floor (between 1 and 9): ");
            numberOfTheFloor = scanner.nextInt();
        } while (numberOfTheFloor < 1 || numberOfTheFloor > 9);

        switch (numberOfTheFloor) {
            case 9:
                System.out.println("Hello Katy");
                //break;
            case 8:
                System.out.println("Hello Jenny");
                //break;
            case 7:
                System.out.println("Hello Sally");
                //break;
            case 6:
                System.out.println("Hello Anny");
                //break;
            case 5:
                System.out.println("Hello Hope");
                //break;
            case 4:
                System.out.println("Hello Nicole");
                //break;
            case 3:
                System.out.println("Hello Nia");
                //break;
            case 2:
                System.out.println("Hello Grace");
                //break;
            case 1:
                System.out.println("Hello Debby");
                //break;
            default:
                System.out.println("PAIN!");
                break;
        }
    }
}
