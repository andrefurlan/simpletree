package simpletree.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KpiData {

	private List<Kpi> kpiData;
	
	public KpiData() {
		kpiData = new ArrayList<>();
		HashSet<Integer> c1 = new HashSet<Integer>();
		c1.add(2);
		c1.add(3);
		HashSet<Integer> c2 = new HashSet<Integer>();
		c2.add(3);
		c2.add(4);
		c2.add(5);
		HashSet<Integer> c3 = new HashSet<Integer>();
		c3.add(2);
		c3.add(5);
		c3.add(6);
		c3.add(7);
		Kpi kpi1 = new Kpi(1, "kpi 1", -1, c1, true, "Units");
		Kpi kpi2 = new Kpi(2, "kpi 2", 1, c2, true, "Units");
		Kpi kpi3 = new Kpi(4, "kpi 3", 1, new HashSet<Integer>(), true, "Units");
		Kpi kpi4 = new Kpi(3, "kpi 4", 2, c3, true, "Units");
		Kpi kpi5 = new Kpi(5, "kpi 5", 2, new HashSet<Integer>(), true, "Units");
		Kpi kpi6 = new Kpi(6, "kpi 6", 2, new HashSet<Integer>(), true, "Units");
		Kpi kpi7 = new Kpi(7, "kpi 7", 2, new HashSet<Integer>(), true, "Units");

		HashSet<MonthlyValue> kpi1Data = new HashSet<MonthlyValue>();
		kpi1Data.add(new MonthlyValue(10, 2014, 1, 1));
		kpi1Data.add(new MonthlyValue(14, 2014, 2, 1));
		kpi1.setMonthlyActuals(kpi1Data);

		HashSet<MonthlyValue> kpi2Data = new HashSet<MonthlyValue>();
		kpi2Data.add(new MonthlyValue(1, 2014, 1, 1));
		kpi2Data.add(new MonthlyValue(25, 2014, 2, 1));
		kpi2.setMonthlyActuals(kpi2Data);

		HashSet<MonthlyValue> kpi3Data = new HashSet<MonthlyValue>();
		kpi3Data.add(new MonthlyValue(15, 2014, 1, 1));
		kpi3Data.add(new MonthlyValue(89, 2014, 2, 1));
		kpi3.setMonthlyActuals(kpi3Data);

		HashSet<MonthlyValue> kpi4Data = new HashSet<MonthlyValue>();
		kpi4Data.add(new MonthlyValue(91, 2014, 1, 1));
		kpi4Data.add(new MonthlyValue(45, 2014, 2, 1));
		kpi4.setMonthlyActuals(kpi4Data);

		HashSet<MonthlyValue> kpi5Data = new HashSet<MonthlyValue>();
		kpi5Data.add(new MonthlyValue(19, 2014, 1, 1));
		kpi5Data.add(new MonthlyValue(75, 2014, 2, 1));
		kpi5.setMonthlyActuals(kpi5Data);
		
		HashSet<MonthlyValue> kpi6Data = new HashSet<MonthlyValue>();
		kpi6Data.add(new MonthlyValue(19, 2014, 1, 1));
		kpi6Data.add(new MonthlyValue(75, 2014, 2, 1));
		kpi6.setMonthlyActuals(kpi5Data);
		
		HashSet<MonthlyValue> kpi7Data = new HashSet<MonthlyValue>();
		kpi7Data.add(new MonthlyValue(19, 2014, 1, 1));
		kpi7Data.add(new MonthlyValue(75, 2014, 2, 1));
		kpi7.setMonthlyActuals(kpi5Data);

		kpiData.add(kpi1);
		kpiData.add(kpi2);
		kpiData.add(kpi3);
		kpiData.add(kpi4);
		kpiData.add(kpi5);
		kpiData.add(kpi6);
		kpiData.add(kpi7);
	}
	
	public List<Kpi> getData(){
		return this.kpiData;
	}

	public Kpi getKpiById(int id) {
		Kpi kpi = null;
		for (Kpi k: kpiData) {
			if (k.getId() == id)
				kpi = k;
		}
		return kpi;
	}
	
	public int size(){
		return kpiData.size();
	}
	
	public Kpi getHead() {
		Kpi kpi = null;
		for (Kpi k: kpiData) {
			if (k.getParent() == -1)
				kpi = k;
		}
		return kpi;
	}
	
	
	
}
