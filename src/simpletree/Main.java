/**
 * @author Andre Furlan
 *
 */

package simpletree;

import javax.jws.Oneway;

import simpletree.model.KPI;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * Class for the main application. It creates the first stage and set the first
 * scene
 */

public class Main extends Application {

	private BorderPane rootLayout;
	private ScrollPane treeScrollPane;
	private ObservableList<KPI> kpiData = FXCollections.observableArrayList();
	

	/**
	 * Constructor for the Main Class. Adds the data <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public Main() {
		//TODO Implement tests.
		//TODO Implement way to read more complex data from database
		//FIXME  Implement way to read more complex data from xml files
		// Adds some sample data
		kpiData.add(new KPI(0, (new int[] { 1, 2 }), "Opex/Oz"));
		kpiData.add(new KPI(1, (new int[] {}), "Opex (USD)"));
		kpiData.add(new KPI(2, (new int[] { 3, 4, 5, 6, 7 }),
				"Equivalent Ounces"));
		kpiData.add(new KPI(3, (new int[] {}), "Throughtput"));
		kpiData.add(new KPI(4, (new int[] {}), "Gold Back Grade"));
		kpiData.add(new KPI(5, (new int[] {}), "Crushing Throughput"));
		kpiData.add(new KPI(6, (new int[] { 8, 9 }), "Mill Throughput"));
		kpiData.add(new KPI(7, (new int[] {}), "Global Recovery"));
		kpiData.add(new KPI(8, (new int[] {}), "Work Index"));
		kpiData.add(new KPI(9, (new int[] {}), "Availability"));
		
	}


	
	/**
	 * Starts the primary stage from rootLayout <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	@Override
	public void start(Stage primaryStage) {
		//TODO Implement tests.
		try {

			//TODO create helper function to load and define controller for all views in the main class
			
			// loads the FXML file with the root layout interface
			FXMLLoader rootLoader = new FXMLLoader(
					Main.class.getResource("view/RootLayout.fxml"));
			setRootLayout((BorderPane) rootLoader.load());

			// sets the first scene
			Scene firstScene = new Scene(rootLayout);

			// sets the primaryStage
			primaryStage.setTitle("Simple Tree Deployment");
			primaryStage.setScene(firstScene);

			// Gives RootLayoutController permission to call methods that
			// requires the primary scene
			RootLayoutController controller = rootLoader.getController();
			controller.setMain(this);

			showTreeScrollPane();

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	
	
	/**
	 * Purpose <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public void showTreeScrollPane() {
		//TODO Implement tests.
		try {
			//TODO modify to use helper function
			FXMLLoader ScrollPaneLoader = new FXMLLoader(
					Main.class.getResource("view/TreeScrollPaneLayout.fxml"));
			setTreeScrollPane((ScrollPane) ScrollPaneLoader.load());
			TreeScrollPaneLayoutController controller = ScrollPaneLoader.getController();
			controller.setMain(this);

			rootLayout.setCenter(getTreeScrollPane());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Purpose <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public ObservableList<KPI> getkpiData() {
		//TODO Implement tests.
		return kpiData;
	}

	/**
	 * Purpose <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public BorderPane getrootLayout() {
		//XXX Implement tests.
		return rootLayout;
	}

	/**
	 * Purpose <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public void setRootLayout(BorderPane rootLayout) {
		//XXX Implement tests.
		this.rootLayout = rootLayout;
	}
	
	/**
	 * Purpose <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public BorderPane getRootLayout() {
		//TODO Implement tests.
		return rootLayout;
	}
	
	/**
	 * Purpose here <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public ScrollPane getTreeScrollPane() {
		//TODO Implement tests.
		return treeScrollPane;
	}

	/**
	 * Purpose here <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public void setTreeScrollPane(ScrollPane treeScrollPane) {
		//TODO Implement tests.
		this.treeScrollPane = treeScrollPane;
	}
	
	/**
	 * Purpose here <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
