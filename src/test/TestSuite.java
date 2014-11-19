
package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    LinkedListTest.class,
    DoublyLinkedListTest.class,
    HashtableTest.class,
    LinkedQueueTest.class,
    LinkedStackTest.class,
    LinkedBinaryTreeTest.class,
//    UtilTest.class,
    BinarySearchTest.class,
})
public class TestSuite
{
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(TestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.getTrace());
        }
        if (result.wasSuccessful()) {
            System.out.printf("%d tests completed successfully.\n",
                    result.getRunCount());
        }
    }
}
