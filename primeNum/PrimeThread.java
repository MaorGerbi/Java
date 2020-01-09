
public class PrimeThread extends Thread {
Controller con;
int num;

public PrimeThread(int i,Controller c){
     num = i;
     con = c;
}
public void run() {

    int j;
    for (j = 2; j < num; j++)
        if (num % j == 0)
            break;

    if (j == num)
        con.numbers[j] = true;
    con.finish();

}
}

