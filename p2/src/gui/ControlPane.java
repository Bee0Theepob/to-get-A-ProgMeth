package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

//You might need to do something to the following line
public class ControlPane extends VBox{
	
	private Text drawnNumberText;
	private Text drawCountText;
	private Text bingoText;
	private Button drawButton;
	private Button newRoundButton;
	private NumberGrid numberGrid;

	
	public ControlPane(NumberGrid numberGrid) {
		// TODO
		this.setNumberGrid(numberGrid);
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(20);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		drawnNumberText=new Text();
		drawCountText=new Text();
		initializeBingoText();
		initializeDrawButton();
		initializeNewRoundButton();
		this.getChildren().addAll(drawnNumberText,drawButton,newRoundButton,bingoText,drawCountText);
		BingoUtil.setTextsBeginning(drawnNumberText, drawCountText);
	}
	

	private void initializeBingoText() {
		// TODO
		this.bingoText=new Text("Bingo!!");
		this.bingoText.setStyle("-fx-font-size:40;");
		this.bingoText.setVisible(false);
	}

	private void initializeDrawButton() {
		// TODO
		drawButton=new Button("Draw a number");
		drawButton.setPrefWidth(100);
		drawButton.setOnAction(e -> drawButtonHandler());
	}

	private void initializeNewRoundButton() {
		// TODO
		newRoundButton=new Button("New Round");
		newRoundButton.setPrefWidth(100);
		newRoundButton.setDisable(true);
		newRoundButton.setOnAction(e -> newRoundButtonHandler());
	}
	
	private void drawButtonHandler() {
		// TODO
		int number =BingoUtil.drawNumber();
		if(numberGrid.highlightNumber(number)) {
			this.bingoText.setVisible(true);
			this.drawButton.setDisable(true);
			this.newRoundButton.setDisable(false);
		}
		BingoUtil.updateTextsAfterDrawn(number, drawnNumberText, drawCountText);
	}
	
	private void newRoundButtonHandler() {
		// TODO
		BingoUtil.assignRandomNumbers(numberGrid.getNumberSquares());
		this.bingoText.setVisible(false);
		this.drawButton.setDisable(false);
		this.newRoundButton.setDisable(true);
		BingoUtil.setTextsBeginning(drawnNumberText, drawCountText);
	}
	public Text getDrawnNumberText() {
		return drawnNumberText;
	}

	public void setDrawnNumberText(Text drawnNumberText) {
		this.drawnNumberText = drawnNumberText;
	}

	public Text getDrawCountText() {
		return drawCountText;
	}

	public void setDrawCountText(Text drawCountText) {
		this.drawCountText = drawCountText;
	}

	public Text getBingoText() {
		return bingoText;
	}

	public void setBingoText(Text bingoText) {
		this.bingoText = bingoText;
	}

	public Button getDrawButton() {
		return drawButton;
	}

	public void setDrawButton(Button drawButton) {
		this.drawButton = drawButton;
	}

	public Button getNewRoundButton() {
		return newRoundButton;
	}

	public void setNewRoundButton(Button newRoundButton) {
		this.newRoundButton = newRoundButton;
	}

	public NumberGrid getNumberGrid() {
		return numberGrid;
	}

	public void setNumberGrid(NumberGrid numberGrid) {
		this.numberGrid = numberGrid;
	}

}
