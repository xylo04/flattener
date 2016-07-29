package com.xylo04.examples.flattener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Test;

public class FlattenerTest {

  @Test
  public void testFlattener() {
    // initialize our nested lists
    ArrayList<ArrayList<String>> outer = new ArrayList<>();
    ArrayList<String> inner1 = new ArrayList<>();
    inner1.add("a");
    inner1.add("b");
    inner1.add("c");
    outer.add(inner1);
    ArrayList<String> inner2 = new ArrayList<>();
    inner2.add("d");
    inner2.add("e");
    outer.add(inner2);
    outer.add(new ArrayList<String>()); // empty list!
    ArrayList<String> inner4 = new ArrayList<>();
    inner4.add("f");
    inner4.add("g");
    outer.add(inner4);

    // "flatten" the lists; swap Flattener1 out for other implementations
    Iterator<String> flattenedList = new Flattener1(outer);
    assertTrue(flattenedList.hasNext());
    assertEquals("a", flattenedList.next());
    assertEquals("b", flattenedList.next());

    // calling hasNext doesn’t move cursor
    assertTrue(flattenedList.hasNext());
    assertTrue(flattenedList.hasNext());
    assertEquals("c", flattenedList.next());

    assertEquals("d", flattenedList.next());
    assertEquals("e", flattenedList.next());
    assertEquals("f", flattenedList.next());

    // getting close to the end now...
    assertTrue(flattenedList.hasNext());
    assertEquals("g", flattenedList.next());
    assertFalse(flattenedList.hasNext());
    try {
      flattenedList.next();
      fail("Reached the end; should have thrown");
    } catch (NoSuchElementException expected) {
      // expected path
    }
  }
}
