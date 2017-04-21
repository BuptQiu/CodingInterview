package sortalgorithm;
class SelectSort{
    public static int[] selectSort(int[] dataArray, int index){
        int min = dataArray[index];
        int pos=index;
        if(index == dataArray.length-1){
            return dataArray;
        }
        for (int i=index; i<dataArray.length; i++ ) {
            if(min>dataArray[i]){
                min = dataArray[i];
                pos = i;
            }
        }
        swap(dataArray,index,pos);
        index++;
        selectSort(dataArray,index);
        return dataArray;
    }
    public static int[] swap(int[] dataArray, int position1, int position2){
        int temp = dataArray[position1];
        dataArray[position1] = dataArray[position2];
        dataArray[position2] = temp;
        return dataArray;
    }
    public static void main(String[] args){
        int[] dataArray = new int[10];
        for(int i=0;i<10;i++){
            dataArray[i] = (int)Math.floor(Math.random()*10);
        };
        for (int i=0;i<dataArray.length ;i++ ) {
            System.out.print(dataArray[i]+" ");
        }
        System.out.print("\n");
        int[] result = selectSort(dataArray,0);
        for (int i=0;i<result.length ;i++ ) {
            System.out.print(result[i]+" ");
        }
    }
}