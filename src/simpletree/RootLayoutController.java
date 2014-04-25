/**
 * @author Andre Furlan
 * 
 */

package simpletree;

import simpletree.exceptions.FXMLLoadException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class RootLayoutController {

	private ScrollPane scrollPane;
	private static RootLayoutController instance;
	

	public RootLayoutController() {
		instance = this;
	}

	@FXML
	private void initialize() {
		
	}

	public static RootLayoutController getInstance() {
		return instance;
	}
	

	
	public ScrollPane getScrollPane(){
		return scrollPane;
	}

	@FXML
	private void handleExit() {
		 System.exit(0);
	}
	
	@FXML
	private void handleAbout() {
		//TODO fix this
		//		 Dialogs.showInformationDialog(Main.getInstance().getPrimaryStage(), "Author: André Furlan Bueno \nhttps://github.com/andrefurlan/simpletree" , "Simple Tree Deployment", "About");
	}
	
	
	@FXML
	private void handleSelectPeriod() {
		Main.getInstance().setPrimaryStageTitle("new title");
		
		
	}


	
	@FXML
	private void handleImportData() {
		
		//TODO datastub...
		

		
//		FileChooser fileChooser = new FileChooser();
//
//		// Set extension filter
//		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
//				"XML files (*.xml)", "*.xml");
//		fileChooser.getExtensionFilters().add(extFilter);
//
//		// Show save file dialog
//		File file = fileChooser.showOpenDialog(main.getPrimaryStage());
//
//		if (file != null) {
//			main.loadKPIDataFromFile(file);
//		}
		
		try {
			loadScrollPane();
		} catch (FXMLLoadException e) {
			System.out.println(e.getMessage());
		}
		BorderPane rootLayoutCenter = (BorderPane) Main.getInstance().getRootLayout().getCenter();
		
//		Main.getInstance().getRootLayout().setCenter(scrollPane);
		rootLayoutCenter.setCenter(scrollPane);
		scrollPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent e) {
	            
//	        	System.out.println("Y: " + e.getY());
	        	
	        }
	    });
		
	}

	

	private void loadScrollPane() throws FXMLLoadException {
		
		String scrollPanePath = "view/TreeScrollPaneLayout.fxml";
		FXMLLoader scrollPaneLoader = new FXMLLoader(getClass().getResource(scrollPanePath));

		try {
			this.scrollPane = (ScrollPane) scrollPaneLoader.load();
		} catch (Exception e) {
			throw new FXMLLoadException("Failed to load the file: " + scrollPanePath);
		}
		
	}
	



	@FXML
	private void handleSaveData() {
		//TODO implement save data
		//	      File personFile = main.getKPIFilePath();
//	      if (personFile != null) {
////	          main.saveKPIDataToFile(personFile);
//	      } else {
//	          handleSaveAs();
//	      }
	  }
	
	@FXML
	private void handleSaveDataAs() {
		//TODO implement save data as
//	    FileChooser fileChooser = new FileChooser();
//
//	    // Set extension filter
//	      FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
//	              "XML files (*.xml)", "*.xml");
//	    fileChooser.getExtensionFilters().add(extFilter);
//
//	    // Show save file dialog
//	    File file = fileChooser.showSaveDialog(main.getPrimaryStage());
//
//	    if (file != null) {
//	      // Make sure it has the correct extension
//	      if (!file.getPath().endsWith(".xml")) {
//	        file = new File(file.getPath() + ".xml");
//	      }
////	      main.saveKPIDataToFile(file);
//	    }
	  }
}