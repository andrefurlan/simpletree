package simpletree.model;

public class DailyValue extends MonthlyValue {

	private int dayNumber;
	
	
	public DailyValue(double value, int year, int month, int day, int kpiId) {
		
		super(value, year, month, kpiId);
		this.dayNumber = day;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dayNumber;
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
		DailyValue other = (DailyValue) obj;
		if (dayNumber != other.dayNumber)
			return false;
		return true;
	}


	/**
	 * @return the dayNumber
	 */
	public int getDay() {
		return dayNumber;
	}


	/**
	 * @param dayNumber the dayNumber to set
	 */
	public void setDay(int dayNumber) {
		this.dayNumber = dayNumber;
	}

}
