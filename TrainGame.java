
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class TrainGame - used to run the Ticket to Ride game. To be instantiated by
 * the applet.
 *
 * @author London Brunell
 */
/**
 *
 * @author London Brunell
 */
public class TrainGame {

    //deck of train cards
    List<TrainCard> trainDeck;
    //list of currently displayed train cards
    List<TrainCard> trainPile;
    List<TrainCard> trainDiscard;

    //deck of destination cards
    DestCard[] dcards;

    //deck of stock cards
    StockCards stockCards;

    //array of players (constructor?)
    private int cardsTaken = 0;

    private Player[] players;

    private int activePlayer;

    /**
     * Constructor for TrainGame objects.
     *
     */
    public TrainGame() {

        //set up the train cards:
        trainDeck = new ArrayList<>();
        trainDiscard = new ArrayList<>();

        //add 14 wild cards
        for (int i = 0; i < 14; i++) {
            trainDeck.add(new TrainCard(TrainColor.WILD, new File("wild.jpg")));
        }
        //add 12 of each color
        for (int i = 0; i < 12; i++) {
            trainDeck.add(new TrainCard(TrainColor.YELLOW, new File("yellow.jpg")));
        }
        for (int i = 0; i < 12; i++) {
            trainDeck.add(new TrainCard(TrainColor.WHITE, new File("white.jpg")));
        }
        for (int i = 0; i < 12; i++) {
            trainDeck.add(new TrainCard(TrainColor.RED, new File("red.jpg")));
        }
        for (int i = 0; i < 12; i++) {
            trainDeck.add(new TrainCard(TrainColor.PINK, new File("pink.jpg")));
        }
        for (int i = 0; i < 12; i++) {
            trainDeck.add(new TrainCard(TrainColor.ORANGE, new File("orange.jpg")));
        }
        for (int i = 0; i < 12; i++) {
            trainDeck.add(new TrainCard(TrainColor.GREEN, new File("green.jpg")));
        }
        for (int i = 0; i < 12; i++) {
            trainDeck.add(new TrainCard(TrainColor.BLUE, new File("blue.jpg")));
        }
        for (int i = 0; i < 12; i++) {
            trainDeck.add(new TrainCard(TrainColor.BLACK, new File("black.jpg")));
        }
        //shuffle the deck to randomize it
        Collections.shuffle(trainDeck);

        //give players their hands
        for (Player p : players) {
            for (int i = 0; i < 4; i++) {
                p.hand.add(trainDeck.remove(0));
            }
        }

        //set up the cards on the table
        trainPile = new ArrayList<>();
        boolean pileDone = false;
        while (!pileDone) {
            //put the first five cards of the deck into the pile
            for (int i = 0; i < 5; i++) {
                trainPile.add(trainDeck.remove(0));
            }

            int wildCount = 0;
            //check if each of the cards is a wild card
            for (TrainCard c : trainPile) {
                if (c.isWild()) {
                    wildCount++;
                }
            }
            //if there's not 3 or more wild cards, we're good
            if (!(wildCount >= 3)) {
                pileDone = true;
            } else {
                //we have to discard the pile and get a new one
                for (int i = 0; i < 5; i++) {
                    trainDiscard.add(trainPile.remove(0));
                }
            }
        }

        //set up the destination cards.
        //set up the stock cards.
    }

    /**
     * Used when a player claims a route.
     *
     * @param p, the player who is claiming the route
     * @param r, the data for the route
     *
     *
     */
    public void claimRoute(Route r, TrainCard[] cardsSelected) {

        if (cardsTaken == 0) {

            Player p = players[activePlayer];

            //the part where you claim the route
            if (r.isClaimed) {
                System.err.println("You can't claim a claimed route!");
            }

            TrainCard[] cardsUsed = new TrainCard[r.length];
            int cardsUsedIndex = 0;
            //has enough on-color trains in the selected cards?
            boolean hasEnough = false;

            for (int i = 0; i < cardsSelected.length; i++) {

                if (cardsSelected[i].color == r.color) {
                    cardsUsed[cardsUsedIndex] = cardsSelected[i];
                    cardsUsedIndex++;

                    if (cardsUsedIndex >= cardsUsed.length) {
                        hasEnough = true;
                        break;
                    }
                }
            }

            if (hasEnough) {

                for (TrainCard c : cardsUsed) {
                    trainDiscard.add(c);
                }

                p.routesOwned.add(r);

                r.isClaimed = true;

                cardsTaken = 2;

            } else {
                System.err.println("Route not taken: insufficient cards"
                        + " selected.");
            }

        //the part where you claim the stocks
        }
    }

    /**
     * Used when a player draws a card from the train deck.
     *
     *
     */
    public void drawCard() {

        if (cardsTaken < 2) {

            players[activePlayer].hand.add(trainDeck.remove(0));

            fixTrainDeck();

            cardsTaken++;
        }//else do nothing       

    }

    /**
     * Used when a player takes a card from the trains on the table.
     *
     * @param index
     */
    public void drawCard(Player p, int index) {

        TrainCard card = trainPile.remove(index);

        if (card.isWild()) {
            if (cardsTaken == 1) {
                System.err.println("Card not taken: cannot take a wild after "
                        + "taking another card");
            } else if (cardsTaken == 0) {
                players[activePlayer].hand.add(card);
                cardsTaken = 2;
            }
        } else {//if the card is't wild
            if (cardsTaken < 2) {
                players[activePlayer].hand.add(card);
                cardsTaken++;

                trainPile.add(trainDeck.remove(0));

                fixTrainDeck();
            }
        }

    }

    /**
     * Helper method to reshuffle the train deck, iff it is empty
     *
     */
    private void fixTrainDeck() {
        if (trainDeck.isEmpty()) {
            for (TrainCard c : trainDiscard) {
                trainDeck.add(c);
            }
            Collections.shuffle(trainDeck);
            trainDiscard.clear();
        }
    }

    /**
     * Call this whenever the turn changes from one player to another.
     *
     */
    public void changeTurn() {
        cardsTaken = 0;
        activePlayer++;
        if (activePlayer >= players.length) {
            activePlayer = 0;
        }
    }

    /**
     * Used when a player takes destination cards.
     *
     *
     */
    public void takeDest() {
        if (cardsTaken == 0) {
            
            //do the thing here
            
            cardsTaken = 2;

        }

    }
}
