package simpletree.model;

public class KPI {

	private int id;
	private int[] children;
	private String name;
	private double goal;
	private double actual;
	private double percDeviation;
	private String better;

	public KPI(int id, int[] children, String name) {
		this.id = id;
		this.children = children;
		this.name = name;
		this.actual = 0.0;
		this.goal = 0.0;
		this.percDeviation = 0.0;
		this.better = "up";
	}

	// TODO White documentation for get functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public int getId() {
		//TODO Implement tests.
		int id = this.id;
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
		//TODO Implement tests.
		int[] children = this.children;
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
		//TODO Implement tests.
		double actual = this.actual;
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
		//TODO Implement tests.
		double goal = this.goal;
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
		//TODO Implement tests.
		String name = this.name;
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
		//TODO Implement tests.
		String better = this.better;
		return better;
	}

	// TODO White documentation for set functions in KPI
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public void setActual(double actual) {
		//TODO Implement tests.
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
		//TODO Implement tests.
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
		//TODO Implement tests.
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
		//TODO Implement tests.
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
		//TODO Implement tests.
		this.children = children;
	}

	// TODO White documentation for getPercDeviation
	/**
	 * Purpose here <br>
	 * REQUIRES: <br>
	 * MODIFIES: <br>
	 * EFFECTS: <br>
	 */
	public double getPercDeviation() {
		//TODO Implement tests.
		// TODO Implement deviation calculation
		double percDeviation = this.percDeviation;
		return percDeviation;
	}

}