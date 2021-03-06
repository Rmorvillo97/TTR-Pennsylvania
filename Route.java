
/**
 * Used to hold a Ticket to Ride route.
 *
 * @author London Brunell
 */
public class Route {

    City source;
    City dest;
    TrainColor color;

    String[] stocks;

    int length;

    boolean isClaimed;

    /**
     * Constructor for objects of class Route
     *
     */
    public Route(City s, City d, TrainColor c, int l, String[] st) {
        
        source = s;
        dest = d;
        color = c;
        length = l;
        stocks = st;
        
        isClaimed = false;
        source.routes.add(this);
        dest.routes.add(this);
    }

    /**
     * Used to determine the point value of a Route of a given length.
     *
     * @param length
     * @return the point value of a Route of the specified length
     */
    public static int getPoints(int length) {
        
        switch (length) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 7;
            case 5:
                return 10;
            case 6:
                return 15;
            case 7:
                return 18;
            case 8:
                return 21;
        }

        //this is an error case. No route is worth zero points.
        return 0;
    }

    /**
     * Used to access this particular route's point value.
     * 
     * @return the number of points this route is worth.
     */
    public int getPoints() {
        return getPoints(this.length);
    }

}
