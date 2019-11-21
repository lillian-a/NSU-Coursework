/**
 * Queue Class for Shark OS
 * Customized creating of Queue structure
 * works with Job Objects
 */
import java.util.*;
public class Queue {
	protected Job Queue[] ;
    protected int front;		// queue start
    protected int rear;		// queue end		
    protected int size;		// queue max-size
    protected int len;		// queue length
    
    /**
     * Constructor for Queue class
     * @param number		how large is the Queue
     */
	public Queue (int number) {
		Queue = new Job[number];
		front = -1;
		rear = -1; 
		size = number;
		len = 0;
	}
	/**
	 * is the queue empty? Yes (True) or No (False)
	 * @return	boolean
	 */
	public boolean isEmpty() {
		return front == -1;
	}
	/**
	 * is the queue full? Yes (True) or No (False)
	 * @return	boolean
	 */
	public boolean isFull() {
		return ( front == 0 ) && ( rear == size - 1 );
	}
	/**
	 * get queue size
	 * @return	int		size of queue
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Inserts a job into the Queue
	 * @param 		i	Job
	 *					job to insert into queue
	 * @exception 	IndexOutOfBoundsException
	 * 					if attempt to insert into full queue	
	 */
	public void insert(Job i) {
        if (rear == -1) {
            front = 0;
            rear = 0;
            Queue[rear] = i;
        }
        else if (rear + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        else if ( rear + 1 < size)
            Queue[++rear] = i;    
        len++ ;    
    }
	/**
	 * Removes and returns a job from beginning of queue
	 * @return	Job		job removed from the queue
	 * @exception 	NoSuchElementException
	 * 					if attempt to remove from empty queue
	 */
	public Job remove() {
        if (isEmpty())
           throw new NoSuchElementException("Underflow Exception");
        else {
            len-- ;
            Job ele = Queue[front];
            if ( front == rear) 
            {
                front = -1;
                rear = -1;
            }
            else
                front++;                
            return ele;
        }        
    }
}
