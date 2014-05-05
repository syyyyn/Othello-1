/**
 * Created by pmunoz on 01/04/14.
 * Updated by aeap and jgeorge on 05/05/14.
 */
public class Cell {
    public static final char BLACK = 'X'; //
    public static final char WHITE = 'O'; //
    public static final char EMPTY = ' ';
    
    public boolean empty; //
    public boolean white;
    public boolean black;
    
    public cellState value;

    public Cell() {
        this.empty = true;
    }

    public boolean isEmpty() {
        return this.empty;
    }


    public void placeChip( cellState player) {
        this.empty = false;
        this.value = player;

        if (player == cellState.white)  {
            this.white = true;
            this.black = false;
        }
        else{
            this.black = true;
            this.white = false;
        }
    }

    public void placeChip( int player ) {
        if(player == 0){
        	placeChip(cellState.white);
        }
        else{
        	placeChip(cellState.black);
        }
    }

    public boolean isWhite(){
    	return this.white = true;
    }
    
    public boolean isBlack(){
    	return this.black = true;
    }
    
    public void display() {
       if (this.isEmpty())
       {
            System.out.print("[ " + " " + " ]");
       }
       else {
           char content = BLACK;
           if (this.value == cellState.white)
               content = WHITE;
           System.out.print("[ " + content + " ]");
       }
    }
}
