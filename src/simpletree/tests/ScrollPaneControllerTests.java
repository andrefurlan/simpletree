package simpletree.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

import org.junit.Before;
import org.junit.Test;

import simpletree.Main;
import simpletree.RootLayoutController;
import simpletree.ScrollPaneController;
import simpletree.exceptions.FXMLLoadException;
import simpletree.model.Kpi;
import simpletree.model.KpiData;
import simpletree.model.TreeNode;


public class ScrollPaneControllerTests {
	
	public ScrollPane scrollPane;
	double xfortest1 = 30.0;
	double xfortest2 = 30.9;
	double xfortest3 = 0.0;
	double xfortest4 = -20.0;
	private static ScrollPaneController instance;
	private KpiData data;
	private Set<TreeNode> tree;
	


	
	@Test
	public void testNewTreeNodes(){
		data = new KpiData();
		Kpi kpi = data.getKpiById(4);
		Kpi kpi2 = data.getKpiById(4);
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(380.0);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(105.0);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((kpi == null) ? 0 : kpi.hashCode());
		
		int result1 = 1;
		long temp1;
		temp1 = Double.doubleToLongBits(380.0);
		result1 = prime * result1 + (int) (temp1 ^ (temp1 >>> 32));
		temp1 = Double.doubleToLongBits(105.0);
		result1 = prime * result1 + (int) (temp1 ^ (temp1 >>> 32));
		result1 = prime * result1 + ((kpi2 == null) ? 0 : kpi2.hashCode());
		
		
		assertEquals(result, 1);
		
	}
	
}
