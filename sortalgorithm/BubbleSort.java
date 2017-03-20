import java.util.Arrays;
public class BubbleSort {
    public static void sort(int dataArray[], int start, int end) {
        if(start>end){
            return;
        }
        int i =start;
        int j = end;
        int key = findmid(dataArray,start,end);
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
    public static int findmid(int[] dataArray ,int start, int end){
        int mid = start+(end-start)>>1;
        if(dataArray[start]>dataArray[end]){
            swap(dataArray,start,end);
        }
        if(dataArray[mid]>dataArray[end]){
            swap(dataArray,mid,end);
        }
        if(dataArray[start]<dataArray[mid]){
            swap(dataArray,start,mid);
        }
        return dataArray[start];
    }
    public static void swap(int[] dataArray, int a, int b) {
        int temp = dataArray[a];
        dataArray[a] = dataArray[b];
        dataArray[b] = temp;
        return;
    }
    public static void quickSort(int dataArray[]) {
        sort(dataArray, 0, dataArray.length - 1);
    }
    public static void main(String[] args) {
        int dataArray[] = new int[10];
        for(int i=0;i<dataArray.length;i++){
            dataArray[i] = (int)Math.floor(Math.random()*20);
        }
        quickSort(dataArray);
        System.out.println(Arrays.toString(dataArray));
    }
}