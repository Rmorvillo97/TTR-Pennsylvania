import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JApplet;
import java.io.File;
import javax.imageio.*;
import java.io.IOException;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Class TicketToRide - write a description of the class here
 * 
 * @author Rachael, Rob, London, Javier, Jose
 */
public class TicketToRide extends JApplet implements MouseListener
{
    /** Board image */
    private BufferedImage board;

    /** Number of players*/
    private int NUM_PLAYERS;

    /** If you click to bring stock cards up */
    private boolean stockScreen;

    /** If you click to get more routes */
    private boolean moreRoutesScreen;

    /** If you click on to view your routes */
    private boolean myRoutesScreen;

    /** If you click to place trains */
    private boolean placingTrains;

    /** If you click to intruction button */
    private boolean intructionDisplay;

    /** first click */
    private boolean firstClickHappened;

    /** status bar text */
    private String status = "";

    /** where was first click? */
    private int click1Row, click1Col;

    /** main train game */
    private TrainGame game;

    /** the surrounding area of around the city that you can click on */
    private final int AREA_AROUND_CITY = 13;

    // players turn
    private Player playerGoing;

    // images of trains assigned to each player's color
    private BufferedImage blackTrain;
    private BufferedImage blueTrain;
    private BufferedImage greenTrain;
    private BufferedImage redTrain;
    private BufferedImage yellowTrain;

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        addMouseListener(this);

        // read board and train color pieces in
        try{
            board = ImageIO.read(new File("TicketToRideGraphics/board.jpg"));
            blackTrain = ImageIO.read(new File("TicketToRideGraphics/TrainPieces/BLACKTRAIN.jpg"));
            blueTrain = ImageIO.read(new File("TicketToRideGraphics/TrainPieces/BLUETRAIN.jpg"));
            greenTrain = ImageIO.read(new File("TicketToRideGraphics/TrainPieces/GREENTRAIN.jpg"));
            redTrain = ImageIO.read(new File("TicketToRideGraphics/TrainPieces/REDTRAIN.jpg"));
            yellowTrain = ImageIO.read(new File("TicketToRideGraphics/TrainPieces/YELLOWTRAIN.jpg"));
        }
        catch (IOException e){
            System.err.println("Image file for board missing");
        }
        // pick how many players are playing
        Object[] possiblePlayers = { "2", "3", "4", "5",};
        Object selectedValue = JOptionPane.showInputDialog(null, "Choose how many players", "Number of Players", JOptionPane.INFORMATION_MESSAGE, null, possiblePlayers, possiblePlayers[0]);
        NUM_PLAYERS = Integer.valueOf((String) selectedValue);

        String[] playerNames = new String[NUM_PLAYERS];
        TrainColor[] playerColors = new TrainColor[NUM_PLAYERS];

        // possible colors for players to choose
        Object[] possibleColors = { "Blue", "Green", "Black", "Red", "Yellow" };

        // assign names to players
        for (int i = 0; i < NUM_PLAYERS; i++) {
            // ask user for players name
            String player = JOptionPane.showInputDialog("Please enter player " + (i+1) + "'s name.");
            // ask for color for user
            String selectedColor = (String)JOptionPane.showInputDialog(null, "Choose a color for player " + player + "", "Color", JOptionPane.INFORMATION_MESSAGE, null, possibleColors, possibleColors[0]);
            for (int j = 0; j < possibleColors.length; j++){
                if(selectedColor.equals((String)possibleColors[j])){
                    // once you pick a color, it becomes null in the list
                    possibleColors[j] = null;
                }
            }
            // creates a new player and adds it to list of players

            TrainColor c = null;

            switch(selectedColor){
                case "Blue": c = TrainColor.BLUE; break;
                case "Green": c = TrainColor.GREEN; break;
                case "Black": c = TrainColor.BLACK; break;
                case "Red": c = TrainColor.RED; break;
                case "Yellow": c = TrainColor.YELLOW; break;
            }

            playerNames[i] = player;
            playerColors[i] = c;
        }

        game = new TrainGame(playerNames, playerColors);

    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        // displays board
        g.drawImage(board, 0, 0, null);
        // draw images of card on board
        g.drawImage(game.trainPile.get(0).image, 150, 797, null);
        g.drawImage(game.trainPile.get(1).image, 352, 797, null);
        g.drawImage(game.trainPile.get(2).image, 552, 797, null);
        g.drawImage(game.trainPile.get(3).image, 752, 797, null);
        g.drawImage(game.trainPile.get(4).image, 954, 797, null);

        // number of cards the player has
        int numWild = 0;
        int numBlue = 0;
        int numWhite = 0;
        int numYellow = 0;
        int numPink = 0;
        int numOrange = 0;
        int numBlack = 0;
        int numGreen = 0;
        int numRed = 0;

        // loops through current players hand to count how many cards of each type
        for (int i = 0; i < game.players[game.activePlayer].hand.size(); i++){
            if (game.players[game.activePlayer].hand.get(i).color.equals(TrainColor.WILD)) {
                numWild++;
            }
            if (game.players[game.activePlayer].hand.get(i).color.equals(TrainColor.BLUE)) {
                numBlue++;
            }
            if (game.players[game.activePlayer].hand.get(i).color.equals(TrainColor.WHITE)) {
                numWhite++;
            }
            if (game.players[game.activePlayer].hand.get(i).color.equals(TrainColor.YELLOW)) {
                numYellow++;
            }
            if (game.players[game.activePlayer].hand.get(i).color.equals(TrainColor.PINK)) {
                numPink++;
            }
            if (game.players[game.activePlayer].hand.get(i).color.equals(TrainColor.ORANGE)) {
                numOrange++;
            }
            if (game.players[game.activePlayer].hand.get(i).color.equals(TrainColor.BLACK)) {
                numBlack++;
            }
            if (game.players[game.activePlayer].hand.get(i).color.equals(TrainColor.GREEN)) {
                numGreen++;
            }
            if (game.players[game.activePlayer].hand.get(i).color.equals(TrainColor.RED)) {
                numRed++;
            }
        }

