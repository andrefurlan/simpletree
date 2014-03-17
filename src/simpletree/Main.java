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
	private Stage primaryStage;
	private static Main instance;
	
	public Main() {
		instance = this;
	}

	
	@Override
	public void start(Stage primaryStage) throws FXMLLoadException, CSSLoadException {
		// TODO Implement tests.
		
		String rootLayoutPath = "view/RootLayout.fxml";
		String cssPath = "view/MainTheme.css";
		String title = "Simple Tree Deployment";
		this.primaryStage = primaryStage;

		// Creates the load object for the root layout and loads the rootLayout
		FXMLLoader rootLoader = new FXMLLoader(getClass().getResource(rootLayoutPath));
		try {
			this.rootLayout = rootLoader.load();
		} catch (Exception e) {
			throw new FXMLLoadException("Failed to load the file: " + rootLayoutPath);
		}

		// sets the first scene
		Scene firstScene = new Scene(rootLayout);
		setPrimaryStageScene(firstScene);

		//TODO change this later so that the style can be changed
		// ADD CSS FILE
		try {
			firstScene.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
		} catch (Exception e) {
			throw new CSSLoadException("Failed to load the file: " + cssPath);
			
		}
		
		// sets the primaryStage title
		setPrimaryStageTitle(title);
		primaryStage.show();
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
	 */
	public void setPrimaryStageScene(Scene scene) {
		this.primaryStage.setScene(scene);
	}

	/**
	 * @return the instance
	 */
	public static Main getInstance() {
		return instance;
	}

}
	
