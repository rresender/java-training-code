package com.resende.codesignal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testSize() {
		LinkedList<Integer> list = new LinkedList<>();
		assertTrue(list.isEmpty());
		list.add(1);
		assertFalse(list.isEmpty());
		list.add(2);
		assertEquals(2, list.size());
	}

	@Test
	public void testGetFirst() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(1, list.getFirst().intValue());
	}

	@Test
	public void testGetLast() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		assertEquals(2, list.getLast().intValue());
	}

	@Test
	public void testPrint() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.print();
		
	}

	@Test
	public void testReverse() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		assertEquals(1, list.getFirst().intValue());
		list.reverse();
		assertEquals(5, list.getFirst().intValue());
		list.print();
	}

	@Test
	public void testReverseRec() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		assertEquals(1, list.getFirst().intValue());
		list.reverseRec();
		assertEquals(5, list.getFirst().intValue());
		list.print();
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTail() {
		fail("Not yet implemented");
	}

}
