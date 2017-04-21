package sortalgorithm;
import java.util.Arrays;
public class QuickSort {
    public static void sort(int dataArray[], int start, int end) {
        if(start>end){
            return;
        }
        int i =start;
        int j = end;
        int key = dataArray[start];
        while(i<j){
            while(i < j && dataArray[j]>=key){
                j--;
            }
            if(i<j){
                dataArray[i++] = dataArray[j];
            }
            while(i<j&&dataArray[i]<=key){
                i++;
            }
            if(i<j){
                dataArray[j--] = dataArray[i];
            }
        }
        dataArray[i] = key;
        sort(dataArray,start,i-1);
        sort(dataArray,i+1,end);
    }
    public static void quickSort(int dataArray[]) {
        sort(dataArray, 0, dataArray.length - 1);
    }
    public static void main(String[] args) {
        int dataArray[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(dataArray);
        System.out.println(Arrays.toString(dataArray));
    }
}