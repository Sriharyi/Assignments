import java.util.*;
public class PriorityQueueEg{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        List<Integer> elements = Arrays.asList(new Integer[]{4,5,6,7});
        pq.addAll(elements);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(Arrays.toString(pq.toArray()));

        System.out.println(pq.remove());
        System.out.println(pq.contains(5));
        System.out.println(pq.isEmpty());
        System.out.println(pq.offer(8));
        System.out.println(pq.element());
        System.out.println(pq.size());
        System.out.println(Arrays.toString(pq.toArray()));
        System.out.println();
        Iterator value = pq.iterator();
  
        // Displaying the values after iterating through the queue
        System.out.println("The iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }
        System.out.println(pq.toString());
        pq.clear();
        System.out.println(pq.toString());

    }
}