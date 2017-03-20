/**
 * 实现快速插入算法
 */

public class InsertSort{
    public static int[] insertSort(int[] dataArray, int index){
        for(int i=index;i<dataArray.length;i++){
            int key = dataArray[i];
            int pos = i;
            for(int j=i-1;j>=0;j--){
                if(dataArray[j]>key){
                    dataArray[j+1] = dataArray[j];
                    pos --;
                }else{
                    break;
                }
            }
            dataArray[pos] = key;
        }
        return dataArray;
    }
    public static void main(String[] args){
        int[] dataArray = new int[10];
        for(int i=0;i<10;i++){
            dataArray[i] = (int)Math.floor(Math.random()*20);
        };
        for (int i=0;i<dataArray.length ;i++ ) {
            System.out.print(dataArray[i]+" ");
        }
        System.out.print("\n");
        int[] result = insertSort(dataArray,0);
        for (int i=0;i<result.length ;i++ ) {
            System.out.print(result[i]+" ");
        }
    }
}