package simpletree.tests;

import static org.junit.Assert.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simpletree.Main;

public class MainTests {

	
	@BeforeClass
	public static void initJFX() {
	    Thread t = new Thread("JavaFX Init Thread") {
	        public void run() {
	            Application.launch(Main.class, new String[0]);
	        }
	    };
	    t.setDaemon(true);
	    t.start();
	}
	
	
	
	public static class SimpleTree extends Application {
		private Stage primaryStage;
		@Override
	    public void start(Stage primaryStage) throws Exception {
	        //this.primaryStage = primaryStage;
	    }
		
		@Test
		public void testTitle() {
			assertTrue(primaryStage.getTitle().equals("Simple Tree Deployment"));
		}
	}


	 

	
}
