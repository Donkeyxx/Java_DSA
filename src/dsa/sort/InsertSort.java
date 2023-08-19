package dsa.sort;

/**
 * TODO 插入排序算法描述
 *  1. 为了将list[i]插入list[0...i-1],需要将list[i]插入在一个名为currentElement的临时变量中
 *  2. 如果 list[i-1] > currentElement,就将list[i - 1]移动到 list[i]
 *  3. 如果 list[i-2] > currentElement,就将list[i - 2]移动到 list[i - 1]
 *  4. 依次类推
 *  5. 直到 list[i - k] <= currentElement 或者 k > i
 *  6. 将 currentElement赋值给 list[i - k + 1]
 *  简而言之就是不断的将一个新的元素插入到已经排好序的序列中,直到整个数组排好序
 * @author kepler
 * @date 2023-08-12 23:58
 */
public class InsertSort {

    public static void insertSort(int[] list){
        for(int i = 1;i < list.length;i++){
            int currentElement = list[i];
            int k = 0;
            for(k = i - 1;k >= 0 && list[k] > currentElement;k--){
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }

}
