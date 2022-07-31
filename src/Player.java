import java.util.*;
public class Player {
    private List<Card> hand = new ArrayList<>();
    private int j = 0;
    private Mould mouldOne;
    private Mould mouldTwo;
    private Mould mouldThree;
    public Player (String name, Deck deck){
        startHand(deck);
        mouldOne = new Mould(this, 0, 2);
        mouldTwo = new Mould(this, 3, 5);
        mouldThree = new Mould(this, 6, 8);
        sortHand();
    }
    private void startHand (Deck d) {
        for (int i = 0; i < 9; i++){
            this.hand.add(d.pop());
        }
    }

    private void sortHand (){
        Collections.sort(hand, new Comparator<Card>(){
            @Override
            public int compare (Card c1, Card c2){
                return c1.getRankValue() - c2.getRankValue();
            }
        });
    }
    public void showHand () {
        sortHand();
        System.out.println("\nYour hand is: \n");
        for (int i = 0; i < this.hand.size(); i++){
            System.out.print(this.hand.get(i) + " ");
            j++;
            if (j == 3){
                j = 0;
                System.out.println();
            }
        }
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setMoulds (){
        mouldOne.setMould();
        mouldTwo.setMould();
        mouldThree.setMould();
    }

    public Mould getMouldOne() {
        return mouldOne;
    }

    public Mould getMouldTwo() {
        return mouldTwo;
    }

    public Mould getMouldThree() {
        return mouldThree;
    }
}
