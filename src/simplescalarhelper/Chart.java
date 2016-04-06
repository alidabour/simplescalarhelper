/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplescalarhelper;

import java.io.BufferedReader;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author ali
 */
public class Chart  {
    String cl1, cl2, cl3,
             cl4, cl5, cl6,
             cl7, cl8, cl9,
             cl10, cl11, cl12;
    
    Chart(  String c1,String c2,String c3,
            String c4,String c5,String c6,
            String c7,String c8,String c9,
            String c10,String c11,String c12){
       /* if(all.contains(".miss_rate")){
            System.out.print("YESSS");
        }
        Scanner scanner = new Scanner(all);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(all.contains(".miss_rate")){
            System.out.print(line);
        }
        }
        scanner.close();     */   
        
        int ind = c1.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl1 = c1.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c2.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl2 = c2.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c3.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl3 = c3.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c4.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl4 = c4.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c5.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl5 = c5.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c6.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl6 = c6.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c7.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl7 = c7.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c8.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl8 = c8.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c9.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl9 = c9.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c10.indexOf(".miss_rate");
                    System.out.print("Index of :"+ind);
         cl10 = c10.substring(ind+23,ind+6+23);
         System.out.print("line :"+cl1);
         
          ind = c11.indexOf(".miss_rate");
         cl11 = c11.substring(ind+23,ind+6+23);
         
          ind = c12.indexOf(".miss_rate");
         cl12 = c12.substring(ind+23,ind+6+23);

    }
     public Scene draw(Stage stage) {
        stage.setTitle("Line Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("Associativity");
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("Associativity vs Miss Ratio");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("32 sets");
        
        series1.getData().add(new XYChart.Data("1",Double.parseDouble(cl1)));
        series1.getData().add(new XYChart.Data("2", Double.parseDouble(cl2)));
        series1.getData().add(new XYChart.Data("4", Double.parseDouble(cl3)));
        series1.getData().add(new XYChart.Data("8", Double.parseDouble(cl4)));
       
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("64 sets");
        series2.getData().add(new XYChart.Data("1", Double.parseDouble(cl5)));
        series2.getData().add(new XYChart.Data("2", Double.parseDouble(cl6)));
        series2.getData().add(new XYChart.Data("4", Double.parseDouble(cl7)));
        series2.getData().add(new XYChart.Data("8", Double.parseDouble(cl8)));
        
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("128 sets");
        series3.getData().add(new XYChart.Data("1", Double.parseDouble(cl9)));
        series3.getData().add(new XYChart.Data("2", Double.parseDouble(cl10)));
        series3.getData().add(new XYChart.Data("4", Double.parseDouble(cl11)));
        series3.getData().add(new XYChart.Data("8", Double.parseDouble(cl12)));
        
        lineChart.getData().addAll(series1, series2, series3);
        return new Scene(lineChart,800,600);
        //Scene scene  = new Scene(lineChart,800,600);       
        /*lineChart.getData().addAll(series1, series2, series3);
       
        stage.setScene(scene);
        stage.show();*/
    }
    
}
