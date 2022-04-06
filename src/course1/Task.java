package course1;

import util.Customer;

import java.util.LinkedList;
import java.util.Queue;

public class Task {
    private static void add(Queue<Customer> queue, Customer newCustomer){
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
/*        while (newCustomer.getTimeToQueue() > queue.element().getTimeToQueue()){
            queue.add(queue.remove());
        }*/
        queue.add(newCustomer);
        while (newCustomer.getTimeToQueue() <= queue.element().getTimeToQueue() && !queue.element().equals(newCustomer)){
            queue.add(queue.remove());
        }
    }
    public static Queue<Customer> sort(int[][] matrix){
        Queue<Customer> queue = new LinkedList<>();
        assert matrix != null;
        int time = matrix[0][0]*24 + matrix[0][1]*60 + matrix[0][2];
        add(queue,new Customer(time,matrix[0][3],matrix[0][4]));

        for (int i = 1; i < matrix.length; i++) {
            time = matrix[i][0]*24 + matrix[i][1]*60 + matrix[i][2];
            Customer newCustomer = new Customer(time,matrix[i][3],matrix[i][4]);
            add(queue,newCustomer);
        }
        return queue;
    }

}
