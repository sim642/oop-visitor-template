package nodes;

import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;

/**
 * Visits a {@link DrawNode} with default behavior.
 *
 * Override only needed methods.
 */
public class SimpleDrawVisitor implements DrawVisitor {
    @Override
    public void visit(RectangleNode rectangle) {

    }

    @Override
    public void visit(CircleNode circle) {

    }

    @Override
    public void visit(TextNode text) {

    }

    @Override
    public void preVisit(GroupNode group) {

    }

    @Override
    public void postVisit(GroupNode group) {

    }

    @Override
    public void preVisit(ImageNode image) {

    }

    @Override
    public void postVisit(ImageNode image) {

    }
}
