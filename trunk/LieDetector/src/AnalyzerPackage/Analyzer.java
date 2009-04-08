package AnalyzerPackage;

import java.util.*;

/*
 * Ryan McGrath and Erin Hayes Spring 2009
 * 
 * Analyzer.java processes snapshots of voice data and makes a judgement on the stress level
 * of the voice sample by comparing similar power values through the 8-12 Hz Spectrum
 */
public class Analyzer {
	
	public Analyzer(){
		
	}	
	public boolean judgement(ArrayList<Snapshot> snapArr){
		Iterator<Snapshot> iter = snapArr.iterator();
		int stressed = 0;
		int unstressed = 0;
			
		//test the snapshot to see how many stressed response
		while(iter.hasNext()){
			Snapshot snap = iter.next();
			float average = findAverage(snap);

			if(runAnalysis(snap, average)){
				stressed += 1;
			}else{
				unstressed += 1;
			}
		}
		
		if(stressed > unstressed){
			return true;
		}else{		
			return false;		
		}
	}
	
	private float findAverage(Snapshot snaps){
		float count = 0;
		float total = 0;		
		Iterator<DataPoint> iter = snaps.getData().iterator();
		
		while(iter.hasNext()){
			count++;
			total += iter.next().getIntensity();			
		}
		
		return total/count;		
	}
	
	//returns true if stressed, false if unstressed
	//Greater than 50% of DataPoints inside +/- 10% threshold determines stress 
	private boolean runAnalysis(Snapshot snap, float average){
		Iterator<DataPoint> iter = snap.getData().iterator();
		int stressed = 0;
		int unstressed = 0;
		float threshold = (float) (average * .1);
		
		while(iter.hasNext()){
			DataPoint point = iter.next();
			if((point.getIntensity() <= average + threshold) && (point.getIntensity() >= average - threshold)){
				stressed++;
			}else{
				unstressed++;
			}
		}
		if(stressed >= (snap.getNumberOfDataPoints()*.5)){
			return true;
		}else{
			return false;
		}
		
	}

}
