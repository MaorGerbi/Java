public class Node<E> {
    E obj;
    Node<E> next;
    public  Node (E obj){

        this.obj=obj;
        next=null;
    }
public Node (Node<E> pointer, E obj){
        this.obj=obj;
        this.next=pointer;
}

    public  E getObj() {
        return obj;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }
    public void setNext(Node<E> pointer) {
        this.next = pointer;
    }

}
