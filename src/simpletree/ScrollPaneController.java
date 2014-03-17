/**
 * @author Andre Furlan
 * 
 */

package simpletree;

import simpletree.model.KPI;
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
		KPI headKPI = new KPI(0, (new int[] { 1, 2 }), "Opex/Oz");
		//KPI headKPI = main.getkpiData().get(0);

		GridPane head = buildGridPane(headKPI, startX, startY);
		// TODO verify why is this yellow
		treeAnchorPane.setTopAnchor(head, startY);
		treeAnchorPane.setLeftAnchor(head, startX);
		treeAnchorPane.getChildren().addAll(head);
	}


	private GridPane buildGridPane(KPI kpi, double x, double y) {
		// TODO Implement tests.
		// TODO make treeGrid pretty
		GridPane treeGrid = new GridPane();
		// treeGrid.setGridLinesVisible(true);
		treeGrid.setId("treegrid");
		// set main grid constraints
		treeGrid.getColumnConstraints().add(new ColumnConstraints(150));
		treeGrid.getRowConstraints().add(new RowConstraints(18));
		treeGrid.getRowConstraints().add(new RowConstraints(54));
		treeGrid.getRowConstraints().add(new RowConstraints(18));

		// call helper functions to build nested grids
		GridPane firstRowGrid = buildFirstRowGrid(kpi, x, y);
		GridPane secondRowGrid = buildSecondRowGrid(kpi);
		GridPane thirdRowGrid = buildThirdRowGrid(kpi);
		// TODO helper function for row three
		treeGrid.add(firstRowGrid, 0, 0);
		treeGrid.add(secondRowGrid, 0, 1);
		treeGrid.add(thirdRowGrid, 0, 2);

		return treeGrid;
	}

	private GridPane buildThirdRowGrid(KPI kpi) {
		GridPane thirdRowGrid = new GridPane();
		thirdRowGrid.setId("treegrid-thirdrow");
		// thirdRowGrid.setGridLinesVisible(true);
		thirdRowGrid.getRowConstraints().add(new RowConstraints(18));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));

		return thirdRowGrid;
	}

	private GridPane buildSecondRowGrid(KPI kpi) {
		// TODO Auto-generated method stub
		String goalStr = String.valueOf(kpi.getGoal());
		String actualStr = String.valueOf(kpi.getActual());
		String percDeviationStr = String.valueOf(kpi.getPercDeviation());

		GridPane secondRowGrid = new GridPane();
		secondRowGrid.setId("treegrid-secondrow");
		// secondRowGrid.setGridLinesVisible(true);
		secondRowGrid.getColumnConstraints().add(new ColumnConstraints(50));
		secondRowGrid.getColumnConstraints().add(new ColumnConstraints(100));
		secondRowGrid.getRowConstraints().add(new RowConstraints(18));
		secondRowGrid.getRowConstraints().add(new RowConstraints(18));
		secondRowGrid.getRowConstraints().add(new RowConstraints(18));

		Label goalLabel = new Label("GOAL");
		secondRowGrid.add(goalLabel, 0, 0);
		goalLabel.setId("grid-label");

		Label goalValue = new Label(goalStr);
		secondRowGrid.add(goalValue, 1, 0);
		goalValue.setId("grid-value");

		Label actualLabel = new Label("ACTUAL");
		secondRowGrid.add(actualLabel, 0, 1);
		actualLabel.setId("grid-label");

		Label actualValue = new Label(actualStr);
		secondRowGrid.add(actualValue, 1, 1);
		actualValue.setId("grid-value");

		Label percDeviationLabel = new Label("Dev. %");
		secondRowGrid.add(percDeviationLabel, 0, 2);
		percDeviationLabel.setId("grid-label");

		Label percDeviationValue = new Label(percDeviationStr);
		secondRowGrid.add(percDeviationValue, 1, 2);
		percDeviationValue.setId("grid-value");

		return secondRowGrid;
	}


	private GridPane buildFirstRowGrid(KPI kpi, final double x, final double y) {

		// TODO Implement tests.
		int id = kpi.getId();
		String name = kpi.getName();
		final int[] childrenID = kpi.getChildren();

		GridPane firstRowGrid = new GridPane();
		firstRowGrid.setId("treegrid-firstrow");
		// firstRowGrid.setGridLinesVisible(true);
		firstRowGrid.getColumnConstraints().add(new ColumnConstraints(132));
		firstRowGrid.getColumnConstraints().add(new ColumnConstraints(18));
		firstRowGrid.getRowConstraints().add(new RowConstraints(18));

		// insert the KPI name
		Label kpiName = new Label(name);
		firstRowGrid.add(kpiName, 0, 0);

		// insert button to deploy tree
		Button btNext = new Button();
		btNext.setId("btNext");
		// btNext.setId("btNext: " + id);

		// defines the action the button will perform
		// TODO make btNext pretty
		btNext.setOnAction(new EventHandler<ActionEvent>() {


			public void handle(ActionEvent e) {
				deploy(childrenID, x, y);
			}
		});
		firstRowGrid.add(btNext, 1, 0);

		return firstRowGrid;
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