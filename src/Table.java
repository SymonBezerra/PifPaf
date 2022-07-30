import java.util.*;
public class Table {
    private List<Card> cards;
    public Table (){
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card pop (){
        Card pop = cards.get(cards.size() - 1);
        cards.remove(pop);
        return pop;
    }
    
    public void add (Card card) {
        cards.add(card);
    }
    
    public Card tableCard (){
        Card tableCard = cards.get(cards.size() - 1);
        return tableCard;
    }

}