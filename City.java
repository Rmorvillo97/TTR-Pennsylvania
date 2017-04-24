
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
    /**
     * Equals method.
     * 
     * @param o the object to compare to
     * @return true if o is a City and the two are equal.
     */
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(! (o instanceof City) ) return false;
        
        City other = (City)o;
        
        return (this.name.equals(other.name) && 
                this.x == other.x && this.y == other.y);
    }

    /**
     * Hash Code method
     * 
     * @return the object's hash code
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.x;
        hash = 97 * hash + this.y;
        return hash;
    }
    
}
