public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] args) {
        MyLinkedList<Integer> ar = new MyLinkedList<>();
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.add(5);
        ar.print();
        ar.printReverse();
    }

    MyLinkedList(){
        head = null;
        tail = null;
    }

    void add(T val){
        if(tail == null){
            head = new Node<>(val);
            tail = head;
            return;
        }
        Node<T> n = new Node<>(val);

        tail.next = n;
        tail = n;
    }

    T get(int i) throws Exception {
        Node<T> ptr = head;
        while(ptr.next != null && i >= 0){
            ptr = ptr.next;
            i++;
        }
        if(i != 0)
            throw  new Exception("index out of bound");
        return ptr.val;

    }

    void print(){
        Node<T> ptr = head;

        while(ptr != null){
            System.out.print(ptr.val.toString() + "  -  ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    void printReverse(){
        printElement(head);
    }

    private void printElement(Node<T> node) {
        if(node == null)
            return;
        printElement(node.next);
        System.out.print(node.val.toString() + "  -  ");
    }


}
