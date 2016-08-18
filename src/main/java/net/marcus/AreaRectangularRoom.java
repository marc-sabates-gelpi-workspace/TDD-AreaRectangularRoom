package net.marcus;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AreaRectangularRoom {

	private static final Pattern FOOT_PATTERN = Pattern.compile("(\\d+(?:\\.\\d+)?)ft");
	private static final Pattern METER_PATTERN = Pattern.compile("(\\d+(?:\\.\\d+)?)m");
	private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+(?:\\.\\d+)?)");
	private static final int SCALE = 3;
	private static final BigDecimal squareMetersInASquareFeet = new BigDecimal("0.09290304");
	
	public static final void main(String burps[]){
		try(Scanner scanner = new Scanner(System.in)) {
			MeasureInput length = retrieveInput(scanner, "What is the length of the room? ");
			MeasureInput width = retrieveInput(scanner, "What is the width of the room? ");
			
			if(length.getUnit() == width.getUnit()){
				System.out.println(String.format("You entered dimensions: %s %s by %s %s.\nThe area is", length.getMeasure(), length.getUnit(), width.getMeasure(), width.getUnit()));

				BigDecimal convertedArea, calculatedArea = AreaRectangularRoom.area(new BigDecimal(length.getMeasure()), new BigDecimal(width.getMeasure()));
				if(length.getUnit() == MeasureInput.Unit.FEET){
					convertedArea = AreaRectangularRoom.squareFeetToSquareMeters(calculatedArea);					
					System.out.println(String.format("%s square %s", calculatedArea.toPlainString(), MeasureInput.Unit.FEET));
					System.out.println(String.format("%s square %s", convertedArea.toPlainString(), MeasureInput.Unit.METERS));
				}else{
					convertedArea = AreaRectangularRoom.squareMetersToSquareFeet(calculatedArea);
					System.out.println(String.format("%s square %s", convertedArea.toPlainString(), MeasureInput.Unit.FEET));
					System.out.println(String.format("%s square %s", calculatedArea.toPlainString(), MeasureInput.Unit.METERS));
				}
			} else {
				System.out.println(String.format("You entered mixed up dimensions: %s %s by %s %s.", length.getMeasure(), length.getUnit(), width.getMeasure(), width.getUnit()));
			}
		}
	}
	

	public static BigDecimal area(BigDecimal length, BigDecimal width) {
		return length.multiply(width).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal squareFeetToSquareMeters(BigDecimal squareFeets) {
		return squareFeets.multiply(squareMetersInASquareFeet).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal squareMetersToSquareFeet(BigDecimal squareMeters) {
		return squareMeters.divide(squareMetersInASquareFeet, SCALE, BigDecimal.ROUND_HALF_UP);
	}
	
	private static MeasureInput retrieveInput(Scanner scanner, String prompt) {
		String input;
		do {
			System.out.print(prompt);
			input = scanner.next();
		} while (isNotAValidInput(input, p -> !NUMBER_PATTERN.matcher(p).matches()
												&& !FOOT_PATTERN.matcher(p).matches()
												&& !METER_PATTERN.matcher(p).matches()));
		
		return convertMeasure(input);
	}
	
	private static MeasureInput convertMeasure(String input) {
		Matcher matcher = METER_PATTERN.matcher(input);
		if(matcher.matches()){
			return new MeasureInput(matcher.group(1),MeasureInput.Unit.METERS);
		}
		
		matcher = FOOT_PATTERN.matcher(input);
		if(matcher.matches()){
			return new MeasureInput(matcher.group(1),MeasureInput.Unit.FEET);
		}
		
		matcher = NUMBER_PATTERN.matcher(input);
		matcher.matches();
		return new MeasureInput(matcher.group(1));
	}


	private static boolean isNotAValidInput(String input, Predicate<String> predicate) {
		return predicate.test(input);
	}

}
