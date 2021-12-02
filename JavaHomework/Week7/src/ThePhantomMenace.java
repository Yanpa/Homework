import java.util.Random;
import java.util.Scanner;

import static java.lang.StrictMath.abs;

public class ThePhantomMenace {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int gameBoardHeight;
    static int gameBoardWidth;
    static int mines;
    static int numberOfProbes;
    static int defusesLeft;
    static int heightOfStart = 0, widthOfStart = 0, heightOfFinish = 0, widthOfFinish = 0;
    static int playerHeightCoordinates = heightOfStart, playerWidthCoordinates = widthOfStart;
    static char[][] mineField;
    static boolean[][] whereTheMinesAre;

    public static void main(String[] args) {
        gettingValues();
        gameBoard();
    }


    public static void gettingValues() {
        int[] tempArr = new int[3];
        TheReader reader = new TheReader("enemy_territory.txt",tempArr);
        gameBoardWidth=tempArr[0];
        gameBoardHeight=tempArr[1];
        mines=tempArr[2];
        mineField= new char[gameBoardHeight][gameBoardWidth];
        whereTheMinesAre = new boolean[gameBoardHeight][gameBoardWidth];

        int[] tempArr2 = new int[2];
        TheReader reader1 = new TheReader("configurations.txt", tempArr2);
        numberOfProbes = tempArr2[0];
        defusesLeft = tempArr2[1];
    }

    public static void gameBoard() {
        for (int i = 0; i < gameBoardHeight; i++) {
            for (int j = 0; j < gameBoardWidth; j++) {
                mineField[i][j] = 'X';
            }
        }
        piecesOfTheBoard();
        settingMines();
        while(true) {
            printGameBoard();
            playerMovement();
            printingOptionsAndInformation();
            if(numberOfProbes == 0){
                System.out.println("Game Over! You lost!");
                break;
            }
            if(mineField[heightOfFinish][widthOfFinish] != 'F'){
                System.out.println("You win!");
                break;
            }
            if(whereTheMinesAre[playerHeightCoordinates][playerWidthCoordinates]){
                System.out.println("Game Over! You lost!");
                break;
            }
        }
    }

    public static void printingOptionsAndInformation(){
        System.out.println("1. Анализ\n" +
                "2. Обезвреждане\n" +
                "3. Придвижване, по бойното поле");

        int choice;
        while(true) {
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();
            if(choice < 4 && choice > 0) break;
            else System.out.println("Invalid input");
        }

        switch (choice){
            case 1:
                analyzingForMines();
                break;
            case 2:
                defusingTheMines();
                break;
            case 3:
                movingPlayer(playerHeightCoordinates, playerWidthCoordinates);
                break;
        }
    }

    public static void settingMines(){
        for (int i = 0; i < gameBoardHeight; i++) {
            for (int j = 0; j < gameBoardWidth; j++) {
                whereTheMinesAre[i][j] = false;
            }
        }
        while (mines>0) {
            int h = random.nextInt(gameBoardHeight);
            int w = random.nextInt(gameBoardWidth);
            whereTheMinesAre[h][w] = true;
            mines--;
        }
    }


