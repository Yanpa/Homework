import java.util.Scanner;

public class TheKingIsDead {
    static Scanner scanner = new Scanner(System.in);
    static String[][] gameBoardArray = new String[7][7];
    static int count = 1;
    static boolean isGameOver = false;

    public static void main(String[] args) {
        gameBoard();

        while(true){
            whichPlayerMoves(count);
            selectingAFigureAndWhereToPutIt(count);
            gameBoardUpdated();

            count++;

            if(isGameOver) break;
        }
    }
    public static void gameBoard(){
        gameBoardArray[0][0] = "   ";
        gameBoardArray[0][1] = "  A ";
        gameBoardArray[0][2] = "   B ";
        gameBoardArray[0][3] = "  C ";
        gameBoardArray[0][4] = "  D ";
        gameBoardArray[0][5] = "  E ";
        gameBoardArray[0][6] = "  F ";
        gameBoardArray[1][0] = " A ";
        gameBoardArray[2][0] = " B ";
        gameBoardArray[3][0] = " C ";
        gameBoardArray[4][0] = " D ";
        gameBoardArray[5][0] = " E ";
        gameBoardArray[6][0] = " F ";
        for(byte row = 0; row < 7; row++){
            for(byte col = 0; col < 7; col++){
                if((row == 1 && col == 1) || (row == 1 && col == 6))
                    gameBoardArray[row][col] = " bDw ";
                if ((row == 6 && col == 1) || (row == 6 && col == 6))
                    gameBoardArray[row][col] = " wDw ";
                if((row == 1 && col == 2))    gameBoardArray[row][col] = " bD ";
                if((row == 6 && col == 5))    gameBoardArray[row][col] = " wD ";
                if((row == 1 && col == 3))    gameBoardArray[row][col] = " bQ ";
                if((row == 6 && col == 4))    gameBoardArray[row][col] = " wQ ";
                if((row == 1 && col == 4))    gameBoardArray[row][col] = " bK ";
                if((row == 6 && col == 3))    gameBoardArray[row][col] = " wK ";
                if((row == 1 && col == 5))    gameBoardArray[row][col] = " bM ";
                if((row == 6 && col == 2))    gameBoardArray[row][col] = " wM ";
                if(row != 0 && row != 1 && row != 6 && col != 0) gameBoardArray[row][col] = "  X ";

                System.out.print(gameBoardArray[row][col]);
            }
            System.out.println();
        }
    }


