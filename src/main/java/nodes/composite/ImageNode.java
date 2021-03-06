package nodes.composite;

import nodes.DrawNode;
import nodes.DrawVisitor;

/**
 * Represents the entire image.
 */
public class ImageNode extends DrawNode {

    private final DrawNode child;

    public ImageNode(DrawNode child) {
        this.child = child;
    }

    @Override
    public void accept(DrawVisitor visitor) {
        visitor.preVisit(this);
        child.accept(visitor);
        visitor.postVisit(this);
    }

    public DrawNode getChild() {
        return child;
    }
}
