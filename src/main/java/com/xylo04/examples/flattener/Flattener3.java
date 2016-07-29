package com.xylo04.examples.flattener;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The really clever, clean solution. Requires a really good understanding of Java-specific
 * interfaces.
 */
public class Flattener3<T> implements Iterator<T> {

  private Iterator<? extends Collection<T>> outer;
  private Iterator<T> inner;

  public Flattener3(Collection<? extends Collection<T>> input) {
    outer = input.iterator();
  }

  public boolean hasNext() {
    while (inner == null || !inner.hasNext()) {
      if (!outer.hasNext()) {
        return false;
      }
      inner = outer.next().iterator();
    }
    return true;
  }

  public T next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException();
    } else {
      return inner.next();
    }
  }

  public void remove() throws UnsupportedOperationException, IllegalStateException {
    throw new UnsupportedOperationException();
  }
}
