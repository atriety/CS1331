import java.util.Scanner;
public class TestMe {
    public static char [][] boardArray = new char[5][5];
    public static char [][] boardTracker = new char[5][5];
    public static void main(String[] args) {
        int playNum = 1;
        System.out.println("PLAYER " + playNum + ", ENTER YOUR SHIPS' COORDINATES.");
        int i = 1;
        while(i <= 5) {    
            System.out.println("Enter in ship #" + i + "\'s coordinates");
            Scanner input = new Scanner(System.in);
            int coordShipX = input.nextInt();
            int coordShipY = input.nextInt();
            if (coordShipX > 4 || coordShipX < 0 || coordShipY < 0 || coordShipY > 4) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
            else if (boardArray[coordShipX][coordShipY] == '@') {
                System.out.println("You already have a ship there. Choose different coordinates.");
            } else {
            boardArray[coordShipX][coordShipY] = '@';
            System.out.println("ship "+ i + " is at " + coordShipX + " and " + coordShipY);
            i++;
            }
            
        }
        // fill the rest of boardArray with '-'
        for (i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (boardArray[i][j] != '@') {
                    boardArray[i][j] = '-';
                }
            }
        }  
        printBattleShip(boardArray);
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
}
