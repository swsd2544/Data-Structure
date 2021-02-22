import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Sorting {
    private static LinkedList<Integer> mergeSort(LinkedList<Integer> s) throws Exception {
        if(s == null){
            throw new NullPointerException();
        }
        if(s.size() == 1){
            return s;
        }
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        for(int i = 0; i < s.size(); i++){
            if(i < (int) s.size()/2){
                l1.add(s.get(i));
            } else {
                l2.add(s.get(i));
            }
        }
        l1 = mergeSort(l1);
        l2 = mergeSort(l2);
        return merge(l1, l2);
    }

    private static LinkedList<Integer> merge(LinkedList<Integer> l1, LinkedList<Integer> l2) throws Exception{
        if(l1 == null || l2 == null){
            throw new NullPointerException();
        }
        LinkedList<Integer> ret = new LinkedList<Integer>();
        ListIterator i1 = l1.listIterator();
        ListIterator i2 = l2.listIterator();
        while(i1.hasNext() && i2.hasNext()){
            int d1 = (int) i1.next(), d2 = (int) i2.next();
            if(d1 < d2){
                ret.add(d1);
                i2.previous();
            } else {
                ret.add(d2);
                i1.previous();
            }
        }
        while(i1.hasNext()){
            ret.add((Integer) i1.next());
        }
        while(i2.hasNext()){
            ret.add((Integer) i2.next());
        }
        return ret;
    }

    private static LinkedList<Integer> bubbleSort(LinkedList<Integer> s){
        LinkedList l = new LinkedList<Integer>();
        while(!s.isEmpty()){
            ListIterator iterator = s.listIterator();
            int min = Integer.MAX_VALUE;
            while(iterator.hasNext()){
                int data = (int) iterator.next();
                if(min > data){
                    min = data;
                }
            }
            s.removeFirstOccurrence(min);
            l.add(min);
        }
        return l;
    }

    private static void printIntList(List<Integer> l){
        Iterator iterator = l.iterator();
        while(iterator.hasNext()){
            System.out.print((int) iterator.next());
            System.out.print(" ");
        }
        System.out.println();
    }

    private static LinkedList<Integer> newArr(int size){
        LinkedList<Integer> s = new LinkedList<Integer>();
        Random r = new Random();
        for(int i = 0; i < size; i++){
            s.add(r.nextInt());
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        long currtime;
        try (PrintWriter writer = new PrintWriter(new File("Data.csv"))) {
            StringBuilder sb = new StringBuilder();

            for(int i = 1000; i < 50000; i+=1000){

                LinkedList<Integer> s = newArr(i);
                sb.append(i + ",");
                currtime = System.nanoTime();
                mergeSort(s);
                sb.append((System.nanoTime() - currtime) + ",");
                currtime = System.nanoTime();
                bubbleSort(s);
                sb.append((System.nanoTime() - currtime) + "\n");

            }

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
