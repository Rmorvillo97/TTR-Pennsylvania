
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * 
 * @author London Brunell
 */
public class DestCard {
   
    protected City source;
    protected City dest;
    
    public Image cardImage;

    
    public DestCard(City s, City d, File f){
        
        try {
            cardImage = ImageIO.read(f);
        }catch (IOException ex) {
            System.err.println(ex);
        }
        
        source = s;
        dest = d;
    }
    
}


