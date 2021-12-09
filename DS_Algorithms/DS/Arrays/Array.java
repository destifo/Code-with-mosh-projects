

public class Array {
    private int length;
    public int[] list;
    private int lastIndex = -1;


    public Array(int length){
        this.length = length;
        this.list = new int[length];
    }

    public void getLength(){
        System.out.println(this.length);
    }

    public boolean isEmpty(){
        if (length == 0){
            return true;
        }
        return false;
    }

    public void insert(int element){
        if (lastIndex == length - 1){
            int[] temp = new int[length + 1];
            for (int i = 0; i < list.length; i++ ){
                temp[i] = list[i];
            }
            length += 1;
            list = new int[length];
            for (int i = 0; i < temp.length; i++){
                list[i] = temp[i];
            }   
        }
        lastIndex += 1;
        list[lastIndex] = element;
        
    }

    public void removeAt(int index){
        if (isEmpty()){
            return;
        }
        list[index] = 0;
        for (int i = index; i < list.length - 1; i++){
            list[i] = list[i + 1];
        }
        length = list.length - 1;
        lastIndex = length - 1;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++){
            temp[i] = list[i];
        }
        list = new int[length];
        for (int i = 0; i < length; i++){
            list[i] = temp[i];
        }
    }

    public void print(){
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
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

}