/*Ryan McGrath and Erin Hayes*/

package AnalyzerPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
	private ArrayList<Snapshot> response;
	private Snapshot snap;
	private DataPoint dp;

	public Parser() {
		response = new ArrayList<Snapshot>();
		snap = new Snapshot();
	}

	// get a file, create a list of snapshots and return an arraylist of them
	public ArrayList<Snapshot> parse(File theFile) {

		try {
			Scanner scan = new Scanner(theFile);
			int timestamp = 0;
			int linecount = 1;
			int offset = 4000;
			int lowFreq = 8, highFreq = 12;// for double sample rate, 16-22

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				// Is this a new snapshot
				
				if (linecount % offset >= lowFreq && linecount % offset <= highFreq) {
					if (linecount % offset == lowFreq) {
						// new snapshot, clear old one
						snap = new Snapshot();
						timestamp++;

					} 
					
					float frequency;// = Float.parseFloat(lineScan.next());
					float intensity = Float.parseFloat(line);
					
					frequency = linecount % offset;// count from 8 to 12Hz
					dp = new DataPoint(intensity, frequency, timestamp);

					snap.addDatapoint(dp);
					
					if (linecount % offset == highFreq) {
						// done with snapshot
						response.add(snap);
					}
				}
				linecount++;

			}

		} catch (FileNotFoundException e) {
			// Error
			System.out.println("Error: File Not Found.");
			e.printStackTrace();
			return null;
		}

		return response;
	}

}
