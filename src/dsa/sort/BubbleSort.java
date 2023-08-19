package dsa.sort;

/**
 * TODO
 *
 * @author kepler
 * @date 2023-08-13 0:26
 */
public class BubbleSort {
    public static void bubbleSort(int[] list){
        boolean needNextCircle = true;
        for(int k = 1;k < list.length && needNextCircle;k++){
            for(int i = 0;i < list.length - k;i++){
                needNextCircle = false;
                if(list[i] > list[i + 1]){
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextCircle = true;
                }
            }
        }
    }
}
