import lombok.val;

public class Node<T> {
        T val;
        Node<T> next;

        Node(T val){
            this.val = val;
        }
}
