package simpletree.model;

public class MonthlyValue extends YearlyValue {
	
	private int monthNumber;
	
	public MonthlyValue(double value, int year, int month, int kpiId) {
		super(value, year, kpiId);
		this.monthNumber = month;
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + monthNumber;
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
		MonthlyValue other = (MonthlyValue) obj;
		if (monthNumber != other.monthNumber)
			return false;
		return true;
	}

	/**
	 * @return the monthNumber
	 */
	public int getMonth() {
		return monthNumber;
	}

	/**	
	 * @param monthNumber the monthNumber to set
	 */
	public void setMonth(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String monthName = new String();
		int i = 1;
		for (Months p : Months.values()) {
			if(i == this.monthNumber)
				monthName = p.toString();
			i++;
		}
		return monthName;
	}
	
	private enum Months{
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
	}
	

}
