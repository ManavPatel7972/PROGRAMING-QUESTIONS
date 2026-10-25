class MyHashSet {
    boolean[] arr;

    MyHashSet() {
        arr = new boolean[1000001];
    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }
}

public class DesignHashSet {
    public static void main(String[] args) {

    }

}
