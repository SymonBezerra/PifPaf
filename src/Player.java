import java.util.*;
public class Player {
    private List<Card> hand = new ArrayList<>();
    private int j = 0;
    public Player (String name, Deck deck){
        startHand(deck);
    }
    public void startHand (Deck d) {
        for (int i = 0; i < 9; i++){
            this.hand.add(d.pop());
        }
    }

    public void sortHand (){
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
}
