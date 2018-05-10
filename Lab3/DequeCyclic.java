import CITS2200.*;
/**
 * Write a description of class Deque here.
 * 
 * @author Peylin Ng
 * @version 1
 */
public class DequeCyclic implements Deque
{
    private static int size;
    private static Object[] deque;
    private int leftMost;
    private int rightMost;
    
    /**
     * create an empty stack of size s
     */
    public DequeCyclic(int s)
    {
        size = s;
        deque = new Object[size];
        leftMost = -1; 
        rightMost = 0;
    }

    /**
     * return true iff the deque is empty, false otherwise.
     */
    public boolean isEmpty(){
        return (leftMost == -1);
    }
    
    /**
     * return true iff the deque is empty, false otherwise.
     */
    public boolean isFull(){
        return ((leftMost == 0 && rightMost == size-1) || leftMost == rightMost+1);
    }
    
    /**
     * add object c as the left-most object in the deque, or throw an Overflow exception if the deque is full.
     */
    public void pushLeft(Object c) throws Overflow {
        if(!isFull())
        {
            if(leftMost == -1){
                leftMost = 0;
                rightMost = 0;
            }
            else if(leftMost == 0){
                leftMost = size - 1;
            }
            else{
                leftMost = leftMost -1;
            }
            
            deque[leftMost] = c;
        }
        else
        {
            throw new Overflow( "Stack overflow");
        }
    }
    
    /**
     * add object c as the right-most object in the deque, or throw an Overflow exception if the deque is full.
     */
    public void pushRight(Object c) throws Overflow {
        if(!isFull())
        {
            if(leftMost == -1){
                leftMost = 0;
                rightMost = 0;
            }
            else if(rightMost == size-1){
                rightMost = 0;
            }
            else{
                rightMost = rightMost+1;
            }
            
            deque[rightMost] = c;
        }
        else
        {
            throw new Overflow( "Stack overflow");
        }
    }
    
    /**
     * return the left-most object in the deque, or throw an Underflow exception if the deque is empty.
     */
    public Object peekLeft() throws Underflow {
        if(!isEmpty())
        {
            return deque[leftMost];
        }
        else
        {
            throw new Underflow( "Stack underflow");
        }
    }
    
    /**
     * return the right-most object in the deque, or throw an Underflow exception if the deque is empty.
     */
    public Object peekRight() throws Underflow {
        if(!isEmpty())
        {
            return deque[rightMost];
        }
        else
        {
            throw new Underflow( "Stack underflow");
        }
    }
    
    /**
     * remove and return the left-most object in the deque, or throw an Underflow exception if the deque is empty.
     */
    public Object popLeft() throws Underflow { 
        if(!isEmpty())
        {
            if(rightMost == leftMost){
                leftMost = -1;
                rightMost = -1;
            }
            else{
                if(leftMost == size-1){
                    leftMost = 0;
                }
                else{
                    leftMost = leftMost+1;
                }
            }
            return deque[leftMost];
        }
        else
        {
            throw new Underflow( "Stack underflow");
        }
    }
    
    /**
     * remove and return the right-most object in the deque, or throw an Underflow exception if the deque is empty.
     */
    public Object popRight() throws Underflow {
        if(!isEmpty())
        {
            if(leftMost == rightMost){
                leftMost = -1;
                rightMost = -1;
            }
            else if(rightMost == 0){
                rightMost = size-1;
            }
            else{
                rightMost = rightMost-1;
            }
            
            return deque[rightMost];
        }
        else
        {
            throw new Underflow("Stack underflow");
        }
    }
}
