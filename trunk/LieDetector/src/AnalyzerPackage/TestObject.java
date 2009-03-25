package AnalyzerPackage;

import java.io.File;
import java.util.ArrayList;


public class TestObject {
	String filename;
	public TestObject(String filename){
		this.filename = filename;
		
         
        
         
        
	}
	
	public String runTest(){
			File input  =  new File(filename);
		 Parser par = new Parser();
         //par.parse(input);
         
         ArrayList<Snapshot> response = null;
         response = par.parse(input);
         String ret = null;
         
         ret = response.get(1).toString();
         return ret;
             

	
	}

}
