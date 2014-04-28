/**
 * Created by lfmingo on 01/04/14.
 */
public class Cell {
    private static final char BLACK = 'X';
    private static final char WHITE = 'O';

    private boolean empty;

    private int value;

    public Cell() {
        this.empty = true;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public void placeChip( int jugador ) {
        this.empty = false;
        this.value = jugador;
    }

    public void display() {
       if (this.isEmpty())
       {
            System.out.print("| " + " " + " |");
       }
       else {
           char content = BLACK;
           if (this.value == 0)
               content = WHITE;
           System.out.print("| " + content + " |");
       }
    }
}
