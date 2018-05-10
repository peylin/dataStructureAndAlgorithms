import CITS2200.*;

/**
 * Write a description of class PriorityQueueLinked here.
 * 
 * @author Peylin Ng
 * @version 28/04/18
 */
public class PriorityQueueLinked implements PriorityQueue
{
    Link front;
    
    /**
     * Constructor for objects of class PriorityQueueLinked
     */
    public PriorityQueueLinked()
    {
        front = null;
    }

    /**
     * An inner class to hold the object, the successor, and the priority
     */
    private class Link<E>
    {
        Object o;
        int priority;
        Link<E> next;
        
        public Link(Object ob, int p, Link l)
        {
            this.o = ob;
            this.priority = p;
            this.next = l;
        }
    }

    /**
     * Test whether the queue is empty.
     * 
     * @return     true if the priority queue is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return front == null;
    }
    
    /**
     * Insert an item at the back into the queue with a given priority.
     * 
     * @param  x            The object to insert.
     *         pp           The priority of the element.
     * @throws     IllegalValue if the priority is not in a valid range.
     */
    public void enqueue(Object x, int pp) throws IllegalValue
    {
        if(isEmpty() || pp > front.priority)
        {
            front = new Link(x, pp, front);
        }
        else
        {
            Link curr = front;
            
            while( curr.next !=null && curr.next.priority >= pp )
            {
                curr = curr.next;
            }
            
            curr.next = new Link(x,pp,curr.next);
        }
    }
    
    /**
     * Examine the item at the front of the queue 
     * (the element with the highest priority that has been in the queue the longest)
     * 
     * @return     the first object
     * @throws     Underflow if the queue is empty
     */
    public Object examine() throws Underflow
    {
        if(!isEmpty())
        {
            return front.o;
        }
        else
        {
            throw new Underflow("Empty Queue");
        }
    }
    
    /**
     * Remove the item at the front of the queue
     * (the element with the highest priority that has been there the longest)
     *  
     * @return     the removed Object
     * @throws     Underflow if the queue is empty
     */
    public Object dequeue() throws Underflow
    {
        if(!isEmpty())
        {
            Object temp = front.o;
            front = front.next;
            return temp;
        }
        else
        {
            throw new Underflow("Empty Queue");
        }
    }
    
    /**
     * return a DAT.Iterator to examine all the elements in the PriorityQueue.
     * 
     * @return     An Iterator pointing to before the first item.
     */

    public CITS2200.Iterator iterator()
	{
		return new PQueueIterator();
	}
	
    private class PQueueIterator implements Iterator
    {
    	Link curr;
    
    	PQueueIterator()
    	{
    		curr = PriorityQueueLinked.this.front;
    	}
    	
    	//tests to see if there is a next item to return.
    	public boolean hasNext()
    	{
    		return (curr != null);
    	}
    
    	//Returns the next element and moves the iterator to the next position.
    	public Object next()
    	{
    	    if(hasNext())
    	    {
    	        Object temp = (Object)curr.o;
    	        curr = curr.next;
    	        
    	        return temp;
    	    }
    	    else
    	    {
    	        throw new OutOfBounds("No next item");
            }
        }
    }
    	
}
