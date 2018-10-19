import java.util.*;
import java.io.*;

class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private String birthplace;
	
	//constructors
	public HockeyPlayer(String lastName, String position, String birthplace){
		this.lastName = lastName;
		this.position = position;
		this.birthplace = birthplace;
	}
	
	public HockeyPlayer(HockeyPlayer hp){
		this(hp.lastName, hp.position, hp.birthplace);
	}
	
	//setters
	public void setLastName(String lastName){
		this.lastName = lastName;	
	}
	
	public void setPosition(String position){
		this.position = position;	
	}
	
	public void setBirthplace(String birthplace){
		this.birthplace = birthplace;	
	}
	
	//getters
	public String getLastName(){
		return lastName;	
	}
	
	public String getPosition(){
		return position;	
	}
	
	public String getBirthplace(){
		return birthplace;	
	}
	
	//print
	public String printPositionDetails(){
		return "\nName: " + lastName + "\tPosition: " + position;
	}
	
	public String printBiography(){
		return this.printPositionDetails() + "\tBirthPlace: " + birthplace;	
	}
}


class Goalies extends HockeyPlayer implements Comparable<Goalies>{
	//fields
	private int shotsAgainst;
	private int goalsAgainst;
	private int saves;
	private ArrayList<Goalies> goaliesRoster;
	private static int sortGoaliesBy;
	
	//constructors
	public Goalies(){
		super(" ", " ", " ");
		setGoaliesRoster();	
	}
	
	public Goalies(int sortGoaliesBy){
		super(" ", " ", " ");
		setGoaliesRoster();
		this.sortGoaliesBy = sortGoaliesBy;
	}
	
	public Goalies(String lastName, String position, String birthplace, int shotsAgainst, int goalsAgainst, int saves){
		super(lastName, position, birthplace);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
	}
	
	public Goalies(HockeyPlayer hp, int shotsAgainst, int goalsAgainst, int saves){
		super(hp);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
	}
	
	/**
	* a method that defines how to sort Goalies numerically by a stat
	* @param Player the player to which we are comparing
	*/
	@Override
    	public int compareTo(Goalies other) {
    	switch(sortGoaliesBy){
    	case 1:
    		if (this.getShotsAgainst() < other.getShotsAgainst()) {
    			return -1;
    		}
    		if (this.getShotsAgainst() == other.getShotsAgainst()) { 
    			return 0;
    		}
    		break;
   	case 2:
    		if (this.getGoalsAgainst() < other.getGoalsAgainst()) {
    			return -1;
    		}
    		if (this.getGoalsAgainst() == other.getGoalsAgainst()) { 
    			return 0;
    		}
    		break;
    	case 3:
    		if (this.getSaves() < other.getSaves()) {
    			return -1;
    		}
    		if (this.getSaves() == other.getSaves()) { 
    			return 0;
    		}
    		break;
    	}
    	return 1;
    	}
	
	//setters
	public void setShotsAgainst(int shotsAgainst){
		this.shotsAgainst = shotsAgainst;	
	}
	
	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;	
	}
	
	public void setSaves(int saves){
		this.saves = saves;	
	}
	
	public void setGoaliesRoster(){
		goaliesRoster = new ArrayList<Goalies>();
		goaliesRoster.add(new Goalies("Holtby", "Goalie", "Canada", 1648, 153, 1495));
		goaliesRoster.add(new Goalies("Grubauer", "Goalie", "Germany", 953, 73, 880));
	}
	
	//getters
	public int getShotsAgainst(){
		return shotsAgainst;	
	}
	
	public int getGoalsAgainst(){
		return goalsAgainst;	
	}
	
	public int getSaves(){
		return saves;	
	}
	
	public ArrayList<Goalies> getGoaliesRoster(){
		return goaliesRoster;
	}
	
	//print
	@Override
	public String printPositionDetails(){
		return super.printPositionDetails() + "\tShots Against: " + shotsAgainst + "\tGoals Against: " + goalsAgainst + "\tSaves: " + saves;
	}
}