    public static void selectingAFigureAndWhereToPutIt(int count){
        byte rowOfItemYouMove = 0, colOfItemYouMove = 0, rowOfWhereYouMoveTheItem = 0, colOfWhereYouMoveTheItem = 0;
        while(true) {
            System.out.print("Please enter the row of the item you want to move: ");
            String heightPosition = scanner.nextLine().trim().toLowerCase();
            if (!heightPosition.equals("a") && !heightPosition.equals("b") && !heightPosition.equals("c") &&
                    !heightPosition.equals("d") && !heightPosition.equals("e") && !heightPosition.equals("f")) {
                System.out.println("Invalid input");
                continue;
            }
            System.out.print("Please enter the col of the item you want to move: ");
            String lengthPosition = scanner.nextLine().trim().toLowerCase();
            if (!lengthPosition.equals("a") && !lengthPosition.equals("b") && !lengthPosition.equals("c") &&
                    !lengthPosition.equals("d") && !lengthPosition.equals("e") && !lengthPosition.equals("f")) {
                System.out.println("Invalid input");
                continue;
            }
            if(heightPosition.equals("a")) rowOfItemYouMove = 1;
            if(heightPosition.equals("b")) rowOfItemYouMove = 2;
            if(heightPosition.equals("c")) rowOfItemYouMove = 3;
            if(heightPosition.equals("d")) rowOfItemYouMove = 4;
            if(heightPosition.equals("e")) rowOfItemYouMove = 5;
            if(heightPosition.equals("f")) rowOfItemYouMove = 6;

            if(lengthPosition.equals("a")) colOfItemYouMove = 1;
            if(lengthPosition.equals("b")) colOfItemYouMove = 2;
            if(lengthPosition.equals("c")) colOfItemYouMove = 3;
            if(lengthPosition.equals("d")) colOfItemYouMove = 4;
            if(lengthPosition.equals("e")) colOfItemYouMove = 5;
            if(lengthPosition.equals("f")) colOfItemYouMove = 6;


            if(gameBoardArray[rowOfItemYouMove][colOfItemYouMove].equals("  X ")){
                System.out.println("You didn't select a figure, please try again!");
                continue;
            }

            if(count % 3 != 0 && (gameBoardArray[rowOfItemYouMove][colOfItemYouMove].equals(" bD ") ||
                                  gameBoardArray[rowOfItemYouMove][colOfItemYouMove].equals(" wD "))) {
                System.out.println("You can't choose donkey until the number of moves is divideble by 3");
                continue;
            }

            System.out.printf("This is the item you selected: %s%n", gameBoardArray[rowOfItemYouMove][colOfItemYouMove]);

            if (count % 2 != 0){
                if(isItWhite(gameBoardArray[rowOfItemYouMove][colOfItemYouMove])) break;
                continue;
            }

            if (count % 2 == 0){
                if(isItBlack(gameBoardArray[rowOfItemYouMove][colOfItemYouMove])) break;
            }
        }

        while (true) {
            System.out.print("Now enter where to put that piece(row): ");
            String newHeightPosition = scanner.nextLine().toLowerCase().trim();
            if (!newHeightPosition.equals("a") && !newHeightPosition.equals("b") && !newHeightPosition.equals("c") &&
                    !newHeightPosition.equals("d") && !newHeightPosition.equals("e") && !newHeightPosition.equals("f")) {
                System.out.println("Invalid input");
                continue;
            }

            System.out.print("Now enter where to put that piece(col): ");
            String newLengthPosition = scanner.nextLine().toLowerCase().trim();
            if (!newLengthPosition.equals("a") && !newLengthPosition.equals("b") && !newLengthPosition.equals("c") &&
                    !newLengthPosition.equals("d") && !newLengthPosition.equals("e") && !newLengthPosition.equals("f")) {
                System.out.println("Invalid input");
                continue;
            }

            if(newHeightPosition.equals("a")) rowOfWhereYouMoveTheItem = 1;
            if(newHeightPosition.equals("b")) rowOfWhereYouMoveTheItem = 2;
            if(newHeightPosition.equals("c")) rowOfWhereYouMoveTheItem = 3;
            if(newHeightPosition.equals("d")) rowOfWhereYouMoveTheItem = 4;
            if(newHeightPosition.equals("e")) rowOfWhereYouMoveTheItem = 5;
            if(newHeightPosition.equals("f")) rowOfWhereYouMoveTheItem = 6;

            if(newLengthPosition.equals("a")) colOfWhereYouMoveTheItem = 1;
            if(newLengthPosition.equals("b")) colOfWhereYouMoveTheItem = 2;
            if(newLengthPosition.equals("c")) colOfWhereYouMoveTheItem = 3;
            if(newLengthPosition.equals("d")) colOfWhereYouMoveTheItem = 4;
            if(newLengthPosition.equals("e")) colOfWhereYouMoveTheItem = 5;
            if(newLengthPosition.equals("f")) colOfWhereYouMoveTheItem = 6;

            if(gameRules(rowOfItemYouMove, colOfItemYouMove, rowOfWhereYouMoveTheItem, colOfWhereYouMoveTheItem)) {
                break;
            }
            System.out.println("Wrong coordinates");
            continue;
        }
    }

    public static void changePlaces(int whatWeChangeRow, int whatWeChangeCol, int withWhatWeChangeRow, int withWhatWeChangeCol){
        String emptyString = "";
        emptyString = gameBoardArray[whatWeChangeRow][whatWeChangeCol];
        gameBoardArray[whatWeChangeRow][whatWeChangeCol] = gameBoardArray[withWhatWeChangeRow][withWhatWeChangeCol];
        gameBoardArray[withWhatWeChangeRow][withWhatWeChangeCol] = emptyString;
    }

    public static boolean isItWhite(String isItWhite){
        if(isItWhite.equals(" wDw ") || isItWhite.equals(" wD ") || isItWhite.equals(" wQ ")
                ||isItWhite.equals(" wK ") || isItWhite.equals(" wM ")) return true;
        System.out.println("I said it needs to be white figure");
        return false;
    }

    public static boolean isItBlack(String isItBlack){
        if(isItBlack.equals(" bDw ") ||isItBlack.equals(" bD ") ||isItBlack.equals(" bQ ")
                ||isItBlack.equals(" bK ") ||isItBlack.equals(" bM ")) return true;
        System.out.println("I said it needs to be black figure");
        return false;
    }

    public static void whichPlayerMoves(int count){
        if(count %2 != 0){
            System.out.println("White have to move right now!");
        }
        if(count %2 == 0){
            System.out.println("Black moves now!");
        }
    }

