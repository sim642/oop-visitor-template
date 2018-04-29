package nodes;

public abstract class DrawNode {
    public abstract void accept(DrawVisitor visitor);
}
