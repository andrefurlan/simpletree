/**
 * @author Andre Furlan
 * 
 */

package simpletree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import simpletree.model.Kpi;
import simpletree.model.KpiData;
import simpletree.model.PeriodOptions;
import simpletree.model.TreeNode;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ScrollPaneController {

	@FXML
	private AnchorPane treeAnchorPane;
	private final double startX = 20.0;
	private final double startY = 100;
	private PeriodOptions periodSelection;
	private double difMInY = 0.0;
	private double paneHeight = 0.0;
	private double paneWidth = 0.0;
	private static ScrollPaneController instance;
	private List<TreeNode> tree;
	private KpiData data;

	public ScrollPaneController() {
		instance = this;
	}

	@FXML
	private void initialize() {


		// TODO Implement tests.
		tree = new LinkedList<TreeNode>();

		// TODO delete stub later
		data = new KpiData();
		setupHead();
		// TODO Implement tests for initialize in TreeScrollPaneLayoutController

		
	}



	public void setupHead() {
		// TODO Implement tests.

		// TODO implement a way to find the head based on the relationship
		// between the kpis

		
		TreeNode head = new TreeNode(data.getHead());
		//head.setX(Main.getInstance().getTreeScrollPane().getHeight());
		head.setY(startY);
		head.setX(startX);
		tree.add(head);
		buildTree();

	}

	public void deploy(TreeNode treeNode) {

		Kpi kpi = treeNode.getKpi();
		Kpi parent = data.getKpiById(kpi.getParent());
		Set<Integer> childrenSet = kpi.getChildrenSet();
		double width = treeNode.getGridPane().getWidth();
		double height = treeNode.getGridPane().getHeight();
		double space = 18;
		treeAnchorPane.getChildren().clear();
		clearTree(treeNode);

		if (!childrenSet.isEmpty()) {

			double levelHeight = childrenSet.size() * height
					+ (childrenSet.size() - 1) * (space);
			double start = treeNode.getY() + (height / 2) - (levelHeight / 2);
			int i = 0;
			for (int childId : childrenSet) {
				TreeNode child = new TreeNode(data.getKpiById(childId));
				child.setY(start + (height + space) * i);
				child.setX(treeNode.getX() + (width + space * 2));
				tree.add(child);
				i++;
			}

			adjustCoordinates();

		}

		
		buildTree();
		System.out.println(tree.size());
	}

	private void buildTree() {
		for (TreeNode tn : tree) {
			AnchorPane.setTopAnchor(tn.getGridPane(), tn.getY());
			AnchorPane.setLeftAnchor(tn.getGridPane(), tn.getX());
			treeAnchorPane.getChildren().addAll(tn.getGridPane());
		}

	}

	private void adjustCoordinates() {
		double minY = 100000.0;
		double maxY = 0.0;
		double minX = 100000.0;
		double maxX = 0.0;

		for (TreeNode tn : tree) {
			minY = Math.min(minY, tn.getY());
			maxY = Math.max(maxY, tn.getY());
			minX = Math.min(minX, tn.getX());
			maxX = Math.max(maxX, tn.getX());
		}

		maxY = maxY + 92.0;
		maxX = maxX + 180;
		difMInY = 100.0 - minY;
		System.out.println(Main.getInstance().getTreeScrollPane().getHeight());
		paneHeight = Main.getInstance().getTreeScrollPane().getViewportBounds().getHeight();
		double right = Math.max(maxX, paneWidth);
		double bottom = Math.max(maxY, paneHeight);

		for (TreeNode tn : tree) {
			double Y = tn.getY();
			tn.setY(Y + difMInY);

		}

		// this is a very stupid workaround to make the tree appear where I want
		// it to be, with paddings.
		// it happens that the scrollpane is very stubborn

		Label bLabel = new Label("blabel");
		Label tLabel = new Label("tlabel");
		bLabel.setVisible(false);
		tLabel.setVisible(false);
		AnchorPane.setTopAnchor(bLabel, maxY + difMInY + 100);
		AnchorPane.setLeftAnchor(bLabel, 5.0);
		AnchorPane.setTopAnchor(tLabel, 5.0);
		AnchorPane.setLeftAnchor(tLabel, maxX + 100);
		treeAnchorPane.getChildren().addAll(bLabel, tLabel);

	}

	private void clearTree(TreeNode treeNode) {

		for (Iterator<TreeNode> it = tree.iterator(); it.hasNext();)
			if (it.next().getX() > treeNode.getX())
				it.remove();

	}

	//*****************GETTERS****************
	
	/**
	 * @return the instance
	 */
	public static ScrollPaneController getInstance() {
		return instance;
	}

	public void setPeriodSelection(PeriodOptions selection) {
		this.periodSelection = selection;
	}

	public PeriodOptions getPeriodSelection() {
		return this.periodSelection;
	}
	
}
