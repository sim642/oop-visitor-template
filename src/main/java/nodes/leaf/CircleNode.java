package nodes.leaf;

import nodes.DrawVisitor;

/**
 * Represents a circle.
 */
public class CircleNode extends LeafNode {

    private final int radius;

    public CircleNode(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void accept(DrawVisitor visitor) {
        visitor.visit(this);
    }

    public int getRadius() {
        return radius;
    }
}
