package com.xylo04.examples.flattener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The most basic solution: flatten out in the constructor. The solution is correct, but what if you
 * don't use all of the elements? What about memory usage? This can be more efficient.
 */
public class Flattener1 implements Iterator<String> {

  private ArrayList<String> flat = new ArrayList<>();
  private int cursor = 0;

  public Flattener1(ArrayList<ArrayList<String>> outer) {
    for (ArrayList<String> inner : outer) {
      for (String element : inner) {
        flat.add(element);
      }
    }
  }

  @Override
  public boolean hasNext() {
    return cursor < flat.size();
  }

  @Override
  public String next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    String returnValue = flat.get(cursor);
    cursor++;
    return returnValue;
  }

  @Override
  public void remove() {
    // no need to implement this
    throw new UnsupportedOperationException();
  }
}
