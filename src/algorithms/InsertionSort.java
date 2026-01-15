public class InsertionSort {

    // Audio-visual implementation of insertion sort. The algorithm operates on an array of Element objects,
    // with comparisons and swaps rendered visually and sonified in real time.

    // The structure and audio-visualization approach were coursework-directed; the implementation details
    // reflect student design decisions.

    // Dependencies:
    //  - StdDraw.java (Princeton introcs)
    //  - StdAudio.java (Princeton introcs)

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if( args.length != 1 || n < 1) {
            System.err.println("This program takes a single command line argument, a positive integer int:n");
            System.exit(1);
        }

        //Creating array of Element objects and initializing each Element object to have a random value
        //between 1 and n(the user input: positive integer).
        Element[] array = new Element[n];
        for(int i = 0; i < n; i++) {
            array[i] = new Element((int) (Math.random() * n + 1));
        }

        //Finding the Element object in the array with the smallest value
        int minIndex = 0;
        for(int i = 1; i < array.length; i++) {
            if(array[i].getValue() < array[minIndex].getValue()) {
                minIndex = i;
            }
        }

        //Setting the Element object in the array with the smallest value to have a .sound property that represents
        //a "Concert A" (i.e assign the object with the min value to have .sound with 440 hz) and assigning every
        //other Element in the array a .sound with hz as a function of the difference of the Element's value and
        //the minimum Element's value.
        array[minIndex].setSound(440);
        for(int i = 0; i < array.length; i++) {
            if(i == minIndex) {
                continue;
            }
            else {
                int valueDiff = array[i].getValue() - array[minIndex].getValue();
                array[i].setSound((int)(440 * Math.pow(2, (double)(valueDiff) / 12)));
            }
        }

        //Setting up the StdDraw canvas for the given array length
        StdDraw.setCanvasSize();
        StdDraw.setYscale(0,n);
        StdDraw.setXscale(0,n);

        //Drawing each Element object prior to InsertionSort
        for(int i = 0; i < array.length; i++) {
            array[i].draw(n, i);
            StdAudio.play(array[i].getSound());
        }

        for(int i = 0; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j-1].getValue() > array[j].getValue()) {
                    swap(array, j-1, j);
                    StdDraw.clear();
                    for(int k = 0; k< j - 1; k++) {
                        StdDraw.setPenColor(StdDraw.BLACK);
                        array[k].draw(n,k);
                        StdAudio.play(array[k].getSound());
                    }
                    for(int k = (j - 1); k < (j + 1); k++) {
                        StdDraw.setPenColor(StdDraw.AQUA);
                        array[k].draw(n,k);
                        StdAudio.play(array[k].getSound());
                    }
                    for(int k = j + 1; k < array.length; k++) {
                        StdDraw.setPenColor(StdDraw.BLACK);
                        array[k].draw(n,k);
                        StdAudio.play(array[k].getSound());
                    }
                }
                else {
                    break;
                }
            }
        }

        //Drawing each Element object after InsertionSort
        for(int i = 0; i < array.length; i++) {
            array[i].draw(n, i);
            StdAudio.play(array[i].getSound());
        }

    }

    public static void swap(Element[] a1, int index1, int index2) {
        Element tmp = a1[index1];
        a1[index1] = a1[index2];
        a1[index2] = tmp;
    }
}