class Skaters extends HockeyPlayer implements Comparable<Skaters>{
	//fields
	private int goals;
	private int assists;
	private int points;
	private int plusMinus;
	private String shoots; //only allow L/R as valid input
	private ArrayList<Skaters> skatersRoster;
	private static int sortSkatersBy;
	
	//constructors
	public Skaters(){
		super(" ", " ", " ");
		setSkatersRoster();	
	}
	
	public Skaters(int sortSkatersBy){
		super(" ", " ", " ");
		setSkatersRoster();
		this.sortSkatersBy = sortSkatersBy;
	}
	
	public Skaters(String lastName, String position, String birthplace, int goals, int assists, int points, int plusMinus, String shoots){
		super(lastName, position, birthplace);
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
		this.shoots = shoots;
	}
	
	public Skaters(HockeyPlayer hp, int goals, int assists, int points, int plusMinus){
		super(hp);
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
	}
	
	/**
	* a method that defines how to sort Skaters numerically by a stat
	* @param Player the player to which we are comparing
	*/
	@Override
    	public int compareTo(Skaters other) {
    	switch(sortSkatersBy){
    	case 1:
    		if (this.getPoints() < other.getPoints()) {
    			return -1;
    		}
    		if (this.getPoints() == other.getPoints()) { 
    			return 0;
    		}
    		break;
   	case 2:
    		if (this.getGoals() < other.getGoals()) {
    			return -1;
    		}
    		if (this.getGoals() == other.getGoals()) { 
    			return 0;
    		}
    		break;
    	case 3:
    		if (this.getAssists() < other.getAssists()) {
    			return -1;
    		}
    		if (this.getAssists() == other.getAssists()) { 
    			return 0;
    		}
    		break;
    	case 4:
    		if (this.getPlusMinus() < other.getPlusMinus()) {
    			return -1;
    		}
    		if (this.getPlusMinus() == other.getPlusMinus()) { 
    			return 0;
    		}
    		break;
    	}
    	return 1;
    	}
		
	//setters
	public void setGoals(int goals){
		this.goals = goals;
	}
	
	public void setAssists(int assists){
		this.assists = assists;	
	}
	
	public void setPoints(int points){
		this.points = points;	
	}
	
	public void setPoints(int goals, int assists){
		points = goals + assists;	
	}
	
	public void setPoints(){
		points = goals + assists;	
	}
	
	public void setPlusMinus(int plusMinus){
		this.plusMinus = plusMinus;	
	}
	
	public void setShoots(String shoots){
		this.shoots = shoots;
	}
	
