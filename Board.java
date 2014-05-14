package othello.Othello;

/**
 * Created by pmunoz and smartinez on 01/04/14.
 * Updated by aeap and jgeorge on 05/05/14.
 * Updated by zwodnik on 09/05/14.
 */
import java.util.ArrayList;

class Move { // TO GO IN TURN CLASS MAYBE?
	int i, j;

	public Move() {
	}

	public Move(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
}

public class Board {

	public static final int NUM = 8; // 8 rows 8 columns board
	private Cell[][] cells = new Cell[NUM][NUM]; // matrix
	int[] counter = new int[2]; // counter for both players moves
	boolean gameOver; // game is over

	public final Move up = new Move(0, -1); // up
	public final Move down = new Move(0, 1); // down
	public final Move left = new Move(-1, 0); // left
	public final Move right = new Move(1, 0); // right
	public final Move upLeft = new Move(-1, -1); // up and left
	public final Move upRight = new Move(1, -1); // up and right
	public final Move downLeft = new Move(-1, 1); // down and left
	public final Move downRight = new Move(1, 1); // down and right

	final Move directions[] = { up, down, left, right, upLeft, upRight,
			downLeft, downRight }; // array containing all directions possible

	public int intPlayer(boolean boolPlayer) { // TESTING
		int result = boolPlayer ? 1 : 0; // 1 for false black and 0 for true
											// white
		return result;
	}

	public boolean boolPlayer(int color) { // TESTING
		boolean result;

		if (color == 0) {
			result = true; // true for white
		} else {
			result = false; // false for black
		}
		return result;
	}

	/*
	 * Sets the boards Sets both players first chips on the board Sets both
	 * players counter at the start Sets noMoves to false at the start
	 */
	public Board() {
		for (int i = 0; i < NUM; i++)
			// for i and j coordinates
			for (int j = 0; j < NUM; j++)
				this.cells[i][j] = new Cell(); // sets all the cells to empty

		// 0 for white starting chips
		this.cells[3][3].placeChip(0); // player 0 has to be white?
		this.cells[4][4].placeChip(0);

		// 1 for black starting chips
		this.cells[3][4].placeChip(1); // player 1 has to be black?
		this.cells[4][3].placeChip(1);

		// start counter at 2 for each player
		counter[0] = 2;
		counter[1] = 2;

		// allows moves by default at start of game
		gameOver = false;
	}

	/*
	 * Creates the outlines and the line numbers of the board
	 */
	public void display() {

		for (int i = 0; i < NUM; i++) {
			System.out.print(i + " |");
			for (int j = 0; j < NUM; j++) {
				this.cells[i][j].display();
			}

			System.out.println("|");
		}

		System.out.print("   ");
		for (int j = 0; j < NUM; j++) {
			System.out.print("  " + j + "  ");
		}

		System.out.println();

	}

	/*
	 * Places a chip on the board
	 * 
	 * @param int color, int row, int col
	 */
	public void placeChip(int color, int row, int col) {
		this.cells[row][col].placeChip(color);
	}

	// public boolean findLegalMove(...){
	/**
	 * Here program must check if the chip could be place in a position set as
	 * parameter It could return the coordinates of every available position
	 */
	// }

	/*
	 * Finds all the valid moves available to the player
	 * 
	 * @param Move move, boolean player(1=false=black, 0=true=white)
	 * 
	 * @return boolean true if legal move, false if not
	 */

	public boolean findLegalMoveNew(Move move, int player) { // !! TESTING
																// boolean / int
																// issue
		boolean result = false; // no legal moves found by default
		int opponent = (player + 1) % 2; // intPlayer(!player); // if player
											// false, opponent
		int playing = player; // intPlayer(player); // if player true, playing

		int i = move.getI(); // get position i axis
		int j = move.getJ(); // get position j axis

		if (cells[i][j].isEmpty() == false) { // checks if cell is empty
			return false; // if cell not empty, no moves available
		} else {
			for (int k = 0; k < directions.length; k++) { // get all the
															// directions one by
															// one

				Move direction = directions[k]; // direction currently in use is
												// stored in new variable
				int iDir = direction.getI(); // gets the i axis of the direction
												// currently in use
				int jDir = direction.getJ(); // gets the j axis of the direction
												// currently in use
				int jump = 2;
				try {
					if (cells[i + iDir][j + jDir].getPlayer() == opponent) {
						while ((j + (jump * jDir)) > -1
								&& (j + (jump * jDir)) < 8
								&& (i + (jump * iDir)) < 8
								&& (i + (jump * iDir)) > -1) { // search inside
																// the
																// board
							if (!cells[i + jump * iDir][j + jump * jDir]
									.isEmpty()) { // cell
													// must
													// be
													// not
													// empty
								if (cells[i + jump * iDir][j + jump * jDir]
										.getPlayer() == playing)
									return true; // if same color found, legal
													// move
													// found
								else if (cells[i + jump * iDir][j + jump * jDir]
										.isEmpty())
									break;
							} else {
								break;
							}
							jump++;
						}
					}
				} catch (Exception e) {
				}

			}
		}
		return result;
	}

