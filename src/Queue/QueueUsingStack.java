import java.util.*;

public class QueueUsingStack {

    private Stack<Integer> stack = new Stack<Integer>();

    public void insert(int elem) {
        if (!stack.empty()) {
            int topElem = stack.pop();
            insert(elem);
            stack.push(topElem);
        }
        else{
            stack.push(elem);
        }
            

    }

    public int remove() 
    {
        return stack.pop();
    }

    public static void main(String[] args) 
    {

        QueueUsingStack sq = new QueueUsingStack();
        
        sq.insert(10);
        sq.insert(20);
        sq.insert(30);
        sq.insert(40);
        //sq.insert(50);

        System.out.println(sq.remove());
        System.out.println(sq.remove());
        System.out.println(sq.remove());
        System.out.println(sq.remove());
        //System.out.println(sq.remove());

    }
}
