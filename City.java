
import java.util.ArrayList;
import java.util.List;


/**
 * Used to store data on cities in TtR.
 * 
 * @author London Brunell
 */
public class City {
    
    String name;
    int x;
    int y;
    
    List<Route> routes;
    
    /**
     * Default constructor for objects of type City
     * 
     * @param nm, the city's name 
     */
    public City(String nm){
        name = nm;
        x = 0;
        y = 0;
        routes = new ArrayList<>();
    }
    
    
    /**
     * Constructor for objects of type City
     * 
     * @param nm, the city's name 
     * @param x, the City's x-coordinate
     * @param y, the city's y-coordinate
     */
    public City(String nm, int x, int y){
        name = nm;
        this.x = x;
        this.y = y;
        routes = new ArrayList<>();
    }
    
}
