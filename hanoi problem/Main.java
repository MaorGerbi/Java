import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

            System.out.print("hello please enter the num of disks");
            Scanner scanner = new Scanner(System.in);
            int num_of_disks = scanner.nextInt();
            Stack a = new Stack(num_of_disks);      
            Stack b = new Stack(num_of_disks);     
            Stack c = new Stack(num_of_disks);     
            for (int i = num_of_disks; i > 0; i--)  //Initializing the first page according to input
                    a.Push(i);
            Hanoi H = new Hanoi(a,b,c,num_of_disks);//Initialization of an object
            int tempsmall = H.getsmall();           // Move the small disc
            H.forward(tempsmall,num_of_disks);
            int small = H.getsmall();
            H.Move(tempsmall,small);
            tempsmall = small;
            while(!(H.Solve())) {                   //As long as we have not solved the problem
                    H.MoveWithoutSmall();           //Move without a small disc
                tempsmall = H.getsmall();       
                H.forward(tempsmall,num_of_disks);  //Move the small disc
                 small = H.getsmall();
               H.Move(tempsmall,small);
                tempsmall = small;
            }

            }

    }
