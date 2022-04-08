package course1;

import util.Customer;
import util.SimpleQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Task {


    public static int[][] sort(int[][] matrix){
        int[][] newMatrix = copyMatrix(matrix);
        int timeToQueue;
        int timeToQueue2;
        for (int i = 1; i < newMatrix.length; i++) {
            timeToQueue = (newMatrix[i][0]*60 + newMatrix[i][1])*60 + newMatrix[i][2] +newMatrix[i][3]; //0,1,2 - час, минута, секунда. 3 - время выбора покупок
            int[] array = matrix[i];
            int j;
            for ( j = i - 1; j >= 0; j--) {
                timeToQueue2 = (newMatrix[j][0]*60 + newMatrix[j][1])*60 + newMatrix[j][2] +newMatrix[j][3];
                if (timeToQueue2 < timeToQueue){
                    break;
                }
                newMatrix[j + 1] = newMatrix[j];
            }
            newMatrix[j + 1] = array;

        }
        return newMatrix;
    }


    private static int[][] copyMatrix(int[][] matrix){
        int[][] newMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = new int[matrix[i].length];
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[i].length);
        }
        return newMatrix;
    }

    public static Queue<Customer> matrixToQueueCustomers(int[][] matrix){
        Queue<Customer> queue = new LinkedList<>();

        for (int[] customer : matrix) {
            int timeIn = (customer[0]*60 + customer[1])*60 + customer[2];
            queue.add(new Customer(timeIn,customer[3],customer[4]));
        }

        return queue;
    }
    public static SimpleQueue<Customer> matrixToSimpleQueueCustomers(int[][] matrix){
        SimpleQueue<Customer> queue = new SimpleQueue<>();

        for (int[] customer : matrix) {
            int timeIn = (customer[0]*60 + customer[1])*60 + customer[2];
            queue.add(new Customer(timeIn,customer[3],customer[4]));
        }

        return queue;
    }

    public static void addTimeOut(int[][] matrix) throws Exception {
        SimpleQueue<Customer> customers = Task.matrixToSimpleQueueCustomers(matrix);
        //Queue<Customer> customers = Task.matrixToQueueCustomers(result);

        int prev = -1;
        if (customers.size() != 0) {
            prev = customers.element().getTimeToQueue() + customers.element().getAmountOfGoods();
        }

        int amountOfGoods;
        int timeToQueue;

        for (int i = 0; customers.size() != 0; i++) {
            amountOfGoods = customers.element().getAmountOfGoods();
            timeToQueue = customers.remove().getTimeToQueue();
            prev = Math.max(timeToQueue, prev) + amountOfGoods;
            matrix[i][5] = prev;
        }
    }
}
