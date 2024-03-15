/**
 * A node can be defined as a class
 * Each node satisfies the binary search tree property that its key is greater
 * than the key to its left child and less than the
 * key of its right child. The head object points to the list of articles for a
 * given key word
 */
class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    protected Node<Article> head;

    public TreeNode(E e) {
        element = e;
    }

    /**
     * All titles for a given key word are placed in the list at the node for that
     * key word; they should be
     * inserted at the BEGINNING of the list.
     */
    public void addFirst(Article a) {
        Node<Article> newNode = new Node<>(a); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        // size++; // Increase list size
    }
}