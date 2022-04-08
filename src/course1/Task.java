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



    //Тут были рабочие методы сортировки очереди, но из-за свинга ничего не получилось
    //Зачем тут графический интерфейс :(

    /*private static void add(Queue<Customer> queue, Customer newCustomer){
        if(queue.isEmpty()){
            queue.add(newCustomer);
            return;
        }
        for (int i = 0; i < queue.size(); i++) {
            if(!(newCustomer.getTimeToQueue() > queue.element().getTimeToQueue())){
                break;
            }
            queue.add(queue.remove());
        }
*//*        while (newCustomer.getTimeToQueue() > queue.element().getTimeToQueue()){
            queue.add(queue.remove());
        }*//*
        queue.add(newCustomer);
        while (newCustomer.getTimeToQueue() <= queue.element().getTimeToQueue() && !queue.element().equals(newCustomer)){
            queue.add(queue.remove());
        }
    }
    public static Queue<Customer> sort(int[][] matrix){
        Queue<Customer> queue = new LinkedList<>();
        assert matrix != null;
        int time = (matrix[0][0]*60 + matrix[0][1])*60 + matrix[0][2];
        add(queue,new Customer(time,matrix[0][3],matrix[0][4]));

        for (int i = 1; i < matrix.length; i++) {
            time = matrix[i][0]*24 + matrix[i][1]*60 + matrix[i][2];
            Customer newCustomer = new Customer(time,matrix[i][3],matrix[i][4]);
            add(queue,newCustomer);
        }
        return queue;
    }

    public static void copyQueue(Queue<Customer> queue, int[][] matrix){
        for (int i = 0; i <  queue.size(); i++) {
            Customer customer = queue.peek();
            queue.add(queue.remove());
            for (int j = 0; j < matrix.length; j++) {
                int time = (matrix[j][0]*60 + matrix[j][1])*60 + matrix[j][2];
                int choosingTime = matrix[j][3];
                int amountOfGoods = matrix[j][4];
                if(time == customer.getTimeIn() && choosingTime == customer.getChoosingTime() && amountOfGoods == customer.getAmountOfGoods() ){
                    //matrix[]
                }
            }
        }
    }*/
}
