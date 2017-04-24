

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author je28rodr
 */
public class StockCards {
    /**
     * 
     * sets up all of the games stock cards.
     */
    protected List<StockBase> lehighValley;
    protected List<StockBase> pennsylvania;
    protected List<StockBase> newyorkCentralSystem;
    protected List<StockBase> readingRailRoad;
    protected List<StockBase> erieLackawanna;
    protected List<StockBase> jerseyCentralLine;
    protected List<StockBase> baltimore;
    protected List<StockBase> westernMaryland;
    protected List<StockBase> brpRailWay;
    /**
     *This class sets up all of the stock cards for the game. All of the cards
     * are made in the constructor and are put into the List with the 
     * appropriate name.
     *
     */
   public StockCards(){
       StockBase lh1 = new StockBase(1,"LEHIGH VALLEY RAILROAD");
       StockBase lh2 = new StockBase(2,"LEHIGH VALLEY RAILROAD");
       StockBase lh3 = new StockBase(3,"LEHIGH VALLEY RAILROAD");
       StockBase lh4 = new StockBase(4,"LEHIGH VALLEY RAILROAD");
       StockBase lh5 = new StockBase(5,"LEHIGH VALLEY RAILROAD");
       StockBase lh6 = new StockBase(6,"LEHIGH VALLEY RAILROAD");
       lehighValley  = new ArrayList<>();
       lehighValley.add(lh1);
       lehighValley.add(lh2);
       lehighValley.add(lh3);
       lehighValley.add(lh4);
       lehighValley.add(lh5);
       lehighValley.add(lh6);
       //Pennsylvania Railraod cards
       StockBase pr1 = new StockBase(1,"PENNSYLVANIA RAILROAD");
       StockBase pr2 = new StockBase(2,"PENNSYLVANIA RAILROAD");
       StockBase pr3 = new StockBase(3,"PENNSYLVANIA RAILROAD");
       StockBase pr4 = new StockBase(4,"PENNSYLVANIA RAILROAD");
       StockBase pr5 = new StockBase(5,"PENNSYLVANIA RAILROAD");
       StockBase pr6 = new StockBase(6,"PENNSYLVANIA RAILROAD");
       StockBase pr7 = new StockBase(7,"PENNSYLVANIA RAILROAD");
       StockBase pr8 = new StockBase(8,"PENNSYLVANIA RAILROAD");
       StockBase pr9 = new StockBase(9,"PENNSYLVANIA RAILROAD");
       StockBase pr10 = new StockBase(10,"PENNSYLVANIA RAILROAD");
       StockBase pr11 = new StockBase(11,"PENNSYLVANIA RAILROAD");
       StockBase pr12 = new StockBase(12,"PENNSYLVANIA RAILROAD");
       StockBase pr13 = new StockBase(13,"PENNSYLVANIA RAILROAD");
       StockBase pr14 = new StockBase(14,"PENNSYLVANIA RAILROAD");
       StockBase pr15= new StockBase(15,"PENNSYLVANIA RAILROAD");
       pennsylvania = new ArrayList<>();
       pennsylvania.add(pr1);
       pennsylvania.add(pr2);
       pennsylvania.add(pr3);
       pennsylvania.add(pr4);
       pennsylvania.add(pr5);
       pennsylvania.add(pr6);
       pennsylvania.add(pr7);
       pennsylvania.add(pr8);
       pennsylvania.add(pr9);
       pennsylvania.add(pr10);
       pennsylvania.add(pr11);
       pennsylvania.add(pr12);
       pennsylvania.add(pr13);
       pennsylvania.add(pr14);
       pennsylvania.add(pr15);
       //cards for NEW YORK CENTRAL SYSTEM
       StockBase ny1 = new StockBase(1,"NEW YORK CENTRAL SYSTEM");
       StockBase ny2 = new StockBase(2,"NEW YORK CENTRAL SYSTEM");
       StockBase ny3 = new StockBase(3,"NEW YORK CENTRAL SYSTEM");
       StockBase ny4 = new StockBase(4,"NEW YORK CENTRAL SYSTEM");
       StockBase ny5 = new StockBase(5,"NEW YORK CENTRAL SYSTEM");
       newyorkCentralSystem = new ArrayList<>();
       newyorkCentralSystem.add(ny1);
       newyorkCentralSystem.add(ny2);
       newyorkCentralSystem.add(ny3);
       newyorkCentralSystem.add(ny4);
       newyorkCentralSystem.add(ny5);
       //cards for Reading Railroad
       StockBase rr1 = new StockBase(1,"READING RAILROAD");
       StockBase rr2 = new StockBase(2,"READING RAILROAD");
       StockBase rr3 = new StockBase(3,"READING RAILROAD");
       StockBase rr4 = new StockBase(4,"READING RAILROAD");
       StockBase rr5 = new StockBase(5,"READING RAILROAD");
       StockBase rr6 = new StockBase(6,"READING RAILROAD");
       StockBase rr7 = new StockBase(7,"READING RAILROAD");
       readingRailRoad = new ArrayList<>();
       readingRailRoad.add(rr1);
       readingRailRoad.add(rr2);
       readingRailRoad.add(rr3);
       readingRailRoad.add(rr4);
       readingRailRoad.add(rr5);
       readingRailRoad.add(rr6);
       readingRailRoad.add(rr7);
       //cards for Jersey Central Line
       StockBase jc1 = new StockBase(1,"JERSEY CENTRAL LINE");
       StockBase jc2 = new StockBase(2,"JERSEY CENTRAL LINE");
       StockBase jc3 = new StockBase(3,"JERSEY CENTRAL LINE");
       //cards for Buffalo, Rochester, & Pittsburgh Railway
       StockBase br1 = new StockBase(1,"BRP RAILWAY");
       StockBase br2 = new StockBase(2,"BRP RAILWAY");
       brpRailWay = new ArrayList<>();
       brpRailWay.add(br1);
       brpRailWay.add(br2);
       //cards for Erie Lackawanna Railway
       StockBase el1 = new StockBase(1,"ERIE LACKAWANNA RAILROAD");
       StockBase el2 = new StockBase(2,"ERIE LACKAWANNA RAILROAD");
       StockBase el3 = new StockBase(3,"ERIE LACKAWANNA RAILROAD");
       StockBase el4 = new StockBase(4,"ERIE LACKAWANNA RAILROAD");
       StockBase el5 = new StockBase(5,"ERIE LACKAWANNA RAILROAD");
       StockBase el6 = new StockBase(6,"ERIE LACKAWANNA RAILROAD");
       StockBase el7 = new StockBase(7,"ERIE LACKAWANNA RAILROAD");
       StockBase el8 = new StockBase(8,"ERIE LACKAWANNA RAILROAD");
       erieLackawanna = new ArrayList<>();
       erieLackawanna.add(el1);
       erieLackawanna.add(el2);
       erieLackawanna.add(el3);
       erieLackawanna.add(el4);
       erieLackawanna.add(el5);
       erieLackawanna.add(el6);
       erieLackawanna.add(el7);
       erieLackawanna.add(el8);
       //cards for Baltimore and Ohio RailRoad
       StockBase bo1 = new StockBase(1,"BALTIMORE OHIO RAILROAD");
       StockBase bo2 = new StockBase(2,"BALTIMORE OHIO RAILROAD");
       StockBase bo3 = new StockBase(3,"BALTIMORE OHIO RAILROAD");
       StockBase bo4 = new StockBase(4,"BALTIMORE OHIO RAILROAD");
       StockBase bo5 = new StockBase(5,"BALTIMORE OHIO RAILROAD");
       StockBase bo6 = new StockBase(6,"BALTIMORE OHIO RAILROAD");
       StockBase bo7 = new StockBase(7,"BALTIMORE OHIO RAILROAD");
       StockBase bo8 = new StockBase(8,"BALTIMORE OHIO RAILROAD");
       StockBase bo9 = new StockBase(9,"BALTIMORE OHIO RAILROAD");
       StockBase bo10 = new StockBase(10,"BALTIMORE OHIO RAILROAD");
       baltimore = new ArrayList<>();
       baltimore.add(bo1);
       baltimore.add(bo2);
       baltimore.add(bo3);
       baltimore.add(bo4);
       baltimore.add(bo5);
       baltimore.add(bo6);
       baltimore.add(bo7);
       baltimore.add(bo8);
       baltimore.add(bo9);
       baltimore.add(bo10);
       StockBase wm1 = new StockBase(1,"WESTERN MARYLAND RAILWAY");
       StockBase wm2 = new StockBase(2,"WESTERN MARYLAND RAILWAY");
       StockBase wm3 = new StockBase(3,"WESTERN MARYLAND RAILWAY");
       StockBase wm4 = new StockBase(4,"WESTERN MARYLAND RAILWAY");
       westernMaryland = new ArrayList<>();
       westernMaryland.add(wm1);
       westernMaryland.add(wm2);
       westernMaryland.add(wm3);
       westernMaryland.add(wm4);

   }
    
}
