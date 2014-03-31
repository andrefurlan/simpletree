package simpletree.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class TreeNode {
	private Kpi kpi;
	private GridPane grid;
	
	public TreeNode(Kpi kpi) {
		this.kpi = kpi;
		buildGrid();
	}

	
	
	public GridPane getGridPane(){
		return this.grid;
	}
	
	public void setValuesDaily() {
		
	}
	
	public void setValuesWeekly() {

	}

	public void setValuesMonthly() {

	}
	
	public void setValuesYearly() {

	}	
	
	
	private GridPane buildGrid() {
		// TODO Implement tests.
		// TODO make treeGrid pretty
		grid = new GridPane();
		// treeGrid.setGridLinesVisible(true);
		grid.setId("tree-node");
		// set main grid constraints
		grid.getColumnConstraints().add(new ColumnConstraints(150));
		grid.getRowConstraints().add(new RowConstraints(18));
		grid.getRowConstraints().add(new RowConstraints(54));
		grid.getRowConstraints().add(new RowConstraints(18));

		// call helper functions to build nested grids
//		GridPane firstRowGrid = buildFirstRowGrid(kpi, x, y);
//		GridPane secondRowGrid = buildSecondRowGrid(kpi);
//		GridPane thirdRowGrid = buildThirdRowGrid(kpi);
//		grid.add(firstRowGrid, 0, 0);
//		grid.add(secondRowGrid, 0, 1);
//		grid.add(thirdRowGrid, 0, 2);

		return grid;
	}

	private GridPane buildThirdRowGrid(Kpi kpi) {
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

	private GridPane buildSecondRowGrid(Kpi kpi) {
		// TODO Auto-generated method stub
//		String goalStr = String.valueOf(kpi.getGoal());
//		String actualStr = String.valueOf(kpi.getActual());
//		String percDeviationStr = String.valueOf(kpi.getPercDeviation());

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

////		Label goalValue = new Label(goalStr);
//		secondRowGrid.add(goalValue, 1, 0);
//		goalValue.setId("grid-value");

		Label actualLabel = new Label("ACTUAL");
		secondRowGrid.add(actualLabel, 0, 1);
		actualLabel.setId("grid-label");

//		Label actualValue = new Label(actualStr);
//		secondRowGrid.add(actualValue, 1, 1);
//		actualValue.setId("grid-value");

		Label percDeviationLabel = new Label("Dev. %");
		secondRowGrid.add(percDeviationLabel, 0, 2);
		percDeviationLabel.setId("grid-label");

//		Label percDeviationValue = new Label(percDeviationStr);
//		secondRowGrid.add(percDeviationValue, 1, 2);
//		percDeviationValue.setId("grid-value");

		return secondRowGrid;
	}


	private GridPane buildFirstRowGrid(Kpi kpi, final double x, final double y) {

		// TODO Implement tests.
		int id = kpi.getId();
//		String name = kpi.getName();
//		final int[] childrenID = kpi.getChildren();

		GridPane firstRowGrid = new GridPane();
		firstRowGrid.setId("treegrid-firstrow");
		// firstRowGrid.setGridLinesVisible(true);
		firstRowGrid.getColumnConstraints().add(new ColumnConstraints(132));
		firstRowGrid.getColumnConstraints().add(new ColumnConstraints(18));
		firstRowGrid.getRowConstraints().add(new RowConstraints(18));

		// insert the KPI name
//		Label kpiName = new Label(name);
//		firstRowGrid.add(kpiName, 0, 0);

		// insert button to deploy tree
		Button btNext = new Button();
		btNext.setId("btNext");
		// btNext.setId("btNext: " + id);

		// defines the action the button will perform
		// TODO make btNext pretty
		btNext.setOnAction(new EventHandler<ActionEvent>() {


			public void handle(ActionEvent e) {
//				deploy(childrenID, x, y);
			}
		});
		firstRowGrid.add(btNext, 1, 0);

		return firstRowGrid;
	}
	
	
}
