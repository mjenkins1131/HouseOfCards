import javafx.scene.shape.Rectangle;
import javax.swing.JLabel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class test extends Application{
	StackPane deck = new StackPane();
	BorderPane borderPane = new BorderPane();
	int counter =0;

	 
		
	public void start(Stage primaryStage){
		String s1 = "Images/";  String s2 = ".png";
		for(int i = 1; i<=54; i++){
			String s3 = Integer.toString(i);
			String two = s1.concat(s3);
			String three = two.concat(s2);
			ImageView[] card = {new ImageView(three)};
		   deck.getChildren().addAll(card);
		}
		NextHandler handle1 = new NextHandler();
		Button nextbutton = new Button("Next Card");
		nextbutton.setOnAction(handle1);
		
		ResetHandler handle2 = new ResetHandler();
		Button resetbutton = new Button("Reset Cards");
		resetbutton.setOnAction(handle2);
		
		ExitHandler handler3 = new ExitHandler();
		Button Exit = new Button("Exit");
		Exit.setOnAction(handler3);
		
		PrevHandler handler4 = new PrevHandler();
		Button prevbutton = new Button("Prev Card");
		prevbutton.setOnAction(handler4);
		
		Label top = new Label("House of cards");
		top.setTextFill(Color.BLACK);
		StackPane topPane = new StackPane();
		Rectangle toprec = new Rectangle(50,50,500,50);
		toprec.setFill(Color.RED );
		topPane.getChildren().addAll(toprec,top);

		StackPane botpane = new StackPane();
		Rectangle botrec = new Rectangle(50,50,500,50);
		botrec.setStroke(Color.BLACK);
		botrec.setFill(Color.GREEN);
		Label bot = new Label("Program designed and developed by Marvin Jenkins");
		bot.setTextFill(Color.BLACK);
		botpane.getChildren().addAll(botrec, bot);
		
		VBox Lvbox = new VBox();
	    Lvbox.setPadding(new Insets(10));
	    Lvbox.setSpacing(10);
	    Lvbox.getChildren().addAll(resetbutton,Exit);
	    
	    VBox Rvbox = new VBox();
	    Rvbox.setPadding(new Insets(10));
	    Rvbox.setSpacing(10);
	    Rvbox.getChildren().addAll(nextbutton,prevbutton);
		
		
		
		borderPane.setLeft(Lvbox);
		borderPane.setRight(Rvbox);
		borderPane.setTop(topPane);
		borderPane.setBottom(botpane);
		borderPane.setCenter(deck);
		Scene scene = new Scene(borderPane, 500, 500);
	    primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
	
	class NextHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			deck.getChildren().get(0).toFront();
			counter++;
		}
	}
	class ExitHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			System.exit(0);
		}
	}
	class PrevHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			deck.getChildren().get(53).toBack();
			counter--;
		}

	}
	class ResetHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent event) {
			
			while(counter!=0){
				if(counter>0){
				deck.getChildren().get(53).toBack();
				counter--;
				}
				else if(counter<0){
					deck.getChildren().get(0).toFront();
					counter++;
				}
			}
		}

	}

  }

 //Marvin Jenkins CSCI-1302-B 