    public static void printGameBoard(){
        for(int i = 0; i < gameBoardHeight; i++){
            System.out.print(i + " ");
            for(int j = 0; j < gameBoardWidth; j++)
                System.out.print(mineField[i][j] + " ");
            System.out.println();
        }
        System.out.print(" ");
        for (int i = 0; i< gameBoardWidth; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public static void piecesOfTheBoard(){
        choosingSidesToPutStartAndFinish();
    }

    public static void choosingSidesToPutStartAndFinish(){
        int sideWhereWeStart = random.nextInt(4);
        int sideWhereWeFinish = random.nextInt(4);

        while (sideWhereWeStart == sideWhereWeFinish) sideWhereWeFinish = random.nextInt(4);

        switch (sideWhereWeStart) {
            case 0:
                widthOfStart = 0;
                heightOfStart = random.nextInt(abs(gameBoardHeight));
                break;
            case 1:
                heightOfStart = 0;
                widthOfStart = random.nextInt(abs(gameBoardWidth));
                break;
            case 2:
                heightOfStart = gameBoardHeight - 1;
                widthOfStart = random.nextInt(abs(gameBoardWidth));
                break;
            case 3:
                heightOfStart = random.nextInt(abs(gameBoardHeight));
                widthOfStart = gameBoardWidth - 1;
                break;
        }

        switch (sideWhereWeFinish) {
            case 0:
                widthOfFinish = 0;
                heightOfFinish = random.nextInt(abs(gameBoardHeight));
                break;
            case 1:
                heightOfFinish = 0;
                widthOfFinish = random.nextInt(abs(gameBoardWidth));
                break;
            case 2:
                heightOfFinish = gameBoardHeight - 1;
                widthOfFinish = random.nextInt(abs(gameBoardWidth));
                break;
            case 3:
                heightOfFinish = random.nextInt(abs(gameBoardHeight));
                widthOfFinish = gameBoardWidth - 1;
                break;
        }

        mineField[heightOfStart][widthOfStart] = 'S';
        mineField[heightOfFinish][widthOfFinish] = 'F';
    }

    public static void playerMovement(){
        int playerChoiceHeight;
        int playerChoiceWidth;
        while(true) {
            System.out.print("Please enter a coordinate (height): ");
            playerChoiceHeight = scanner.nextInt();
            System.out.print("Please enter a coordinate (width): ");
            playerChoiceWidth = scanner.nextInt();
            if ((playerChoiceHeight == (playerHeightCoordinates + 1) && playerChoiceWidth == playerWidthCoordinates)
                    || (playerChoiceWidth == (playerWidthCoordinates - 1) && playerChoiceHeight == playerHeightCoordinates)
                    || (playerWidthCoordinates == playerChoiceWidth && playerChoiceHeight == (playerHeightCoordinates + 1))
                    || (playerWidthCoordinates == playerChoiceWidth && playerChoiceHeight == (playerHeightCoordinates - 1))) {
                System.out.println("You can move only one block at a time! ");
                continue;
            }
            break;
        }

        mineField[playerHeightCoordinates][playerWidthCoordinates] = 'V';
        playerWidthCoordinates = playerChoiceWidth;
        playerHeightCoordinates = playerChoiceHeight;

        movingPlayer(playerHeightCoordinates, playerWidthCoordinates);
        numberOfProbes--;
        System.out.println("You have " + numberOfProbes + " probes left");
    }

    public static void movingPlayer(int h, int w){
        mineField[h][w] = '*';
    }

    public static void analyzingForMines(){
        if(playerHeightCoordinates <= 4 && playerWidthCoordinates <=4) {
            mineField[playerHeightCoordinates][playerWidthCoordinates + 1] =
                    (whereTheMinesAre[playerHeightCoordinates][playerWidthCoordinates + 1]) ? 'Y' : 'N';

            mineField[playerHeightCoordinates][(playerWidthCoordinates - 1)] =
                    (whereTheMinesAre[playerHeightCoordinates][(playerWidthCoordinates - 1)]) ? 'Y' : 'N';

            mineField[playerHeightCoordinates + 1][playerWidthCoordinates] =
                    (whereTheMinesAre[playerHeightCoordinates + 1][playerWidthCoordinates]) ? 'Y' : 'N';

            mineField[(playerHeightCoordinates - 1)][playerWidthCoordinates] =
                    (whereTheMinesAre[(playerHeightCoordinates - 1)][playerWidthCoordinates]) ? 'Y' : 'N';

            mineField[playerHeightCoordinates + 1][playerWidthCoordinates + 1] =
                    (whereTheMinesAre[playerHeightCoordinates + 1][playerWidthCoordinates + 1]) ? 'Y' : 'N';

            mineField[playerHeightCoordinates + 1][(playerWidthCoordinates)] =
                    (whereTheMinesAre[playerHeightCoordinates + 1][(playerWidthCoordinates - 1)]) ? 'Y' : 'N';

            mineField[playerHeightCoordinates - 1][playerWidthCoordinates + 1] =
                    (whereTheMinesAre[(playerHeightCoordinates - 1)][playerWidthCoordinates + 1]) ? 'Y' : 'N';

            mineField[(playerHeightCoordinates - 1)][(playerWidthCoordinates - 1)] =
                    (whereTheMinesAre[(playerHeightCoordinates - 1)][(playerWidthCoordinates - 1)]) ? 'Y' : 'N';

            mineField[heightOfStart][widthOfStart] = 'S';
        }
    }

    public static void defusingTheMines(){
        if (defusesLeft > 0){
            System.out.println("You have " + defusesLeft + " defuses left");
            System.out.print("Defusing the bomb!");

            whereTheMinesAre[playerHeightCoordinates][playerWidthCoordinates] = false;
            System.out.println("The bomb was defused");
            defusesLeft--;
            System.out.println("You have " + defusesLeft + " defuses left");
        }
    }
}