	public void setSkatersRoster(){
		skatersRoster = new ArrayList<Skaters>();
		skatersRoster.add(new Skaters("Ovechkin", "Forward, LW", "Russia", 49, 38, 87, 3, "R"));
		skatersRoster.add(new Skaters("Vrana", "Forward, LW", "Czech Republic", 13, 14, 27, 2, "L"));
		skatersRoster.add(new Skaters("Gersich", "Forward, LW", "USA", 0, 1, 1, -1, "L"));
		skatersRoster.add(new Skaters("Walker", "Forward, LW", "Wales", 1, 0, 1, 1, "L"));
		skatersRoster.add(new Skaters("Burakovsky", "Forward, LW", "Austria", 12, 13, 25, 3, "L"));
		skatersRoster.add(new Skaters("Kuznetsov", "Forward, C", "Russia", 27, 56, 83, 3, "L"));
		skatersRoster.add(new Skaters("Backstrom", "Forward, C", "Sweden", 21, 50, 71, 5, "L"));
		skatersRoster.add(new Skaters("Graovac", "Forward, C", "Canada", 0, 0, 0, -3, "L"));
		skatersRoster.add(new Skaters("Boyd", "Forward, C", "USA", 0, 1, 1, 2, "R"));
		skatersRoster.add(new Skaters("O'Brien", "Forward, C", "Canada", 0, 0, 0, 0, "L"));
		skatersRoster.add(new Skaters("Eller", "Forward, C", "Denmark", 18, 20, 38, -6, "L"));
		skatersRoster.add(new Skaters("Stephenson", "Forward, C", "Canada", 6, 12, 18, 13, "L"));
		skatersRoster.add(new Skaters("Beagle", "Forward, C", "Canada", 7, 15, 22, 3, "R"));
		skatersRoster.add(new Skaters("Oshie", "Forward, RW", "USA", 18, 29, 47, 2, "R"));
		skatersRoster.add(new Skaters("Wilson", "Forward, RW", "Canada", 14, 21, 35, 10, "R"));
		skatersRoster.add(new Skaters("Connolly", "Forward, RW", "Canada", 15, 12, 27, -6, "R"));
		skatersRoster.add(new Skaters("Peluso", "Forward, RW", "Canada", 0, 0, 0, 0, "R"));
		skatersRoster.add(new Skaters("Smith-Pelly", "Forward, RW", "Canada", 7, 9, 16, -6, "R"));
		skatersRoster.add(new Skaters("Chiasson", "Forward, RW", "Canada", 9, 9, 18, 1, "R"));
		skatersRoster.add(new Skaters("Carlson", "Defense", "USA", 15, 53, 68, 0, "R"));
		skatersRoster.add(new Skaters("Orlov", "Defense", "Russia", 10, 21, 31, 10, "L"));
		skatersRoster.add(new Skaters("Niskanen", "Defense", "USA", 7, 22, 29, 24, "R"));
		skatersRoster.add(new Skaters("Djoos", "Defense", "Sweden", 3, 11, 14, 13, "L"));
		skatersRoster.add(new Skaters("Bowey", "Defense", "Canada", 0, 12, 12, -3, "R"));
		skatersRoster.add(new Skaters("Orpik", "Defense", "USA", 0, 10, 10, -9, "L"));
		skatersRoster.add(new Skaters("Chorney", "Defense", "Canada", 1, 3, 4, 8, "L"));
		skatersRoster.add(new Skaters("Jerabek", "Defense", "Czech Republic", 1, 3, 4, -1, "L"));
		skatersRoster.add(new Skaters("Kempny", "Defense", "Czech Republic", 2, 1, 3, 1, "L"));
		skatersRoster.add(new Skaters("Ness", "Defense", "USA", 0, 1, 1, 2, "L"));
	}
	
	//getters
	public int getGoals(){
		return goals;	
	}
	
	public int getAssists(){
		return assists;
	}	
	
	public int getPoints(){
		return points;	
	}
	
	public int getPlusMinus(){
		return plusMinus;	
	}
	
	public String getShoots(){
		return shoots;	
	}
	
	public ArrayList<Skaters> getSkatersRoster(){
		return skatersRoster;	
	}
	
	//print
	@Override
	public String printPositionDetails(){
		return super.printPositionDetails() + "\tGoals: " + goals + "\tAssists: " + assists + "\tPoints: " + points + "\t+/-: " + plusMinus;
	}
	@Override
	public String printBiography(){
		return this.printPositionDetails() + "\tShoots: " + shoots + "\tBirthPlace: " + getBirthplace();	
	}
}


class SortStatsGoalies extends Goalies{
	//fields
	private ArrayList<Goalies> goaliesSorted;
	
	//constructors
	SortStatsGoalies(){
	}
	
	SortStatsGoalies(int g){
		Goalies gl = new Goalies(g);
		setGoaliesSorted();
	}
	
	//setters
	public void setGoaliesSorted(){
		goaliesSorted = new ArrayList<Goalies>(getGoaliesRoster());
		Collections.sort(goaliesSorted);
	}
	
	//getters
	public ArrayList<Goalies> getGoaliesSorted(){
		return goaliesSorted;	
	}
}

class FilterStatsGoalies extends Goalies{
	//fields
	private int filterBy;
	private int minInclusive;
	private int maxInclusive;
	private ArrayList<Goalies> goaliesFiltered;
	
	//constructors
	FilterStatsGoalies(){
	}
	
	FilterStatsGoalies(int filterBy, int minInclusive, int maxInclusive){
		this.filterBy = filterBy;
		this.minInclusive = minInclusive;
		this.maxInclusive = maxInclusive;
	}
	
	//setters
	public void setFilterBy(int filterBy){
		this.filterBy = filterBy;	
	}
	
	public void setMinInclusive(int minInclusive){
		this.minInclusive = minInclusive;	
	}
	
