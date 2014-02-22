package simpletree.model;

public class KPI {

	private int id;
	private int[] children;
	private String name;
	private double goal;
	private String month;
	private String year;
	private String period;
	private double actual;
	private double percDeviation;
	private String better;

	// TODO add unit and responsible to KPI. Add day support and accumulated
	// period

	public KPI(int id, int[] children, String name) {
		this.id = id;
		this.children = children;
		this.name = name;
		this.actual = 0.0;
		this.goal = 0.0;
		this.percDeviation = 0.0;
		this.better = "up";
		this.month = "January";
		this.year = "2010";
		this.period = year + "/" + month;
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public int getId() {
		// TODO Implement tests.
		return id;
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public int[] getChildren() {
		// TODO Implement tests.
		return children;
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public double getActual() {
		// TODO Implement tests.
		return actual;
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public double getGoal() {
		// TODO Implement tests.
		return goal;
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public String getName() {
		// TODO Implement tests.
		return name;
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public String getBetter() {
		// TODO Implement tests.

		return better;
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public String getPeriod() {
		// TODO Implement tests.
		this.period = year + "/" + month;
		return period;
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public String getMonth() {
		// TODO Implement tests.
		return month;
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public String getYear() {
		// TODO Implement tests.
		return year;
	}

	// TODO White documentation for set functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public void setActual(double actual) {
		// TODO Implement tests.
		this.actual = actual;
	}

	// TODO White documentation for set functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public void setGoal(double goal) {
		// TODO Implement tests.
		this.goal = goal;
	}

	// TODO White documentation for set functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public void setName(String name) {
		// TODO Implement tests.
		this.name = name;
	}

	// TODO White documentation for set functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public void setBetter(String better) {
		// TODO Implement tests.
		this.better = better;
	}

	// TODO White documentation for set functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public void setChildren(int[] children) {
		// TODO Implement tests.
		this.children = children;
	}

	// TODO White documentation for set functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public void setMonth(String month) {
		// TODO Implement tests.
		this.month = month;
	}

	// TODO White documentation for set functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public void setYear(String year) {
		// TODO Implement tests.
		this.year = year;

	}

	// TODO White documentation for getPercDeviation
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public double getPercDeviation() {
		// TODO Implement tests.
		// TODO Implement deviation calculation
		double percDeviation = this.percDeviation;
		return percDeviation;
	}

}