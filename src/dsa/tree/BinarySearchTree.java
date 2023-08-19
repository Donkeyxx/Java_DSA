package dsa.tree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * TODO
 *  1.中序遍历,前序遍历和后序遍历的时间复杂度都是O(n),因为树中有n个结点,每个结点只访问一次
 *  2.查找,删除和插入的时间复杂度是树的高度,也就是O(logn)
 *          在最差的情况下,树的高度为O(n),平均而言树的高度是O(logn)
 *    因此在一颗BST中,查找,插入和删除操作的平均时间是O(logn)
 *
 * @author kepler
 * @date 2023-08-19 11:07
 */
public class BinarySearchTree<E extends Comparable<E>> implements Tree<E>{
    protected TreeNode<E> root;
    protected int size = 0;

    /**
     * 创建一颗空的BST
     */
    public BinarySearchTree(){}

    /**
     * 通过一个数组来创建一颗BST
     * @param objects
     */
    public BinarySearchTree(E[] objects){
        for(int i = 0;i < objects.length;i++){
            add(objects[i]);
        }
    }

    /**
     * 如果要查找的元素在树中返回true
     * @param e
     * @return
     */
    @Override
    public boolean search(E e) {
        //比较首先从树的根结点开始
        TreeNode<E> current = root;
        //开始比较,直到找到要查询的元素或者到达一棵空子树为止
        while(current != null){
            if(e.compareTo(current.element) < 0){ //如果e小于当前指向的结点,那么指针应该指向当前结点的左子树根结点
                current = current.left;
            }else if(e.compareTo(current.element) > 0){//如果e大于当前指向的结点,那么指针应该指向当前结点的左子树根结点
                current = current.right;
            }else{
                return true; // e 等于当前指针指向结点的值
            }
        }
        return false;
    }

