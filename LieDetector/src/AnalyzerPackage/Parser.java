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
			int timestamp = -1;
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				// Is this a new snapshot
				if (line.endsWith(";")) {
					// new snapshot, clear old one
					snap = new Snapshot();
					timestamp = Integer.parseInt(line.substring(0, line.indexOf(";")));

				} else if (line.startsWith("*")) {
					// done with snapshot
					response.add(snap);

				} else {
					Scanner lineScan = new Scanner(line);
					float frequency = Float.parseFloat(lineScan.next());
					float intensity = Float.parseFloat(lineScan.next());
										
					dp = new DataPoint(intensity, frequency, timestamp);
					float test = dp.getFrequency();
				
					snap.addDatapoint(dp);
					
				}

			}

		} catch (FileNotFoundException e) {
			// Error
			e.printStackTrace();
			return null;
		}

		return response;
	}

}
