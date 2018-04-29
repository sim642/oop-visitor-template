# Visitor pattern

> The visitor design pattern is a way of separating an algorithm from an object structure on which it operates. A practical result of this separation is the ability to add new operations to existent object structures without modifying the structures.
> — _[Visitor pattern, Wikipedia](https://en.wikipedia.org/wiki/Visitor_pattern)_

Before talking about the visitor pattern in more detail, there must be a data structure to work with.

## Data structure
For the following examples, a tree-like data structure describing simple vector graphics will be used.
It has been defined in package `nodes` and has the following structure:
* `DrawNode` - base class for all nodes
    * `LeafNode` - base class for all visual elements
        * `RectangleNode` - class for rectangles
        * `CircleNode` - class for circles
        * `TextNode` - class for text
    * `GroupNode` - class for grouping multiple nodes to be treated as one
    * `ImageNode` - class for the entire image with a single node

They may be used to define an image like (in `DemoImages` class)
```java
new ImageNode(
        new GroupNode(List.of(
                new RectangleNode(10, 10, 100, 50),
                new GroupNode(List.of(
                        new CircleNode(150, 30, 20),
                        new TextNode(200, 50, "Some text")
                )),
                new TextNode(30, 100, "My cool image")
        ))
);
```

Structurally this is somewhat similar to JavaFX scenes and scene graphs. It is an example of **composite pattern**.

## Algorithms on the structure
The node classes themselves are very simple: they just store data in fields. With that in place, there are several different ways to operate on the data structure when different nodes should behave differently. For example print an image's structure or count its nodes.

### Overloaded methods
Firstly, these algorithms may be added as abstract methods in the base class and implemented in all the nodes. This is the simplest approach that we've used so far. It's not always suitable:

1. If there are too many different methods to add, then the node classes will be all about the pieces of all the different operations to implement and not the original structure itself.
2. If the classes cannot be modified (e.g. they're part of a library), then it's simply impossible to add methods to the nodes.

The next two approaches avoid these issues by implementing desired algorithms outside of the data structure.

### `instanceof` and casts
Secondly, operations may be implemented using if statements with `instanceof` conditions to differentiate different types. In the respective branches of such if statements, the object of the general type can be safely cast into a more specific type safely, after having checked it.

`InstanceOfPrintDemo` has an example of printing the node structure via this approach.

It also has several downsides:

1. Using `instanceof` and casting is considered bad style in object-oriented programming because nicer and intended techniques are not being utilized. They are also rather verbose.
2. It is easy to forget to handle a type that may be in the data structure.

The next approach avoids these issues by introducing a significantly more sophisticated system.

### Visitor pattern

TODO
