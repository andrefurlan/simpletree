/**
 * @author Andre Furlan
 * 
 */

package simpletree;


import simpletree.exceptions.FXMLLoadException;
import simpletree.model.Kpi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialogs;
import javafx.scene.control.ScrollPane;

public class RootLayoutController {

	private ScrollPane scrollPane;
	private static RootLayoutController instance;
	private ObservableList<Kpi> kpiData = FXCollections.observableArrayList();

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
		//TODO fix this
		//		 Dialogs.showInformationDialog(Main.getInstance().getPrimaryStage(), "Author: Andr� Furlan Bueno \nhttps://github.com/andrefurlan/simpletree" , "Simple Tree Deployment", "About");
	}
	
	
	@FXML
	private void handleChangeTitle() {
		Main.getInstance().setPrimaryStageTitle("new title");
	}

	@FXML
	private void handleImportData() {
		
		//TODO datastub...
		//importDataStub();
		

		
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
		
		Main.getInstance().getRootLayout().setCenter(scrollPane);
		
		ScrollPaneController.getInstance().setupHead();
	}
	private void importDataStub() {
		
//		kpiData.add(new Kpi(0, (new int[] { 1, 2 }), "Opex/Oz"));
//  		kpiData.add(new Kpi(1, (new int[] {}), "Opex (USD)"));
//  		kpiData.add(new Kpi(2, (new int[] { 3, 4, 5, 6, 7 }),
//  				"Equivalent Ounces"));
//  		kpiData.add(new Kpi(3, (new int[] {}), "Throughtput"));
//  		kpiData.add(new Kpi(4, (new int[] {}), "Gold Back Grade"));
//  		kpiData.add(new Kpi(5, (new int[] {}), "Crushing Throughput"));
//  		kpiData.add(new Kpi(6, (new int[] { 8, 9 }), "Mill Throughput"));
//  		kpiData.add(new Kpi(7, (new int[] {}), "Global Recovery"));
//  		kpiData.add(new Kpi(8, (new int[] {}), "Work Index"));
//  		kpiData.add(new Kpi(9, (new int[] {}), "Availability"));
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