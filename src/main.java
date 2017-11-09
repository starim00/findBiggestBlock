import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class main extends Application{
    public void start(Stage primaryStage){
        Scene scene = refresh();
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public Scene refresh(){
        GridPane root = new GridPane();
        GridPane toolBar =new GridPane();
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        Label[][] labels = new Label[10][10];
        int[][] block = new int[10][10];
        for(int i = 0;i<10;i++) {
            for (int j = 0; j < 10; j++) {
                board.add(labels[i][j] = new Label(), j, i);
                labels[i][j].setStyle("-fx-alignment: center");
                labels[i][j].setStyle("-fx-border-color: black");
                labels[i][j].setText(Integer.toString(Math.random() > 0.5 ? 1 : 0));
                block[i][j] = Integer.parseInt(labels[i][j].getText());
                labels[i][j].setPrefSize(55, 55);
            }
        }
        Button button1 = new Button();
        button1.setText("Refresh");
        Button button2 = new Button();
        button2.setText("find");
        toolBar.add(button1,1,1);
        toolBar.add(button2,2,1);
        root.add(board,1,1);
        root.add(toolBar,1,2);
        Scene scene = new Scene(root,550,600);
        return scene;
    }
}
