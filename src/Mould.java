import java.util.ArrayList;
public class Mould {
    private ArrayList<Card> mould;
    private Player player;
    private int start;
    private int stop;

    public Mould (Player player, int start, int stop){
        this.player = player;
        this.start = start;
        this.stop = stop;
        mould = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            mould.add(new Card(Card.ranks[0], Card.suits[0]));
        }
    }

    // public Card item (int index) {
    //     return mould.get(index);
    // }

    public ArrayList<Card> getMould() {
        return mould;
    }

    public void setMould (){
        int index = 0;
        for (int card = start; card <= stop; card++){
            this.mould.set(index, player.getHand().get(card));
            index++;
        }
    }
}
