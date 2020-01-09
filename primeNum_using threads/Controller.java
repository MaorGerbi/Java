import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {
    boolean[] numbers;
    private int  maxTrade,totalNums,curentThread,curentNumber;

public Controller(int m,int n)
{
    curentThread=curentNumber=0;
    totalNums = m;
    maxTrade = n;
    numbers = new boolean[m+1];
    for (int i = 0; i < numbers.length; i++)
        numbers[i] = false;

}

public synchronized void waitForThread() {
    while (curentThread == maxTrade) {
        try {
            wait();
            }
        catch (InterruptedException e) {}

    }
        curentThread++;
}
public synchronized void waitForAll(){
        if (curentNumber < numbers.length-1)
            try{
                wait();
            }
        catch (InterruptedException e){}

    }

    public String PrintPrime(){
        String res="";
        for (int i=2;i<numbers.length; i++)
            if (numbers[i])
                 res += i+"  ";
        return res;
    }

public  synchronized void finish(){
    curentThread --;
    curentNumber ++;
    notifyAll();
}


}







