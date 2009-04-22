package AnalyzerPackage;

import java.util.*;
import java.io.*;

public class Driver {

	// Analyzer A;

	int stressResp, relaxResp;
	public static ArrayList<Snapshot> response = null;

	public static void main(String[] args) {
		
		String fileHandle = null;
		//get data file from cmd line params
		 for (String s: args) {
	            //assuming only one param
			 	fileHandle = s;
	        }
		 
		if(fileHandle == null){
			System.out.println("Error, cmd line parameter not read, exiting");
			System.exit(0);
		}
		
		//Get GUI ready
		GUIPopup g = new GUIPopup();
		g.createAndShowGUI();
		
		


		readFile(fileHandle);

		int test = runAnalysis();
		if(test == 0){
			GUIPopup.stress.setVisible(true);
			GUIPopup.unstress.setVisible(false);
		} else if(test == 1){
			GUIPopup.unstress.setVisible(true);
			GUIPopup.stress.setVisible(false);
		}
		
		
		// TODO Auto-generated method stub
		//GUI g = new GUI();
		//g.createAndShowGUI();
		/*
		 * // System.out.println("Entering Main."); // Scanner sc = new
		 * Scanner(System.in); //
		 * System.out.println("Please enter file name: ");
		 * 
		 * // String str = sc.next(); // System.out.println("File input is: "+
		 * str); // File input = new File(str); // Parser par = new Parser();
		 * //par.parse(input); //add something cool
		 */

	}

	public static void readFile(String name) {
		File input = new File(name);
		Parser par = new Parser();

		response = par.parse(input);
		for (int i = 0; i < response.size(); i++) {
			System.out.print(response.get(i).toString());
		}
	}

	public static int runAnalysis() {//could also return string
		Analyzer an = new Analyzer();
		//String ret = "";
		int ret = -1;
		if (an.judgement(response)) {
			System.out.println("Stressed Response");
		//	ret.concat("Stressed Response");
			ret = 0;
		} else {
			System.out.println("Unstressed Response");
		//	ret.concat("Unstressed Response");
			ret = 1;
		}
		return ret;
	}

}