	public void setMinInclusive(){
	try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter minimum inclusive value: ");
			minInclusive = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			setMinInclusive();
		}	
	}
	
	public void setMaxInclusive(int maxInclusive){
		this.maxInclusive = maxInclusive;	
	}
	
	public void setMaxInclusive(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter maximum inclusive value: ");
			maxInclusive = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			setMaxInclusive();
		}	
	}
	
	public void setGoaliesFiltered(){
		goaliesFiltered = new ArrayList<Goalies>();
		switch(filterBy){
		case 1: SortStatsGoalies sa = new SortStatsGoalies(1);
			for(Goalies gl : sa.getGoaliesSorted()){
				if(gl.getShotsAgainst() >= minInclusive){
					if(gl.getShotsAgainst() <= maxInclusive){
						goaliesFiltered.add(gl);
					}
				}
			}
			break;
		case 2: SortStatsGoalies ga = new SortStatsGoalies(2);
			for(Goalies gl : ga.getGoaliesSorted()){
				if(gl.getGoalsAgainst() >= minInclusive){
					if(gl.getGoalsAgainst() <= maxInclusive){
						goaliesFiltered.add(gl);
					}
				}
			}
			break;
		case 3: SortStatsGoalies sv = new SortStatsGoalies(3);
			for(Goalies gl : sv.getGoaliesSorted()){
				if(gl.getSaves() >= minInclusive){
					if(gl.getSaves() <= maxInclusive){
						goaliesFiltered.add(gl);
					}
				}
			}
			break;
		}
	}
	
	//getters
	public int getFilterBy(){
		return filterBy;	
	}
	
	public int getMinInclusive(){
		return minInclusive;	
	}
	
	public int getMaxInclusive(){
		return maxInclusive;	
	}
	
	public ArrayList<Goalies> getGoaliesFiltered(){
		return goaliesFiltered;	
	}
}

class QueryGoalies extends Goalies{
	//fields
	private ArrayList<String> queryGoaliesBP;
	
	//constructor
	public QueryGoalies(){
		setQueryGoaliesBP();
	}
	
	//setter
	public void setQueryGoaliesBP(){
		queryGoaliesBP = new ArrayList<String>();
		queryGoaliesBP.add(getGoaliesRoster().get(0).getBirthplace());
		for(int i = 1; i< getGoaliesRoster().size(); i++){
			if(queryGoaliesBP.contains(getGoaliesRoster().get(i).getBirthplace()) == false){
				queryGoaliesBP.add(getGoaliesRoster().get(i).getBirthplace());	
			}
		}
	}
	
	//getter
	public ArrayList<String> getQueryGoaliesBP(){
		return queryGoaliesBP;	
	}
	
}

class SortStatsSkaters extends Skaters{
	//fields
	private ArrayList<Skaters> skatersSorted;
	
	//constructors
	SortStatsSkaters(){
	}
	
	SortStatsSkaters(int s){
		Skaters sk = new Skaters(s);
		setSkatersSorted();
	}
	
	//setters
	public void setSkatersSorted(){
		skatersSorted = new ArrayList<Skaters>(getSkatersRoster());
		Collections.sort(skatersSorted);
	}
	
	//getters
	public ArrayList<Skaters> getSkatersSorted(){
		return skatersSorted;	
	}
}

class FilterStatsSkaters extends Skaters{
	//fields
	private int filterBy;
	private int minInclusive;
	private int maxInclusive;
	private ArrayList<Skaters> skatersFiltered;
	
	//constructors
	FilterStatsSkaters(){
	}
	
	FilterStatsSkaters(int filterBy, int minInclusive, int maxInclusive){
		this.filterBy = filterBy;
		this.minInclusive = minInclusive;
		this.maxInclusive = maxInclusive;
	}
	
	//setters
	public void setFilterBy(int filterBy){
		this.filterBy = filterBy;	
	}
	
	public void setMinInclusive(int minInclusive){
		this.minInclusive = minInclusive;	
	}
	
