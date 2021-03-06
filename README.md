# Visitor pattern

> The visitor design pattern is a way of separating an algorithm from an object structure on which it operates. A practical result of this separation is the ability to add new operations to existent object structures without modifying the structures.
> — _[Visitor pattern, Wikipedia](https://en.wikipedia.org/wiki/Visitor_pattern)_

You should immediately clone [this repository](https://github.com/sim642/oop-visitor-template) to look at all the classes and examples mentioned here.

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

Structurally this is somewhat similar to JavaFX scenes and scene graphs.
It is actually an example of the [**composite pattern**](https://en.wikipedia.org/wiki/Composite_pattern).

## Algorithms on the structure
The node classes themselves are very simple: they just store data in fields.
With that in place, there are several different ways to operate on the data structure when different nodes should behave differently.
For example, print this kind of image's structure or count its nodes.

### Overloaded methods
Firstly, these algorithms may be added as abstract methods in the base class and implemented in all the nodes.
This is the simplest approach that we've seed and used so far.
It's not always suitable:
1. If there are too many different methods to add, then the node classes will be all about the pieces of all the different operations to implement and not the original structure itself.
2. If the classes cannot be modified (e.g. they're part of a library), then it's simply impossible to add methods to the nodes.

The next two approaches avoid these issues by implementing desired algorithms outside of the data structure.

### `instanceof` and casts
Secondly, operations may be implemented using if statements with `instanceof` conditions to differentiate different types.
In the respective branches of such if statements, the object of the general type can be safely cast into a more specific type safely, after having checked it.

**`InstanceofPrinter` has an example of printing the node structure and `InstanceofCounter` has an example of counting nodes via this approach.**

It also has several downsides:
1. Using `instanceof` and casting is considered bad style in object-oriented programming because nicer and intended techniques are not being utilized. They are also rather verbose.
2. It is easy to forget to handle a type that may be in the data structure.

The next approach avoids these issues by introducing a significantly more sophisticated system.

### Visitor pattern
Thirdly, there is the visitor pattern. `FileVisitor`, used for `Files.walkFileTree`, also is one example of the visitor pattern that exists in JDK.
We look at the pattern more classically on a data structure, not the file tree.

#### Setup 
It allows implementing operations by implementing a visitor interface (`DrawVisitor`) which contains a method overload(s) for every concrete node type:
```java
public interface DrawVisitor {
    void visit(RectangleNode rectangle);
    void visit(CircleNode circle);
    void visit(TextNode text);
    
    void preVisit(GroupNode group);
    void postVisit(GroupNode group);
    
    void preVisit(ImageNode image);
    void postVisit(ImageNode image);
}
```

The abstract node base class (`DrawNode`) will have an additional abstract method for accepting a visitor:
```java
public abstract void accept(DrawVisitor visitor);
```
Every concrete leaf node class implements this in a very simple manner:
```java
@Override
public void accept(DrawVisitor visitor) {
    visitor.visit(this);
}
```
Composite node classes do it similarly by calling `preVisit` and `postVisit` and sending the visitor to their children in between, so **the whole structure automatically gets visited**.
The implementation is pretty much the same in every subclass intentionally because it cannot be implemented directly in the superclass!
_This is explained below._

An implementation of the visitor interface with corresponding actions for every node type can be passed to a node's `accept` method to run the algorithm over the data structure. 
**`VisitorPrinter` has a corresponding example of printing the node structure and `VisitorCounter` has a corresponding example of counting nodes via this approach.**

The latter extends the `SimpleDrawVisitor` class instead of implementing the `DrawVisitor` interface directly.
It contains a reasonable default behavior to simplify creating new visitors where not all methods need to do something special.
Note that no `instanceof` nor casts are required when implementing an algorithm.

#### Working mechanism
The visitor pattern works through **double-dispatch**.
When `accept` is called on a node with a visitor, two calls are dispatched:
1. The implementation of `accept` that runs is found using dynamic dispatch from the node's actual class, which overrides the `accept` method.
2. The implementation of `visit` (or `preVisit`/`postVisit`) that runs is found using overloading based on the node's actual class, which calls `visitor.visit(this)`.
    Because every class implements this on their own, the type of `this` is specifically that class and thus the desired overloaded version of `visit` can be run on the visitor. 
    This is why `accept` needs to be identically implemented in all the subclasses. If it were implemented in the superclass, the type of `this` would be the superclass type, which is insufficient to decide, which `visit` overload needs to be called.
    _In fact, it wouldn't even compile._

##### Detailed example
When running the following in `VisitorPrinter`
```java
printDrawNode(DemoImages.DEMO_GROUP, System.out);
```
these things happen:
1. Visitor created (indent = 0).
2. `GroupNode#accept` called:
    1. `preVisit(GroupNode)` called:
        1. `Group` printed (indent = 0).
        2. Indent increased (indent = 1).
    2. `CircleNode#accept` called:
        1. `visit(CircleNode)` called:
            1. `  Circle` printed (indent = 1).
    3. `TextNode#accept` called:
        1. `visit(TextNode)` called:
            1. `  Text` printed (indent = 1).
    4. `postVisit(GroupNode)` called:
        1. Indent decreased (indent = 0).
    
**You should also try running the visitor examples under the debugger and step through them to see first-hand how things run.**

#### Pros & cons
Visitor pattern allows implementing any number of algorithms on the same data structure without resorting to undesired `instanceof` and casting by adding exactly one method to the data classes.
Thus it solves all the issues described above with previous approaches.

It also is simpler in the sense, that the visitor (specifically the `accept` methods) send the visitor to child nodes automatically, so this doesn't need to be done when implementing such visiting algorithm.
This is great since we don't need to worry about the complex internal structure of the nodes if we don't want to and can only care about some specific nodes, like rectangles.

The pattern doesn't, however, come without its cons:
1. It is significantly more complicated than the other approaches, both in its setup and working mechanism.
2. it isn't always neater to implement a visitor, especially when multiple types need to be treated the same, e.g. in `VisitorCounter` class.

Still, the visitor pattern and other visitor-like patterns are widely preferred when dealing with hierarchical and tree structures consisting of elements of different types. 
In addition to specific application data structures, it's also used more generally, for example:
* Navigating directory and file trees.
* Parsing and writing XML efficiently by streaming.
* Manipulating (abstract) syntax trees of programs in compiler construction.

#### Variations
The visitor pattern implementation used here is only one out of many possible variants.
Different possibilities may include
* iterating children in `visit` methods instead of `accept` methods,
* returning something from `visit` methods,
* passing extra arguments to `accept` and `visit` methods.

The different variants have usually are more flexible but also more complex.
What features are needed from a visitor depends on the specific algorithms and applications.

## Design patterns
There is a very famous software engineering book called ["Design Patterns"](https://en.wikipedia.org/wiki/Design_Patterns) by the so-called **Gang of Four** (GoF) that describes 23 such design patterns.
Among those are the composite and visitor patterns. Others you might have knowingly or unknowingly used are:
* [adapter pattern](https://en.wikipedia.org/wiki/Adapter_pattern),
* [decorator pattern](https://en.wikipedia.org/wiki/Decorator_pattern),
* [chain-of-responsibility pattern](https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern),
* [observer pattern](https://en.wikipedia.org/wiki/Observer_pattern),
* [template method pattern](https://en.wikipedia.org/wiki/Template_method_pattern).

While you shouldn't resort to these possibly sophisticated patterns to solve every object-oriented design issue, being aware of their existence might become handy, especially while reading other people's advanced code that makes use of such patterns.

## Tasks
[This repository](https://github.com/sim642/oop-visitor-template) contains some tasks (in suitable packages) that can be solved by implementing a suitable visitor. Study the `DrawNode` hierarchy, the examples in `sample` package and tests to solve the tasks.
