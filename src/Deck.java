import java.util.*;
public class Deck{
    private List<Card> deck = new ArrayList<>();

    public Deck (){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 13; j++){
                add(j, i);
            }
        }
    }
    // debug method
    public void showDeck () {
        for (int i = 0; i < this.deck.size(); i++){
            System.out.println(this.deck.get(i));
        }
    }

    public Card pop () {
        Random rand = new Random();
        int c = rand.nextInt(deck.size());
        Card pop = deck.get(c);
        this.deck.remove(pop);
        return pop;
    }

    public void add (int rank, int suit){
        this.deck.add(new Card(Card.ranks[rank], Card.suits[suit]));
    }
    public List<Card> getDeck() {
        return deck;
    }
    
    public Card getCard (){
        return deck.get(deck.size() - 1);
    }
}