	public void setMinInclusive(){
	try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter minimum inclusive value: ");
			minInclusive = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			setMinInclusive();
		}	
	}
	
	public void setMaxInclusive(int maxInclusive){
		this.maxInclusive = maxInclusive;	
	}
	
	public void setMaxInclusive(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter maximum inclusive value: ");
			maxInclusive = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			setMaxInclusive();
		}	
	}
	
	public void setSkatersFiltered(){
		skatersFiltered = new ArrayList<Skaters>();
		switch(filterBy){
		case 1: SortStatsSkaters p = new SortStatsSkaters(1);
			for(Skaters s : p.getSkatersSorted()){
				if(s.getPoints() >= minInclusive){
					if(s.getPoints() <= maxInclusive){
						skatersFiltered.add(s);
					}
				}
			}
			break;
		case 2: SortStatsSkaters g = new SortStatsSkaters(2);
			for(Skaters s : g.getSkatersSorted()){
				if(s.getGoals() >= minInclusive){
					if(s.getGoals() <= maxInclusive){
						skatersFiltered.add(s);
					}
				}
			}
			break;
		case 3: SortStatsSkaters a = new SortStatsSkaters(3);
			for(Skaters s : a.getSkatersSorted()){
				if(s.getAssists() >= minInclusive){
					if(s.getAssists() <= maxInclusive){
						skatersFiltered.add(s);
					}
				}
			}
			break;
		case 4: SortStatsSkaters pm = new SortStatsSkaters(4);
			for(Skaters s : pm.getSkatersSorted()){
				if(s.getPlusMinus() >= minInclusive){
					if(s.getPlusMinus() <= maxInclusive){
						skatersFiltered.add(s);
					}
				}
			}
			break;
		}
		
	}
	
	//getters
	public int getFilterBy(){
		return filterBy;	
	}
	
	public int getMinInclusive(){
		return minInclusive;	
	}
	
	public int getMaxInclusive(){
		return maxInclusive;	
	}
	
	public ArrayList<Skaters> getSkatersFiltered(){
		return skatersFiltered;	
	}
}

class QuerySkaters extends Skaters{
	//fields
	private ArrayList<String> querySkatersBP;
	
	//constructor
	public QuerySkaters(){
		setQuerySkatersBP();
	}
	
	//setter
	public void setQuerySkatersBP(){
		querySkatersBP = new ArrayList<String>();
		querySkatersBP.add(getSkatersRoster().get(0).getBirthplace());
		for(int i = 1; i< getSkatersRoster().size(); i++){
			if(querySkatersBP.contains(getSkatersRoster().get(i).getBirthplace()) == false){
				querySkatersBP.add(getSkatersRoster().get(i).getBirthplace());	
			}
		}
	}
	
	//getter
	public ArrayList<String> getQuerySkatersBP(){
		return querySkatersBP;	
	}
}

abstract class Output{
	//constructor
	public Output(){	
	}
	
	//outputs all players and some of their stats in a predetermined order
	public static void printRosterDetails(){
		System.out.println("*****************************************************************************");
		System.out.println("THE 2017-2018 REGULAR SEASON ROSTER AND SOME OF THEIR STATS:\n");
		Skaters skaters = new Skaters();
		for(Skaters s : skaters.getSkatersRoster()){
			System.out.println("Position: " + s.getPosition() + "\tGoals: " + s.getGoals() + "\tAssists: " + s.getAssists() + "\tPoints: " + s.getPoints() + "\t+/-: " + s.getPlusMinus() + "\t\tName: " + s.getLastName());	
		}
		Goalies goalies = new Goalies();
		System.out.println();
		for(Goalies g : goalies.getGoaliesRoster()){
			System.out.println("Position: " + g.getPosition() + "\tShots Against: " + g.getShotsAgainst() + "\tGoals Against: " + g.getGoalsAgainst() + "\tSaves: " + g.getSaves() + "\t\tName: " + g.getLastName());	
		}
		mainMenu();
	}
	
