package sample.counter;

import nodes.DrawNode;
import org.junit.Test;
import sample.TestImages;

import static org.junit.Assert.assertEquals;

public abstract class CounterTest {

    protected abstract int countNodes(DrawNode node);

    @Test
    public void testDemoImage() {
        assertEquals(7, countNodes(TestImages.DEMO_IMAGE));
    }
}
