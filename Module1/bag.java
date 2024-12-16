package Module1;
import java.io.*;

public class bag<T> {
    private Object[] items;
    private int size; // current instance so that the program can keep track of size versus capacity
    private int cap; //capacity
    //constructor
    public bag(){
        this.cap =1;
        items = new Object[cap];
        size=0;
    }
    //bag uses Array and Linked list: for Array we need to constantly change the size of the array to ensure no out of bounds occurs
    private void resize(){
        cap+=1;
        Object[] resized = new Object[cap];
        System.arraycopy(items, 0, resized,0,size);
        items=resized;
    }

    public void add(T item){
        if(size == cap){
            resize();
        }
        items[size] = item;
        size++;
    }
    //remove items and then shift the rest of the array to the left one.
    public void remove(T item){
        for(int i =0; i < size; i++){
            if(items[i]==item){
                for(int j=i; j < size-1;j++){
                    items[j] = items[j+1];
                }
                size--;
                return;
            }
        }
    }
    public boolean contains(T item){
        for(int i =0; i < size; i++){
            if(items[i]==item){
                return true;
            }
        }
        return false;
    }
    public int count(T item){
        int count=0;
        for(int i =0; i < size; i++){
            if(items[i]==item){
                count++;
            }
        }
        return count;
    }
    //prints bag in lines of 10 delimited by commas
    public void output() {
        for(int i=0;i < size; i++){
            if(i%10 ==0 && i > 0){
                System.out.print("\n");
            }
            if(i==size-1){
                System.out.print(items[i]+"\n"); 
            }
            else{
                System.out.print(items[i]+", ");
            }
        }
    }
    public static void main(String[] args){
        bag<Integer> numBag = new bag<Integer>();
        System.out.println("Creating Bag.\n");
        System.out.println("Adding numbers to Bag.");
        System.out.println("14 Added to bag.");
        numBag.add(14);
        System.out.println("23 Added to bag.");
        numBag.add(23);
        System.out.println("57 Added to bag.");
        numBag.add(57);
        System.out.println("1  Added to bag.");
        numBag.add(1);
        System.out.println("2  Added to bag.");
        numBag.add(2);
        System.out.println("14 Added to bag.");
        numBag.add(14);
        System.out.println("13 Added to bag.");
        numBag.add(13);
        System.out.println("17 Added to bag.");
        numBag.add(17);
        System.out.println("12 Added to bag.");
        numBag.add(12);
        System.out.println("1  Added to bag.");
        numBag.add(1);
        System.out.println("2  Added to bag.");
        numBag.add(2);
        System.out.println("2  Added to bag.");
        numBag.add(2);
        System.out.print("\n");

        System.out.println("Number of items added to bag: "+numBag.size);
        System.out.println("Displaying total bag.\n");
        numBag.output();
        System.out.print("\n");

        System.out.println("Does bag contain a 4?  "+numBag.contains(4));
        System.out.println("Does bag contain a 14? "+numBag.contains(14));
        System.out.println("Does bag contain a 2?  "+numBag.contains(2));

        System.out.print("\n");
        System.out.println("14 has been added "+numBag.count(14)+" time(s).");
        System.out.println("2  has been added "+numBag.count(2)+" time(s).");
        System.out.println("1  has been added "+numBag.count(1)+" time(s).");

        System.out.print("\n");
        System.out.println("removing an instance of 23 from bag.");
        numBag.remove(23);

        System.out.print("\n");
        System.out.println("Displaying total bag.\n");
        numBag.output();

        System.out.print("\n");
        System.out.println("Does bag contain a 23? "+numBag.contains(23));
        System.out.println("23 has been added "+numBag.count(23)+" time(s).");
        
        
    }
}