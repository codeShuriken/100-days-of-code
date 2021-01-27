import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
public class HashSet{
    private List<Integer>[] container;
    private static final double capacity = 0.75;
    private int count = 0;
    private int cap = 1000;
    public HashSet(){
        container = new LinkedList[cap];
    }

    public void add(int num){
        if (contains(num))return;
        if (this.count == this.cap * this.capacity){
            this.count = 0;
            this.cap = 2 * this.cap;
            List<Integer>[] oldContainer = this.container;
            this.container  =  new LinkedList[this.cap];
            for (int i = 0; i < oldContainer.length; ++i){
                List<Integer> old = oldContainer[i];
                if (old != null){
                    for (int ele : old){
                        this.add(ele);
                    }
                }
            }
        }
        int hash = num % this.cap;
        if (this.container[hash] == null){
            this.container[hash]  = new LinkedList<>();
        }
        this.container[hash].add(num);
        ++this.count;
    }

    public boolean contains(int num){
        int hash = num % this.cap;
        List<Integer> nums = this.container[hash];
        if (nums != null){
            Iterator<Integer> itr = nums.iterator();
            while (itr.hasNext()){
                if (itr.next() == num)return true;
            }
        }
        return false;
    }

    public void remove(int num){
        int hash = num % this.cap;
        List<Integer> nums = this.container[hash];
        if (nums != null){
            Iterator<Integer> itr = nums.iterator();
            while (itr.hasNext()){
                if (itr.next() == num){
                    itr.remove();
                    this.count--;
                    break;
                }
            }
        }
    }
}