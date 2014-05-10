package othello.Othello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pmunoz on 01/04/14.
 * Updated by zwodnik on 09/05/14.
 */
public class Othello {

    private Board board = new Board();
    private Player[] players = new Player[2];
    private Turn turn;

    

    public void startGame() {

        int who = this.initPlayers();
        this.turn = new Turn(who+1);
        System.out.println("Black chips start");
        this.players[ turn.getTurn() ].findCanSelect();
        board.display();

        while(!board.gameOver()) {

            // put the row and the col (row, col)
                
            int row = this.readRow();
            int col = this.readCol();
           /// empty
           /// I can put
            Move move = new Move(row, col);
            if(board.canSelect(move)) {
                this.players[ turn.getTurn() ].placeChip( row, col);
                turn.change();
            }
            //tHATS NEW
            if(turn.getTurn()==0)
            	System.out.println("White player moves(Chip O)");
            else System.out.println("Black player moves(Chip X)");
            // put chip
            // change turn
            this.players[ turn.getTurn() ].findCanSelect();
            board.display();

        }
    }

    private int readCol() {
        System.out.print("set a col: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer value = -1;
        try {
            value = Integer.parseInt(br.readLine());
        } catch (IOException e) {

        }
        return value;
   
	}

	private int readRow() {
        System.out.print("set a row: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer value = -1;
        try {
            value = Integer.parseInt(br.readLine());
        } catch (IOException e) {

        }
        return value;
    }

    private int initPlayers() {
        Turn aux = new Turn();
        this.players[0] = new Player("name 1", aux.getTurn(), this.board);
        aux.change();
        this.players[1] = new Player("name 2", aux.getTurn(), this.board);

        if (aux.getTurn() == 0) return 1;
        else return 0;
    }

    public static void main(String[] args) {

        new Othello().startGame();

    }


}
