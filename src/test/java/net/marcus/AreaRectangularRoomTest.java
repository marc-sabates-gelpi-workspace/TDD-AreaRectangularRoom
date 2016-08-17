package net.marcus;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AreaRectangularRoomTest {
	
	private AreaRectangularRoom areaRectangularRoom;

	@Before
	public void setUp() throws Exception {
		areaRectangularRoom = new AreaRectangularRoom();
	}

	@Test
	public void shouldReturnArea() {
		BigDecimal areaExpected = new BigDecimal("200.000"),
				   length = new BigDecimal("10"),
				   width = new BigDecimal("20");
		assertEquals(areaExpected, areaRectangularRoom.area(length, width));
	}
	
	@Test
	public void shouldReturnFeets() throws Exception {
		BigDecimal squareFeets = new BigDecimal("234.5678"),
				   expectedSquareMeters = new BigDecimal("21.792");
		assertEquals(expectedSquareMeters, AreaRectangularRoom.squareFeetsToSquareMeters(squareFeets));
	}
	
	@Test
	public void shouldReturnMeters() throws Exception {
		BigDecimal squareMeters = new BigDecimal("200.000"),
				   expectedSquareFeets = new BigDecimal("2152.782");
		assertEquals(expectedSquareFeets, AreaRectangularRoom.squareMetersToSquareFeet(squareMeters));
	}

}
