/**
 * @author Andre Furlan
 * 
 */

package simpletree;

import javafx.fxml.FXML;


public class RootLayoutController {


	private static RootLayoutController instance;
	

	/**
	 * 
	 */
	public RootLayoutController() {
		instance = this;
		System.out.println("instantiate rootlayout");	
	}

	/**
	 * 
	 */
	@FXML
	private void initialize() {
		System.out.println("initialize rootlayout");	
	}

	
	//GETTERS
	
	/**
	 * @return controller instance
	 */
	public static RootLayoutController getInstance() {
		return instance;
	}

	
	//HANDLE
	
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

	}

	
	@FXML
	private void handleImportData() {
		
	}

	
	@FXML
	private void handleSaveData() {

	  }
	
	@FXML
	private void handleSaveDataAs() {

	  }

}