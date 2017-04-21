package sortalgorithm;
public class MinimumHeapSort {
    public static void minHeap(int[] dataArray, int root) {
        int j = root <<1;
        if (j + 1 < dataArray.length) {
            if (dataArray[j] > dataArray[j + 1]) {
                j++;
            }
            if (dataArray[j] < dataArray[root]) {
                swap(dataArray, root, j);
                minHeap(dataArray, root <<1);
            } else {
                return;
            }
        } else if ((j + 1) == dataArray.length) {
            if (dataArray[j] < dataArray[root]) {
                swap(dataArray, root, j);
            }
        }
        return;
    }
    public static int[] buildMinHeap(int[] dataArray, int index) {
        for (int i = (dataArray.length) >>1 -1; i >= index; i--) {
            minHeap(dataArray, i);
        }
        return dataArray;
    }
    public static int[] heapSort(int[] dataArray, int index) {
        if(dataArray==null||dataArray.length<=1){
            return dataArray;
        }
        int[] resultHeap = buildMinHeap(dataArray, 0);
        for (int i = 1; i < dataArray.length-1; i++) {
            int rootValue = resultHeap[dataArray.length-1];
            int[] tempHeap = new int[dataArray.length-i];
            System.arraycopy(resultHeap, i, tempHeap, 1, dataArray.length-i-1);
            tempHeap[0] = rootValue;
            buildMinHeap(tempHeap, 0);
            System.arraycopy(tempHeap,0,resultHeap,i,tempHeap.length);
        }
        return resultHeap;
    }
    public static int[] swap(int[] dataArray, int a, int b) {
        int temp = dataArray[a];
        dataArray[a] = dataArray[b];
        dataArray[b] = temp;
        return dataArray;
    }
    public static void main(String[] args) {
        int[] dataArray = new int[10];
        for (int i = 0; i < dataArray.length; i++) {
            dataArray[i] = (int) Math.floor((Math.random()-0.5) * 20);
        }
        for (int i : dataArray) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        int[] result = heapSort(dataArray, 0);
        for (int i : result) {
            System.err.print(i + " ");
        }
    }
}