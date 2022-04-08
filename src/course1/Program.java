package course1;

import util.Customer;
import util.SwingUtils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Queue;


public class Program {
    public static void main(String[] args) {
/*
        int[][] matrix = new int[][]{
                {1, 0, 50, 10, 10, 0},
                {0, 1, 0, 19, 0, 0},
                {0,2,0,0,0,0},
                {0, 1, 0, 10, 10, 0},
                {0, 1, 10, 10, 10, 0}
        };


        for (int i = 0; i < matrix.length; i++) {
            //time --;
            // v == 0 -> q.add
            //if (q.size > i){
            //
            // }
            //{1, 2,3}
        }
*/
/*        int[] a = matrix[0];
        matrix[0] = matrix[1];
        matrix[1] = a;*//*

       // int[][] newMatrix = Task.sort(matrix);
        int[][] result = Task.sort(matrix);

        Queue<Customer> customers = Task.matrixToQueueCustomers(result);

        int prev = -1;
        if (!customers.isEmpty()) {
            prev = customers.peek().getTimeToQueue() + customers.peek().getAmountOfGoods();
        }

        int amountOfGoods;
        int timeToQueue;
        for (int i = 0; i < Math.min(customers.size(), matrix.length); i++) {
            amountOfGoods = customers.peek().getAmountOfGoods();
            timeToQueue = customers.remove().getTimeToQueue();
            matrix[i][5] = Math.max(timeToQueue, prev) + amountOfGoods;
        }


        System.out.println(Arrays.deepToString(result));
*/

        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));
    }
}
