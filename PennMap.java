
import java.util.ArrayList;
import java.util.List;

/**
 * Used to create and handle all the Cities and Routes in Ticket to Ride:
 * Pennsylvania.
 * 
 * Make sure to clean up the commenting around the local variables
 * 
 * @author London Brunell
 */
public class PennMap {

    Route[] routes = new Route[100]; 
    /*
     * Line 52, FERRY-What should fill into the TrainColor Parameter for the constructor of the Route?
     * DOUBLE CHECK ON ONTARIOS 
     */
    City[] cities = new City[35];

    //DestCard[] destinations = new DestCard[50]
    //To be added later this week

    public PennMap(){
        //create a list of all the cities
        List citiesList = new ArrayList<City>();
        //List citiesList = new ArrayList<>();
        citiesList.add(new City("Albany", 1084, 80, 0 ,0));
        citiesList.add(new City("AllenTown", 905, 430, 0 ,0));
        citiesList.add(new City("Altoona", 507, 441, 0 ,0));
        citiesList.add(new City("Altantic City", 1080, 567, 0 ,0));
        citiesList.add(new City("Baltimore", 805, 615, 0 ,0));
        citiesList.add(new City("Binghamton", 861, 162, 0 ,0));
        citiesList.add(new City("Buffalo", 467, 52, 0 ,0));
        citiesList.add(new City("Chambersburg", 605, 547, 0 ,0));
        citiesList.add(new City("Coundersport", 563, 215, 0 ,0));
        citiesList.add(new City("Cumberland", 509, 612, 0 ,0));
        citiesList.add(new City("Dubois", 456, 347, 0 ,0));
        citiesList.add(new City("Elmira", 716, 164, 0 ,0));
        citiesList.add(new City("Erie", 278, 161, 0 ,0));
        citiesList.add(new City("Gettysburg", 672, 574, 0 ,0));
        citiesList.add(new City("Harrisburg", 714, 484, 0 ,0));
        citiesList.add(new City("Johnstown", 452, 480, 0 ,0));
        citiesList.add(new City("Lancaster", 798, 530, 0 ,0));
        citiesList.add(new City("Lewiston", 621, 431, 0 ,0));
        citiesList.add(new City("MorganTown", 295, 617, 0 ,0));
        citiesList.add(new City("New York", 1084, 327, 0 ,0));
        citiesList.add(new City("Oil City", 327, 290, 0 ,0));

        citiesList.add(new City("Ontario",212, 49, 0 ,0)); 
        citiesList.add(new City("Ontario", 383, 52, 0 ,0));

        citiesList.add(new City("Philadelphia", 970, 554, 0 ,0));
        citiesList.add(new City("Pittsburgh", 283, 462, 0 ,0));  
        citiesList.add(new City("Reading", 816, 469, 0 ,0));   
        citiesList.add(new City("Rochester", 671, 54, 0 ,0));   
        citiesList.add(new City("Scranton/Wikes", 887, 295, 0 ,0));   
        citiesList.add(new City("Stroudsburg", 973, 365, 0 ,0));   
        citiesList.add(new City("Syracuse", 842, 53, 0 ,0));
        citiesList.add(new City("Towanda", 774, 231, 0 ,0));
        citiesList.add(new City("Warren", 402,213, 0 ,0));
        citiesList.add(new City("Wheeling", 198, 527, 0 ,0));
        citiesList.add(new City("Williamsport", 693, 320, 0 ,0));
        citiesList.add(new City("York", 739, 546, 0 ,0));
        citiesList.add(new City("Youngstown", 193, 320, 0 ,0));

        /*
         * all fixed
         *
         *Process of thought was soo close to fixture of statement
         *Object citiesS = citiesList.toArray(); //toArray() creates an array of Objects
         *citiesS = (City[])citiesS;
         *cities = (City[])citiesList.toArray(new City[]{});
         *cities = citiesList.toArray();
         *
         *
         */
        //Cities Arraylist converted into an Array then assigned onto the global variable
        cities = (City[])citiesList.toArray(new City[]{});

        //create a list of all the Routes
        List routesList = new ArrayList<>();

        //public Route(City s, City d, TrainColor c, int l, String[] stocks) {
        //Albany
        //"" to Syracuse
        routesList.add(new Route(cities[0],cities[29],TrainColor.WHITE,6,new String[]{"New York Central System"}));
        routesList.add(new Route(cities[0],cities[29],TrainColor.RED,6,new String[]{"New York Central System"}));
        //"" to Binghamton
        routesList.add(new Route(cities[0],cities[5], TrainColor.PINK, 6, new String[]{" "}));
        //"" to NY
        routesList.add(new Route(cities[0],cities[19], TrainColor.BLUE, 6, new String[]{"Pennsylvania","Baltimore","New York Central System"}));
        routesList.add(new Route(cities[0],cities[19], TrainColor.GREEN,6, new String[]{"Pennsylvania", "Baltimore", "New York Central System"}));

        //Allentown 
        //"" to Stroudsburg
        routesList.add(new Route(cities[1],cities[28],TrainColor.ORANGE ,2  , new String[]{"Reading Railroad","Lehigh Valley","Jersey Central Line" }));
        //"" to Scranton
        routesList.add(new Route(cities[1],cities[27],TrainColor.BLUE , 3 , new String[]{"Pennsylvania", "Reading Railroad", "Lehigh Valley", "Jersey Central Line"}));
        routesList.add(new Route(cities[1],cities[27],TrainColor.WHITE , 3 , new String[]{"Pennsylvania", "Reading Railroad", "Lehigh Valley", "Jersey Central Line"}));
        //"" to Reading
        routesList.add(new Route(cities[1],cities[25],TrainColor.GREEN , 2 , new String[]{"Reading Railroad"}));
        //"" to Philadelphia   
        routesList.add(new Route(cities[1],cities[23],TrainColor.BLACK , 3 , new String[]{"Pennsylvania", "Reading Railroad"}));
        routesList.add(new Route(cities[1],cities[23],TrainColor.RED , 3 , new String[]{"Pennsylvania", "Reading Railroad"}));

        //Altoona 
        //"" to Harrisburg
        routesList.add(new Route(cities[2],cities[14],TrainColor.ORANGE ,5 , new String[]{"Pennslyvania"}));
        routesList.add(new Route(cities[2],cities[14],TrainColor.RED ,5 , new String[]{"Pennsylvania"}));
        //"" to Lewiston
        routesList.add(new Route(cities[2],cities[17],TrainColor.GREEN ,2 , new String[]{" "}));
        //"" to Dubois
        //routesList.add(new Route(cities[2],cities[10],null , 2 , new String[]{"Pennsylvania"}));
        //"" to Johnstown
        routesList.add(new Route(cities[2],cities[15],TrainColor.YELLOW ,1 , new String[]{"Pennsylvania"}));
        routesList.add(new Route(cities[2],cities[15],TrainColor.BLUE ,1 , new String[]{"Pennsylvania"}));

        //Atlantic City 
        // "" to New York
        routesList.add(new Route(cities[3],cities[19],TrainColor.BLACK ,6 , new String[]{"Jersey Central Line"}));
        routesList.add(new Route(cities[3],cities[19],TrainColor.WHITE ,6 , new String[]{"Jersey Central Line"}));
        //"" to Philadelphia 
        //routesList.add(new Route(cities[3],cities[23],null ,2  , new String[]{"Pennslyvania","Reading Railroad","Jersey Central Line"}));
        //routesList.add(new Route(cities[3],cities[23],null , 2 , new String[]{"Pennslyvania","Reading Railroad","Jersey Central Line"}));
        //Baltimore 
        //"" to Philadelphia 
        routesList.add(new Route(cities[4],cities[23],TrainColor.YELLOW ,4  , new String[]{"Pennslyvania","Baltimore" }));
        routesList.add(new Route(cities[4],cities[23],TrainColor.PINK , 4 , new String[]{"Pennslyvania","Baltimore"}));
        //"" to York
        routesList.add(new Route(cities[4],cities[34],TrainColor.WHITE ,2  , new String[]{"Pennsylvania","Western Maryland"}));
        //"" to Gettysburg
        routesList.add(new Route(cities[4],cities[13],TrainColor.RED , 3 , new String[]{"Pennslyvania","Western Maryland"}));
        //"" TO Cumberland
        routesList.add(new Route(cities[4],cities[9],TrainColor.BLUE , 7 , new String[]{"Baltimore", "Pennsylvania"}));

        //Binghamton
        //"" to Albany
        routesList.add(new Route(cities[5],cities[0],TrainColor.PINK ,6  , new String[]{" "}));
        //"" to Syracuse
        routesList.add(new Route(cities[5],cities[29],TrainColor.YELLOW , 2 , new String[]{"Erie Lackawanna"}));
        routesList.add(new Route(cities[5],cities[29],TrainColor.ORANGE , 2 , new String[]{"Erie Lackawanna"}));
        //"" to Elmira
        routesList.add(new Route(cities[5],cities[11],TrainColor.WHITE ,3  , new String[]{"Erie Lackawanna"}));
        //"" to Towanda 
        routesList.add(new Route(cities[5],cities[30],TrainColor.RED , 2 , new String[]{"Erie Lackawanna"}));
        //"" to Scranton
        routesList.add(new Route(cities[5],cities[27],TrainColor.GREEN ,3  , new String[]{"Erie Lackawanna"}));
        routesList.add(new Route(cities[5],cities[27],TrainColor.BLACK ,3  , new String[]{"Erie Lackwanna"}));
        //Buffalo
        //'' to Rochester
        routesList.add(new Route(cities[6],cities[26],TrainColor.BLACK ,5  , new String[]{"Baltimore"}));
        routesList.add(new Route(cities[6],cities[26],TrainColor.YELLOW ,5  , new String[]{"Baltimore"}));
        //'' to Ontario (Right)
        //routesList.add(new Route(cities[6],cities[22],null, 1 , new String[]{"Pennsylvania", "Erie Lackawanna", "New York Central System"}));
        //routesList.add(new Route(cities[6],cities[22],null , 1 , new String[]{"Pennsylvania", "Erie Lackawanna", "New York Central System"}));
        //'' to Erie
        routesList.add(new Route(cities[6],cities[12],TrainColor.ORANGE , 5 , new String[]{"Erie Lackawanna", "New York Central System"}));
        routesList.add(new Route(cities[6],cities[12],TrainColor.WHITE , 5 , new String[]{"Erie Lackwanna", "New York Central System"}));
        //'' to Warren
        routesList.add(new Route(cities[6],cities[31],TrainColor.GREEN , 4 , new String[]{"Pennsylvania", "Erie Lackawanna", "Baltimore", "New York Central System", "BRP Railway"}));
        //'' to CouderSport
        //routesList.add(new Route(cities[6],cities[8],null ,4  , new String[]{"Pennsylvania", "Erie Lackawanna"}));
        //Chambersburg
        routesList.add(new Route(cities[7],cities[14],TrainColor.BLUE ,2  , new String[]{"Western Maryland", "Pennsylvania", "Reading Railroad"}));
        routesList.add(new Route(cities[7],cities[9],TrainColor.GREEN , 2 , new String[]{"Western Maryland", "Pennsylvania"}));
        routesList.add(new Route(cities[7],cities[13],TrainColor.BLACK , 1 , new String[]{" "}));
        //Coudersport
        routesList.add(new Route(cities[8],cities[11],TrainColor.ORANGE ,4  , new String[]{"Pennsylvania", "Erie Lackawanna", "Baltimore", "New York Central System","BRP Railway"}));
        //routesList.add(new Route(cities[8],cities[6],null ,4  , new String[]{"Pennsylvania", "Erie Lackawanna"}));
        //routesList.add(new Route(cities[8],cities[31],null ,4  , new String[]{"Pennsylvania", "Erie Lackawanna", "Baltimore", "New York Central System","BRP Railway"}));
        routesList.add(new Route(cities[8],cities[33],TrainColor.GREEN , 4 , new String[]{"Pennsylvania"}));
        //Cumberland 
        routesList.add(new Route(cities[9],cities[7],TrainColor.GREEN ,2  , new String[]{"Western Maryland","Pennsylvania"}));
        //routesList.add(new Route(cities[9],cities[15],null , 3 , new String[]{"Western Maryland", "Pennsylvania", "Baltimore"}));
        routesList.add(new Route(cities[9],cities[18],TrainColor.RED ,5  , new String[]{"Western Maryland","Baltimore"}));
        routesList.add(new Route(cities[9],cities[4],TrainColor.BLUE ,7  , new String[]{"Western Maryland","Baltimore"}));
        //Dubois
        routesList.add(new Route(cities[10],cities[33],TrainColor.WHITE , 6 , new String[]{" "}));
        routesList.add(new Route(cities[10],cities[31],TrainColor.BLACK , 3 , new String[]{"BRP Railway", "Erie Lackawanna"}));
        routesList.add(new Route(cities[10],cities[20],TrainColor.PINK , 3 , new String[]{" "}));

        routes = (Route[])routesList.toArray(new Route[]{});
       
        //routesList.add(new Route(cities[10],cities[2],null , 2 , new String[]{"Pennsylvania" }));
        //Elmira
        /*
        routesList.add(new Route(cities[11],cities[5],TrainColor.WHITE ,  , new String[]{}));
        routesList.add(new Route(cities[11],cities[29],TrainColor.BLACK ,  , new String[]{}));
        routesList.add(new Route(cities[11],cities[26],TrainColor.GREEN ,  , new String[]{}));
        routesList.add(new Route(cities[11],cities[8],TrainColor.ORANGE ,  , new String[]{}));
        routesList.add(new Route(cities[11],cities[30],TrainColor.YELLOW ,  , new String[]{}));
        //Erie
        routesList.add(new Route(cities[12],cities[6],TrainColor.ORANGE ,  , new String[]{}));
        routesList.add(new Route(cities[12],cities[6],TrainColor.YELLOW ,  , new String[]{}));
        routesList.add(new Route(cities[12],cities[22],null ,  , new String[]{}));
        routesList.add(new Route(cities[12],cities[22],null. ,  , new String[]{}));
        routesList.add(new Route(cities[12],cities[21],null ,  , new String[]{}));
        routesList.add(new Route(cities[12],cities[21],null ,  , new String[]{}));
        routesList.add(new Route(cities[12],cities[35],TrainColor.GREEN ,  , new String[]{}));
        routesList.add(new Route(cities[12],cities[35],TrainColor.YELLOW ,  , new String[]{}));
        routesList.add(new Route(cities[12],cities[20],TrainColor.BLACK ,  , new String[]{}));
        routesList.add(new Route(cities[12],cities[31],TrainColor.BLUE ,  , new String[]{}));
        //Gettysburg
        routesList.add(new Route(cities[13],cities[34],null,  , new String[]{}));
        routesList.add(new Route(cities[13],cities[14],TrainColor.YELLOW ,  , new String[]{}));
        routesList.add(new Route(cities[13],cities[7],TrainColor.BLACK ,  , new String[]{}));
        routesList.add(new Route(cities[13],cities[13],TrainColor.RED ,  , new String[]{}));
        //Harrisburg
        routesList.add(new Route(cities[14],cities[25],TrainColor.PINK ,  , new String[]{}));
        routesList.add(new Route(cities[14],cities[27],null ,  , new String[]{}));
        routesList.add(new Route(cities[14],cities[17],null ,  , new String[]{}));
        routesList.add(new Route(cities[14],cities[2],TrainColor.RED ,  , new String[]{}));
        routesList.add(new Route(cities[14],cities[2],TrainColor.ORANGE ,  , new String[]{}));
        routesList.add(new Route(cities[14],cities[7],TrainColor.BLUE ,  , new String[]{}));
        routesList.add(new Route(cities[14],cities[13],TrainColor.YELLOW ,  , new String[]{}));
        routesList.add(new Route(cities[14],cities[34],TrainColor.BLACK ,  , new String[]{}));
        routesList.add(new Route(cities[14],cities[16],null ,  , new String[]{}));
        //Johnstown
        routesList.add(new Route(cities[15],cities[2],TrainColor.BLUE ,  , new String[]{}));
        routesList.add(new Route(cities[15],cities[2],TrainColor.YELLOW ,  , new String[]{}));
        routesList.add(new Route(cities[15],cities[24],TrainColor.PINK ,  , new String[]{}));
        routesList.add(new Route(cities[15],cities[24],TrainColor.BLACK ,  , new String[]{}));
        routesList.add(new Route(cities[15],cities[9],null ,  , new String[]{}));
        //Lancaster
        routesList.add(new Route(cities[16],cities[25],TrainColor.YELLOW ,  , new String[]{}));
        routesList.add(new Route(cities[16],cities[14],null ,  , new String[]{}));
        routesList.add(new Route(cities[16],cities[14],null ,  , new String[]{}));
        routesList.add(new Route(cities[16],cities[34],TrainColor.PINK ,  , new String[]{}));
        routesList.add(new Route(cities[16],cities[23],TrainColor.GREEN ,  , new String[]{}));
        routesList.add(new Route(cities[16],cities[23],TrainColor.ORANGE ,  , new String[]{}));
        //Lewiston
        routesList.add(new Route(cities[17],cities[33],TrainColor.YELLOW ,  , new String[]{}));
        routesList.add(new Route(cities[17],cities[2],TrainColor.GREEN ,  , new String[]{}));
        routesList.add(new Route(cities[17],cities[14],TrainColor.RED ,  , new String[]{}));
        routesList.add(new Route(cities[17],cities[14],TrainColor.ORANGE ,  , new String[]{}));
        //MorganTown
        routesList.add(new Route(cities[18],cities[9],TrainColor.RED ,  , new String[]{}));
        routesList.add(new Route(cities[18],cities[24],TrainColor.YELLOW ,  , new String[]{}));
        routesList.add(new Route(cities[18],cities[32],TrainColor.BLUE ,  , new String[]{}));
        //New York
        routesList.add(new Route(cities[19],cities[0],TrainColor.GREEN ,  , new String[]{}));
        routesList.add(new Route(cities[19],cities[0],TrainColor.BLUE ,  , new String[]{}));
        routesList.add(new Route(cities[19],cities[27],TrainColor.RED  ,  , new String[]{}));
        routesList.add(new Route(cities[19],cities[27],TrainColor.PINK ,  , new String[]{}));
        routesList.add(new Route(cities[19],cities[23],null ,  , new String[]{}));
        routesList.add(new Route(cities[19],cities[23],null ,  , new String[]{}));
        routesList.add(new Route(cities[19],cities[3],TrainColor.BLACK ,  , new String[]{}));
        routesList.add(new Route(cities[19],cities[3],TrainColor.WHITE ,  , new String[]{}));
        //Oil City
        routesList.add(new Route(cities[20],cities[31],TrainColor.ORANGE ,  , new String[]{}));
        routesList.add(new Route(cities[20],cities[12],TrainColor.BLACK ,  , new String[]{}));
        routesList.add(new Route(cities[20],cities[35],TrainColor.WHITE ,  , new String[]{}));
        routesList.add(new Route(cities[20],cities[24],TrainColor.RED ,  , new String[]{}));
        routesList.add(new Route(cities[20],cities[10],TrainColor.PINK ,  , new String[]{}));
        //Ontario (Left)
        routesList.add(new Route(cities[21],cities[12],null ,  , new String[]{}));
        //routesList.add(new Route(cities[21],cities[12],null ,  , new String[]{}));
        //Ontario (Right)
        routesList.add(new Route(cities[22],cities[6],null ,  , new String[]{}));
        //routesList.add(new Route(cities[22],cities[6],null ,  , new String[]{}));
        //Philadelphia
        routesList.add(new Route(cities[23],cities[19],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[23],cities[19],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[23],cities[1],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[23],cities[1],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[23],cities[16],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[23],cities[16],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[23],cities[4],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[23],cities[4],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[23],cities[3],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[23],cities[3],TrainColor. ,  , new String[]{}));
        //Pittsburgh
        routesList.add(new Route(cities[24],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[24],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[24],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[24],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[24],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[24],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[24],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[24],cities[],TrainColor. ,  , new String[]{}));
        //Reading 
        routesList.add(new Route(cities[25],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[25],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[25],cities[],TrainColor. ,  , new String[]{}));
        //Rochester
        routesList.add(new Route(cities[26],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[26],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[26],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[26],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[26],cities[],TrainColor. ,  , new String[]{}));
        //Scranton
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[27],cities[],TrainColor. ,  , new String[]{}));
        //Stroudsburg
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        //Syracuse
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        //Towanda
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        //Warren
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        //Wheeling
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        //Williamsport
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        //York
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        //Youngstown
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
        routesList.add(new Route(cities[28],cities[],TrainColor. ,  , new String[]{}));
         */
        /*
         * How to state stocks in constructor for Routes
         *Route r = new Route(cities.get(0), cities.get(1), new String[]{"", "" } )
         *String[] s = new String[]{"Erie", "Stock2"};
         *
         */

        //Don't use 2nd contructor
        //routesList.add(new Route(new City("Albany", 1084, 80), new City("Syracuse",842,53),TrainColor.WHITE, TrainColor.RED,6,new String[]{"New York"}));
        //routesList.add(new Route(new City("Albany",1084,80), citiesList.get(5)

        //routes = (Route[])routesList.toArray();

    }

}

