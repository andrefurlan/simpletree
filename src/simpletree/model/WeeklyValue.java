package simpletree.model;

public class WeeklyValue extends YearlyValue {

	private int weekNumber;
		
	public WeeklyValue(double value, int year, int week, int kpiId) {
		
		super (value, year, kpiId);
		this.weekNumber = week;
	}

	/**
	 * @return the weekNumber
	 */
	public int getWeekNumber() {
		return weekNumber;
	}

	/**
	 * @param weekNumber the weekNumber to set
	 */
	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + weekNumber;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeeklyValue other = (WeeklyValue) obj;
		if (weekNumber != other.weekNumber)
			return false;
		return true;
	}
	


}
