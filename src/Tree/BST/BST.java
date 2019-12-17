package Tree.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E> > {
    private class Node{
        public E val;
        public Node left;
        public Node right;
        public Node(E val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素e
     * @param e
     */
    public void add(E e){
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     * 返回插入新节点后，二分搜索树的根
     * @param node
     * @param e
     */
    private Node add(Node node, E e){
        if (node == null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.val) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.val) > 0)
            node.right = add(node.right, e);
        return node;
    }

    /**
     * 看二分搜索树是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e，递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e){
        if (node == null)
            return false;
        else {
            if (e.compareTo(node.val) < 0)
                return contains(node.left, e);
            if (e.compareTo(node.val) == 0)
                return true;
            else
                return contains(node.right, e);
        }
    }

    /**
     * 前序遍历（非递归）
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            stack.push(cur.left);
        }
    }

    public void preOrder(){
        preOder(root);
    }

    /**
     * 前序遍历（递归）
     * @param node
     */
    private void preOder(Node node){
        if (node == null)
            return;
        System.out.println(node.val);
        preOder(node.left);
        preOder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.val);
            if (cur.left != null)
                queue.add(root.left);
            if (cur.right != null)
                queue.add(root.right);
        }
    }

    /**
     * 查找二分搜索树最小的元素（递归）
     * @return
     */
    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("二叉树为空");
        return minimum(root).val;
    }

    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    public E minimumNR(){
        if (size == 0)
            throw new IllegalArgumentException("二叉树为空");
        if (root.left == null)
            return root.val;
        Node cur = root;
        while (cur.left != null){
            cur = cur.left;
        }
        return cur.val;
    }

    /**
     * 删除以node为根的二分搜索树的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 查找二叉树最大的元素
     * @return
     */
    public E maximum(){
        if (size == 0)
            throw new IllegalArgumentException("二叉树为空");
        return maximum(root).val;
    }

    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    /**
     * 删除以node为根的二分搜索树的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if (node.right == null){
            Node rightNode = node.left;
            node.left = null;
            size--;
            return rightNode;
        }
        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 删除二分搜索树中的任意元素
     * @return
     */
    public void remove(E e){
        root =  remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.val) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.val) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null){
                Node rightNode = node.left;
                node.left = null;
                size--;
                return rightNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("前序遍历为:");
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node root, int depth, StringBuilder sb){
        if (root == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + root.val + "\n");
        generateBSTString(root.left, depth+1, sb);
        generateBSTString(root.right, depth+1, sb);
    }

    private String generateDepthString(int depth){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<depth; i++){
            sb.append("-");
        }
        return sb.toString();
    }
}
