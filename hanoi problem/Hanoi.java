
public class Hanoi {
    int num_of_disks;
    Stack H[];
    int smalldisk = 0;

    public Hanoi(Stack a, Stack b, Stack c, int d) {
        this.H = new Stack[3];
        H[0] = a;
        H[1] = b;
        H[2] = c;
        this.num_of_disks = d;
        this.smalldisk = 0;
    }

    public int getsmall() {
        return this.smalldisk;
    }
//made the move of disc and print on screen
    public void Move(int src, int des) {
        H[des].Push(H[src].Pop());
        System.out.print("move from page"+src+ "to --> "+ des+"\n");
        System.out.print("the firs hanoi"+"\n");
       H[0].PrintStack();
        System.out.print("the 2 hanoi"+"\n");
       H[1].PrintStack();
        System.out.print("the 3 hanoi"+"\n");
       H[2].PrintStack();
    }
  //Update the next page that the small disk should go to
    public void forward(int pos, int num) {
        int pos1 = pos;
        if (num % 2 == 0) {
            pos1++;
            if (pos1 > 2)
                this.smalldisk = 0;
            else
            this.smalldisk = pos1;
        } else {
            pos1--;
            if (pos1 < 0)
                this.smalldisk = 2;
            else
             this.smalldisk = pos1;
        }
    }
//Calculates the pages on which the disk must pass without mixing the smaller
    public void MoveWithoutSmall() {
        int start, end;
        if (this.smalldisk == 0) {
            if ((!H[2].IsEmpety())&&(!H[1].IsEmpety())) {
                if (H[2].Top() < H[1].Top())
                    Move(2, 1);
                else  Move(1, 2);
            }
            else if (!H[2].IsEmpety())
                      Move(2, 1);
            else Move(1, 2);

        }
        if (this.smalldisk== 1) {
            if ((!H[2].IsEmpety())&&(!H[0].IsEmpety())) {
                if (H[2].Top() < H[0].Top())
                    Move(2, 0);
                else  Move(0, 2);
            }
            else if (!H[2].IsEmpety())
                Move(2, 0);
            else Move(0, 2);
        }
        if (this.smalldisk == 3) {
            if ((!H[2].IsEmpety()) && (!H[1].IsEmpety())) {
                if (H[2].Top() < H[1].Top())
                    Move(2, 1);
                else Move(1, 2);
            } else if (!H[2].IsEmpety())
                Move(2, 1);
            else Move(1, 2);
        }
    }
    //check if we sole the problem of hanoi two firs pages are empaty
        public boolean Solve(){
            return (this.H[0].IsEmpety()) && (this.H[1].IsEmpety());
        }
    }


