package simpletree.model;


import java.util.HashSet;
import java.util.Set;

public class Kpi {

	// MANDATORY FIELDS
	private int id;
	private String description;
	private Set<Integer> childrenSet;
	private boolean betterUp;
	private String unit;

	// OPTIONAL FIELDS
	private Set<DailyValue> dailyGoals;
	private Set<WeeklyValue> weeklyGoals;
	private Set<MonthlyValue> monthlyGoals;
	private Set<YearlyValue> yearlyGoals;

	private Set<DailyValue> dailyActuals;
	private Set<WeeklyValue> weeklyActuals;
	private Set<MonthlyValue> monthlyActuals;
	private Set<YearlyValue> yearlyActuals;

	private String owner;

	// TODO Add support accumulated period

	public Kpi(int id, String description, Set<Integer> children, boolean betterUp, String unit) {
		this.id = id;
		this.childrenSet = children;
		this.description = description;
		this.betterUp = betterUp;
		this.unit = unit;
		
		this.dailyGoals = new HashSet<>();
		this.weeklyGoals = new HashSet<>();
		this.monthlyGoals = new HashSet<>();
		this.yearlyGoals = new HashSet<>();
		
		this.dailyActuals = new HashSet<>();
		this.weeklyActuals = new HashSet<>();
		this.monthlyActuals = new HashSet<>();
		this.yearlyActuals = new HashSet<>();
		
		this.owner = new String();
		
	}
	
	public Set<Kpi> getChildrenKpis() {
		//TODO getChildrenKpis
		return null;

	}

	
	public int getId() {
		return this.id;
	}
	
	public boolean getBetterUp() {
		return this.betterUp;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Integer> getChildrenArray(){
		return this.childrenSet;
	}
	
	public void setChildrenSet(Set<Integer> childrenSet){
		this.childrenSet = childrenSet;
	}
	
	
	public void addChildren (int childrenId) {
		this.childrenSet.add(childrenId);
	}
	
	public void removeChildren (int childrenId) {
		this.childrenSet.remove(childrenId);
	}
	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kpi other = (Kpi) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public Set<DailyValue> getDailyGoals() {
		return this.dailyGoals;
	}

	public Set<WeeklyValue> getWeeklyGoals() {
		return this.weeklyGoals;
	}

	public Set<MonthlyValue> getMonthlyGoals() {
		return this.monthlyGoals;
	}
	
	public Set<YearlyValue> getYearlyGoals() {
		return this.yearlyGoals;
	}

	public Set<DailyValue> getDailyActuals() {
		return this.dailyActuals;
	}

	public Set<WeeklyValue> getWeeklyActuals() {
		return this.weeklyActuals;
	}

	public Set<MonthlyValue> getMonthlyActuals() {
		return this.monthlyActuals;
	}
	
	public Set<YearlyValue> getYearlyActuals() {
		return this.yearlyActuals;
	}

	

	public void setDailyGoals(Set<DailyValue> goals) {
		this.dailyGoals = goals;
	}

	public void setWeeklyGoals(Set<WeeklyValue> goals) {
		this.weeklyGoals = goals;
	}

	public void setMonthlyGoals(Set<MonthlyValue> goals) {
		this.monthlyGoals = goals;
	}
	
	public void setYearlyGoals(Set<YearlyValue> goals) {
		this.yearlyGoals = goals;
	}

	public void setDailyActuals(Set<DailyValue> actuals) {
		this.dailyActuals = actuals;
	}

	public void setWeeklyActuals(Set<WeeklyValue> actuals) {
		this.weeklyActuals = actuals;
	}

	public void setMonthlyActuals(Set<MonthlyValue> actuals) {
		this.monthlyActuals = actuals;
	}
	
	public void setYearlyActuals(Set<YearlyValue> actuals) {
		this.yearlyActuals = actuals;
	}

}