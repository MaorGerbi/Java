
public class Main{

public static void main(String [ ] args) {
final int n = 10;                           //itialize the number of processes
final int m = 1000;  //itialize the number of processes
    myPrime(m, n);

}

public static void myPrime(int m, int n){
    Controller c = new Controller(m,n);    //Manage the shared resource
    for(int i = 2; i <= m; i++){           //for each number if prime
        c.waitForThread();                 //no more then n thread work together
        (new PrimeThread(i,c)).start();
    }
    c.waitForAll();
    System.out.print(c.PrintPrime());
    System.out.print("all done");
}

}