/**
 * @author André Furlan Bueno "o3d9"
 *
 */

package simpletree;

import simpletree.exceptions.CSSLoadException;
import simpletree.exceptions.FXMLLoadException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/**
 * Class for the main application. It creates the first stage and set the first
 * scene
 */

public class Main extends Application {

	private BorderPane rootLayout;
	private BorderPane rootLayoutCenter;
	private Stage primaryStage;
	private static Main instance;
	
	public Main() {
		instance = this;
	}

	
	@Override
	public void start(Stage primaryStage) throws FXMLLoadException, CSSLoadException {
		// TODO Implement tests.
		
		this.primaryStage = primaryStage;

		
		loadRootLayout("view/RootLayout.fxml");

		// sets the first scene
		Scene firstScene = new Scene(rootLayout);
		String cssPath = "view/MainTheme.css";
		setPrimaryStageScene(firstScene, cssPath);

		//TODO change this later so that the style can be changed
		
		
		// sets the primaryStage title
		String title = "Simple Tree Deployment";
		setPrimaryStageTitle(title);
		primaryStage.show();
	}

	private void loadRootLayout(String path) throws FXMLLoadException {
		// Creates the load object for the root layout and loads the rootLayout
		
		FXMLLoader rootLoader = new FXMLLoader(getClass().getResource(
				path));
		try {
			this.rootLayout = rootLoader.load();
		} catch (Exception e) {
			throw new FXMLLoadException("Failed to load the file: " + path);
		}
		
	}


	/**
	 * Launches the application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
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
	
