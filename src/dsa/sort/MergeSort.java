package dsa.sort;

/**
 * TODO 归并排序算法将数据分为两半,对每部分递归地应用归并排序
 *      在两部分都排好序以后,对它们进行归并
 *
 * @author kepler
 * @date 2023-08-13 13:37
 */
public class MergeSort {
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            int firstHalfLength = list.length / 2;
            int[] firstHalf = new int[firstHalfLength];
            System.arraycopy(list, 0, firstHalf, 0, firstHalfLength);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * 合并两个数组
     * 1.current1 和 current2 指向 list1 和 list2 中要考虑的当前元素
     * 2.不断重复比较list1和list2中的当前元素,并且将一个较小的元素移动到temp中
     * 3.如果较小元素在list1中,那么current1+1;如果较小元素在list2中,那么current2+1
     * 4.如此重复,直到两个数组中的一个数组的所有元素都被移动到temp中
     * 5.如果list1/list2中仍然还有没有移动的元素,那么将它们统一复制到temp中
     * @param list1
     * @param list2
     * @param temp
     */
    public static void merge(int[] list1,int[] list2,int[] temp){
        int current1 = 0; // 指向list1当前元素
        int current2 = 0; // 指向list2当前元素
        int current3 = 0; // 指向list3当前元素

        while(current1 < list1.length && current2 < list2.length){
            if(list1[current1] < list2[current2]){
                temp[current3++] = list1[current1++];
            }else{
                temp[current3++] = list2[current2++];
            }
        }

        while(current1 < list1.length){
            temp[current3++] = list1[current1++];
        }

        while(current2 < list2.length){
            temp[current3++] = list2[current2++];
        }
    }
}























