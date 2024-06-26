package org.bcit.comp2522.dui.client;

/**
 * The type Node.
 *
 * @param <T> the type parameter
 */
public class  Node<T> {
    /**
     * The Data.
     */
    T data;
    /**
     * The Next.
     */
    Node<T> next;

    /**
     * Instantiates a new Node.
     *
     * @param data the data
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}