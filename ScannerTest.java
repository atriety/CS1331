import java.util.Scanner;
public class ScannerTest {
    public static char [][] boardArray = new char[5][5];
    public static void main(String[] args) {
       int playNum = 1;
    //    for (playNum = 1; playNum <= 2; playNum++) {
        char[][] playerOneBoard = getCoords(1);
        System.out.println(playerOneBoard);
        printHundredLines();


    }

        
    





    public static char[][] getCoords(int playNum) {
        System.out.println("PLAYER " + playNum + ", ENTER YOUR SHIPS' COORDINATES.");
        for(int i = 1;  i <= 5; i++) {    
            System.out.println("Enter in ship #" + i + "\'s coordinates");
            Scanner input = new Scanner(System.in);
            int coordShipX = input.nextInt();
            int coordShipY = input.nextInt();
            if (boardArray[coordShipX][coordShipY] == '@') {
                System.out.println("You already have a ship there. Choose different coordinates.");
            } else {
            boardArray[coordShipX][coordShipY] = '@';
            }
            System.out.println("ship "+ i + " is at " + coordShipX + " and " + coordShipY);
        }
        return boardArray;
    }




    private static void printBattleShip(char[][] player) {
    System.out.print("  ");
    for (int row = -1; row < 5; row++) {
        if (row > -1) {
            System.out.print(row + " ");
        }
        for (int column = 0; column < 5; column++) {
            if (row == -1) {
                System.out.print(column + " ");
            } else {
                System.out.print(player[row][column] + " ");
            }
        }
        System.out.println("");
        }
    }

    public static void printHundredLines() {
        for (int lineNum = 1; lineNum <= 100; lineNum++) {
            System.out.println("\n");
        }
    }    

}