import CITS2200.*;
import java.util.*;

/**
 * An Implementation of an immutable binary tree
 * 
 * @author Peylin Ng 
 * @version 20/04/2018
 */

public class BinTree<E> extends CITS2200.BinaryTree<E>
{
	public BinTree(){super();}

	public BinTree(E item, BinaryTree<E> b1, BinaryTree<E> b2)
	{
		super(item,b1,b2);
	}
    
	/**
     * Tests whether the tree is equal to an Object.
     */
    public boolean equals(Object o)
	{
		//Whether the object is empty
	    if (o == null)
	    {
	        return false;
	    }

		//whether the tree is equal to an Object
		if (! (o instanceof BinaryTree) )
		{
	        return false;
	    }
		
	    //Two trees are equal if both trees are empty
		if (this.isEmpty() && ((BinaryTree)o).isEmpty())
		{
	        return true;
	    }
	    
		//Two trees are equal if both trees contain equal items at the root
        //and have equal left subtrees and equal right subtrees
		if (this.getItem().equals(((BinaryTree)o).getItem()))
		{
		    return this.getLeft().equals(((BinaryTree)o).getLeft())&& this.getRight().equals(((BinaryTree)o).getRight());
		}
		
		return false;
	}

	//The Iterator part.
	public CITS2200.Iterator<E> iterator()
	{
		return new BinTreeIterator<E>();
	}

	
	private class BinTreeIterator<E> implements CITS2200.Iterator<E>
	{
		private java.util.Queue<BinaryTree<E>> q;

		BinTreeIterator()
		{
			q = new java.util.LinkedList<BinaryTree<E>>();
			q.offer((BinaryTree<E>)BinTree.this);
		}
		
		//tests to see if there is a next item to return.
		public boolean hasNext()
		{
			return q.peek() != null;
		}

		//Returns the next element a moves the iterator to the next position.
		public E next()
		{
			    BinaryTree<E> tmp = q.remove();
			    BinaryTree<E> x = tmp.getLeft();

			    if (!x.isEmpty())
			    {
			         q.offer(x);
			    }

			    x = tmp.getRight();
			     
			    if (!x.isEmpty())
    			{
    			    q.offer(x);
    			}
    			return tmp.getItem();
		}
	}
}