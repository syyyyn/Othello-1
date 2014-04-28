/**
 * Created by lfmingo on 01/04/14.
 *
 */
public class Turn {


   private int value;


   public Turn() {
        this.value =  (int)(Math.random() * 2.0d );
   }

    /**
     *
      * @param v This parameter adjust the value ...
     */
   public Turn(int v) {
       this.value = v;
   }


    /**
     *
     * @return return the value of the turn ...
     */
    public int getTurn() {
        return this.value;
    }

    public void change() {
        this.value = (this.value + 1) % 2;
    }
}
