/*
 TODO:

 DONE: Check for and handle the end condition of the game
 --> Stock point calculations (Javier)
 - Code the get more destination cards method
 - Implement points for captured routes
 DONE: Finish game initialization (in constructor)
 DONE: Stock card stuff [Javier]
 DONE: Recheck endTurn() to see if it's complete
 DONE? Finish the Route implementation
 --> Hardcode the routes (Jose)
 --> Hardcode the cities (Jose)
 - Replace train card filenames with real ones
 - Two Player Rules
 - Endgame calculations
 --> Stock points (Javier)
 --> Destination ticket points
 -------> Add AND Subtract
 --> Globetrotter Bonus
 --> Longest Continuous Path
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Class TrainGame - used to run the Ticket to Ride game. To be instantiated by
 * the applet.
 *
 * An implementation of this class must, during its initial setup, call the
 * dcardsSetup() method on each of the game's players, using their inputs to
 * determine which destination cards they want to keep.
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
    List<DestCard> dcards;

    //deck of stock cards
    StockCards stockCards;

    //collection of routes & cities
    //array of players (constructor?)
    private int cardsTaken = 0;

    private Player[] players;

    //used to keep track of current active player
    private int activePlayer;

    //used to keep track of who is taking the final turn come endgame
    private int lastTurnTaker = -1;

    //used to check whether the last turn taker is on their last turn.
    private boolean lastTurn = false;

    //used to hold destination cards that are visible to the player
    public DestCard[] shownDestCards;

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
        shownDestCards = null;
        //this gives each player 5 destination cards. 
        //the implementing class must call the dcardsSetup method on each
        //player's first turn.
        for (Player p : players) {
            for (int i = 0; i < 5; i++) {
                p.destCards.add(this.dcards.remove(0));
            }
        }

        //set up the stock cards.
    }

    /**
     * Used to prepare the destination cards for each player, on that player's
     * first turn.
     *
     * @param keeping, the list of indices in the player's array of DestCards
     * that the player has chosen to keep.
     */
    public void dcardsSetup(Player p, int[] keeping) {

        List<DestCard> toKeep = new ArrayList<>();

        for (int i : keeping) {
            toKeep.add(p.destCards.get(i));
        }

        for (int i = 0; i < p.destCards.size(); i++) {
            if (!toKeep.contains(p.destCards.get(i))) {
                dcards.add(p.destCards.get(i));
            }
        }

        p.destCards.clear();

        for (DestCard c : toKeep) {
            p.destCards.add(c);
        }

    }

    /**
     * Used when a player claims a route.
     *
     * Note that this method assumes that all cards in cardsSelected are in the
     * active player's hand.
     *
     * @param p, the player who is claiming the route
     * @param r, the data for the route
     *
     *
     */
    public void claimRoute(Route r, TrainCard[] cardsSelected)
            throws IllegalArgumentException {

        Player p = players[activePlayer];

        //the part where you claim the route, if you haven't done 
        //anything else yet
        if (cardsTaken == 0) {

            //if the route is already claimed
            if (r.isClaimed) {
                throw new IllegalArgumentException("You can't claim a claimed"
                        + " route!");
            }

            //if you don't have enough train pieces left
            if (p.numTrains < r.length) {
                throw new IllegalArgumentException("You don't have enough "
                        + "trains!");
            }

            TrainCard[] cardsUsed = new TrainCard[r.length];
            int cardsUsedIndex = 0;
            //has enough on-color trains in the selected cards?
            boolean hasEnough = false;

            //if it's not a gray route
            if (r.color != TrainColor.WILD) {
                for (int i = 0; i < cardsSelected.length; i++) {

                    if (cardsSelected[i].color == r.color || cardsSelected[i].isWild()) {
                        cardsUsed[cardsUsedIndex] = cardsSelected[i];
                        cardsUsedIndex++;

                        if (cardsUsedIndex >= cardsUsed.length) {
                            hasEnough = true;
                            break;
                        }
                    }
                }
            } else if (!(r.source.name.equals("Ontario")) && r.dest.name.equals("Ontario")) {
                //establish a color
                TrainColor chosenColor = null;
                for (TrainCard c : cardsSelected) {
                    if (!c.isWild()) {
                        chosenColor = c.color;
                    }
                }

                for (int i = 0; i < cardsSelected.length; i++) {

                    if (cardsSelected[i].color == chosenColor || cardsSelected[i].isWild()) {
                        cardsUsed[cardsUsedIndex] = cardsSelected[i];
                        cardsUsedIndex++;

                        if (cardsUsedIndex >= cardsUsed.length) {
                            hasEnough = true;
                            break;
                        }
                    }
                }
                //if it's the ontario with length == 1   
            } else if (r.length == 1) {
                for (int i = 0; i < cardsSelected.length; i++) {
                    if (cardsSelected[i].isWild()) {
                        cardsUsed[cardsUsedIndex] = cardsSelected[i];
                        cardsUsedIndex++;

                        if (cardsUsedIndex >= cardsUsed.length) {
                            hasEnough = true;
                            break;
                        }
                    }
                }
                //if it's the ontario with length == 3
            } else {

                int wildsUsed = 0;

                for (int i = 0; i < cardsSelected.length; i++) {
                    if (cardsSelected[i].isWild() || (wildsUsed >= 2)) {
                        cardsUsed[cardsUsedIndex] = cardsSelected[i];
                        cardsUsedIndex++;
                        wildsUsed++;

                        if (cardsUsedIndex >= cardsUsed.length) {
                            hasEnough = true;
                            break;
                        }
                    }
                }

            }

            if (hasEnough) {

                for (TrainCard c : cardsUsed) {
                    //put the card in the discard pile
                    trainDiscard.add(c);
                    //take the cards out of the player's hand
                    for (int i = 0; i < p.hand.size(); i++) {
                        if (p.hand.get(i).equals(c)) {
                            p.hand.remove(i);
                            break;//break the inner loop
                        }
                    }
                }

                //add the route to the player's list of routes
                p.routesOwned.add(r);

                //the route is claimed now
                r.isClaimed = true;

                //use the player's trains
                p.numTrains -= r.length;

                //the player earns the route's point value
                p.numPoints += r.getPoints();

                //this move takes two "turn points"
                cardsTaken = 2;

                //the part where you claim the stocks
                String stockList = r.stocks[0];

                for (int i = 1; i < r.stocks.length; i++) {
                    stockList += ", " + r.stocks[i];
                }

                boolean stocksClaimed = false;

                while (!stocksClaimed) {

                    String stockChosen = JOptionPane.showInputDialog(
                            "Please choose a stock: " + stockList);

                    try {

                        claimStocks(r, stockChosen);
                        stocksClaimed = true;

                    } catch (IllegalArgumentException e) {

                        JOptionPane.showMessageDialog(null, "Sorry, that's not "
                                + "valid input. Please try again. (We may be"
                                + "out of that type of stock.)");
                        System.err.println(e);

                    }
                }

                checkForEnd();

            } else {
                System.err.println("Route not taken: insufficient cards"
                        + " selected.");
            }

        }

    }

    /**
     * Used to check if the number of trains in any of the players' possession
     * is less than or equal to 2; therefore, if the game is ending.
     *
     * @precondition lastTurnTaker = -1
     * @postcondition lastTurnTaker != -1
     *
     * @return true if the game is set to finish soon, false otherwise
     */
    public boolean checkForEnd() {
        if (lastTurnTaker != -1) {
            return true;
        }

        //check the active player first; in all likelihood, they will be the 
        //first to get to less than 3 trains.
        if (players[activePlayer].numTrains <= 2) {
            lastTurnTaker = activePlayer;
            return true;
        }

        for (int i = 0; i < players.length; i++) {
            if (players[i].numTrains <= 2) {
                lastTurnTaker = i;
                return true;
            }
        }

        return false;
    }

    /**
     * This part of the code would read what stocks the current route has then
     * would prompt the player to choose and once that data is received
     * currently uses switch statements basically how it works is that it
     * removes a card from the Stockcard class and adds it to the player's deck
     * of stock cards.
     *
     * @param r, the route that has been claimed
     * @param s, the desired stock
     */
    public void claimStocks(Route r, String s) {

        Player p = players[activePlayer];

        switch (s) {
            case "lehighValley":

                if (stockCards.lehighValley.isEmpty()) {
                    throw new IllegalArgumentException();
                }

                p.stocks.add(stockCards.lehighValley.remove(0));
                break;
            case "pennsylvania":
                if (stockCards.pennsylvania.isEmpty()) {
                    throw new IllegalArgumentException();

                }

                p.stocks.add(stockCards.pennsylvania.remove(0));
                break;
            case "newyorkCentralSystem":
                if (stockCards.newyorkCentralSystem.isEmpty()) {
                    throw new IllegalArgumentException();

                }
                p.stocks.add(stockCards.newyorkCentralSystem.remove(0));
                break;
            case "readingRailRoad":
                if (stockCards.readingRailRoad.isEmpty()) {
                    throw new IllegalArgumentException();

                }
                p.stocks.add(stockCards.readingRailRoad.remove(0));
                break;
            case "erieLackawanna":
                if (stockCards.erieLackawanna.isEmpty()) {
                    throw new IllegalArgumentException();

                }
                p.stocks.add(stockCards.erieLackawanna.remove(0));
                break;
            case "jerseyCentralLine":
                if (stockCards.jerseyCentralLine.isEmpty()) {
                    throw new IllegalArgumentException();

                }
                p.stocks.add(stockCards.jerseyCentralLine.remove(0));
                break;
            case "baltimore":
                if (stockCards.baltimore.isEmpty()) {
                    throw new IllegalArgumentException();

                }
                p.stocks.add(stockCards.baltimore.remove(0));
                break;
            case "westernMaryland":
                if (stockCards.westernMaryland.isEmpty()) {
                    throw new IllegalArgumentException();

                }
                p.stocks.add(stockCards.westernMaryland.remove(0));
                break;
            case "brpRailWay":
                if (stockCards.brpRailWay.isEmpty()) {
                    throw new IllegalArgumentException();

                }
                p.stocks.add(stockCards.brpRailWay.remove(0));
                break;

        }

        throw new IllegalArgumentException("ERROR: Stock name is invalid");
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

            return;
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
        //reset number of actions taken
        cardsTaken = 0;

        //the first time this fires, it will be as the last turn player's
        //penultimate turn ends.
        //the second time it fires will be after the last turn of the game.
        if (checkForEnd() && activePlayer == lastTurnTaker) {
            if (!lastTurn) {
                lastTurn = true;
            } else {
                //final calculations; game wrap up
            }
        }

        //change active player
        activePlayer++;
        if (activePlayer >= players.length) {
            activePlayer = 0;
        }

    }

    /**
     * Used when a player takes destination cards; this method reveals them.
     *
     * @param toReveal, the number of destination cards to reveal.
     *
     * toReveal should be 4 for a draw on a player's turn.
     *
     * @precondition shownDestCards == null
     * @postcondition shownDestCards != null; it's full of revealed cards
     *
     * Call chooseDest after the player has made their selection.
     */
    public void showDest(int toReveal) {
        if (cardsTaken == 0) {

            shownDestCards = new DestCard[4];
            for (int i = 0; i < 4; i++) {
                shownDestCards[i] = dcards.remove(0);
            }

            cardsTaken = 2;

        }

    }

    /**
     * Used when a player takes destination cards, after the ones to keep have
     * been chosen.
     *
     * @precondition showDest was just called, and shownDestCards != null
     * @postcondition shownDestCards == null
     *
     * @param chosen, a list of shown destination cards that were chosen to keep
     */
    public void chooseDest(int[] chosen) {

        if (shownDestCards != null) {

            for (int i : chosen) {
                players[activePlayer].destCards.add(shownDestCards[i]);
            }

            shownDestCards = null;
        }

    }

    /*
     - Endgame calculations
     --> Stock points (Javier)
     --> Destination ticket points
     -------> Add AND Subtract
     --> Globetrotter Bonus
     --> Longest Continuous Path??
     */
    /**
     * Used to calculate final point totals.
     *
     */
    protected void finalPointsCount() {

        //destination ticket points
        for (Player p : players) {
            for (DestCard d : p.destCards) {
                
            }
        }

    }
}
