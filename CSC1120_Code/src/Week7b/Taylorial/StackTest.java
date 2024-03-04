package Week7b.Taylorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private SJStack<Integer> stack;
@BeforeEach
    public void setUp() {
        stack = new SJStack<>();
    }
    @Test
    @DisplayName("Test empty")
    public void testEmpty() {
        assertTrue(stack.empty());
        stack.push(0);
        assertFalse(stack.empty());
    }
    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertEquals(2, stack.peek());
    }
    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }
    @Test
    public void testPush() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }
    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

}
