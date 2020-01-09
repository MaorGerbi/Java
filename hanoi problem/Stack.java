
public class Stack {
    int top;
    int s[];
    int Dnum;

    public Stack(int Dnum) {
        this.Dnum=Dnum;
        top = -1;
        this.s = new int[Dnum];
    }

   boolean IsEmpety() {
        return (this.top < 0);
    }

    public void Push(int x) {
        if (this.top > this.Dnum)
            System.out.print("over load");
        this.s[++this.top]=x;

    }

    public int Pop() {
        if (IsEmpety()) {
            return -1;
        }
        return this.s[this.top--];
    }

    public void PrintStack() {
        if (!IsEmpety()) {
            for (int i = this.top; i >= 0; i--) {
                System.out.print(this.s[i]+"\n");
            }
        }
        else
            System.out.print("the stack is empty"+"\n");
    }
    public int Top(){
        if(!IsEmpety())
        return s[this.top];
        else {
            return -1;
             }
        }
    }
