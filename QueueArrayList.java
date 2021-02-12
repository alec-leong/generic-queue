import java.util.*;

/**
 * <code>QueueIllegalSizeDeclaration</code> Class
 * <p>
 * A subclass of the <code>IllegalArgumentException</code> class. An exception for creating a
 * <code>QueueArrayList</code> with an illegal size declaration. 
 */
class QueueIllegalSizeDeclaration extends IllegalArgumentException {
  public QueueIllegalSizeDeclaration(int maxSize) {
    super("Can't declare queue size of " + maxSize);
  }
}

/**
 * <code>QueueInsertException</code> Class
 * <p>
 * A subclass of the <code>RuntimeException</code> class. An exception for inserting an item into a
 * full queue.
 */
class QueueInsertException extends RuntimeException {
  public QueueInsertException() {
    super("Can't insert an item into a full queue");
  }
}

/**
 * <code>QueueDeleteException</code> Class
 * <p>
 * A subclass of the <code>RuntimeException</code> class. An exception for deleting an item from an
 * empty queue.
 */
class QueueDeleteException extends RuntimeException {
  public QueueDeleteException() {
    super("Can't delete the front item from an empty queue");
  }
}

/**
 * <code>QueueReadException</code> Class
 * <p>
 * A subclass of the <code>RuntimeException</code> class. An exception for reading an item from an
 * empty queue.
 */
class QueueReadException extends RuntimeException {
  public QueueReadException() {
    super("Can't read the front item from an empty queue");
  }
}

/**
 * <code>QueueArrayList</code> Class
 * <p>
 * A generic queue implementation.
 */
class QueueArrayList<T> {
  private int front;
  private int rear;
  private int maxSize;
  private List<T> container;

  /**
   * No-argument constructor.
   * <p>
   * Creates a <code>QueueArrayList</code> object that doesn't become full and initializes the following fields:
   * <li><code>front</code>     - The <code>int</code> value <code>0</code>.
   * <li><code>rear</code>      - The <code>int</code> value <code>-1</code>.
   * <li><code>container</code> - A <code>List</code> object implemented by the <code>ArrayList</code> class.
   * </ul>
   */
  QueueArrayList() {
    front = 0;
    rear = -1;
    container = new ArrayList<>();
  }

  /**
   * Parameterized constructor with one parameter.
   * <p>
   * Creates a <code>QueueArrayList</code> object that can become full and initializes the following fields:
   * <li><code>front</code>     - The <code>int</code> value <code>0</code>.
   * <li><code>rear</code>      - The <code>int</code> value <code>-1</code>.
   * <li><code>maxSize</code>   - The value of the <code>int</code> parameter <code>maxSize</code>.
   * <li><code>container</code> - A <code>List</code> object implemented by the <code>ArrayList</code> class with an initial capacity of <code>maxSize</code>.
   * @param maxSize the maximum size of the queue.
   * @throws QueueIllegalSizeDeclaration if the the value of the <code>int</code> parameter <code>maxSize</code> is less than or equal to <code>0</code>.
   */
  QueueArrayList(int maxSize) throws QueueIllegalSizeDeclaration {
    if (maxSize <= 0) {
      throw new QueueIllegalSizeDeclaration(maxSize);
    }

    front = 0;
    rear = -1;
    this.maxSize = maxSize;
    container = new ArrayList<>();
  }

  /**
   * The <code>toString()</code> method.
   * <p>
   * @return the <code>QueueArrayList</code> object as a <code>String</code> object.
   */
  public String toString() {
    // Handle empty queue case.
    if (container.isEmpty()) {
      return "[]";
    }

    StringBuilder output = new StringBuilder("[\n");

    // Iterate through the queue, except the first item.
    for (int i = container.size() - 1; i > 0; i--) {
      output.append(" ");
      output.append(container.get(i));
      output.append(",\n");
    }
  
    // Front of the queue, the first item.
    output.append(" ");
    output.append(container.get(0));
    output.append("\n]");
    
    return output.toString();
  }

  /**
   * If the queue is not full, first increment the <code>rear</code> field then insert an item in
   * the rear queue.
   * @param item the item to be inserted in the rear of the queue.
   * @throws QueueInsertException if the queue is full.
   */
  public void enqueue(T item) throws QueueInsertException {
    if (container.size() == maxSize && maxSize > 0) {
      throw new QueueInsertException();
    }

    container.add(++rear, item);
  }

  /**
   * If the queue is not empty, first decrement the <code>rear</code> field then delete the item in
   * front of the queue.
   * @return the item in front of the queue. 
   * @throws QueueDeleteException if the queue is empty.
   */
  public T dequeue() throws QueueDeleteException {
    if (container.isEmpty()) {
      throw new QueueDeleteException();
    }

    rear--;
    return container.remove(front);
  }

  /**
   * If the queue is not empty, then return the item in front of the queue. 
   * @return the item in front of the queue. 
   * @throws QueueReadException if the queue is empty.
   */
  public T peek() throws QueueReadException {
    if (container.isEmpty()) {
      throw new QueueReadException();
    }

    return container.get(front);
  }

  /**
   * Returns the number of items in the queue.
   * @return an <code>int</code> referencing the number of items in the queue.
   */
  public int size() {
    return container.size();
  }

  /**
   * Returns a <code>boolean</code> if the queue is empty or not empty.
   * @return <code>true</code> if the queue is empty. Otherwise <code>false</code>.
   */
  public boolean isEmpty() {
    return container.isEmpty();
  }

  /**
   * Returns a <code>boolean</code> if the queue is full or not full.
   * @return <code>true</code> if the queue is full. Otherwise <code>false</code>.
   */
  public boolean isFull() {
    return container.size() == maxSize;
  }
}