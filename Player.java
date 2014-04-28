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

        // da la vuelta a las otras fichas
    }
}
