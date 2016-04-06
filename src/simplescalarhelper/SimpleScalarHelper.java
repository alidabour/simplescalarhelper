/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplescalarhelper;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ali
 */
public class SimpleScalarHelper extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GetFile getfile1=new GetFile("1.txt"); 
        GetFile getfile2=new GetFile("2.txt"); 
        GetFile getfile3=new GetFile("3.txt"); 
        GetFile getfile4=new GetFile("4.txt"); 
        GetFile getfile5=new GetFile("5.txt"); 
        GetFile getfile6=new GetFile("6.txt"); 
        GetFile getfile7=new GetFile("7.txt"); 
        GetFile getfile8=new GetFile("8.txt"); 
        GetFile getfile9=new GetFile("9.txt"); 
        GetFile getfile10=new GetFile("10.txt"); 
        GetFile getfile11=new GetFile("11.txt"); 
        GetFile getfile12=new GetFile("12.txt"); 
        Chart chart=new Chart(getfile1.getFileToString()
        ,getfile2.getFileToString(),getfile3.getFileToString(),
        getfile4.getFileToString(),getfile5.getFileToString()
        ,getfile6.getFileToString(),getfile7.getFileToString(),
        getfile8.getFileToString(),getfile9.getFileToString(),
        getfile10.getFileToString(),getfile11.getFileToString(),
        getfile12.getFileToString());
        
        GridPane gridpane =new GridPane();
        
        Label l1CacheL=new Label("Level 1 Cache :");
        Label l1CacheNameL = new Label("Level 1 Cache Name:");
        Label l1CacheNoOfSetsL = new Label("Level 1 Cache No. of Sets:");
        Label l1CacheBlockSizeL = new Label("Level 1 Cache Block Size:");
        Label l1CacheSetsAssociativityL = new Label("Level 1 Cache No. of Associativity:");
        Label l1CacheReplacementPolicyL=new Label("Level 1 Cache Replacement Policy:");
        Label outputFileNameL=new Label("Output File Name :");
        TextField l1CacheNameT = new TextField();
        final ComboBox l1CacheNoOfSetsCB = new ComboBox();
        l1CacheNoOfSetsCB.getItems().addAll(
            "32",
            "64",
            "128",
            "256",
            "512"  
        );
        TextField l1CacheBlockSizeT = new TextField();
        final ComboBox l1CacheSetsAssociativityCB = new ComboBox();
        l1CacheSetsAssociativityCB.getItems().addAll("1","2","4","8");
        ComboBox l1CacheReplacementPolicyCB=new ComboBox();
        l1CacheReplacementPolicyCB.getItems().addAll("l","f","r");
        TextField outputFileNameT=new TextField();
        TextArea output=new TextArea();
        Button help = new Button();
        Button plot = new Button();
        plot.setText("Plot");
        Scene s=chart.draw(primaryStage);
        plot.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                        Scene s=chart.draw(primaryStage);
                        Stage ss=new Stage();
                        ss.setScene(s);
                        ss.setTitle("Chart");
                        ss.show();
                        
            }
            
        });
              
        
        help.setText("Help");
        help.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                output.setText("./sim-cache -redir:sim "
                        +outputFileNameT.getText()+".txt "
                        +"-cache:il1 "+
                        l1CacheNameT.getText()+":"+
                        l1CacheNoOfSetsCB.getValue().toString()+":"+
                        l1CacheBlockSizeT.getText()+":"+
                        l1CacheSetsAssociativityCB.getValue().toString()+":"
                        +l1CacheReplacementPolicyCB.getValue().toString()+" "
                        +"-cache:il2 none -cache:dl1 none -cache:dl2"
                        + " none -tlb:itlb none -tlb:dtlb none");
                
            }
        });
        
        
        gridpane.add(l1CacheL,0,0);
        gridpane.add(l1CacheNameL,0,1);
        gridpane.add(l1CacheNoOfSetsL,0,2);
        gridpane.add(l1CacheBlockSizeL,0,3);
        gridpane.add(l1CacheSetsAssociativityL,0,4);
        gridpane.add(l1CacheReplacementPolicyL,0,5);
        gridpane.add(outputFileNameL,0,6);

        gridpane.add(l1CacheNameT,1,1);
        gridpane.add(l1CacheNoOfSetsCB,1,2);
        gridpane.add(l1CacheBlockSizeT,1,3);
        gridpane.add(l1CacheSetsAssociativityCB,1,4);
        gridpane.add(l1CacheReplacementPolicyCB,1,5);
        gridpane.add(outputFileNameT,1,6);
        gridpane.add(help,0,7);
        gridpane.add(output,1,7);
        gridpane.add(plot,0,8,2,1);

        
        StackPane root = new StackPane();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridpane);
        root.getChildren().add(scrollPane);
        
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("SimpleScalar Helper Sim-Cache");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
