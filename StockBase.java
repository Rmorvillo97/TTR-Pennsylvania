import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
/**
 *Class for handling stock cards.
 * @author Javier Rodriguez
 */
public class StockBase {
    /**
     * 
     * 
     * Below variables contain the date needed for each stock card
     */
    protected int share;
    protected String company;
    protected BufferedImage stockPicture;

    public StockBase(int sh, String comp){
        share = sh;
        company = comp;
    }

    public StockBase(int sh, String comp, String i){
        share = sh;
        company = comp;
        
        try{
            stockPicture = ImageIO.read(new File("TicketToRideGraphics/Stocks/" + i));
        }
        catch(IOException e){
            System.err.println("Could not read file: " + e);
        }
    }

}
