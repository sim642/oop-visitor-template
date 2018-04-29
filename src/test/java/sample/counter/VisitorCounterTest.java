package sample.counter;

import nodes.DrawNode;

public class VisitorCounterTest extends CounterTest {

    @Override
    protected int countNodes(DrawNode node) {
        return VisitorCounter.countNodes(node);
    }
}
