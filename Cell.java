/**
 * Created by pmunoz on 01/04/14.
 * Updated by aeap and jgeorge on 05/05/14.
 */
public class Cell {
    public static final char BLACK = 'X'; //
    public static final char WHITE = 'O'; // 

    public boolean empty; //
    public boolean white;
    public boolean black;
    
    public int value;

    public Cell() {
        this.empty = true;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public void placeChip( int player ) {
        this.empty = false;
        this.value = player;
        
        if(player == 0){
        	this.white = true;
        	this.black = false;
        }
        
        else{
        	this.black = true;
        	this.white = false;
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
           if (this.value == 0)
               content = WHITE;
           System.out.print("[ " + content + " ]");
       }
    }
}
