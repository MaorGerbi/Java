
import java.util.ArrayList;


public class AirPort {
    public static final int First=0;
    String name;
    int maxpath, activepath = 0;
    boolean[] path;
    ArrayList pathWait;

    public AirPort(int maxpath, String name) {
        this.maxpath = maxpath;
        this.name = name;
        path = new boolean[maxpath];
        for (int i = 0; i < maxpath; i++) {
            path[i] = true;
        }
        pathWait=new ArrayList();
    }
    public synchronized int land(int FlightNum){
        System.out.print("flight :"+FlightNum+"is now wathing to land  on:"+name+ "Airport \n");
        addToWait(FlightNum);
        while ((activepath==maxpath)&&((int)pathWait.get(First)==FlightNum)){
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }
        pathWait.remove(First);
        return getPath();
    }


    public synchronized int depart(int FlightNum) {
        System.out.print("flight :"+FlightNum+"is now wathing to depart on: "+name+" Airport \n");
        addToWait(FlightNum);
        while ((activepath==maxpath)&&((int)pathWait.get(First)==FlightNum)){
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }
        return getPath();
        }

        public synchronized void freeRunway(int flightnum,int pathn){
        path[pathn] = true;
        activepath --;
        notifyAll();
        }


 public synchronized void addToWait(int flightnum){
        pathWait.add(flightnum);
 }

        private int getPath () {
        int i=0;
            for (; i < path.length; i++) {
                if (path[i] == true)
                    break;
            }
            if(i == path.length)
                i--;
            path[i] = false;
            activepath ++;
            return i;
    }

  }

