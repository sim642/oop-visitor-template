package nodes;

import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;

/**
 * Visits a {@link DrawNode} with default behavior.
 * Leaves do nothing. Composites delegate to children.
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
    public void visit(GroupNode group) {
        group.getChildren().forEach(child -> child.accept(this));
    }

    @Override
    public void visit(ImageNode image) {
        image.getChild().accept(this);
    }
}
