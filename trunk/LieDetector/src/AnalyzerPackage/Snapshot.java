 /** Erin Hayes and Ryan McGrath **/
package AnalyzerPackage;
import java.util.ArrayList;


public class Snapshot {
       private ArrayList<DataPoint> data;
       
       public Snapshot(){
               data = new ArrayList<DataPoint>();
       }
       
       public String printDataToString(){
               return null;        
       }
       
       public void addDatapoint(DataPoint dp){
    	   data.add(dp);
       }

       public void setData(ArrayList<DataPoint> data) {
               this.data = data;
       }

       public ArrayList<DataPoint> getData() {
               return data;
       }
       
       public int getNumberOfDataPoints(){
    	   return data.size();
       }
       
       public String toString(){//printDataToString(){
   		//iterate through datapoints, print each piece
   		String answer = "";
   		for(int i = 0; i < data.size(); i++){
   			answer += data.get(i).toString();
   		}
   		return answer;
   	}
}
 
