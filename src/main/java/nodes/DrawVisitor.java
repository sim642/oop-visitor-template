package nodes;

import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;

/**
 * Visits a {@link DrawNode}.
 */
public interface DrawVisitor {
    void visit(RectangleNode rectangle);
    void visit(CircleNode circle);
    void visit(TextNode text);

    void visit(GroupNode group);
    void visit(ImageNode image);
}
