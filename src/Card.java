public class Card{
    public static final String [] ranks = {"1", "2", "3", "4",
    "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static final String [] suits = {"of Hearts", "of Diamonds", "of Clubs", "of Spades"};

    private final String rank;
    private final String suit;
    public Card (String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    @Override
    public String toString() {   
        String card = this.rank + " " + this.suit;
        return card;
    }

    public int getRankValue (){
        int index = 0;
        for (int i = 0; i < 14; i++){
            if (this.rank == Card.ranks[i]){
                index = i;
                break;
            }
        }
        return index;
    }

    public int getSuitValue (){
        int index = 0;
        for (int i = 0; i < 4; i++){
            if (this.rank == Card.suits[i]){
                index = i;
                break;
            }
        }
        return index;
    }
}