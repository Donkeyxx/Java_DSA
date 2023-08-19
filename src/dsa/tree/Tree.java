package dsa.tree;

import java.util.Collection;

/**
 * TODO
 *  1. 二叉树是一种层次结构
 *      它要么是空集
 *      要么是由一个称为根的元素和两颗不同的二叉树组成的,这两棵二叉树分别称为左子树和右子树
 *      允许这两颗子树中的一颗或者两颗为空
 *  2. 二叉树的每个结点有0棵,1棵或2棵子树
 *  3. 一条路径的长度是指在该条路径上的边的数量
 *  4. 一个结点的深度是指从 根节点 到 该结点 的路径长度
 *  5. 一棵树中具有某个给定深度的所有结点的集合称为该树的层
 *  6. 兄弟结点是共享同一父亲的结点
 *  7. 一个结点的左子树的根称为这个结点的左子结点
 *  8. 一个结点的右子树的根称为这个结点的右子结点
 *  9. 没有子结点的结点称为叶子结点
 *  10. 非空树的高度为从根结点到最远的叶子结点的路径长度
 *          只包含一个结点的树的高度为0
 *          习惯上将空树的高度定义为 -1
 * @author kepler
 * @date 2023-08-19 10:52
 */
public interface Tree<E> extends Collection<E> {
    /**
     * 如果元素e在树中,那么返回true;否则返回false
     * @param e
     * @return
     */
    public boolean search(E e);

    /**
     * 将一个元素插入树中,如果插入成功那么返回true;否则返回false
     * @param e
     * @return
     */
    public boolean insert(E e);

    /**
     * 将一个元素从树中删除,如果删除成功返回true;否则返回false
     * @param e
     * @return
     */
    public boolean delete(E e);

    /**
     * 返回树中元素的个数
     * @return
     */
    public int getSize();

    /**
     * 中序遍历树
     */
    public default void inorder(){}

    /**
     *  后序遍历树
     */
    public default void postorder(){}

    /**
     * 先序遍历树
     */
    public default void preorder(){}

    /**
     * 如果树是空的那么返回true
     * @return
     */
    @Override
    public default boolean isEmpty(){
        return size() == 0;
    }


    @Override
    public default boolean contains(Object e){
        return search((E) e);
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public default boolean add(E e){
        return insert((E) e);
    }

    @Override
    public default boolean remove(Object e){
        return delete((E) e);
    }

    @Override
    public default int size(){
        return getSize();
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c){
        return false;
    }

    @Override
    public default boolean removeAll(Collection<?> c){
        return false;
    }

    @Override
    public default boolean retainAll(Collection<?> c){
        return false;
    }

    @Override
    public default Object[] toArray(){
        return null;
    }

    @Override
    public default <T> T[] toArray(T[] a){
        return null;
    }


}
