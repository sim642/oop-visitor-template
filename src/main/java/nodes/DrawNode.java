package nodes;

/**
 * Represents any node in the graphic.
 */
public abstract class DrawNode {
    /**
     * Accepts a visitor.
     */
    public abstract void accept(DrawVisitor visitor);
}
