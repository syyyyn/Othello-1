/**
 * Created by pmunoz on 01/04/14.
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
}
