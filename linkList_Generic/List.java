public class List <E> {

    Node<E> head;
    Node<E> tail;

    public List(){
        head=null;
        tail=null;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;

}
    public void add(E obj){
        Node<E> node = new Node<E>(obj);////FOR THE FIRS NODE
        if (head==null) {
            head = node;
            tail = node;
        }
            else{//ALL OTHER CASES
                Node<E> temp;
                temp=tail;
                temp.setNext(node);
                tail=node;
            }

        }
        public E remove() throws EmptyListException{

                E obj = null;
               if(head==null)
                   throw new EmptyListException("List empty");//NEW EXCEPITION
                    obj = head.getObj();
                    Node<E> temp;
                    temp = head.getNext();
                    head = temp;

                return obj;
        }
    public String toString() {
        String str="";
        Node<E> P=head;
        while(P!=null){
            str+=P.getObj()+"\n";
                P=P.getNext();
        }
        return str;
    }

}


