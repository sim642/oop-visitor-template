package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeCounterTest {

    @Test
    public void testDemoImage() {
        assertEquals(7, NodeCounter.countNodes(TestImages.DEMO_IMAGE));
    }
}
