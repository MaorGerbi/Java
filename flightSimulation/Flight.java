



public class Flight extends Thread {
AirPort source;
AirPort target;
int flightnum;

public Flight(AirPort A ,AirPort A1,int flightnum){
    this.flightnum = flightnum;
    this.source = A;
    this.target = A1;
}

public void run(){

    int freeway=source.depart(flightnum);
    departSimulation(freeway);
    source.freeRunway(flightnum,freeway);

     flightSimulation();

    int freewayOnTarget=target.land(flightnum);
    landSimulation(freewayOnTarget);
    target.freeRunway(flightnum,freewayOnTarget);
}

    private void landSimulation(int freewayOnTarget){
        System.out.print("flight :"+flightnum+"is now landing on "+target.name+"on path number"+freewayOnTarget+"\n");
        int sleepTime = 200 + (int)(Math.random()*30000);
        try {
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e){}

    }

private void departSimulation(int freeway){
    System.out.print("flight :"+flightnum+"is now depart| on "+source.name+"on path number"+freeway+"\n");
    int sleepTime= 200 + (int)(Math.random()*30000);
    try {
        Thread.sleep(sleepTime);
    }
    catch (InterruptedException e){}
        }

private void flightSimulation(){
    System.out.print("flight num: "+flightnum+ "is now flight from :"+source.name +"to :"+target.name+"\n");
    int sleepTime= 200 + (int)(Math.random()*30000);
    try {
        Thread.sleep( sleepTime);
        }
    catch (InterruptedException e){}


}

}
