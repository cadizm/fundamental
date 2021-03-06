
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import datastructures.impl.LinkedStack;
import exception.StackException;


public class LinkedStackTest
{
    @Test
    public void testConstruct()
    {
        LinkedStack<String> stack = new LinkedStack<String>();
        assertEquals("", stack.toString());
    }

    @Test
    public void testPushPop()
        throws StackException
    {
        LinkedStack<String> stack = new LinkedStack<String>();

        stack.push("A");
        assertEquals("A", stack.toString());

        assertEquals("A", stack.pop());
        assertEquals("", stack.toString());

        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.pop());

        stack.push("D");
        assertEquals("D", stack.pop());

        stack.push("E");
        assertEquals("EBA", stack.toString());
    }

    @Test
    public void testIsEmpty()
        throws StackException
    {
        LinkedStack<String> stack = new LinkedStack<String>();
        assertEquals(true, stack.isEmpty());

        stack.push("A");
        assertEquals(false, stack.isEmpty());

        stack.push("B");
        stack.push("C");

        stack.pop();
        stack.pop();
        stack.pop();

        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testSize()
        throws StackException
    {
        LinkedStack<String> stack = new LinkedStack<String>();
        assertEquals(0, stack.size());

        stack.push("A");
        assertEquals(1, stack.size());

        stack.push("B");
        stack.push("C");
        assertEquals(3, stack.size());

        stack.pop();
        stack.pop();
        stack.pop();

        assertEquals(0, stack.size());
    }
}
