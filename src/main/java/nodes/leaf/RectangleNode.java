package nodes.leaf;

import nodes.DrawVisitor;

public class RectangleNode extends LeafNode {

    private final int width;
    private final int height;

    public RectangleNode(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void accept(DrawVisitor visitor) {
        visitor.visit(this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
