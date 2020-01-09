import java.util.Scanner;

import static java.lang.System.exit;

public class main {

    public static void main(String args[]) {

        //firs list print****
        Scanner scan = new Scanner(System.in);
        String obj;
        List<String> mylist = new List<String>();

        for (int i = 1; i <= 6; i++) {//scan 6 strings
            System.out.print("please enter " + i + " strings:");
            obj = scan.next();
            mylist.add(obj);
        }
        System.out.print(mylist.toString());//print the new string


        //transport the data from List to List2
        List<String> mylist2 = new List<String>();
        String temp="";
        for (int i = 0; i <= 5; i++) {
            try {

                    temp = mylist.remove();
                }
                catch(EmptyListException e){
                System.out.print("LIST IS EMPTEY") ;
                exit(1);
                }

            mylist2.add(temp);
        }

        //revers the lisr use 3 pointers

        Node<String> P1 = mylist2.getHead();
        Node<String> P2 = mylist2.getHead().getNext();
        Node<String> P3 = mylist2.getHead().getNext().getNext();
        P1.setNext(null);
        for (int i = 0; i < 3; i++) {
            P2.setNext(P1);
            P1 = P2;
            P2 = P3;
            P3 = P3.getNext();
        }
        P2.setNext(P1);
        P3.setNext(P2);
        mylist2.setTail(mylist2.getHead());
        mylist2.setHead(P3);

        System.out.print(mylist2.toString());//print



//input and print the person list
       List<Person> list3=new List<Person>();
        Person A1=new Person("maor","3",1991);
        Person A2=new Person("liron","2",1990);
        Person A3=new Person("penalopi","1",1989);
        Person A4=new Person("alex","4",1987);
           list3.add(A1);//
           list3.add(A2);//
           list3.add(A3);//      add the persone data to list
           list3.add(A4);//
          Person temp1=list3.getHead().getObj();
          Node<Person> cur=list3.getHead();
        for(int i=0;i<3;i++){
            System.out.print(temp1.toString());
            cur=cur.getNext();
            temp1=cur.getObj();
        }
        System.out.print(temp1.toString());
           System.out.print("the max nod on list is :"+max(list3));


    }

//generic method max
    public static <T extends Comparable<T>> T max(List<T> list) {

        if (list == null || list.getHead() == null)
            return null;
        T max = list.getHead().getObj();
        Node<T> current = list.getHead();
        while (current != null) {
            T currentData = current.getObj();
            if (max.compareTo(currentData) < 0)//if current older than max, set max to be current currentData.
                max = currentData;
            current = current.getNext();
        }
        return max;

    }
}


