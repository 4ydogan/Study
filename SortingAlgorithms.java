public class SortingAlgorithms {
    public static void main(String[] args) {

        int[] lengths = {50, 100, 250, 500, 1000};

        for (int j = 0; j < lengths.length; j++) {

            int length = lengths[j];

            int[] array1 = new int[length];
            int[] array2 = new int[length];
            int[] array3 = new int[length];
            int[] array4 = new int[length];

            for(int i=0; i<length; i++){
                int random = (int) Math.random()*1000;

                array1[i] = random;
                array2[i] = random;
                array3[i] = random;
                array4[i] = random;
            }

            System.out.println("\n------------ array length: " + length + " --------------");

            long startTime = System.nanoTime();
            insertionSort(array1);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Insertion-Sort: " + totalTime);

            startTime = System.nanoTime();
            mergeSort(array2, 0, length-1);
            endTime   = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Merge-Sort: " + totalTime);

            startTime = System.nanoTime();
            heapSort(array3);
            endTime   = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Heap-Sort: " + totalTime);

            startTime = System.nanoTime();
            quickSort(array4, 0, length-1);
            endTime   = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Quick-Sort: " + totalTime);
        }
    }


    public static void insertionSort(int[] A){

        int n = A.length;

        for (int j = 1; j < n; j++) {

            int key = A[j];
            int i = j - 1;
 
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }

            A[i + 1] = key;
        }
    }

    public static void mergeSort(int[] A, int p, int r){
        if(p < r){
            int q = (int) Math.floor((p+r)/2);
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1+1];
        int R[] = new int[n2+1];
  
        for (int i = 0; i < n1; i++)
            L[i] = A[p + i];
        for (int j = 0; j < n2; j++)
            R[j] = A[q + 1 + j];
        
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i=0, j=0;

        for(int k = p; k <= r; k++){
            if (L[i] <= R[j]){
                A[k] = L[i];
                i++;
            }
            else{
                A[k] = R[j];
                j++;
            }
        }
    }


    public static void heapSort(int A[]){
        int n = A.length;
 
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(A, n, i);
 
        for (int i = n - 1; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
 
            heapify(A, i, 0);
        }
        
    }

    public static void heapify(int A[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
 
        if (l < n && A[l] > A[largest])
            largest = l;
 
        if (r < n && A[r] > A[largest])
            largest = r;
 
        if (largest != i) {
            int swap = A[i];
            A[i] = A[largest];
            A[largest] = swap;
 
            heapify(A, n, largest);
        }
    }

    public static void quickSort(int[] A, int p, int r){
        if (p < r){
            int q = partition (A, p, r);
            quickSort (A, p, q - 1);
            quickSort (A, q + 1, r);
        }       
    }

    public static int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p-1;
        
        for(int j=p; j<r; j++){
            if(A[j] <= x){
                i++;
                exchange(A, i, j);
            }
        }

        exchange(A, i+1, r);

        return i+1;
    }

    public static void exchange(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
