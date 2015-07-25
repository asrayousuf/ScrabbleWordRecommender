package ScrabbleTeam3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;


public class TestConstraintToRegexConverter {

	ConstraintToRegexConverter tester = new ConstraintToRegexConverter();
	@Test
	public void testconvertToRegex() {
		assertEquals("(.*)c(.)(.)a(.)b(.*)", tester.convertToRegex("***c**a*b**"));
		assertEquals("c(.*)", tester.convertToRegex("c*"));
		assertEquals("(.*)b", tester.convertToRegex("**b"));
	}
	@Test
	public void testisMatching() {
		assertEquals(true, tester.isMatching("cllacb","(.*)c(.)(.)a(.)b(.*)"));
		assertEquals(false, tester.isMatching("ice","(.*)c(.)(.)a(.)b(.*)"));
		assertEquals(false, tester.isMatching("alba","(.*)c(.)(.)a(.)b(.*)"));
	}
   public static void main(String args[]){
	   JUnitCore.main("Test1");
   }
}
