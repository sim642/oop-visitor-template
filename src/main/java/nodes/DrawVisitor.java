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

    void preVisit(GroupNode group);
    void postVisit(GroupNode group);

    void preVisit(ImageNode image);
    void postVisit(ImageNode image);
}
