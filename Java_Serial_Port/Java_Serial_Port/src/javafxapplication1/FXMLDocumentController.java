/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable 
{
BufferedReader read;  
 String[] save; 
  String[] xdata;
  String[] ydata;
  String[] Name;
 String[] save1; 
 
    @FXML
    private ScatterChart<?, ?> ScatterChart;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
 XYChart.Series series=new XYChart.Series();
 XYChart.Series series2=new XYChart.Series();

int i=0;

File file =new File("C:\\Users\\User\\Desktop\\store.txt");

try
{
read = new BufferedReader (new FileReader(file));
}
catch (FileNotFoundException ex)
{
Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
}
try
{
save = new String[read.readLine().length()];
}
catch (IOException ex)
{
Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
}
String str=null;

try
{
while((str=read.readLine()) !=null )
{
if(str.contains("hu"))
{
String[] data=str.split(",",7);

if (data!=null)
{
save[i]=data[1]+","+data[3]+","+data[5];//Arrays.toString(data)
i++;
}else{
i--;
}
}
else
{
continue;
}
}
}
catch (IOException ex) 
{
Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
}

String[] xdata= new String[i];
String[] ydata=new String[i];
String[] Name=new String[i];

for(int r=0;r<i;r++)
{    
//System.out.println(save[r]+"\n");         
String[] exploied=  save[r].split(",",3);

/*System.out.print(exploied[0]+"\n");
System.out.print(exploied[1]+"\n");
System.out.print(exploied[2]+"\n");*/
Name[r]=exploied[0];    
xdata[r]=exploied[1];
ydata[r]=exploied[2];
}
for(int data=0;data<i;data++)
{
series.getData().add(new XYChart.Data(xdata[data],Double.parseDouble(ydata[data])));
}
     
ScatterChart.setTitle("Compute Error to each ID");
ScatterChart.getData().addAll(series);  
}    
}