	//prints an arrayList of skaterStats
	public static void printSkaters(ArrayList<Skaters> sRoster){
		System.out.println("  POINTS:\t+/-:\tGOALS:\tASSISTS\tPLAYERS:  ");
		for(int i=(sRoster.size() - 1); i>=0; i--){
			System.out.println("  " + sRoster.get(i).getPoints() + "\t\t" + sRoster.get(i).getPlusMinus() + "\t" + sRoster.get(i).getGoals() + "\t" + sRoster.get(i).getAssists() + "\t" + sRoster.get(i).getLastName());	
		}		
	}
	
	//prints an arrayList of goalieStats
	public static void printGoalies(ArrayList<Goalies> gRoster){
		System.out.println("  SHOTS AGAINST:\tGOALS AGAINST:\tSAVES:\t\tPLAYERS:  ");
		for(int i=(gRoster.size() - 1); i>=0; i--){
			System.out.println("  " + gRoster.get(i).getShotsAgainst() + "\t\t\t" + gRoster.get(i).getGoalsAgainst() + "\t\t" + gRoster.get(i).getSaves() + "\t\t" + gRoster.get(i).getLastName());	
		}		
	}
	
	//gives user option of sorting or filtering stats
	public static int statsWizard(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("WELCOME TO 2017-2018 WASHINGTON CAPITALS' (SOME) REGULAR SEASON STATS WIZARD!");
		System.out.println("\nSelect an option:\n1.) Display Roster \n2.) Sort Stats \n3.) Filter Stats \n4.) Query Players \n\n\n5.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println(  "You selected: DISPLAY");
						return 1;
					case 2: System.out.println("  You selected: SORT");
						return 2;
					case 3: System.out.println("  You selected: FILTER");
						return 3;
					case 4: System.out.println(  "You selected: QUERY");
						return 4;
					case 5: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: Output.statsWizard(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		statsWizard();
		}
		return 1;
	}
	
	public static void mainMenu(){
		int sortFilter = statsWizard();
		if(sortFilter == 1){
			printRosterDetails();
		}
		else if(sortFilter == 2){
			SortOutput.userSortOptions();
		}
		else if(sortFilter == 3){
			FilterOutput.userFilterOptions();	
		}
		else{
			QueryOutput.userQueryOptions();	
		}
	}
	
}


class SortOutput extends Output{
	//constructor
	private SortOutput(){
	}
	
	/**
	* a method that outputs a menu to select type of sorted stats to display on screen
	*/
	public static void userSortOptions(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("\nSelect a sort by option:\n1.) Points \n2.) Goals\n3.) Assists \n4.) +/- \n5.) Shots Against \n6.) Goals Against \n7.) Saves\n\n8.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("  You selected: Sort Washington Capitals' Stats by POINTS");
						SortStatsSkaters p = new SortStatsSkaters(1);
						Output.printSkaters(p.getSkatersSorted() );
						break;
					case 2: System.out.println("  You selected: Sort Washington Capitals' Stats by GOALS");
						SortStatsSkaters g = new SortStatsSkaters(2);
						Output.printSkaters(g.getSkatersSorted() );
						break;
					case 3: System.out.println("  You selected: Sort Washington Capitals' Stats by ASSISTS");
						SortStatsSkaters a = new SortStatsSkaters(3);
						Output.printSkaters(a.getSkatersSorted() );
						break;
					case 4: System.out.println("  You selected: Sort Washington Capitals' Stats by +/-");
						SortStatsSkaters pm = new SortStatsSkaters(4);
						Output.printSkaters(pm.getSkatersSorted() );
						break;
					case 5: System.out.println("  You selected: Sort Washington Capitals' Stats by SHOTS AGAINST");
						SortStatsGoalies sa = new SortStatsGoalies(1);
						Output.printGoalies(sa.getGoaliesSorted() );
						break;
					case 6: System.out.println("  You selected: Sort Washington Capitals' Stats by GOALS AGAINST");
						SortStatsGoalies ga = new SortStatsGoalies(2);
						Output.printGoalies(ga.getGoaliesSorted() );
						break;
					case 7: System.out.println("  You selected: Sort Washington Capitals' Stats by SAVES");
						SortStatsGoalies s = new SortStatsGoalies(3);
						Output.printGoalies(s.getGoaliesSorted() );
						break;
					case 8: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: userSortOptions(); //reload menu bc invalid selection
						break;	
				}
				mainMenu();
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		userSortOptions();
		}
	}
}

