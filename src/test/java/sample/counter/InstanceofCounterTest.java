package sample.counter;

import nodes.DrawNode;

public class InstanceofCounterTest extends CounterTest {

    @Override
    protected int countNodes(DrawNode node) {
        return InstanceofCounter.countNodes(node);
    }
}