    /**
     * 向BST中插入新元素,插入成功返回true
     * BST中插入的情况只有 1. 树是空树 2.树不是空树
     * 只要确定了要插入结点的父亲结点在树中的位置,就可以确定要插入元素的位置
     * 插入操作只有当要插入的元素已经在树中的时候才会是失败的
     * @param e
     * @return
     */
    @Override
    public boolean insert(E e) {
        if(root == null){
            //如果树是空的,就用这个新元素创建一个根结点
            root = createNewNode(e);
        }else{
            //寻找新元素结点的父结点的位置,如果新元素小于父节点,那么将它链接到父结点的左子结点,大于的话链接到父结点的右子结点
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            //开始查找父结点的位置,当current指向null的时候,说明父结点的位置已经找到了
            while(current != null){
                if(e.compareTo(current.element) < 0){
                    parent = current;
                    current = current.left;
                }else if(e.compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                }else{
                    return false; // 要插入的元素已经在树中,这里我们不插入重复的元素
                }
            }
            //最后将要插入的元素链接到父结点上
            if(e.compareTo(parent.element) < 0){
                parent.left = createNewNode(e);
            }else{
                parent.right = createNewNode(e);
            }
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e){
        return new TreeNode<>(e);
    }

    /**
     * 中序遍历BST
     */
    @Override
    public void inorder() {
        inorder(root);
    }

    /**
     * 就算插入元素的顺序不同,但只要这些元素组成的集合是相等的,那么中序遍历得到的结果就是一样的
     * @param root
     */
    protected void inorder(TreeNode<E> root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    /**
     * 先序遍历BST
     */
    @Override
    public void preorder(){
        preorder(root);
    }
    protected void preorder(TreeNode<E> root){
        if(root == null)
            return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 后序遍历BST
     */
    @Override
    public void postorder(){
        preorder(root);
    }
    protected void postorder(TreeNode<E> root){
        if(root == null)
            return;
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.element + " ");
    }

    /**
     * 返回树中结点的个数
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 返回根结点
     * @return
     */
    public TreeNode<E> getRoot(){
        return root;
    }

    /**
     * 返回一条从根结点到指定结点的路径,通过数组线性表的形式返回
     * @param e
     * @return
     */
    public ArrayList<TreeNode<E>> path(E e){
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;
        //需要改进,因为还没有考虑元素不在树中的情况
        while(current != null){
            list.add(current);
            if(e.compareTo(current.element) < 0){
                current = current.left;
            }else if(e.compareTo(current.element) > 0){
                current = current.right;
            }else{
                break;
            }
        }
        return list;
    }


    /**
     * 删除BST中的特定元素
     * 1.首先确定要删除的元素的结点的位置,以及该结点的父结点的位置
     * 2.注意: 要删除的结点可能是父结点的左子结点也可能是右子结点
     * 3.在删除之前,要考虑两种情况:
     *      (1)当前结点没有左子结点:
     *          这时只需要将该结点的父亲结点和该结点的右子结点相连即可
     *          例如: 如果当前结点是叶子结点,也就是没有左孩子,这时候直接将null赋值给当前结点的父结点即可
     *      (2)当前结点有左子结点:
     *          假设 leftMost 指向包含 current 结点的左子树中的最大的那个结点
     *          parentOfLeftMost 指向 leftMost 结点的父结点
     *          显然,leftMost 结点不会有右孩子,因为它是 current结点 的左子树中最大的结点,但是它可以有左孩子
     *          使用 leftMost结点 中的值替换 current结点 中的元素值
     *          将 parentOfLeftMost结点 和 leftMost结点 的左孩子(如果有的话)相连
     *          最后删除 leftMost结点
     *
     * @param e
     * @return 如果删除成功返回true,如果要删除的元素不在树中的话返回false
     */
    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null; // parent指向要删除结点的父结点
        TreeNode<E> current = root; // current指向将要删除的结点
        //开始定位要删除的结点
        while(current != null){
            if(e.compareTo(current.element) < 0){
                parent = current;
                current = current.left;
            }else if(e.compareTo(current.element) > 0){
                parent = current;
                current = current.right;
            }else{
                break; // 找到要删除的元素,停止定位
            }
        }
        //要删除的元素不在数中
        if(current == null)
            return false;
        if(current.left == null){ // 第一种情况: 当前结点没有左孩子
            if(parent == null){ // 第一种情况中的特殊情况: 要删除的结点是树中的根结点
                root = current.right; // 根结点的右孩子称为新的根结点
            }else{ // 如果要删除的结点不是根结点
                if(e.compareTo(parent.element) < 0) // 当前结点的值小于当前结点的父结点的值,说明当前结点是父节点的左孩子
                    parent.left = current.right; // 将当前结点的右孩子连接到当前结点父结点的左孩子上
                else //当前结点的值大于当前结点的父结点的值,说明当前结点是父节点的右孩子
                    parent.right = current.right; //将当前结点的右孩子连接到当前结点父结点的右孩子上
            }
        }else{ // 第二种情况,当前结点有左孩子
            TreeNode<E> parentOfLeftMost = current; // parentOfLeftMost 指向当前结点的左子树中最大结点的父结点
            TreeNode<E> leftMost = current.left; // leftMost 指向当前结点的左子树中的最大的结点
            // 定位当前结点的左子树中最大的结点和最大结点的父结点
            while(leftMost.right != null){
                parentOfLeftMost = leftMost;
                leftMost = leftMost.right;
            }
            // 找到最大结点以后,将当前结点的值替换为最大结点的值
            current.element = leftMost.element;
            // 要注意leftMost没有右孩子,如果有的话它就不是最大的结点了
            if(parentOfLeftMost.right == leftMost){ // 如果leftMost是parentOfLeftMost的右孩子
                parentOfLeftMost.right = leftMost.left; // 将leftMost的左孩子赋值给parentOfLeftMost的右子结点
            }else{ //如果leftMost是parentOfLeftMost的左孩子
                parentOfLeftMost.left = leftMost.left; // 将leftMost的左孩子赋值给parentOfLeftMost的左子结点
            }
        }
        size--;
        return true;
    }

    /**
     * 清除树中所有元素
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements Iterator<E>{
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;

        public InorderIterator(){
            inorder();
        }

        private void inorder(){
            inorder(root);
        }

        private void inorder(TreeNode<E> root){
            if(root == null){
                return;
            }
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            if (current < list.size()){
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            if (current == 0){
                throw new IllegalStateException();
            }
            delete(list.get(--current));
            list.clear();
            inorder();
        }
    }

    public static class TreeNode<E>{
        public E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e){
            this.element = e;
        }
    }
}
