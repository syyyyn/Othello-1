/**
 * Created by pmunoz and smartinez on 01/04/14.
 */

class Move { // TURN??
        int i, j;
        public Move () {
        }
        public Move (int i, int j) {
                this.i = i;
                this.j = j;
        }
};

enum cellState {white, black, empty};

public class Board {

    private static final int NUM = 8; // 8 rows 8 columns board
    private Cell[][] cells = new Cell[NUM][NUM]; // matrix
    int [] counter = new int[2]; // counter for both players moves
    boolean noMoves; // checks if 0 moves are available for the player to play

    /*
     *  Sets the boards
     *  Sets both players first chips on the board
     *  Sets both players counter at the start
     *  Sets noMoves to false at the start
     * 
     */
    public Board() {
         for (int i=0; i<NUM; i++) // for i and j coordinates
             for (int j=0; j<NUM; j++)
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
         noMoves = false;
    }

    /*
     *  Creates the outlines and the line numbers of the board
     * 
     */
    public void display() {

        for (int i=0; i<NUM; i++) {
            System.out.print(i + " |");
            for (int j=0; j<NUM; j++) {
                this.cells[i][j].display();
            }

            System.out.println("|");
        }

        System.out.print("   ");
        for (int j= 0; j<NUM; j++) {
            System.out.print("  " + j + "  ");
        }

        System.out.println();

    }
    
    /*
     * @param i coordinate
     * @param j coordinate
     * @return True if cell at the coordinates is empty, false if not
     * 
     */
    public boolean isEmpty(int i, int j){
    	return cells[i][j].isEmpty();
    }
    
    /*
     * @param i coordinate
     * @param j coordinate
     * @return True if cell at the coordinates is white, false if not
     * 
     */
    public boolean isWhite(int i, int j){
    	return cells[i][j].isWhite();
    }
    
    /*
     * @param i coordinate
     * @param j coordinate
     * @return True if cell at the coordinates is black, false if not
     * 
     */
    public boolean isBlack(int i, int j){
    	return cells[i][j].isBlack();
    }

    /*
     *  Places a chip on the board
     *  
     *  @param int color, int row, int col
     * 
     */
    public void placeChip(int color, int row, int col) {
        this.cells[row][col].placeChip(color);
    }
    
    //public boolean findLegalMove(...){
        /**
         * Here program must check if the chip could be place in a position set as parameter
         * It could return the coordinates of every available position
        */
   // }
    
    public void set(Move move, Cell player) {
        if(cells[move.i][move.j].isWhite()) {
                counter[0]--;
        }
        else if(cells[move.i][move.j].isBlack()){
        		counter[1]--;
        }
        
        cells[move.i][move.j]=player;
        
        if(player.isWhite()){
        	counter[0]++;
        }
        else if(player.isBlack()){
            counter[1]++;
        }
    }
    
    public int move(Move move, cellState type) {
        return checkBoard(move,type);
    }
    
    private int checkBoard(Move move, cellState type) {
        // check increasing x
        int j=Check(move,1,0,type,true);
        // check decreasing x
        j+=Check(move,-1,0,type,true);
        // check increasing y
        j+=Check(move,0,1,type,true);
        // check decreasing y
        j+=Check(move,0,-1,type,true);
        // check diagonals
        j+=Check(move,1,1,type,true);
        j+=Check(move,-1,1,type,true);
        j+=Check(move,1,-1,type,true);
        j+=Check(move,-1,-1,type,true);
        if (j != 0) set(move,type);
        return j;
    }
    
    private int Check(Move move, int inci, int incj, cellState type , boolean set)  {
        cellState opponent;
        int i=move.i;
        int j=move.j;
        if (type == cellState.black){
        	opponent=cellState.white;
        }
        else {
        	opponent=cellState.black;
        }
        int n_inc=0;
        i+=inci; j+=incj;
        while ((i<8) && (i>=0) && (j<8) && (j>=0) && (cells[i][j].isBlack() || cells[i][j].isWhite())) {
                i+=inci; j+=incj;
                n_inc++;
        }
        if ((n_inc != 0) && (i<8) && (i>=0) && (j<8) && (j>=0) && (cells[i][j].isBlack() || cells[i][j].isWhite())) {
                 if (set)
                 for (int k = 1 ; k <= n_inc ; k++) {
                        i-=inci; j-=incj;
                         set(new Move(i,j),type);
                 }
                return n_inc;
        }
        else return 0;
    }
    
    
    
    //public void replaceChip(...){
        /**
         * Here program will replace chips while are between the color chips
        */
    //}
    //public int getChipsCount(int color){
        /**
         * program will iterate over the array and return the number of chips that the player ser as parameter has
         * 
         * Maybe we could set another method to count the total
        */
    //}
    
    
    //public boolean gameOver(...){
        /**
         * If the board is complete or if a chip cant be set, this method return true.
			*/
    
    /*
     * checks if the players have made 64 moves which indicates the end of the game.
     * @param none
     *  
     */
    public boolean gameOver() {
    	return counter[0]+counter[1]==64;
    }
}
