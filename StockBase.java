
package stockcards;

import java.awt.Image;

/**
 *Class for handling stock cards.
 * @author je28rodr
 */
public class StockBase {
    /**
     * 
     * 
     * Below variables contain the date needed for each stock card
     */
    protected int share;
    protected String company;
    protected Image stockPicture;
    
    public StockBase(int sh, String comp){
        share = sh;
        company = comp;
    }
     public StockBase(int sh, String comp, Image img){
        share = sh;
        company = comp;
        stockPicture = img;
    }
 
    
    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
