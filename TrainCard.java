
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 * Used to store data on the Train Cards for Ticket to Ride.
 *
 * 
 * @author ls11brun
 */
public class TrainCard {
    
    protected TrainColor color;
    private boolean isWild;
    public Image cardImage;
    
    /**
     * Constructor for TrainCards.
     * 
     * @param c, the card's color
     * @param f, a file for the card's image
     */
    public TrainCard(TrainColor c, File f){
        color = c;
        
        try {
            cardImage = ImageIO.read(f);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
        if(c == TrainColor.WILD){
           isWild = true; 
        }else{
            isWild = false;
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
    
}
