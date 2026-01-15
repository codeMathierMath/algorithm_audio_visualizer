public class MergeSort {

    // Audio-visual implementation of merge sort. Recursive subdivision and merging steps are visualized through
    // color-coding and audio playback.

    // The algorithmic structure follows standard mergesort; visualization timing and element mapping were implemented
    // as part of coursework.

    // Dependencies:
    //  - StdDraw.java (Princeton introcs)
    //  - StdAudio.java (Princeton introcs)


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (args.length != 1 || n < 1) {
            System.err.println("This program takes a single command line argument, a positive integer int:n");
            System.exit(1);
        }

        //Creating array of Element objects and initializing each Element object to have a random value
        //between 1 and n(the user input: positive integer).
        Element[] array = new Element[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Element((int) (Math.random() * n + 1));
        }

        //Finding the Element object in the array with the smallest value
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i].getValue() < array[minIndex].getValue()) {
                minIndex = i;
            }
        }

        //Setting the Element object in the array with the smallest value to have a .sound property that represents
        //a "Concert A" (i.e assign the object with the min value to have .sound with 440 hz) and assigning every
        //other Element in the array a .sound with hz as a function of the difference of the Element's value and
        //the minimum Element's value.
        array[minIndex].setSound(440);
        for (int i = 0; i < array.length; i++) {
            if (i == minIndex) {
                continue;
            } else {
                int valueDiff = array[i].getValue() - array[minIndex].getValue();
                array[i].setSound((int) (440 * Math.pow(2, (double) (valueDiff) / 12)));
            }
        }

        //Setting up the StdDraw canvas for the given array length
        StdDraw.setCanvasSize();
        StdDraw.setYscale(0, n);
        StdDraw.setXscale(0, n);

        //Drawing each Element object prior to MergeSort
        for (int i = 0; i < array.length; i++) {
            array[i].draw(n, i);
            StdAudio.play(array[i].getSound());
        }

        mergeSort(array);
    }

    public static void mergeSort(Element[] array1) {
        mergeSort_Helper(array1, 0, array1.length);
    }

    public static void mergeSort_Helper(Element[] array, int lo, int hi) {

        int n = array.length;
        //Base case: the sub-array has length 0 or 1
        if (hi - lo <= 1) {
            StdDraw.clear();
            for (int i = 0; i < lo; i++) {
                StdDraw.setPenColor(StdDraw.BLACK);
                array[i].draw(n, i);
                StdAudio.play(array[i].getSound());
            }
            for (int i = lo; i < lo + 1; i++) {
                StdDraw.setPenColor(StdDraw.AQUA);
                array[i].draw(n, i);
                StdAudio.play(array[i].getSound());
            }
            for (int i = lo + 1; i < n; i++) {
                StdDraw.setPenColor(StdDraw.BLACK);
                array[i].draw(n, i);
                StdAudio.play(array[i].getSound());
            }

        } else {
            StdDraw.clear();
            int mid = lo + (hi - lo) / 2;

            mergeSort_Helper(array, lo, mid);
            mergeSort_Helper(array, mid, hi);

            merge(array, lo, hi);
        }
    }

    public static void merge(Element[] array, int lo, int hi) {
        int n = array.length;
        int mid = lo + (hi-lo)/2;
        Element[] merged = new Element[hi-lo];
        int low_i = lo;
        int upp_i = mid;
        for (int mer_i = 0; mer_i < merged.length; mer_i++) {
            if (low_i == mid) {
                while(upp_i < hi) {
                    merged[mer_i] = array[upp_i];
                    upp_i++;
                    mer_i++;
                }
                break;
            }
            else if (upp_i == hi) {
                while (low_i < mid) {
                    merged[mer_i] = array[low_i];
                    low_i++;
                    mer_i++;
                }
                break;
            }
            else if (array[low_i].compareTo(array[upp_i]) < 0) {
                merged[mer_i] = array[low_i];
                low_i++;
            }
            else {
                merged[mer_i] = array[upp_i];
                upp_i++;
            }
        }

        //Copy the elements of merged back into array in the correct place.
        for (int i = 0; i < merged.length; i++) {
            array[lo + i] = merged[i];
        }

        //Using StdDraw to show the sorting via color coding.
        StdDraw.clear();
        for (int i = 0; i < lo; i++) {
            StdDraw.setPenColor(StdDraw.BLACK);
            array[i].draw(n, i);
            StdAudio.play(array[i].getSound());
        }
        for (int i = lo; i < hi; i++) {
            StdDraw.setPenColor(StdDraw.AQUA);
            array[i].draw(n, i);
            StdAudio.play(array[i].getSound());
        }
        for (int i = hi; i < array.length; i++) {
            StdDraw.setPenColor(StdDraw.BLACK);
            array[i].draw(n, i);
            StdAudio.play(array[i].getSound());
        }
    }

}