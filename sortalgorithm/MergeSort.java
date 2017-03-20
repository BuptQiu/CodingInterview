import java.util.Arrays;
public class MergeSort {
    public static void sort(int dataArray[], int start, int end) {
        if(start<end){
            int mid = (start+end)>>1;
            sort(dataArray,start,mid);
            sort(dataArray,mid+1,end);
            merge(dataArray,start,mid,end);
        }
        return;
    }
    public static void merge(int[] dataArray,int start, int mid, int end){
        int i =start;
        int j = mid+1;
        int[] tempArray = new int[end-start+1];
        int k = 0;
        while(i<=mid&&j<=end){
            if(dataArray[i]<=dataArray[j]){
                tempArray[k++] = dataArray[i++];
            }else{
                tempArray[k++] = dataArray[j++];
            }
        }
        while(i<=mid){
            tempArray[k++] = dataArray[i++];
        }
        while(j<=end){
            tempArray[k++] = dataArray[j++];
        }
        for(int m = 0;m<tempArray.length;m++){
            dataArray[start+m] = tempArray[m];
        }
    }
    public static void mergeSort(int dataArray[]) {
        sort(dataArray, 0, dataArray.length - 1);
    }
    public static void main(String[] args) {
        int dataArray[] = new int[10];
        for(int i=0;i<dataArray.length;i++){
            dataArray[i] = (int)Math.floor(Math.random()*20);
        }
        System.out.println(Arrays.toString(dataArray));
        mergeSort(dataArray);
        System.out.println(Arrays.toString(dataArray));
    }
}