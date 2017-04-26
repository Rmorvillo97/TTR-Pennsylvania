import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Used to store data on the Train Cards for Ticket to Ride.
 *
 * 
 * @author ls11brun
 */
public class TrainCard {

    protected TrainColor color;
    private boolean isWild;
    protected BufferedImage image;

    /**
     * Constructor for TrainCards.
     * 
     * @param c, the card's color
     * @param f, a file for the card's image
     */
    public TrainCard(TrainColor c, String i){
        color = c;

        if(c == TrainColor.WILD){
            isWild = true; 
        }else{
            isWild = false;
        }

        try{
            image = ImageIO.read(new File("TicketToRideGraphics/TrainColors/" + i));
        }
        catch(IOException e){
            System.err.println("Could not read file: " + e);
        }
    }

    /**
     * Used to access the isWild boolean, to find out whether the card is 
     * wild (rainbow colored) or not.
     * 
     * @return true if the card is wild, false otherwise
     */
    public boolean isWild(){
        return this.isWild;
    }

    /**
     * Used to determine whether this object is equal to another TrainCard.
     * 
     * @param other, the other TrainCard
     * @return true if they're the same and false otherwise
     */
    @Override
    public boolean equals(Object other){
        if(other == null) return false;
        if(! (other instanceof TrainCard) ) return false;

        TrainCard o = (TrainCard)other;
        if(this.color == o.color){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + java.util.Objects.hashCode(this.color);
        return hash;
    }
}
