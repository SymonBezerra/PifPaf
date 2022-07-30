import java.util.ArrayList;
public class Mould {
    private ArrayList<Card> mould;
    public Mould (){
        mould = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            mould.add(new Card(Card.ranks[0], Card.suits[0]));
        }
    }

    public Card item (int index) {
        return mould.get(index);
    }

    public ArrayList<Card> getMould() {
        return mould;
    }

    public void setMould(int index, Card c) {
        this.mould.set(index, c);
    }
}
