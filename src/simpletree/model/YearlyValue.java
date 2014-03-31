package simpletree.model;


public class YearlyValue {

	private double value;
	private int year;
	private int kpiId;
	
	public YearlyValue(double value, int  year, int kpiId) {
		if (validYearEh(year)) 
			this.value = value;
		this.year = year;
		this.kpiId = kpiId;
	}

	private boolean validYearEh(int year2) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the kpiId
	 */
	public int getKpiId() {
		return kpiId;
	}

	/**
	 * @param kpiId the kpiId to set
	 */
	public void setKpiId(int kpiId) {
		this.kpiId = kpiId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + kpiId;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + year;
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
		YearlyValue other = (YearlyValue) obj;
		if (kpiId != other.kpiId)
			return false;
		if (Double.doubleToLongBits(value) != Double
				.doubleToLongBits(other.value))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	

	
	


}
