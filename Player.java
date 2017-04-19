
import java.util.ArrayList;
import java.util.List;

/**
 * Used to store information on a Player of Ticket to Ride.
 * 
 * @author London Brunell
 */
public class Player {
    
    protected String name;
    
    protected List<TrainCard> hand;
    
    protected List<StockBase> stocks;
    
    protected List<DestCard> destCards;
    
    protected List<Route> routesOwned;
    
    protected int numPoints;
    
    protected int numTrains;
    
    /**
     * Constructor for objects of class Player
     * 
     * @param nm, the player's name
     */
    public Player(String nm){
        name = nm;
        hand = new ArrayList<>();
        stocks = new ArrayList<>();
        destCards = new ArrayList<>();
        routesOwned = new ArrayList<>();
        numPoints = 0;
        numTrains = 45;
    }
    
    
}
