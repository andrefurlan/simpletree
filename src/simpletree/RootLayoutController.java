/**
 * @author Andre Furlan
 * 
 */

package simpletree;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Dialogs;
import javafx.stage.FileChooser;

public class RootLayoutController {

	private Main main;

	public RootLayoutController() {

	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleExit() {
		 System.exit(0);
	}
	
	@FXML
	private void handleAbout() {
		 Dialogs.showInformationDialog(main.getPrimaryStage(), "Author: André Furlan Bueno \nhttps://github.com/andrefurlan/simpletree" , "Simple Tree Deployment", "About");
	}
	

	@FXML
	private void handleImportData() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showOpenDialog(main.getPrimaryStage());

		if (file != null) {
			main.loadKPIDataFromFile(file);
		}
	}

	@FXML
	private void handleSaveData() {
	      File personFile = main.getKPIFilePath();
	      if (personFile != null) {
	          main.saveKPIDataToFile(personFile);
	      } else {
	          handleSaveAs();
	      }
	  }
	
	private void handleSaveAs() {
	    FileChooser fileChooser = new FileChooser();

	    // Set extension filter
	      FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
	              "XML files (*.xml)", "*.xml");
	    fileChooser.getExtensionFilters().add(extFilter);

	    // Show save file dialog
	    File file = fileChooser.showSaveDialog(main.getPrimaryStage());

	    if (file != null) {
	      // Make sure it has the correct extension
	      if (!file.getPath().endsWith(".xml")) {
	        file = new File(file.getPath() + ".xml");
	      }
	      main.saveKPIDataToFile(file);
	    }
	  }
}