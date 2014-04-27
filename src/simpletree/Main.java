/**
 * @author André Furlan Bueno "o3d9"
 *
 */

package simpletree;

import simpletree.exceptions.CSSLoadException;
import simpletree.exceptions.FXMLLoadException;
import simpletree.model.PeriodOptions;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;


/**
 * Class for the main application. It creates the first stage and set the first
 * scene
 */

public class Main extends Application {

	
	private Stage primaryStage;
	private static Main instance;
	
	//RootLayout.fxml elements
	private BorderPane rootLayout;
	private MenuBar rootMenu;
	private BorderPane rootLayoutCenter;
	private ToolBar rootToolBar;
	private ScrollPane treeScrollPane;
	private ComboBox periodComboBox;
	

	
	public Main() {
		instance = this;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws FXMLLoadException, CSSLoadException {
		// TODO Implement tests.
		System.out.println("main start");	
		this.primaryStage = primaryStage;

		//loads the root layout and defines its components
		rootLayout = (BorderPane) loadLayout("view/RootLayout.fxml");

		rootMenu = (MenuBar) rootLayout.getTop();
		rootLayoutCenter = (BorderPane) rootLayout.getCenter();
		
		//loads the scroll pane and defines its position
		treeScrollPane = (ScrollPane) loadLayout("view/TreeScrollPaneLayout.fxml");
		rootLayoutCenter.setCenter(treeScrollPane);
		
		//defines rootLayout components
		rootToolBar = (ToolBar) rootLayoutCenter.getTop();
		
		//defines rootToolBar components
		periodComboBox = (ComboBox<PeriodOptions>) rootToolBar.getItems().get(0);
		ObservableList<PeriodOptions> options = 
			    FXCollections.observableArrayList(PeriodOptions.values());
		
		periodComboBox.setItems(options);
		periodComboBox.setTooltip(new Tooltip("Select the period to analyze"));
		
		
		System.out.println("set scene");	
		// sets the first scene
		Scene firstScene = new Scene(rootLayout);
		String cssPath = "view/MainTheme.css";
		setPrimaryStageScene(firstScene, cssPath);

		//TODO change this later so that the style can be changed
		
		
		// sets the primaryStage title
		String title = "Simple Tree Deployment";
		setPrimaryStageTitle(title);
		System.out.println("show primary stage");	
		primaryStage.show();
	}

	private Node loadLayout(String path) throws FXMLLoadException {
		// Creates the load object for the root layout and loads the rootLayout
		System.out.println("load rootlayout");	
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				path));
		try {
			return loader.load();
		} catch (Exception e) {
			throw new FXMLLoadException("Failed to load the file: " + path);
		} finally{
		System.out.println("finish load rootlayout");	
		}
	}


	/**
	 * Launches the application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
		System.out.println("main");	
	}
	
	
	/**
	 * @return the rootLayout
	 */
	public BorderPane getRootLayout() {
		return rootLayout;
	}


	public BorderPane getRootLayoutCenter() {
		return rootLayoutCenter;
	}

	/**
	 * @return the primaryStage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * sets the primary stage title
	 * @param title
	 */
	public void setPrimaryStageTitle(String title) {
		this.primaryStage.setTitle(title);
		
	}
	
	/**
	 * sets a new scene to the primary stage
	 * @param scene
	 * @throws CSSLoadException 
	 */
	public void setPrimaryStageScene(Scene scene, String cssPath) throws CSSLoadException {
		this.primaryStage.setScene(scene);
		// ADD CSS FILE
		try {
			scene.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
		} catch (Exception e) {
			throw new CSSLoadException("Failed to load the file: " + cssPath);

		}
	}

	/**
	 * @return the instance
	 */
	public static Main getInstance() {
		return instance;
	}

}
	
