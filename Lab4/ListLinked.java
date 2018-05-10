import CITS2200.*;
/**
 * This is a class called ListLinked, and it completes the ADT.
 * 
 * @author Peylin Ng
 * @version 5/04/2018
 */

public class ListLinked implements List
{
    private Link before;
    private Link after;

    /**
     * Constructor for objects of class ListLinked
     */
    public ListLinked()
    {
        after = new Link(null, null);
        before = new Link(null, after);
    }

    /**
     * Returns true if the list is empty.
     */
    public boolean isEmpty()
    {
        return before.successor == after;
    }
    
    /**
     * Returns true if w is over the before first position.
     */
    public boolean isBeforeFirst(WindowLinked w)
    {
        return w.link == before;
    }
    
    /**
     * Returns true if w is over the after last position.
     */
    public boolean isAfterLast(WindowLinked w)
    {
        return w.link == after;
    }
    
    /**
     * Initialises w to the before first position.
     */
    public void beforeFirst(WindowLinked w)
    {
        w.link = before;
    }
    
    /**
     * Initialises w to the after last position.
     */
    public void afterLast(WindowLinked w)
    {
        w.link = after;
    }
    
    /**
     * Throws an exception if w is over the after last position,
     * otherwise moves w to the next window position.
     */
    public void next(WindowLinked w) throws OutOfBounds
    {
        if(!isAfterLast(w))
        {
           w.link = w.link.successor;
        }
        else
        {
            throw new OutOfBounds( "It's over the after last position!");
        }
    }
    
    /**
     * Throws an exception if w is over the before first position,
     * otherwise moves w to the previous window position.
     */
    public void previous(WindowLinked w) throws OutOfBounds
    {
        if(isBeforeFirst(w) || w.link == null)
        {
            throw new OutOfBounds( "It's over the before first position!");
        }
        else
        {
            Link current = before.successor;
            Link previous = before;
            while(current != w.link)
            {
                previous = current;
                current = current.successor;
            }
            w.link = previous;
        }
    }
    
    /**
     * Throws an exception if w is over the after last position,
     * otherwise an extra element e is added to the list after w.
     */
    public void insertAfter(Object e, WindowLinked w) throws OutOfBounds
    {
        if(isAfterLast(w) || w.link == null)
        {
            throw new OutOfBounds( "It's over the after last position!");
        }
        else
        {
            Link next = new Link(e, w.link.successor);
            w.link.successor = next;
        }
    }
    
    /**
     * Throws an exception if w is over the before first position,
     * otherwise an extra element e is added to the list before w.
     */
    public void insertBefore(Object e, WindowLinked w) throws OutOfBounds
    {
        if(isBeforeFirst(w) || w.link == null)
        {
            throw new OutOfBounds( "It's over the before first position!");
        }
        else
        {
            w.link.successor = new Link(w.link.item, w.link.successor);
            if(isAfterLast(w))
            {
                after = w.link.successor;
            }
            w.link.item = e;
            w.link = w.link.successor;            
        }
    }
    
    /**
     * Throws an exception if w is in before first or after last position,
     * otherwise returns the element under w.
     */
    public Object examine(WindowLinked w) throws OutOfBounds
    {
        if(isBeforeFirst(w) || isAfterLast(w) || w.link == null)
        {
            throw new OutOfBounds( "It's in either the before first position or after last position!");
        }
        else
        {
            return w.link.item;
        }
    }
    
    /**
     * Throws an exception if w is in before first or after last position,
     * otherwise replaces the element under w with e and returns the old element.
     */
    public Object replace(Object e, WindowLinked w) throws OutOfBounds
    {
        if(isBeforeFirst(w) || isAfterLast(w) || w.link == null)
        {
            throw new OutOfBounds( "It's in either the before first position or after last position!");
        }
        else
        {
            Object temp = w.link.item;
            w.link.item = e;
            return temp;        
        }
    }
    
    /**
     * Throws an exception if w is in the before first or after last position,
     * otherwise deletes and returns the element under w,
     * and places w over the next element.
     */
    public Object delete(WindowLinked w) throws OutOfBounds
    {
        if(isBeforeFirst(w) || isAfterLast(w) || w.link == null)
        {
            throw new OutOfBounds( "It's in either the before first position or after last position!");
        }
        else
        {
            if(after == w.link.successor)
            {
                after = w.link;
                return w.link.item;
            }
            Object temp = w.link.item;
            w.link.item = w.link.successor.item;
            w.link.successor = w.link.successor.successor;
            
            return temp;
        }
    }
    
}
