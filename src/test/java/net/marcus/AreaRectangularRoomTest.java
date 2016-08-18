package net.marcus;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AreaRectangularRoomTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldReturnArea() {
		BigDecimal areaExpected = new BigDecimal("200.000"),
				   length = new BigDecimal("10"),
				   width = new BigDecimal("20");
		assertEquals(areaExpected, AreaRectangularRoom.area(length, width));
	}
	
	@Test
	public void shouldReturnFeets() throws Exception {
		BigDecimal squareFeets = new BigDecimal("234.5678"),
				   expectedSquareMeters = new BigDecimal("21.792");
		assertEquals(expectedSquareMeters, AreaRectangularRoom.squareFeetToSquareMeters(squareFeets));
	}
	
	@Test
	public void shouldReturnMeters() throws Exception {
		BigDecimal squareMeters = new BigDecimal("200.000"),
				   expectedSquareFeets = new BigDecimal("2152.782");
		assertEquals(expectedSquareFeets, AreaRectangularRoom.squareMetersToSquareFeet(squareMeters));
	}

}
