class DynamicArray {
    private int[] arr;
    private int size;
    private int capacity;


    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity){
            resize();
        }
        arr[size] = n;
        size++;

    }

    public int popback() {
    size--;                
    return arr[size];      
}

    private void resize() {
    int newCapacity = capacity * 2;          
    int[] newArr = new int[newCapacity];     
    
    for (int i = 0; i < size; i++) {
        newArr[i] = arr[i];
    }
    
    arr = newArr;            
    capacity = newCapacity;  
}

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
