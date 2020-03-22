public class CycleShift {
    private static int[] arr;

    public CycleShift(int[] arr) {
        this.arr = arr;
    }

    public int[] shift(int shift) {
        int tmp;
        int x = 0;
        int length = arr.length;
        while (x < shift) {
            tmp = arr[length - 1];
            for (int i = length - 1; i >= 1; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;
            x++;
        }
        return arr;
    }
}