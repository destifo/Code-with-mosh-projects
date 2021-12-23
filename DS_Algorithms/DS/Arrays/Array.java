

public class Array {
    public int[] list;
    private int lastIndex;


    public Array(int length){
        this.list = new int[length];
    }

    public void getLength(){
        System.out.println(list.length);
    }

    public boolean isEmpty(){
        if (lastIndex == 0){
            return true;
        }
        return false;
    }

    public void insert(int element){
        if (lastIndex == list.length){
            int[] temp = new int[lastIndex * 2];
            for (int i = 0; i < list.length; i++ ){
                temp[i] = list[i];
            }
            list = temp;   
        }
        list[lastIndex++] = element;
        
    }

    public void removeAt(int index){
        if (isEmpty()){
            return;
        }
        list[index] = 0;
        for (int i = index; i < list.length - 1; i++){
            list[i] = list[i + 1];
        }
        lastIndex--;
        // spacewise implementation
        //int[] temp = new int[lastIndex];
        //for (int i = 0; i < lastIndex; i++){
        //    temp[i] = list[i];
        //}
        //list = temp;
        //}
    }

    public void print(){
        System.out.print("[");
        for (int i = 0; i < lastIndex; i++){
            if (i != 0){
                System.out.print(", ");
            }
            System.out.print(list[i]);
        }
        System.out.println("]");
    }

    public int indexOf(int element){
        for (int i = 0; i < list.length; i++){
            int item = list[i];
            if (item == element){
                return i;
            }
        }
        return -1;
    }

    public int max(){
        int largest = -1;
        for ( int i = 0; i < list.length; i++ ){
            if (largest < list[i]){
                largest = list[i];
            }   
        }
        return largest;

    }

    public void reverse(){
        int[] temp = new int[list.length];
        int j = 0;
        for (int i = lastIndex -1; i >= 0; i-- ){
            temp[j++] = list[i];
        }
        list = temp;
        
    }

}