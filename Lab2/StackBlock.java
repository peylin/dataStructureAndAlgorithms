import CITS2200.*;
/**
 * Write a description of class StackBlock here.
 * 
 * @author Peylin Ng
 * @version 1
 */
public class StackBlock implements Stack
{
    private static int size;
    private static Object[] myStack;
    private int i;
    
    /**
     * create an empty stack of size s
     */
    public StackBlock(int s)
    {
        size = s;
        myStack = new Object[size];
        i = -1;
    }

    /**
     * return true iff the stack is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (i == -1);
    }
    
    /**
     * return true iff the stack is full, false otherwise
     */
    public boolean isFull()
    {
        return (i == size - 1);
    }
    
    /**
     * push Object j onto the top of the stack, 
     * or throw an Overflow exception if the stack is full
     */
    public void push(Object j) throws Overflow
    {
        if(!isFull())
        {
            i++;
            myStack[i] = j;
        }
        else
        {
            throw new Overflow( "Stack overflow");
        }
    }
    
    /**
     * return the Object on top of the stack, 
     * or throw an Underflow exception if the stack is empty
     */
    public Object examine() throws Underflow
    {
        if (!isEmpty())
        {
            return myStack[i];
        }
        else 
        {
            throw new Underflow( "Stack underflow");
        }
    }
    
    /**
     * remove and return the Object on the top of the stack, 
     * or throw an Underflow exception if the stack is empty
     */
    public Object pop() throws Underflow
    {
        Object x = new Object();
        if (!isEmpty())
        {
            x = myStack[i];
            i--;
            return x;
        }
        else 
        {
            throw new Underflow( "Stack underflow");
        }
    }
    
}
