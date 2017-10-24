
package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer <T> extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */

    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount == capacity){
            throw new RuntimeException("Ring Buffer Overflow");
        }
            rb[last] = x;
            last += 1;
            fillCount += 1;
            if (last == capacity){
                last = 0;
            }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (fillCount == 0){
            throw new RuntimeException("Ring Buffer Underflow" );
        }
        T result = rb[first];
        rb[first] = null;
        fillCount -= 1;
        first += 1;
        if (first == capacity){
            first = 0;
        }

        return result;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        T result = rb[first];
        return  result;
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    public Iterator <T> iterator(){
        return new ItQueue();
    }


    private class ItQueue implements Iterator<T>{
        private int i;
        public T next(){
            T result = rb[i];
            i += 1;
            return result;
        }
        public boolean hasNext(){
            return i <= fillCount ;
        }
    }
}
