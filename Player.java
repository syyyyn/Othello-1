package othello.Othello;
import java.util.ArrayList;

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
    public void findCanSelect(){

        ArrayList<Move> moves = board.validMove(this.color);

        //for( int i=0; i<moves.size(); i++)
        //    board.setCanSelect(moves.get(i));

        for (Move move : moves)
            board.setCanSelect(move);
    }

}