class FilterOutput extends Output{
	//constructor
	private FilterOutput(){
	}
	

	public static void userDefinedSkaterFilter(int filterByThis){
		FilterStatsSkaters fss = new FilterStatsSkaters();
		fss.setFilterBy(filterByThis);
		fss.setMinInclusive();
		fss.setMaxInclusive();
		fss.setSkatersFiltered();
		System.out.println();
		Output.printSkaters(fss.getSkatersFiltered() );	
	}
	
	
	public static void userDefinedGoalieFilter(int filterByThis){
		FilterStatsGoalies fsg = new FilterStatsGoalies();
		fsg.setFilterBy(filterByThis);
		fsg.setMinInclusive();
		fsg.setMaxInclusive();
		fsg.setGoaliesFiltered();
		System.out.println();
		Output.printGoalies(fsg.getGoaliesFiltered() );
	}
	
	/**
	* a method that outputs a menu to select which filtered stats to display on screen
	*/
	public static void userFilterOptions(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("\nSelect a stat to filter:\n1.) Points \n2.) Goals\n3.) Assists \n4.) +/- \n5.) Shots Against \n6.) Goals Against \n7.) Saves\n\n8.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("  You selected: Filter Skater POINTS");
						userDefinedSkaterFilter(1);
						break;
					case 2: System.out.println("  You selected: Filter Skater GOALS");
						userDefinedSkaterFilter(2);
						break;
					case 3: System.out.println("  You selected: Filter Skater ASSISTS");
						userDefinedSkaterFilter(3);
						break;
					case 4: System.out.println("  You selected: Filter Skater +/-");
						userDefinedSkaterFilter(4);
						break;
					case 5: System.out.println("  You selected: Filter Goalie SHOTS AGAINST");
						userDefinedGoalieFilter(1);
						break;
					case 6: System.out.println("  You selected: Filter Goalie GOALS AGAINST");
						userDefinedGoalieFilter(2);
						break;
					case 7: System.out.println("  You selected: Filter Goalie SAVES");
						userDefinedGoalieFilter(3);
						break;
					case 8: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: userFilterOptions(); //reload menu bc invalid selection
						break;	
				}
				mainMenu();
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		userFilterOptions();
		}
	}
}

class QueryOutput extends Output{
	//constructor
	public QueryOutput(){
	}
		
	public static void BPQueryOptions(){
		ArrayList<String> bpQueryOptions = new ArrayList<String>();
		
		QuerySkaters qs = new QuerySkaters();
		QueryGoalies qg = new QueryGoalies();
		bpQueryOptions = qs.getQuerySkatersBP();
		for(int i = 0; i<qg.getQueryGoaliesBP().size(); i++){
			if(bpQueryOptions.contains(qg.getQueryGoaliesBP().get(i)) == false){
				bpQueryOptions.add(qg.getQueryGoaliesBP().get(i));	
			}
		}
		Collections.sort(bpQueryOptions);
		System.out.println("Select a Birthplace from these options: ");
		for(int i = 0; i<bpQueryOptions.size(); i++){
			System.out.println((i+1) + "). " + bpQueryOptions.get(i));
		}
	}
	
	/**
	* a method that outputs a menu to select which queried detail to display on screen
	*/
	public static void userQueryOptions(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("\nSelect a detail to query:\n1.) Birthplace \n2.) Shoots \n\n3.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("  You selected: Query Player Birthplace");
						BPQueryOptions();
						System.out.println("Enter selection:  ");
						System.out.println("\nResults:\t____ players were born in ________________.  These players are ...");
						break;
					case 2: System.out.println("  You selected: Query Skater Shoots");
						System.out.println("Select 1.) L 2.) R");
						System.out.println("_____ skaters shoot ____.  These skaters are....");
						break;
					case 3: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: userQueryOptions(); //reload menu bc invalid selection
						break;	
				}
				mainMenu();
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			userQueryOptions();
		}
	}
}

public class HockeyStatsWizard{
	//constructor
	public HockeyStatsWizard(){	
	}
	
	//main method
	public static void main(String... args){
		Output.mainMenu();
	}
}