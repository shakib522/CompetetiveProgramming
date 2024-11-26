package src.main.kotlin;

class Ara{
    public static void main(String[] args) {
        DynamicArray ara=new DynamicArray(4);
        ara.pushback(3);
        ara.pushback(5);
        ara.pushback(8);
        ara.pushback(9);
        ara.pushback(91);
        for (int i = 0; i < ara.getSize(); i++) {
            System.out.println(ara.get(i));
        }
        ara.popback();
        ara.popback();
        for (int i = 0; i < ara.getSize(); i++) {
            System.out.println(ara.get(i));
        }
    }
}

public class DynamicArray {
    int[] ar;
    int size=0;
    int capacity;
    public DynamicArray(int capacity) {
        ar=new int[capacity];
        this.capacity=capacity;
    }

    public int get(int i) {
        return ar[i];
    }

    public void set(int i, int n) {
        ar[i]=n;
    }

    public void pushback(int n) {
        ar[size++]=n;
        if (size==capacity){
            resize();
        }
    }

    public int popback() {
        if (size>0){
            size--;
        }
        return ar[size];
    }

    private void resize() {
        capacity*=2;
        int[] ar2=new int[capacity];
        for (int i = 0; i <size ; i++) {
            ar2[i]=ar[i];
        }
        ar=ar2;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
