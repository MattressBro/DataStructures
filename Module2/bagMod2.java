import java.io.*;
import java.util.Random;
public class bagMod2<T> {
    private Object[] items;
    private int size; // current instance so that the program can keep track of size versus capacity
    private int cap; //capacity
    //constructor
    public bagMod2(){
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
    //add
    public void add(T item){
        if(size == cap){
            resize();
        }
        items[size] = item;
        size++;
    }
    //remove item and then shift the rest of the array to the left one.
    public void remove(int num){
        for(int j=num; j < size-1;j++){
            items[j] = items[j+1];
        }
        size--;
        return;
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
    //size function
    public int size(){
        int bagSize=0;
        for(int i=0; i < size; i++){
            bagSize++;
        }
        return bagSize;
    }
    //merge two bags together with the helper function add
    @SuppressWarnings("unchecked")
    void merge(bagMod2<T> otherBag){
        for(int i=0; i < otherBag.size(); i++){
            add((T) otherBag.items[i]);
        }
    }
    public bagMod2<T> distinct(){
        bagMod2<T> newBag = new bagMod2<>();
        for(int i=0;i < size(); i++){
            for(int j=i+1; j < size(); j++){
                if((T)this.items[i]==(T)this.items[j]){
                    remove(j);
                    j--;
                }
            }
            newBag.add((T) items[i]);
        }
        return newBag;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        bagMod2<Integer> bag1 = new bagMod2<>();
        bagMod2<Integer> bag2 = new bagMod2<>();
        for (int i=0; i < 20;i++){
            bag1.add(rand.nextInt(26));
        }
        for (int i=0; i < 20;i++){
            bag2.add(rand.nextInt(26));
        }
        System.out.println("Bag 1, size: "+bag1.size());
        bag1.output();
        System.out.println("Bag 1, size: "+bag2.size());
        bag2.output();
        bag1.merge(bag2);
        System.out.println("Merged, size: "+bag1.size());
        bag1.output();
        bagMod2<Integer> newBag = bag1.distinct();
        System.out.println("Distinct, size: "+newBag.size());
        newBag.output();
    }
}