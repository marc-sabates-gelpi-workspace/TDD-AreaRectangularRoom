package net.marcus;

import java.math.BigDecimal;

public class AreaRectangularRoom {

	private static final int SCALE = 3;
	private static final BigDecimal squareMetersInASquareFeet = new BigDecimal("0.09290304");
	
	public BigDecimal area(BigDecimal length, BigDecimal width) {
		return length.multiply(width).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal squareFeetsToSquareMeters(BigDecimal squareFeets) {
		return squareFeets.multiply(squareMetersInASquareFeet).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal squareMetersToSquareFeet(BigDecimal squareMeters) {
		return squareMeters.divide(squareMetersInASquareFeet, SCALE, BigDecimal.ROUND_HALF_UP);
	}
	

}