    public static boolean gameRules(int rowWhereWeStart, int colWhereWeStart, int rowWhereWeMove, int colWhereWeMove){
        if(gameBoardArray[rowWhereWeMove][colWhereWeMove].equals(" wK ")){
            takingPieces(rowWhereWeStart, colWhereWeStart, rowWhereWeMove, colWhereWeMove);
            System.out.println("Black side wins!");
            isGameOver = true;
            return true;
        }

        if(gameBoardArray[rowWhereWeMove][colWhereWeMove].equals(" bK ")){
            takingPieces(rowWhereWeStart, colWhereWeStart, rowWhereWeMove, colWhereWeMove);
            System.out.println("White side wins!");
            isGameOver = true;
            return true;
        }

        if(gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" wDw ")
                && colWhereWeStart == colWhereWeMove && rowWhereWeMove == (rowWhereWeStart - 1)){
            takingPieces(rowWhereWeStart, colWhereWeStart, rowWhereWeMove, colWhereWeMove);
            return true;
        }
        if(gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" bDw ")
                && colWhereWeStart == colWhereWeMove && rowWhereWeMove == (rowWhereWeStart + 1)){
            takingPieces(rowWhereWeStart, colWhereWeStart, rowWhereWeMove, colWhereWeMove);
            return true;
        }

        if((gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" wK ") ||
                gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" bK ")) &&
                (colWhereWeMove == (colWhereWeStart+1) && rowWhereWeMove == rowWhereWeStart)
                || (colWhereWeMove == (colWhereWeStart+1) && rowWhereWeMove == (rowWhereWeStart + 1))
                || (colWhereWeMove == (colWhereWeStart-1) && rowWhereWeMove == (rowWhereWeStart - 1))
                || (colWhereWeMove == (colWhereWeStart - 1) && rowWhereWeMove == rowWhereWeStart)
                || (colWhereWeMove == colWhereWeStart && rowWhereWeMove == (rowWhereWeStart + 1))
                || (colWhereWeMove == colWhereWeStart && rowWhereWeMove == (rowWhereWeStart - 1))){
            takingPieces(rowWhereWeStart, colWhereWeStart, rowWhereWeMove, colWhereWeMove);
            return true;
        }
        if((gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" wM ") ||
                gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" bM "))
                &&
                (colWhereWeStart == (colWhereWeMove+1) && rowWhereWeMove == rowWhereWeStart)
                || (colWhereWeStart == (colWhereWeMove - 1) && rowWhereWeMove == rowWhereWeStart)
                || (colWhereWeStart == colWhereWeMove && rowWhereWeMove == (rowWhereWeStart + 1))
                || (colWhereWeStart == colWhereWeMove && rowWhereWeMove == (rowWhereWeStart - 1))) {
            takingPieces(rowWhereWeStart, colWhereWeStart, rowWhereWeMove, colWhereWeMove);
            return true;
        }
        if((gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" wQ ") ||
                gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" bQ ")) &&
                (colWhereWeMove == (colWhereWeStart+1) && rowWhereWeMove == (rowWhereWeStart + 1))
                || (colWhereWeMove == (colWhereWeStart+1) && rowWhereWeMove == (rowWhereWeStart - 1))
                ||(colWhereWeMove == (colWhereWeStart-1) && rowWhereWeMove == (rowWhereWeStart + 1))
                || (colWhereWeMove == (colWhereWeStart-1) && rowWhereWeMove == (rowWhereWeStart - 1))) {

            takingPieces(rowWhereWeStart, colWhereWeStart, rowWhereWeMove, colWhereWeMove);
            return true;
        }


            if (gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" wD ") ||
                    gameBoardArray[rowWhereWeStart][colWhereWeStart].equals(" bD ")){
                    if((colWhereWeMove == (colWhereWeStart+2) && rowWhereWeMove == rowWhereWeStart)
                            || (colWhereWeMove == (colWhereWeStart+2) && rowWhereWeMove == (rowWhereWeStart + 2))
                            || (colWhereWeMove == (colWhereWeStart-2) && rowWhereWeMove == (rowWhereWeStart - 2))
                            || (colWhereWeMove == (colWhereWeStart - 2) && rowWhereWeMove == rowWhereWeStart)
                            || (colWhereWeMove == colWhereWeStart && rowWhereWeMove == (rowWhereWeStart + 2))
                            || (colWhereWeMove == colWhereWeStart && rowWhereWeMove == (rowWhereWeStart - 2))){
                    takingPieces(rowWhereWeStart, colWhereWeStart, rowWhereWeMove, colWhereWeMove);
                    return true;
                    }
            }

        return false;
    }

    public static void takingPieces(int rowStart, int colStart, int rowEnd, int colEnd){
        if(!gameBoardArray[rowEnd][colEnd].equals("  X ")){
            gameBoardArray[rowEnd][colEnd] = "  X ";
            changePlaces(rowStart, colStart, rowEnd, colEnd);
        }
        else changePlaces(rowStart, colStart, rowEnd, colEnd);
    }

    public static void gameBoardUpdated(){
        for(int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(gameBoardArray[i][j]);
            }
            System.out.println();
        }
    }

}
