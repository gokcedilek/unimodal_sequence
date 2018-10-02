package unimodal;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnimodalSequenceTest {

	@Test
	public void test1() {
		// the entire array is a unimodal sequence
		int[] intArray = new int[] { 1, 2, 3, 4, 5, 4, 3, 2, 1 };
		try {
			assertEquals(9, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
		} catch (NoUnimodalSequenceException e) {
			fail("no exception expected");
		}
	}

	@Test
	public void test2() {
		// part of the array is a unimodal sequence
		int[] intArray = new int[] { 2, 3, 2, 4, 6, 8, 10, 5, 3, 1 };
		try {
			assertEquals(8, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
		} catch (NoUnimodalSequenceException e) {
			fail("no exception expected");
		}
	}

	@Test
	public void test3() {
		// no unimodal sequence in a small array
		int[] intArray = new int[] { 3, 2 };
		try {
			UnimodalSequence.getLength_longestUnimodalSequence(intArray);
			fail("should have resulted in an exception");
		} catch (NoUnimodalSequenceException e) {
			// nothing specific to do
		}
	}

	@Test
	public void test4() {
		// longish unimodal sequence -6, 10, 12, 13, 14, 9, 2, 1, 0, -5 in the
		// middle
		int[] intArray = new int[] { -1, 2, -3, -4, -6, 10, 12, 13, 14, 9, 2, 1, 0, -5, -3, 1 };
		try {
			assertEquals(10, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
		} catch (NoUnimodalSequenceException e) {
			fail("no exception expected");
		}
	}

	@Test
	public void test5() {
		// empty array
		int[] intArray = new int[] {};
		try {
			UnimodalSequence.getLength_longestUnimodalSequence(intArray);
			fail("should have resulted in an exception");
		} catch (NoUnimodalSequenceException e) {
			// ...
		}
	}

	@Test
	public void test6() {
		// single entry array
		int[] intArray = new int[] { 11 };
		try {
			UnimodalSequence.getLength_longestUnimodalSequence(intArray);
			fail("should have resulted in an exception");
		} catch (NoUnimodalSequenceException e) {
			// ...
		}
	}

	@Test
	public void test7() {
		// longish non-descending array
		int[] intArray = new int[] { 11, 12, 13, 14, 14, 15, 16 };
		try {
			UnimodalSequence.getLength_longestUnimodalSequence(intArray);
			fail("should have resulted in an exception");
		} catch (NoUnimodalSequenceException e) {
			// ...
		}
	}

	@Test
	public void test8() {
		// smallest unimodal sequence
		int[] intArray = new int[] { 10, 12, 11 };
		try {
			assertEquals(3, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
		} catch (NoUnimodalSequenceException e) {
			fail("no exception expected");
		}
	}

	@Test
	public void test9() {
		// two unimodal sequences, one longer than the other
		// 10, 12, 11 is one sequence
		// 11, 17, 9, 8, 7 is the other sequence (which is also longer)
		int[] intArray = new int[] { 13, 10, 12, 11, 17, 9, 8, 7, 10 };
		try {
			assertEquals(5, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
		} catch (NoUnimodalSequenceException e) {
			fail("no exception expected");
		}
	}

}
