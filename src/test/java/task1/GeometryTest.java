package task1;

import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import org.junit.Test;
import sample.TestImages;

import static org.junit.Assert.*;

public class GeometryTest {

    @Test
    public void testRectangle() {
        assertEquals(20 * 10, Geometry.calculateTotalArea(new RectangleNode(0, 0, 20, 10)), 0.001);
    }

    @Test
    public void testCircle() {
        assertEquals(Math.PI * 10 * 10, Geometry.calculateTotalArea(new CircleNode(0, 0, 10)), 0.001);
    }

    @Test
    public void testDemoImage() {
        assertEquals(100 * 50 + Math.PI * 20 * 20, Geometry.calculateTotalArea(TestImages.DEMO_IMAGE), 0.001);
    }
}
