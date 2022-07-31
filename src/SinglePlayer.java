import java.util.*;

public class SinglePlayer {
    private Scanner input;
    private Table table;
    public Deck deck;
    private Player player;

    public SinglePlayer(){
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
            player.setMoulds();
            System.out.println(player.getMouldOne().getMould());
            System.out.println(player.getMouldTwo().getMould());
            System.out.println(player.getMouldThree().getMould());
            
            boolean playerWins = winner(player);
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

    public boolean winner(Player player){
        boolean mouldOneReady = 
        mouldRuleOne(player.getMouldOne()) ||
        mouldRuleTwo(player.getMouldOne());

        boolean mouldTwoReady = 
        mouldRuleOne(player.getMouldTwo()) ||
        mouldRuleTwo(player.getMouldTwo());

        boolean mouldThreeReady = 
        mouldRuleOne(player.getMouldTwo()) ||
        mouldRuleTwo(player.getMouldTwo());

        if (mouldOneReady && mouldTwoReady && mouldThreeReady){
            return true;
        } else{
            return false;
        }
        
    }

    private boolean mouldRuleOne (Mould mould){
        boolean rule = 
        mould.getMould().get(1).getRankValue() ==
        mould.getMould().get(0).getRankValue() + 1 && 
        mould.getMould().get(2).getRankValue() == 
        mould.getMould().get(1).getRankValue() + 1 &&
        mould.getMould().get(0).getSuitValue() ==
        mould.getMould().get(1).getSuitValue() && 
        mould.getMould().get(1).getSuitValue() ==
        mould.getMould().get(2).getSuitValue();

        return rule;
    }

    private boolean mouldRuleTwo (Mould mould){
        boolean rule = 
        mould.getMould().get(0).getRankValue() ==
        mould.getMould().get(1).getRankValue() &&
        mould.getMould().get(1).getRankValue() ==
        mould.getMould().get(2).getRankValue();

        return rule;
    }
}