package LinearSearch;

public class LinearSearch <T> {
    public int search(T [] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target))
                return i;
        }
        return -1;
    }
}
