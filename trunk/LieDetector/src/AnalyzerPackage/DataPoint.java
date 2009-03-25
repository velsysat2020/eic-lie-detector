package AnalyzerPackage;

public class DataPoint {
	private float intensity;
	private float frequency;
	private int timestamp;

	public DataPoint(){
		
	}
	
	public DataPoint(float intensity, float frequency, int timestamp){
		this.setIntensity(intensity);
		this.setFrequency(frequency);
		this.setTimestamp(timestamp);		
	}

	public void setIntensity(float intensity) {
		this.intensity = intensity;
	}

	public float getIntensity() {
		return intensity;
	}

	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	public float getFrequency() {
		return frequency;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public int getTimestamp() {
		return timestamp;
	}
	 public String toString(){
  	   return "Datapoint " + intensity + ", " + frequency + ", " + timestamp;
     }
	
	
}
