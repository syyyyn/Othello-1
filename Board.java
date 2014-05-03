/**
 * Created by pmunoz and smartinez on 01/04/14.
 */
public class Board {

    private static final int NUM = 8;

    private Cell[][] cells = new Cell[NUM][NUM];

    public Board() {
         for (int i=0; i<NUM; i++)
             for (int j=0; j<NUM; j++)
                 this.cells[i][j] = new Cell();

         // 0 son fichas blancas
         this.cells[3][3].placeChip(0);
         this.cells[4][4].placeChip(0);

        // 1 son fichas negras
        this.cells[3][4].placeChip(1);
        this.cells[4][3].placeChip(1);
    }

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

    public void placeChip(int color, int row, int col) {
        this.cells[row][col].placeChip(color);
    }
    
    public boolean findLegalMove(...){
        /**
         * Here program must check if the chip could be place in a position set as parameter
         * It could return the coordinates of every available position
        */
    }
    public void replaceChip(...){
        /**
         * Here program will replace chips while are between the color chips
        */
    }
    public int getChipsCount(int color){
        /**
         * program will iterate over the array and return the number of chips that the player ser as parameter has
         * 
         * Maybe we could set another method to count the total
        */
    }
    public boolean gameOver(...){
        /**
         * If the board is complete or if a chip cant be set, this method return true.
        */
}
