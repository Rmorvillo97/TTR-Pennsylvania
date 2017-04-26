
import java.awt.Color;
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
        
    protected List<DestCard> destCards;
    
    protected List<Route> routesOwned;
    
    protected int numPoints;
    
    protected int numTrains;
    
    protected TrainColor color;
    
    protected List<StockBase> lehighValley;

    protected List<StockBase> pennsylvania;

    protected List<StockBase> newyorkCentralSystem;

    protected List<StockBase> readingRailRoad;

    protected List<StockBase> erieLackawanna;

    protected List<StockBase> jerseyCentralLine;

    protected List<StockBase> baltimore;

    protected List<StockBase> westernMaryland;

    protected List<StockBase> brpRailWay;
    
    /**
     * Constructor for objects of class Player
     * 
     * @param nm, the player's name
     */
    public Player(String nm, TrainColor tc){
        name = nm;
        hand = new ArrayList<>();
        destCards = new ArrayList<>();
        routesOwned = new ArrayList<>();
        numPoints = 0;
        numTrains = 45;
        color = tc;
        
        lehighValley = new ArrayList<>();
        pennsylvania = new ArrayList<>();
        newyorkCentralSystem = new ArrayList<>();
        readingRailRoad = new ArrayList<>();
        erieLackawanna = new ArrayList<>();
        jerseyCentralLine = new ArrayList<>();
        baltimore = new ArrayList<>();
        westernMaryland = new ArrayList<>();
        brpRailWay = new ArrayList<>();
    }
    
    
    
    
    
}