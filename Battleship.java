import java.util.Scanner;
public class Battleship {
	public static char [][] playerOneBoard = new char[5][5];
	public static char [][] playerTwoBoard = new char[5][5];
	public static char [][] playerOneTracker = new char[5][5];
	public static char [][] playerTwoTracker = new char[5][5];
	public static int playerOneShips = 5;
	public static int playerTwoShips = 5;

    public static char[][] createBoard(int playNum) {
        char [][] boardArray = new char[5][5];
		System.out.println("PLAYER " + playNum + ", ENTER YOUR SHIPS' COORDINATES.");
        int i = 1;
        while(i <= 5) {    
            System.out.println("Enter in ship #" + i + "\'s coordinates");
            Scanner input = new Scanner(System.in);
            int coordShipX = input.nextInt();
            int coordShipY = input.nextInt();
            if (isValidCoords(coordShipX, coordShipY) == false) {
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

    public static void printBlankLines(int numLines) {
        for (int i = 1; i <= numLines; i++) {
            System.out.println("\n");
        }
    }   

	public static char[][] createBoardTracker() {
		char [][] boardTrackerArray = new char[5][5];
		for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                    boardTrackerArray[i][j] = '-';
                }
            }
		// printBattleShip(boardTrackerArray);
		return boardTrackerArray;
	} 

	public static void battlePhase() {
		boolean playerOneTurn = true;
		char[][] playerOneTracker = createBoardTracker();
		char[][] playerTwoTracker = createBoardTracker();
		char[][] playerOneBoard = createBoard(1);
		printBlankLines(10);
		char[][] playerTwoBoard = createBoard(2);
		printBlankLines(10);
		do {
			int playerCurr = playerOneTurn ? 1 : 2;
			int playerOpp = playerOneTurn ? 2 : 1;
			char[][] currTracker = playerOneTurn ? playerOneTracker : playerTwoTracker;
			char[][] oppBoard = playerOneTurn ? playerTwoBoard : playerOneBoard;
 			System.out.println("Player " + playerCurr + ", enter hit row/column:");
			boolean shotValid = false;
			while(!shotValid) {
				Scanner input = new Scanner(System.in);
				int hitRow = input.nextInt();
				int hitColumn = input.nextInt();
				// player enters incorrect coordinates
				if (isValidCoords(hitRow,hitColumn)) {
					// player re-enters previous coordinates
					if (currTracker[hitRow][hitColumn] == 'O' || currTracker[hitRow][hitColumn] == 'X') {
						System.out.println("You already fired on this spot. Choose different coordinates.");
					} else {
						shotValid = true;
						// player misses
						if (oppBoard[hitRow][hitColumn] == '-') {
							System.out.println("PLAYER" + playerCurr + " MISSED!");
							currTracker[hitRow][hitColumn] = 'O';
						} 
						// player hits	
						else if (oppBoard[hitRow][hitColumn] == '@') {
							System.out.println("PLAYER " + playerCurr + " HIT PLAYER " + playerOpp + "\'s SHIP!");	
							currTracker[hitRow][hitColumn] = 'X';
							if (playerCurr == 1) {
								playerTwoShips--;
							} else {
								playerOneShips--;
							}
						}
					} 		
				} else {
					System.out.println("Invalid coordinates. Choose different coordinates.");
				}
			}
			playerOneTurn = !playerOneTurn;
			printBattleShip(currTracker);
		} while (playerOneShips != 0 || playerTwoShips != 0);
		System.out.println("PLAYER  WINS! YOU SUNK ALL OF YOUR OPPONENT\'S SHIPS!");
	} 

	public static boolean isValidCoords(int a, int b) {
		if (a < 0 || a >4 || b < 0 || b > 4) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		battlePhase();
    	}
	

}






	// System.out.println("Player " + playNum + ", enter hit row/column:");
	// 	Scanner input = new Scanner(System.in);
	// 	int hitRow = input.nextInt();
	// 	int hitColumn = input.nextInt();
		

		
		
	// 	if (array[row][column] == '@') {
	// 		System.out.println("PLAYER " + playNum + "HIT PLAYER 2\'s SHIP!");
	// 	}
	// }