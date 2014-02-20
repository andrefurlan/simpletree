/**
 * @author Andre Furlan
 * 
 */

package simpletree;

import simpletree.model.KPI;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class TreeScrollPaneLayoutController {

	private Main main;
	@FXML
	private AnchorPane treeAnchorPane;
	private double startX = 20.0;
	private double startY = 100.0;
	
	//TODO White documentation for TreeScrollPaneLayoutController
	/**
	 * Purpose here <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public TreeScrollPaneLayoutController() {
		//TODO Implement tests.
	}
	//TODO White documentation for initialize
	/**
	 * Purpose here <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	@FXML
	private void initialize() {
		//TODO Implement tests.

		//TODO Implement tests for initialize in TreeScrollPaneLayoutController
		//TODO add function to initialize dropdown button with options for period to analyze
		
	}

	//TODO White documentation for setMain
	/**
	 * Is called by the main application to give a reference back to itself.
	 * Once the link is set, it calls the function to setup the head of the tree. <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public void setMain(Main main) {
		//TODO Implement tests.
		this.main = main;
		setupHead();
	}

	//TODO White documentation for setupHead
	/**
	 * Purpose here <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public void setupHead() {
		//TODO Implement tests.
		//headKPI = new KPI(0, (new int[] { 1, 2 }), "Opex/Oz");
		KPI headKPI = main.getkpiData().get(0);
		
		GridPane head = buildGridPane(headKPI, startX, startY);
		//TODO verify why is this yellow
		treeAnchorPane.setTopAnchor(head, startY);
		treeAnchorPane.setLeftAnchor(head, startX);
		treeAnchorPane.getChildren().addAll(head);
	}
	
	//TODO White documentation for buildGridPane
	/**
	 * Purpose here <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	private GridPane buildGridPane(KPI kpi, double X, double Y) {
		//TODO Implement tests.
		//TODO make treeGrid pretty
		GridPane treeGrid = new GridPane();
		treeGrid.setGridLinesVisible(true);
		//set main grid constraints
		treeGrid.getColumnConstraints().add(new ColumnConstraints(150));
		treeGrid.getRowConstraints().add(new RowConstraints(18));
		treeGrid.getRowConstraints().add(new RowConstraints(54));
		treeGrid.getRowConstraints().add(new RowConstraints(18));

		//call helper functions to build nested grids
		GridPane firstRowGrid = buildFirstRowGrid(kpi, X, Y);
		//TODO helper function for row two
		//TODO helper function for row three
		treeGrid.getChildren().addAll(firstRowGrid);

		return treeGrid;
	}

	//TODO White documentation for buildFirstRowGrid
	/**
	 * Purpose here <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	private GridPane buildFirstRowGrid(KPI kpi, final double X, final double Y) {

		//TODO Implement tests.
		int id = kpi.getId();
		String name = kpi.getName();
		final int[] childrenID = kpi.getChildren();

		GridPane firstRowGrid = new GridPane();
		firstRowGrid.setGridLinesVisible(true);
		firstRowGrid.getColumnConstraints().add(new ColumnConstraints(132));
		firstRowGrid.getColumnConstraints().add(new ColumnConstraints(18));
		firstRowGrid.getRowConstraints().add(new RowConstraints(18));

		// insert the KPI name
		Label kpiName = new Label(name);
		firstRowGrid.add(kpiName, 0, 0);

		// insert button to deploy tree
		Button btNext = new Button();
		btNext.setId("btNext: " + id);

		// defines the action the button will perform
		//TODO make btNext pretty
		btNext.setOnAction(new EventHandler<ActionEvent>() {

			//TODO White documentation for handle
			/**
			 * Purpose here <br>
			 * REQUIRES:  <br>
			 * MODIFIES:  <br>
			 * EFFECTS:   <br>
			 */
			public void handle(ActionEvent e) {
				deploy(childrenID, X, Y);
			}
		});
		btNext.prefHeight(18);
		btNext.prefWidth(30);
		firstRowGrid.add(btNext, 1, 0);

		return firstRowGrid;
	}

	//TODO White documentation for deploy
	/**
	 * Purpose here <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	protected void deploy(int[] childrenID, double X, double Y) {

		double nextX = X + 180;
		double nextY = Y + 10;
		//TODO finish the method. 
		//TODO Implement tests.
		for (int childID : childrenID) {
			//TODO Define better method for getting the KPI from the list...
			KPI child = main.getkpiData().get(childID);
			GridPane childGrid = buildGridPane(child, nextX, nextY);
			treeAnchorPane.setTopAnchor(childGrid, nextY);
			treeAnchorPane.setLeftAnchor(childGrid, nextX);
			treeAnchorPane.getChildren().addAll(childGrid);
			nextX = nextX + 180;
			nextY = nextY + 10;
		}
	}

}