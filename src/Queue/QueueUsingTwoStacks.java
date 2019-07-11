import java.util.Stack;

public class QueueUsingTwoStacks<E>
{

    private Stack<Integer> inbox = new Stack<Integer>();
    private Stack<Integer> outbox = new Stack<Integer>();

    public void queue(E item) {
        inbox.push((Integer) item);
    }

    public E dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
               outbox.push(inbox.pop());
            }
        }
        return (E) outbox.pop();
    }

}
