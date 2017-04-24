
import java.util.ArrayList;
import java.util.List;

/**
 * Used to create and handle all the Cities and Routes in Ticket to Ride:
 * Pennsylvania.
 * 
 * @author London Brunell
 */
public class PennMap {
    
    Route[] routes = new Route[50];
    City[] cities = new City[35]; 
    
    public PennMap(){
        
        //create a list of all the cities
        List citiesList = new ArrayList<>();
        citiesList.add(new City("Reading", 0, 0));
        
        cities = (City[])citiesList.toArray();
        
        //create a list of all the Routes
        List routesList = new ArrayList<>();
        
        
        
        routes = (Route[])routesList.toArray();
        
    }
    
}
