/**
 * @author Andre Furlan
 *
 */

package simpletree;

import java.io.File;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.jws.Oneway;

import com.thoughtworks.xstream.XStream;

import simpletree.model.KPI;
import simpletree.util.FileUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
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
	private Stage primaryStage;

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
		this.primaryStage = primaryStage;
		
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
	public Stage getPrimaryStage() {
		//XXX Implement tests.
		return primaryStage;
	}

	
	/**
	 * Purpose <br>
	 * REQUIRES:  <br>
	 * MODIFIES:  <br>
	 * EFFECTS:   <br>
	 */
	public void setPrimaryStage(Stage primaryStage) {
		//XXX Implement tests.
		this.primaryStage = primaryStage;
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

	/**
	 * Loads KPI data from the specified file. The current KPI data will
	 * be replaced.
	 * 
	 * @param file
	 */
	@SuppressWarnings("unchecked")
	public void loadKPIDataFromFile(File file) {
	  XStream xstream = new XStream();
	  xstream.alias("kpi", KPI.class);

	  try {
	    String xml = FileUtil.readFile(file);

	    ArrayList<KPI> kpiList = (ArrayList<KPI>) xstream.fromXML(xml);

	    kpiData.clear();
	    kpiData.addAll(kpiList);

	    setKPIFilePath(file);
	  } catch (Exception e) { // catches ANY exception
	    Dialogs.showErrorDialog(primaryStage,
	        "Could not load data from file:\n" + file.getPath(),
	        "Could not load data", "Error", e);
	  }
	}

	/**
	 * Saves the current KPI data to the specified file.
	 * 
	 * @param file
	 */
	public void saveKPIDataToFile(File file) {
	  XStream xstream = new XStream();
	  xstream.alias("kpi", KPI.class);

	  // Convert ObservableList to a normal ArrayList
	  ArrayList<KPI> kpiList = new ArrayList<>(kpiData);

	  String xml = xstream.toXML(kpiList);
	  try {
	    FileUtil.saveFile(xml, file);

	    setKPIFilePath(file);
	  } catch (Exception e) { // catches ANY exception
	    Dialogs.showErrorDialog(primaryStage,
	        "Could not save data to file:\n" + file.getPath(),
	        "Could not save data", "Error", e);
	  }
	}
	
	/**
	 * Returns the kpi file preference, i.e. the file that was last opened.
	 * The preference is read from the OS specific registry. If no such
	 * preference can be found, null is returned.
	 * 
	 * @return
	 */
	public File getKPIFilePath() {
	  Preferences prefs = Preferences.userNodeForPackage(Main.class);
	  String filePath = prefs.get("filePath", null);
	  if (filePath != null) {
	    return new File(filePath);
	  } else {
	    return null;
	  }
	}

	/**
	 * Sets the file path of the currently loaded file.
	 * The path is persisted in the OS specific registry.
	 * 
	 * @param file the file or null to remove the path
	 */
	public void setKPIFilePath(File file) {
	  Preferences prefs = Preferences.userNodeForPackage(Main.class);
	  if (file != null) {
	    prefs.put("filePath", file.getPath());

	    // Update the stage title
	    primaryStage.setTitle("Simple Tree Deployment- " + file.getName());
	  } else {
	    prefs.remove("filePath");

	    // Update the stage title
	    primaryStage.setTitle("Simple Tree Deployment");
	  }
	}
	
}
