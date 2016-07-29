package com.xylo04.examples.flattener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Keep the structure nested, but multiple cursors. This solution is memory efficient and optimized
 * for partial traversals, but more complex to understand and maintain.
 */
public class Flattener2 implements Iterator<String> {

  private final ArrayList<ArrayList<String>> outerList;
  private int outerCursor = 0, innerCursor = 0;

  public Flattener2(ArrayList<ArrayList<String>> outerList) {
    this.outerList = outerList;
    outerCursor = 0;
    innerCursor = 0;
  }

  @Override
  public boolean hasNext() {
    // make sure the cursors are on a valid element
    while (!cursorsPointingAtSomething()) {
      if (outerCursor >= outerList.size()) {
        // we're past the end
        return false;
      }
      if (innerCursor >= getInnerList().size()) {
        outerCursor++;
        innerCursor = 0;
      }
    }
    return true;
  }

  @Override
  public String next() throws NoSuchElementException {
    // hasNext will make sure the cursors are on a valid element, or that we're past the end
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    ArrayList<String> innerList = getInnerList();
    String nextElement = innerList.get(innerCursor);

    // just increment the cursor, even if it's left pointing at nothing
    // hasNext() will clean it up next time
    innerCursor++;
    return nextElement;
  }

  @Override
  public void remove() {
    // no need to implement this
    throw new UnsupportedOperationException();
  }

  private boolean cursorsPointingAtSomething() {
    return outerCursor < outerList.size() && innerCursor < getInnerList().size();
  }

  private ArrayList<String> getInnerList() {
    return outerList.get(outerCursor);
  }
}
