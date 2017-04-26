
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
    int xStart;
    int xEnd;
    int yStart;
    int yEnd;

    List<Route> routes;

    /**
     * Default constructor for objects of type City
     * 
     * @param nm, the city's name 
     */
    public City(String nm){
        name = nm;
        xStart = 0;
        xEnd = 0;
        yStart = 0;
        yEnd = 0;
        routes = new ArrayList<>();
    }

    /**
     * Constructor for objects of type City
     * 
     * @param nm, the city's name 
     * @param x, the City's x-coordinate
     * @param y, the city's y-coordinate
     */
    public City(String nm, int xStart, int xEnd, int yStart, int yEnd){
        name = nm;
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.yStart = yStart;
        this.yEnd = yEnd;
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

        return (this.name.equals(other.name));
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
        //hash = 97 * hash + this.x;
        //hash = 97 * hash + this.y;
        return hash;
    }

}
