package simpletree.model;


import simpletree.RootLayoutController;
import simpletree.ScrollPaneController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class TreeNode {
	private Kpi kpi;
	private GridPane grid;
	private double X;
	private double Y;
	private double goalValue;
	private double actualValue;
	
	public TreeNode(Kpi kpi) {
		this.kpi = kpi;
		buildGrid();
	}

	
	private GridPane buildGrid() {
		// TODO Implement tests.
		// TODO make treeGrid pretty
		grid = new GridPane();
		grid.setGridLinesVisible(true);
		
		// set main grid constraints
		grid.getColumnConstraints().add(new ColumnConstraints(150));
		grid.getRowConstraints().add(new RowConstraints(18));
		grid.getRowConstraints().add(new RowConstraints(54));
		grid.getRowConstraints().add(new RowConstraints(18));

		// call helper functions to build nested grids
		GridPane firstRowGrid = buildFirstRowGrid(kpi);
		GridPane valuesGrid = buildValuesGrid(kpi);
		GridPane thirdRowGrid = buildThirdRowGrid(kpi);
		grid.add(firstRowGrid, 0, 0);
		grid.add(valuesGrid, 0, 1);
		grid.add(thirdRowGrid, 0, 2);
		grid.setId("tree-node");
		return grid;
	}

	
	

	private GridPane buildFirstRowGrid(Kpi kpi) {

		// TODO Implement tests.
		String name = kpi.getDescription().toUpperCase();
		
		GridPane firstRowGrid = new GridPane();
		
		ColumnConstraints column1 = new ColumnConstraints(132);
		column1.setHalignment(HPos.CENTER);
		firstRowGrid.getColumnConstraints().add(column1);
		
		ColumnConstraints column2 = new ColumnConstraints(18);
		column2.setHalignment(HPos.CENTER);
		firstRowGrid.getColumnConstraints().add(column2);
		RowConstraints row1 = new RowConstraints(18);
		row1.setValignment(VPos.CENTER);
		firstRowGrid.getRowConstraints().add(row1);
		firstRowGrid.setGridLinesVisible(true);
		
		// insert the KPI name
		Label kpiName = new Label(name);
		kpiName.setId("kpi-name");
		firstRowGrid.add(kpiName, 0, 0);
		// insert button to deploy tree
		Button btNext = new Button();
		btNext.setTooltip(new Tooltip("Click to deploy"));
		btNext.setId("btNext");

		// defines the action the button will perform
		// TODO make btNext pretty
		btNext.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				deploy();
			}
		});
		
		// adds the button to the grid
		firstRowGrid.add(btNext, 1, 0);
		firstRowGrid.setId("tree-node");
		return firstRowGrid;
	}
	
	private void deploy(){
		ScrollPaneController.getInstance().deploy(this);
//		RootLayoutController.getInstance().getScrollPane().setHvalue(1.0);
		
	}

	private GridPane buildValuesGrid(Kpi kpi) {
		String goalStr = String.valueOf(this.goalValue)+" ("+kpi.getUnit()+")";
		String actualStr = String.valueOf(this.actualValue)+" ("+kpi.getUnit()+")";
//		String percDeviationStr = String.valueOf(kpi.getPercDeviation());

		GridPane valuesGrid = new GridPane();
		
		valuesGrid.setGridLinesVisible(true);
		valuesGrid.getColumnConstraints().add(new ColumnConstraints(50));
		valuesGrid.getColumnConstraints().add(new ColumnConstraints(100));
		valuesGrid.getRowConstraints().add(new RowConstraints(18));
		valuesGrid.getRowConstraints().add(new RowConstraints(18));
		valuesGrid.getRowConstraints().add(new RowConstraints(18));

		Label goalLabel = new Label("GOAL");
		valuesGrid.add(goalLabel, 0, 0);
		goalLabel.setId("grid-label");

		Label goalValue = new Label(goalStr);
		valuesGrid.add(goalValue, 1, 0);
		goalValue.setId("grid-value");

		Label actualLabel = new Label("ACTUAL");
		valuesGrid.add(actualLabel, 0, 1);
		actualLabel.setId("grid-label");

		Label actualValue = new Label(actualStr);
		valuesGrid.add(actualValue, 1, 1);
		actualValue.setId("grid-value");

		GridPane devGrid = new GridPane();
		
		devGrid.setGridLinesVisible(true);
		devGrid.getColumnConstraints().add(new ColumnConstraints(82));
		devGrid.getColumnConstraints().add(new ColumnConstraints(18));
		devGrid.getRowConstraints().add(new RowConstraints(18));
		
		Rectangle farol = new Rectangle();
		farol.setHeight(18.0);
		farol.setWidth(18.0);
		double deviation = calculateDeviation();
		
		farol.setFill(farolColor(deviation));
		devGrid.add(farol, 1, 0);
		
		Label percDeviationLabel = new Label("Dev. %");
		valuesGrid.add(percDeviationLabel, 0, 2);
		percDeviationLabel.setId("grid-label");
		
		valuesGrid.add(devGrid, 1, 2);
//		Label percDeviationValue = new Label(percDeviationStr);
//		secondRowGrid.add(percDeviationValue, 1, 2);
//		percDeviationValue.setId("grid-value");
		
		
		valuesGrid.setId("tree-node");
		return valuesGrid;
	}

	
	
	private javafx.scene.paint.Paint farolColor(double deviation) {
		// TODO Auto-generated method stub
		return Color.GREEN;
	}


	private double calculateDeviation() {
		// TODO Auto-generated method stub
		return 0;
	}


	private GridPane buildThirdRowGrid(Kpi kpi) {
		GridPane thirdRowGrid = new GridPane();
		
		thirdRowGrid.setGridLinesVisible(true);
		thirdRowGrid.getRowConstraints().add(new RowConstraints(18));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));
		thirdRowGrid.getColumnConstraints().add(new ColumnConstraints(30));
		thirdRowGrid.setId("tree-node");
		return thirdRowGrid;
	}
	



	public GridPane getGridPane(){
		return this.grid;
	}
	
	public Kpi getKpi(){
		return this.kpi;
	}	
	
	public void setGoalValue(double goal){
		this.goalValue = goal;
		
	}
	
	
	
	public void setX(double x) {
		this.X = x;
	}
	
	public void setY(double y) {
		this.Y = y;
	}
	
	public double getX(){
		return this.X;
	}
	
	public double getY(){
		return this.Y;
	}
	
	
	


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(X);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(Y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((kpi == null) ? 0 : kpi.hashCode());
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
		TreeNode other = (TreeNode) obj;
		if (Double.doubleToLongBits(X) != Double.doubleToLongBits(other.X))
			return false;
		if (Double.doubleToLongBits(Y) != Double.doubleToLongBits(other.Y))
			return false;
		if (kpi == null) {
			if (other.kpi != null)
				return false;
		} else if (!kpi.equals(other.kpi))
			return false;
		return true;
	}




	
}
