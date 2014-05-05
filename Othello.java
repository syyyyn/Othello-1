import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pmunoz on 01/04/14.
 */
public class Othello {

    private Board board = new Board();
    private Player[] players = new Player[2];
    private Turn turn;



    public void startGame() {

        int who = this.initPlayers();
        this.turn = new Turn(who);

        board.display();

       // while(true) {

            // put the row and the col (row, col)

            System.out.println("JUEGA " + players[turn.getTurn()].getChip());
            int row = this.readRow();
            int col = this.readCol();
           /// empty
           /// I can put


            int puedo =  board.move(new Move(row,col), players[turn.getTurn()].getChip());
            System.out.println("-----"+ puedo + "........");
            //this.players[ turn.getTurn() ].placeChip( row, row);
            //turn.change();


            // put chip
            // change turn
            board.display();



        //}
    }

    private int readRow() {
        System.out.print("set a row");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer value = -1;
        try {
            value = Integer.parseInt(br.readLine());
        } catch (IOException e) {

        }
        return value;
    }

    private int readCol() {
        System.out.print("set a col");

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

        if (aux.getTurn() == 0) return 0;
        else return 1;
    }

    public static void main(String[] args) {

        new Othello().startGame();

    }


}