	/*
	 * Creates a new ArrayList of all the valid moves available
	 * 
	 * @param int color
	 * 
	 * @return ArrayList of all validMoves available
	 */
	public ArrayList<Move> validMove(int color) {
		ArrayList<Move> allValidMoves = new ArrayList<Move>();

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				// clear canselect
				cells[i][j].unselect();

				Move testMove = new Move(i, j);

				boolean valid = findLegalMoveNew(testMove, color);
				if (valid) {
					allValidMoves.add(testMove);
				}
			}
		}
		return allValidMoves;
	}

	/*
	 * Set cell canselect = true
	 * 
	 * @param Move move
	 * 
	 * @return void
	 */
	public void setCanSelect(Move move) {
		this.cells[move.getI()][move.getJ()].setSelect();
	}

	public boolean canSelect(Move move) {
		return this.cells[move.getI()][move.getJ()].canSelect();
	}

	// public void replaceChip(...){
	/**
	 * Here program will replace chips while are between the color chips
	 */
	// }

	public void replaceChip(Move move, int player) { // working version
		int opponent = (player + 1) % 2;
		int playing = player;

		int i = move.getI();
		int j = move.getJ();

		for (int movement = 0; movement < directions.length; movement++) {
			Move direction = directions[movement];
			int iDir = direction.getI();
			int jDir = direction.getJ();
			boolean possible = false;

			if ((j + jDir) > -1 && (j + jDir) < NUM && (i + iDir) < NUM
					&& (i + iDir) > -1) { // checks for an opponent in all the
											// directions
				if (cells[i + iDir][j + jDir].getPlayer() == opponent) {
					possible = true;
				}
			}

			if (possible == true) {
				int jump = 2;
				while ((j + (jump * jDir)) > -1 && (j + (jump * jDir)) < 8
						&& (i + (jump * iDir)) < 8 && (i + (jump * iDir)) > -1) { // search
																					// inside
																					// the
																					// board
					if (!cells[i + jump * iDir][j + jump * jDir].isEmpty()) // cell
																			// must
																			// be
																			// not
																			// empty
						if (cells[i + jump * iDir][j + jump * jDir].getPlayer() == playing) {
							for (int k = 1; k < jump; k++) {
								cells[i + k * iDir][j + k * jDir].changeChip();// =
																				// playing;
																				// //
																				// everything
																				// between
																				// i
																				// and
																				// j
																				// is
																				// ours
							}
							break;
						}
					jump++;
				}
			}
		}
	}

	// public int getChipsCount(int color){
	/**
	 * program will iterate over the array and return the number of chips that
	 * the player ser as parameter has
	 * 
	 * Maybe we could set another method to count the total
	 */
	// }

	/*
	 * Updates and Returns the value of the counter for each player
	 * 
	 * @param int color
	 * 
	 * @return counter for each player
	 */
	public int getChipsCount(int color) {

		int scoreWhite = 2;
		int scoreBlack = 2;

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[j].length; j++) {
				if (color == 0) {
					scoreWhite++;
				}
				if (color == 1) {
					scoreBlack++;
				}
			}
		}
		counter[0] = scoreWhite;
		counter[1] = scoreBlack;

		return counter[color];
	}

	/*
	 * Adds up both player's counters and returns the value
	 * 
	 * @return total of turns
	 */
	public int totalTurns() {
		return counter[0] + counter[1];
	}

	// public boolean gameOver(...){
	/**
	 * If the board is complete or if a chip cant be set, this method return
	 * true.
	 */

	/*
	 * Checks if the players have made 64 moves which indicates the end of the
	 * game.
	 * 
	 * @param none
	 */
	public boolean gameOver() {
		int count = 0;

		if (counter[0] + counter[1] == 64) { // if all the cells are full then
												// game over
			return true;
		}

		else { // TESTING
			for (int j = 0; j < NUM; j++) {
				for (int i = 0; i < NUM; i++) {
					if (findLegalMoveNew(new Move(i, j), 0) == true) {
						count++;
					}
					if (findLegalMoveNew(new Move(i, j), 1) == true) {
						count++;
					}
				}
			}
			if (count == 0) { // if no legal moves left then game over
				return true;
			}
		}
		return false;
	}
}
