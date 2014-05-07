/**
 * Created by lfmingo on 01/04/14.
 */
public class Player {
    private String name;
    private int color;
    private Board board;

    public Player(String name, int color, Board board) {
        this.name = name;
        this.color = color;
        this.board = board;
    }


    public void placeChip(int row, int col) {

        this.board.placeChip( this.color, row, col );
    }
    public void findCanSelect(int color){
    	/**you have to create a method that find in what squares you can place a chip, and in that squares we can write a '?', 
    	you can take information of the class board*/
    	
    }

}
