public class Main {

    public static void main(String [ ] args) {
        AirPort A1 = new AirPort(3,"BEN-GURION");
        AirPort A2 = new AirPort(3,"SDE-DOV");

        for (int i = 0; i < 10;i++){

            if(Math.random()>0.5)
             ( new Flight(A1,A2,i)).start();
            else
             ( new Flight(A2,A1,i)).start();

        }

    }









}
