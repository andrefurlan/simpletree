/**
 * @author Andre Furlan
 *
 */

package simpletree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.jws.Oneway;

import com.thoughtworks.xstream.XStream;

import simpletree.exceptions.CSSLoadException;
import simpletree.exceptions.FXMLLoadException;
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
	private String rootLayoutPath;
	private String cssPath;
	private String title;
	
	public Main() {
		rootLayoutPath = "view/RootLayout.fxml";
		cssPath = "view/MainTheme.css";
		title = "Simple Tree Deployment";
	}

	@Override
	public void start(Stage primaryStage) throws FXMLLoadException, CSSLoadException {
		// TODO Implement tests.
		
		
		this.primaryStage = primaryStage;
		FXMLLoader rootLoader;

		try {
			// Creates the load object for the root layout
			rootLoader = new FXMLLoader(Main.class.getResource(rootLayoutPath));
			this.rootLayout = rootLoader.load();
		} catch (Exception e) {
			throw new FXMLLoadException("Failed to load the file: " + rootLayoutPath);

		}

		// sets the first scene
		Scene firstScene = new Scene(rootLayout);

		// ADD CSS FILE
		try {
			firstScene.getStylesheets().add(
					Main.class.getResource(cssPath).toExternalForm());
		} catch (Exception e) {
			throw new CSSLoadException("Failed to load the file: " + cssPath);
			
		}

		// Gives RootLayoutController permission to call methods that
		// requires the primary scene
//		RootLayoutController controller = rootLoader.getController();
//		controller.setMain(this);

		// showTreeScrollPane();

		// Loads the view and assigns it to rootLayout



		// sets the primaryStage
		primaryStage.setTitle(title);
		primaryStage.setScene(firstScene);

		primaryStage.show();

	}

	public void showTreeScrollPane() {
		// TODO Implement tests.
		try {
			// TODO modify to use helper function
			FXMLLoader ScrollPaneLoader = new FXMLLoader(
					Main.class.getResource("view/TreeScrollPaneLayout.fxml"));
			setTreeScrollPane((ScrollPane) ScrollPaneLoader.load());
			TreeScrollPaneLayoutController controller = ScrollPaneLoader
					.getController();
			controller.setMain(this);

			rootLayout.setCenter(getTreeScrollPane());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ObservableList<KPI> getkpiData() {
		// TODO Implement tests.
		return kpiData;
	}

	public BorderPane getrootLayout() {
		// XXX Implement tests.
		return rootLayout;
	}

	public Stage getPrimaryStage() {
		// XXX Implement tests.
		return primaryStage;
	}

	public BorderPane getRootLayout() {
		// TODO Implement tests.
		return rootLayout;
	}

	public ScrollPane getTreeScrollPane() {
		// TODO Implement tests.
		return treeScrollPane;
	}

	public void setTreeScrollPane(ScrollPane treeScrollPane) {
		// TODO Implement tests.
		this.treeScrollPane = treeScrollPane;
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Loads KPI data from the specified file. The current KPI data will be
	 * replaced.
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
	 * Returns the kpi file preference, i.e. the file that was last opened. The
	 * preference is read from the OS specific registry. If no such preference
	 * can be found, null is returned.
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
	 * Sets the file path of the currently loaded file. The path is persisted in
	 * the OS specific registry.
	 * 
	 * @param file
	 *            the file or null to remove the path
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
