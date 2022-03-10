import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class RandomBucketSort {
    public static void main(String[] args) throws Exception {

        // define the size of arrays
        int[] size = new int[]{10000,50000,250000,1000000,5000000};
        long startTime, endTime, duration, average = 0, prev=1;

        for (int i = 0; i < size.length; i++) {
            for (int j = 0; j < 10; j++) {
                double[] array = randomNumberGenerator(size[i]);    // create random number double array
                startTime = System.nanoTime();                      // starting time
                fastSort(array);                                    // sorting
                endTime = System.nanoTime();                        // ending time
                duration = endTime - startTime;                     // duration
                average += duration;                                // adding
            }
            average = average/10;                                   // calculate average
            
            // print the average duration and rate the terminal 
            if(i != 0){
                System.out.print(i+1 + ". duration: " + average);
                System.out.println(" Rate of previous: " + 1.0*average/prev);
            } 
            else{
                System.out.println(i+1 + ". duration: " + average);
            }
            prev = average;     // previous
            average = 0;        // zero
        }
    }

    // the method takes an integer and return an array that contains random double
    public static double[] randomNumberGenerator(int k) {
        Random random = new Random();

        // create an array that length is k
        double[] array = new double[k];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble(3);
        }

        return array;
    }

    // the method takes a double array and sorts the array
    public static void fastSort(double[] array) {
        LinkedList<Double>[] bucket = new LinkedList[array.length];

        int index = 0;

        // creates lists
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<Double>();
        }

        // adds the elements into bucket
        for (int i = 0; i < array.length; i++) {
            index = (int) (array[i] / 3 * array.length);

            bucket[index].add(array[i]);
        }

        // sorts the buckets
        for (int i = 0; i < bucket.length; i++) {
            Collections.sort(bucket[i]);
        }
        
        index = 0;

        // write the all elements to array
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                array[index] = bucket[i].get(j);
                index++;
            }
        }
    }
}
