public class MaximumHeapSort {
    public static void maxHeap(int[] dataArray, int root, int end) {
        int j = root <<1;
        if (j + 1 < end) {
            if (dataArray[j] < dataArray[j + 1]) {
                j++;
            }
            if (dataArray[j] > dataArray[root]) {
                swap(dataArray, root, j);
                maxHeap(dataArray, root <<1, end);
            } else {
                return;
            }
        } else if ((j + 1) == end) {
            if (dataArray[j] > dataArray[root]) {
                swap(dataArray, root, j);
            }
        }
        return;
    }
    public static int[] buildMaxHeap(int[] dataArray, int end) {
        for (int i = end >>1 -1; i >= 0; i--) {
            maxHeap(dataArray, i, end);
        }
        return dataArray;
    }
    public static int[] heapSort(int[] dataArray, int index) {
        if(dataArray==null||dataArray.length<=1){
            return dataArray;
        }
        int[] resultHeap = new int[dataArray.length];
        for (int i = dataArray.length; i >1; i--) {
            resultHeap = buildMaxHeap(dataArray, i);
            swap(resultHeap,0,i-1);
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