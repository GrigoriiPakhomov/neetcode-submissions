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
    size--;                // 1. Уменьшаем размер
    return arr[size];      // 2. Возвращаем последний элемент
}

    private void resize() {
    int newCapacity = capacity * 2;          // 1. Новая вместимость
    int[] newArr = new int[newCapacity];     // 2. Создаём новый массив
    
    // 3. Копируем старые элементы (цикл или System.arraycopy)
    for (int i = 0; i < size; i++) {
        newArr[i] = arr[i];
    }
    
    arr = newArr;            // 4. Подменяем массив
    capacity = newCapacity;  // 5. Обновляем capacity
}

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
