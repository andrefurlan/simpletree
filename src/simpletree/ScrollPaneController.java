/**
 * @author Andre Furlan
 * 
 */

package simpletree;

import simpletree.model.Kpi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class ScrollPaneController {

	@FXML
	private AnchorPane treeAnchorPane;
	private double startX = 20.0;
	private double startY = 100.0;
	private static ScrollPaneController instance;


	public ScrollPaneController() {
		instance = this;
	}


	@FXML
	private void initialize() {
		// TODO Implement tests.

		// TODO Implement tests for initialize in TreeScrollPaneLayoutController
		// TODO add function to initialize dropdown button with options for
		// period to analyze

	}


	/**
	 * @return the instance
	 */
	public static ScrollPaneController getInstance() {
		return instance;
	}

	
	public void setupHead() {
		// TODO Implement tests.
		Kpi headKPI = new Kpi(0, (new int[] { 1, 2 }), "Opex/Oz");
		//KPI headKPI = main.getkpiData().get(0);

		GridPane head = buildGridPane(headKPI, startX, startY);
		// TODO verify why is this yellow
		treeAnchorPane.setTopAnchor(head, startY);
		treeAnchorPane.setLeftAnchor(head, startX);
		treeAnchorPane.getChildren().addAll(head);
	}


	


	protected void deploy(int[] childrenID, double x, double y) {

		double nextX = x + 180;
		double nextY = y + 10;
		//TODO finish the method. 
		//TODO Implement tests.
		for (int childID : childrenID) {
			//TODO Define better method for getting the KPI from the list...
			//KPI child = main.getkpiData().get(childID);
//			GridPane childGrid = buildGridPane(child, nextX, nextY);
//			treeAnchorPane.setTopAnchor(childGrid, nextY);
//			treeAnchorPane.setLeftAnchor(childGrid, nextX);
//			treeAnchorPane.getChildren().addAll(childGrid);
//			nextX = nextX + 180;
//			nextY = nextY + 10;
		}
//		int nChildren = childrenID.length;
//		double[] nextYs = calcNextY(nChildren, Y);
//		double nextX = calcNextX(X);
//		
//		int i = 0;
//		// TODO finish the method.
//		// TODO Implement tests.
//		for (int childID : childrenID) {
//			// TODO Define better method for getting the KPI from the list...
//			KPI child = main.getkpiData().get(childID);
//			GridPane childGrid = buildGridPane(child, nextX, nextYs[i]);
//			treeAnchorPane.setTopAnchor(childGrid, nextYs[i]);
//			treeAnchorPane.setLeftAnchor(childGrid, nextX);
//			treeAnchorPane.getChildren().addAll(childGrid);
//			i++;
//		}
	}
	
	private double[] calcNextY(int nChildren, double y) {
		// TODO Auto-generated method stub
		

		double[] nextYs;
		
		
		return null;
	}

	private double calcNextX (double x) {
		
		double nextX = x + 180;
		return nextX;
	}
	
	
	

}