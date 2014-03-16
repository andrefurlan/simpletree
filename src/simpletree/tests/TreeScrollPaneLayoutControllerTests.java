package simpletree.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

import org.junit.Before;
import org.junit.Test;

import simpletree.Main;
import simpletree.RootLayoutController;
import simpletree.TreeScrollPaneLayoutController;


public class TreeScrollPaneLayoutControllerTests {
	
	public ScrollPane TSPL;
	double xfortest1 = 30.0;
	double xfortest2 = 30.9;
	double xfortest3 = 0.0;
	double xfortest4 = -20.0;
	
	@Before
	public void Init() {
		

		try {
			FXMLLoader ScrollPaneLoader = new FXMLLoader(
					Main.class.getResource("view/TreeScrollPaneLayout.fxml"));
			TSPL = (ScrollPane) ScrollPaneLoader.load();
			TreeScrollPaneLayoutController controller = ScrollPaneLoader.getController();
			//controller.setMain(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testDeploy(int[] childrenID, double x, double y) {
		
		
		
	}

	@Test
	public void testCalcNextY(int nChildren, double y) {
		
		
	}
	
	@Test
	public void testCalcNextX(double x) {
		
		
		
	}
	
	
}
