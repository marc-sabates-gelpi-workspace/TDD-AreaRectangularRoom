package net.marcus;

public class MeasureInput {
	public static enum Unit {FEET, METERS}
	private String measure;
	private Unit unit = Unit.FEET;
	
	public MeasureInput(String measure) {
		this.measure = measure;
	}

	public MeasureInput(String measure, Unit unit){
		this.measure = measure;
		this.unit = unit;
	}

	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
}
