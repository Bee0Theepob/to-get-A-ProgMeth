package gui;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.GameLogic;

public class ControlPane extends VBox{
	
	private Text gameText;
	private Button newGameButton;
	private TicTacToePane ticTacToePane;
	
	public ControlPane(TicTacToePane ticTacToePane) {
		super();
		this.ticTacToePane = ticTacToePane;
		//To be implemented
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(20);
		initializeGameText();
		initializeNewGameButton();
		this.getChildren().addAll(gameText,newGameButton);
		
	}
	
	private void initializeGameText() {
		//To be implemented
		this.gameText = new Text("O Turn");
		this.gameText.setStyle("-fx-font-size:35;");
	}
	
	public void updateGameText(String text) {
		//To be implemented
		this.gameText.setText(text);
	}
	
	private void initializeNewGameButton() {
		//To be implemented
		this.newGameButton =new Button("New Game");
		this.newGameButton.setPrefWidth(100);
		this.newGameButton.setOnAction(e -> newGameButtonHandler());
	}
	
	private void newGameButtonHandler() {
		//To be implemented
		GameLogic.getInstance().newGame();
		this.gameText.setText("O Turn");
		for(var cell:this.ticTacToePane.getAllCells()) {
			cell.initializeCellColor();
		}
	}
}

