/**
 * @author Andre Furlan
 * 
 */

package simpletree;


import simpletree.exceptions.FXMLLoadException;
import simpletree.model.KPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialogs;
import javafx.scene.control.ScrollPane;

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

	@FXML
	private void handleExit() {
		 System.exit(0);
	}
	
	@FXML
	private void handleAbout() {
		 Dialogs.showInformationDialog(Main.getInstance().getPrimaryStage(), "Author: André Furlan Bueno \nhttps://github.com/andrefurlan/simpletree" , "Simple Tree Deployment", "About");
	}
	
	
	@FXML
	private void handleChangeTitle() {
		Main.getInstance().setPrimaryStageTitle("new title");
	}

	@FXML
	private void handleImportData() {
		
		
		importDataStub();
		
		try {
			loadScrollPane();
		} catch (FXMLLoadException e) {
			System.out.println(e.getMessage());
		}
		
		
		Main.getInstance().getRootLayout().setCenter(scrollPane);
		
		addTreeHead();
		
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
	}
	private void importDataStub() {
		ObservableList<KPI> kpiData = FXCollections.observableArrayList();
		
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
	
	private void addTreeHead() {
		// TODO Auto-generated method stub
		
	}





	@FXML
	private void handleSaveData() {
////	      File personFile = main.getKPIFilePath();
//	      if (personFile != null) {
////	          main.saveKPIDataToFile(personFile);
//	      } else {
//	          handleSaveAs();
//	      }
	  }
	
	private void handleSaveAs() {
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