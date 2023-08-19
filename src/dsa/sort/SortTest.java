package dsa.sort;

/**
 * TODO
 *
 * @author kepler
 * @date 2023-08-13 0:25
 */
public class SortTest {
    public static void main(String[] args) {
        int[] num = {9,8,7,6,5,4,3,2,1};
        //InsertSort.insertSort(num);
        BubbleSort.bubbleSort(num);
        printArr(num);
    }

    public static void printArr(int[] list){
        for(int i = 0;i < list.length;i++){
            System.out.printf("%d ",list[i]);
        }
    }
}
