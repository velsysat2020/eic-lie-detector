package AnalyzerPackage;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Driver {

	// Analyzer A;

	int stressResp, relaxResp;
	public static ArrayList<Snapshot> response = null;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		GUI g = new GUI();
		g.createAndShowGUI();
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