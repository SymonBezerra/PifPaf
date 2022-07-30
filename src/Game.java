import java.util.*;

public class Game {
    private Scanner input;
    private Table table;
    public Deck deck;
    private Player player;
    private Mould mouldOne = new Mould();
    private Mould mouldTwo = new Mould();
    private Mould mouldThree = new Mould();

    public Game(){
        table = new Table();
        deck = new Deck();
        Collections.shuffle(deck.getDeck());
        player = new Player("Player", deck);
        input = new Scanner(System.in);
        movePull();
        System.out.println("Welcome to PifPaf! \n ");
        player.showHand();
        boolean wins = true;
        while (wins){
            wins = false;
            setMouldOne();
            setMouldTwo();
            setMouldThree();
            boolean playerWins = winner();
            if (playerWins){
                System.out.println("You win!");
                break;
            }
            if (table.getCards().size() == 0){
                movePull();
            }
            System.out.println("Card on the table: "+
            table.tableCard());
            System.out.println("Pull (1) or switch (2)?");
            int move = input.nextInt();
            if (move == 2){
                System.out.println("Which card do you want to switch? (1-9)");
                int card = input.nextInt();
                moveSwitch(card);
                player.showHand();
                wins = true;
            }
            else if (move == 1){
                movePull();
                System.out.println("Card on the table: "+
                table.tableCard());
                System.out.println("Pass (1) or switch (2)?");
                int nextMove = input.nextInt();
                if (nextMove == 2){
                    System.out.println("Which card do you want to switch? (1-9)");
                    int card = input.nextInt();
                    moveSwitch(card);
                    player.showHand();
                    wins = true;
                }
                else if (nextMove == 1){
                    player.showHand();
                    wins = true;
                }
                else {
                    System.out.println("Try again...");
                    wins = true;
                }
            }
            else {
                System.out.println("Try again...");
                wins = true;
            }
        }
    }

    public void movePull (){
        table.add(deck.pop());
    }

    public void moveSwitch (int card){
        player.getHand().set(card - 1, table.pop());
    }

    public boolean winner(){
        boolean mouldOneReady = 
        mouldRuleOne(mouldOne) &&
        mouldRuleTwo(mouldOne);

        boolean mouldTwoReady = 
        mouldRuleOne(mouldTwo) &&
        mouldRuleTwo(mouldTwo);

        boolean mouldThreeReady = 
        mouldRuleOne(mouldThree) &&
        mouldRuleTwo(mouldThree);

        if (mouldOneReady && mouldTwoReady && mouldThreeReady)
            return true;
        return false;
        
    }

    private boolean mouldRuleOne (Mould mould){
        boolean rule = 
        mould.item(1).getRankValue() ==
        mould.item(0).getRankValue() + 1 && 
        mould.item(2).getRankValue() == 
        mould.item(1).getRankValue() + 1 &&
        mould.item(0).getSuitValue() ==
        mould.item(1).getSuitValue() && 
        mould.item(1).getSuitValue() ==
        mould.item(2).getSuitValue();

        return rule;
    }

    private boolean mouldRuleTwo (Mould mould){
        boolean rule = 
        mould.item(0).getRankValue() ==
        mould.item(1).getRankValue() &&
        mould.item(1).getRankValue() ==
        mould.item(2).getRankValue();

        return rule;
    }

    public void setMould(Mould mould){
        
    }

    public void setMouldOne() {
        int index = 0;
        for (int card = 0; card < 3; card++){
            mouldOne.getMould().set(index, player.getHand().get(card));
            index++;
        }
    }

    public void setMouldTwo() {
        int index = 0;
        for (int card = 3; card < 6; card++){
            mouldTwo.getMould().set(index, player.getHand().get(card));
            index++;
        }
    }

    public void setMouldThree() {
        int index = 0;
        for (int card = 6; card < 9; card++){
            mouldThree.getMould().set(index, player.getHand().get(card));
            index++;
        }
    }
}