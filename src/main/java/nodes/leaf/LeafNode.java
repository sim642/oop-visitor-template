package nodes.leaf;

import nodes.DrawNode;

public abstract class LeafNode extends DrawNode {

    private final int x;
    private final int y;

    public LeafNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
