import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;

public class Challenge7
{
    private static TextField textFieldRank; 
    private static TextField textFieldUni; 
    private static TextField textFieldCountry; 
    private static ListView<University> uniListView;
    private static ArrayList<University> uniArrList = new ArrayList<University>();
    private static University currentlySelectedUniversity = null;
    
    public static void main(String args[]){
        launchFX(); 
    }
    
    private static void launchFX(){
        new JFXPanel();
        Platform.runLater(() -> initialiseGUI());
    }
    
    private static void initialiseGUI(){
        Stage stage = new Stage();
        stage.setTitle("Top Universities by Sam");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we)->terminate());
        stage.show();
        
        uniListView = new ListView<University>();
        uniListView.setLayoutX(700);
        uniListView.setLayoutY(50);
        uniListView.setOnMouseClicked((MouseEvent me) -> {
                currentlySelectedUniversity = uniListView.getSelectionModel().getSelectedItem();
            });
        rootPane.getChildren().add(uniListView);
        updateListView();
       
        Label label = new Label();
        label.setText("Enter details of top university");
        label.setLayoutX(50);
        label.setLayoutY(50);
        rootPane.getChildren().add(label);
        
        textFieldRank = new TextField();
        textFieldRank.setLayoutX(50);
        textFieldRank.setLayoutY(100);
        textFieldRank.setPrefWidth(400);
        textFieldRank.setPromptText("Enter Ranking");
        rootPane.getChildren().add(textFieldRank);
        
        textFieldUni = new TextField();
        textFieldUni.setLayoutX(50);
        textFieldUni.setLayoutY(150);
        textFieldUni.setPrefWidth(400);
        textFieldUni.setPromptText("Enter University");
        rootPane.getChildren().add(textFieldUni);
        
        textFieldCountry = new TextField();
        textFieldCountry.setLayoutX(50);
        textFieldCountry.setLayoutY(200);
        textFieldCountry.setPrefWidth(400);
        textFieldCountry.setPromptText("Enter Country");
        rootPane.getChildren().add(textFieldCountry);
        
        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(50);
        btn.setLayoutY(250);
        btn.setOnAction((ActionEvent ae) -> addNewItem());
        rootPane.getChildren().add(btn); 
        
        Button deletebtn = new Button();
        deletebtn.setText("Delete");
        deletebtn.setLayoutX(100);
        deletebtn.setLayoutY(250);
        deletebtn.setOnAction((ActionEvent ae) -> deleteItem());
        rootPane.getChildren().add(deletebtn);
    }
       
    private static void deleteItem(){
        uniArrList.remove(currentlySelectedUniversity);
        updateListView();
    }
    
    private static void terminate(){
        System.out.println("bye, bye!");
        System.exit(0);
    }
    
    private static void addNewItem(){
        int ranking = Integer.parseInt(textFieldRank.getText());
        String name = textFieldUni.getText();
        String country = textFieldCountry.getText();
        uniArrList.add(new University(ranking, name, country));
        
        updateListView();
    }
    
    private static void updateListView(){
        uniListView.getItems().clear();
        
        for(University uni : uniArrList){
            uniListView.getItems().add(uni);
        }
    }
}