        // change font of numbers
        Font myFont = new Font("Papyrus", Font.BOLD, 100);
        g.setFont(myFont);

        g.setColor(Color.white);
        // display number of cards player has
        g.drawString(numWild + "", 35, 62);
        g.drawString(numBlue + "", 35, 148);
        g.drawString(numWhite + "", 35, 233);
        g.drawString(numYellow + "", 35, 318);
        g.drawString(numPink + "", 35, 403);
        g.drawString(numOrange + "", 35, 488);
        g.drawString(numBlack + "", 35, 574);
        g.drawString(numGreen + "", 35, 658);
        g.drawString(numRed + "", 35, 744);

        myFont = new Font("Papyrus", Font.BOLD, 20);
        g.setFont(myFont);
        // display who's turn it is number and name
        g.drawString("PLAYER:", 1130, 60);
        g.drawString(game.players[game.activePlayer].name, 1120, 130);
        myFont = new Font("Papyrus", Font.BOLD, 60);
        g.setFont(myFont);
        g.drawString("" + game.activePlayer, 1160, 100);

        // picture of players color train according to whos turn it is
        if (game.players[game.activePlayer].color.equals(TrainColor.BLACK)) {
            g.drawImage(blackTrain, 1138, 461, null);
        }
        else if (game.players[game.activePlayer].color.equals(TrainColor.BLUE)) {
            g.drawImage(blueTrain, 1138, 461, null);
        }
        else if (game.players[game.activePlayer].color.equals(TrainColor.GREEN)) {
            g.drawImage(greenTrain, 1138, 461, null);
        }
        else if (game.players[game.activePlayer].color.equals(TrainColor.RED)) {
            g.drawImage(redTrain, 1138, 461, null);
        }
        else if (game.players[game.activePlayer].color.equals(TrainColor.YELLOW)) {
            g.drawImage(yellowTrain, 1138, 461, null);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // if you click on top of color deck to take, adds to your stack
        if (x > 8 && x < 125 && y > 766 && y < 942){ 
            status = "You just picked a new card from the pile!";
            showStatus(status);
            // players draws a card from deck
            game.drawCard();
            repaint();
            return;
        }

        // if you pick a color card to take from slot 1, will immediately draw from top and fill in spot
        if (x > 150 && x < 325 && y > 797 && y < 906){
            status = "You just picked a new card from slot one!";
            showStatus(status);
            // players draws a card from deck
            game.drawCard( 0);
            repaint();
            return;
        }

        // if you pick a color card to take from slot 2, will immediately draw from top and fill in spot
        if (x > 352 && x < 527 && y > 797 && y < 906){ 
            status = "You just picked a new card from slot two!";
            showStatus(status);
            // players draws a card from deck
            game.drawCard(1);
            repaint();
            return;
        }

        // if you pick a color card to take from slot 3, will immediately draw from top and fill in spot
        if (x > 553 && x < 728 && y > 797 && y < 906){ 
            status = "You just picked a new card from slot three!";
            showStatus(status);
            // players draws a card from deck
            game.drawCard(2);
            repaint();
            return;
        }

        // if you pick a color card to take from slot 4, will immediately draw from top and fill in spot
        if (x > 752 && x < 927 && y > 797 && y < 906){ 
            status = "You just picked a new card from slot four!";
            showStatus(status);
            // players draws a card from deck
            game.drawCard(3);
            repaint();
            return;
        }

        // if you pick a color card to take from slot 5, will immediately draw from top and fill in spot
        if (x > 955 && x < 1130 && y > 797 && y < 906){ 
            status = "You just picked a new card from slot five!";
            showStatus(status);
            // players draws a card from deck
            game.drawCard(4);
            repaint();
            return;
        }

        // if you end your turn
        if (x > 1108 && x < 1217 && y > 640 && y < 780){ 
            status = "You just ended your turn!";
            showStatus(status);
            // if it is last player, start from first player again
            game.changeTurn();
            repaint();
            return;
        }

        // if you click to view your stocks
        if (x > 560 && x < 717 && y > 681 && y < 780){ 
            status = "You are viewing your stocks!";
            showStatus(status);
            stockScreen = true;
            return;
        }

        // if you click to view your routes 
        if (x > 260 && x < 418 && y > 681 && y < 740){
            status = "You are viewing your routes!";
            showStatus(status);
            myRoutesScreen = true;
            return;
        }

        // if you click to get more routes
        if (x > 891 && x < 990 && y > 682 && y < 781){ 
            status = "You are getting more routes!";
            showStatus(status);
            moreRoutesScreen = true;
            return;
        }

        // if you click to place trains
        if (x > 1134 && x < 1263 && y > 369 && y < 426){ 
            status = "You are placing trains! Pick a city to start at!";
            showStatus(status);
            placingTrains = true;
            return;
        }

        // you are placing trains
        if (placingTrains) {
            // if it is second click
            if (firstClickHappened) { // if it is second click
                status = "You just won the city!";
                showStatus(status);
                // get second coordinates of city
            }

            else{ // if it is the first click
                // get coordinates of first city
                //click1Row;
                //click1Col;
                status = "Pick a city you want to end at!";
                showStatus(status);
            }
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {    }

    @Override
    public void mouseReleased(MouseEvent e) {    }

    @Override
    public void mouseEntered(MouseEvent e) {    }

    @Override
    public void mouseExited(MouseEvent e) {    }

}