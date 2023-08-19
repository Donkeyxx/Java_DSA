package test;

import dsa.tree.BinarySearchTree;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author kepler
 * @date 2023-08-19 14:28
 */
public class TestBST {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        System.out.print("\n先序遍历: ");
        tree.preorder();


        System.out.print("\n中序遍历 (sorted): ");
        tree.inorder();

        System.out.print("\n后序遍历: ");
        tree.postorder();

        System.out.println("\n树中结点的个数是: " + tree.getSize());

        System.out.println("Peter是否在树中? " + tree.search("Peter"));

        System.out.print("从根结点到Peter所在结点的路径是: ");
        ArrayList<BinarySearchTree.TreeNode<String>> path = tree.path("Peter");
        for(int i = 0; path != null && i < path.size(); i++){
            System.out.print(path.get(i).element + " ");
        }



        Integer[] numbers = {2,4,3,1,8,5,6,7};
        BinarySearchTree<Integer> intTree = new BinarySearchTree<>(numbers);
        System.out.print("\n中序遍历结果: ");
        intTree.inorder();

        System.out.println("\n\n删除元素1.");
        System.out.println(intTree.delete(1));
        System.out.print("中序遍历结果: ");
        intTree.inorder();

        System.out.println("\n删除元素5.");
        intTree.delete(5);
        System.out.print("中序遍历结果: ");
        intTree.inorder();

        System.out.println("\n删除元素2.");
        intTree.delete(2);
        System.out.print("中序遍历结果: ");
        intTree.inorder();
    }
}
