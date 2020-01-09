package maman14;

import java.util.ArrayList;
import java.util.Scanner;

import maman14.SmmHeap;

public class Maman14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        SmmHeap minMaxHeap = null;
        
        while(true) {
            System.out.println("Choose an operation, by number:");
            System.out.println("1) build data structure");
            System.out.println("2) insert a value");
            System.out.println("3) find max");
            System.out.println("4) find min");
            System.out.println("5) delete max");
            System.out.println("6) delete min");
            System.out.println("7) exit");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    minMaxHeap = buildHeap();
                    break;
                case 2:
                    System.out.println("Enter a value:");
                    minMaxHeap.insert(scanner.nextInt());
                    break;
                case 3:
                    System.out.println("The max is: "+minMaxHeap.findMax());
                    break;
                case 4:
                    System.out.println("The min is: "+minMaxHeap.findMin());
                    break;
                case 5:
                    System.out.println("The max deleted is: "+minMaxHeap.deleteMax());
                    break;
                case 6:
                    System.out.println("The min deleted is: "+minMaxHeap.deleteMin());
                    break;
                case 7:
                    return;
                default:
                    System.out.println("invalid choice");
                    break;
            }
            minMaxHeap.printArray();
        }
    }
    
    public static SmmHeap buildHeap() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<Integer>();
        while(true) {
            System.out.println("Enter a value to add, type 'stop' to finish.");
            String value = scanner.nextLine();
            if(value.equals("stop"))
                break;
            values.add(Integer.parseInt(value));
        }
        return new SmmHeap(values);
    }
}
