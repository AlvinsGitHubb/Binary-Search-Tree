//line 45

/**
 * This BST class implements binary search tree and use it to store and retrieve
 * articles.
 * The tree will be sorted by keyword, and each node will contain an unordered
 * linked list of Article
 * objects which contain information about each article that corresponds to that
 * keyword.
 * 
 * Each node satisfies the binary search tree property that its key is greater
 * than the key to its left child and less than the
 * key of its right child. All titles for a given key word are placed in the
 * list at the node for that key word; they should be
 * inserted at the BEGINNING of the list.
 * 
 */
public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size = 0;

    /** Create a default binary search tree */
    public BST() {
    }

    /**
     * insert an element into a BST, you need to locate where to insert it in the
     * tree. The key idea
     * is to locate the parent for the new node.
     * 
     * If the tree is empty, create a root node with the new element. Otherwise,
     * locate the
     * parent node for the new element node. Create a new node for the element and
     * link
     * this node to its parent node. If the new element is less than the parent
     * element, the node for the
     * new element will be the left child of the parent. If the new element is
     * greater than the parent
     * element, the node for the new element will be the right child of the parent.
     * 
     * Insert element e into the binary search tree. Return true if the element is
     * inserted successfully.
     */
    public boolean insert(E e, Article a) {
        // e = node
        // a = article info
        if (root == null) {
            root = createNewNode(e); // Create a new root
            root.addFirst(a); // add an article to the root
        } else {
            // Locate the parent node
            TreeNode<E> parent = null; // first mark the parent as null
            TreeNode<E> current = root;
            // this while loop traverses from the parent node down
            while (current != null) // if current = null then we got a free spot
                // if given element is less than current element, given = left child
                if (e.compareTo(current.element) < 0) { // .compareto returns 0 if both strings r equal
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    // return false; // Duplicate node not inserted
                    current.addFirst(a); // replace the dup w the given
                    return false; // we now leave this whole method
                }
            // we r currently looking at free spots to put in the given node
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
                parent.left.addFirst(a);
            } else {
                parent.right = createNewNode(e);
                parent.right.addFirst(a);
            }
        }
        size++;
        return true; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    /**
     * To search for an element in the BST, you start from the root and scan down
     * from it until a
     * match is found or you arrive at an empty subtree
     * - If element is less than current.element, assign current.left to current
     * - If element is greater than current.element, assign current.right to current
     * - If element is equal to current.element, return true
     * 
     * If current is null, the subtree is empty and the element is not in the tree
     */
    public boolean search(E element) {
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                current = current.left; // Go left
            } else if (element.compareTo(current.element) > 0) {
                current = current.right; // Go right
            } else {// Element matches current.element
                print(current);
                return true; // Element is found
            }
        }
        System.out.printf("Keyword %s does not exist in the information database!", element);
        return false; // Element is not in the tree
    }

    /** Inorder traversal from the root */
    public void inorder() {
        inorder(root);
    }

    /**
     * Tree traversal is the process of visiting each node in the tree exactly once.
     * There are several
     * ways to traverse a tree.
     * With inorder traversal, the left subtree of the current node is visited first
     * recursively, then
     * the current node, and finally the right subtree of the current node
     * recursively. The inorder
     * traversal displays all the nodes in a BST in increasing order
     * 
     * Inorder traversal from a subtree
     */
    protected void inorder(TreeNode<E> root) {
        if (root == null) // if nothing in root go back
            return;
        inorder(root.left);
        System.out.print(root.element + " ");
        Node<Article> artRec = root.head; // get head of article linked list in order to access current node
        System.out.println("\t");
        while (artRec != null) {
            System.out.printf("%s", artRec); // find current node in linked list
            artRec = artRec.next;
        }
        System.out.println();
        inorder(root.right); // now do it all for the left subtree
    }

    protected void print(TreeNode<E> t) {
        if (t == null)
            return;
        System.out.print(t.element + " ");
        Node<Article> artRec = root.head;
        System.out.println("\t");
        while (artRec != null) {
            System.out.printf("%s", artRec);
            artRec = artRec.next;
        }
        System.out.println();
    }
}