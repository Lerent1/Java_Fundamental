package Session03.Bai06;

public class XuatSac02 {
    public static void main(String[] args) {
        int[] old = {1, 3, 5, 7, 9};
        int[] newKho = {2, 3, 5, 6, 8, 9, 10};

        int i = 0, j = 0, k = 0;
        int[] temp = new int[old.length + newKho.length];
        while (i < old.length && j < newKho.length) {
            if (old[i] < newKho[j]) {
                temp[k++] = old[i++];
            } else if (old[i] > newKho[j]) {
                temp[k++] = newKho[j++];
            } else {
                temp[k++] = old[i];
                i++;
                j++;
            }
        }

        while (i < old.length) {
            temp[k++] = old[i++];
        }

        while (j < newKho.length) {
            temp[k++] = newKho[j++];
        }

        int[] arrayMerge = new int[k];
        int size = 0;

        arrayMerge[size++] = temp[0];
        for (int x = 1; x < k; x++) {
            if (temp[x] != temp[x - 1]) {
                arrayMerge[size++] = temp[x];
            }
        }

        System.out.print("Kho tong: ");
        for (int x = 0; x < size; x++) {
            System.out.print(arrayMerge[x] + " ");
        }
    }
}
