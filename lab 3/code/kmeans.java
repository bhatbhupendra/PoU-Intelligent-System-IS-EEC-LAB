import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class kmeans {
    int x[], y[]; // data points
    int num; // number of data points (supplied by the user)
    int k; // number of clusters (supplied by the user)
    double meanX[], meanY[]; // cluster centres
    double oldX[], oldY[]; // backup old cluster centres
    int cAssign[]; // cluster assignment

    private kmeans(int num, int clusters) {
        this.num = num;
        x = new int[num];
        y = new int[num];
        k = clusters;
        meanX = new double[k];
        meanY = new double[k];
        oldX = new double[k];
        oldY = new double[k];
        cAssign = new int[num];

    }

    void randomMean() {
        // Initialize meanX and meanY with random values between 0 and 500 for all k
        // centres
        // using the nextInt() method in the java.util.Random class
        for (int i = 0; i < k; i++) {
            Random rand = new Random();
            int first = rand.nextInt(499) + 1;
            int second = rand.nextInt(499) + 1;

            this.meanX[i] = first * 1.0;
            this.meanY[i] = second * 1.0;

        }

    }

    void randomData() {
        // for random x and y data
        for (int i = 0; i < num; i++) {
            Random rand = new Random();
            int first = rand.nextInt(499) + 1;
            int second = rand.nextInt(499) + 1;
            x[i] = first;
            y[i] = second;

        }

    }

    void assignCluster() {
        // Calculate the distance between the point and the cluster centre
        // The Euclidean distance between the jth data point and ith cluster centre is:
        double distance[] = new double[k];// stores the k distances
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < k; j++) {
                distance[j] = Math.sqrt(Math.pow(x[i] - meanX[j], 2) + Math.pow(y[i] - meanY[j], 2));
            }

            double minValue = distance[0];
            int minIndex = 0;
            for (int j = 0; j < k; j++) {
                if (distance[j] < minValue) {
                    minValue = distance[j];
                    minIndex = j;
                }
            }
            cAssign[i] = minIndex;

        }

        // Calculate distance for all k clusters and assign j to whichever i has the
        // smallest distance
        // Assign this i to cAssign
    }

    void updateMeans() {
        // Before updating the centres, backup meanX and meanY (copy to oldX and oldY)

        for (int j = 0; j < k; j++) {
            oldX[j] = meanX[j];
            oldY[j] = meanY[j];
        }

        // Calculate meanX and meanY for each cluster

        // this stores total sum in meanX and meanY
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < num; i++) {
                if (cAssign[i] == j) {
                    meanX[j] += x[i];
                    meanY[j] += y[i];
                }
            }

        }
        // updatindg meanX and meanY by dividing it with num ie 100 [which eventually
        // the mean]
        for (int j = 0; j < k; j++) {
            meanX[j] = meanX[j] / num;
            meanY[j] = meanY[j] / num;
        }

    }

    boolean isDifferent() {
        // return true if meanX≠oldX or meanY≠oldY for one or more clusters
        // Otherwise return false

        if (meanX[0] != oldX[0]) {
            return true; // returns true
        } else {
            return false;
        }
    }

    void doClustering() {
        // This is where you implement the clustering algorithm. Simple isn’t it.
        randomMean();
        randomData();
        do {
            assignCluster();
            updateMeans();
        } while (isDifferent());
    }

    public static void main(String[] args) {

        kmeans km = new kmeans(100, 2);
        km.doClustering();
        System.out.println("The X and Y values are");
        System.out.println(Arrays.toString(km.x));
        System.out.println(Arrays.toString(km.y));
        System.out.println("The value after k clustering");
        System.out.println(Arrays.toString(km.cAssign));
        // System.out.println(Arrays.toString(km.meanX));
        // System.out.println(Arrays.toString(km.meanY));
        // System.out.println(Arrays.toString(km.oldX));
        // System.out.println(Arrays.toString(km.oldY));

    }

}
