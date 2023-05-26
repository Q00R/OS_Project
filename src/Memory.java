import java.util.ArrayList;

public class Memory
{
    private Object [] mem;
    private final int privilageStart; //assuming en mn 0 l 59 da el non-privileged
    private int stackEnd; //el heya bardo heap start

    private int processMem;
    private int usedInStack;
    private int usedInNonpriv;
    ArrayList <Character> keys = new ArrayList<Character>();

    public Memory()
    {
        mem = new Object [120];
        privilageStart = 60;
        processMem = 30;
        stackEnd = 14;
        usedInStack = 0;
        usedInNonpriv = processMem;
        mem[59] = keys;
    }

    public void addIntoList(char c)
    {
        ((ArrayList) mem[59]).add(c);
    }

    public void display()
    {
        System.out.println((mem[59]));
    }

    public void increaseUsedInStack(int x)
    {
        usedInStack+=x;
    }

    public void increaseUsedInNonpriv(int x)
    {
        usedInNonpriv+=x;
    }

    public int getStackEnd()
    {
        return stackEnd;
    }

    public int getUsedInStack()
    {
        return usedInStack;
    }

    public void decrementStackEnd()
    {
        stackEnd--;
    }

    public int getPrivilageStart() {
        return privilageStart;
    }

    public int getProcessMem() {
        return processMem;
    }

    public int getUsedInNonpriv() {
        return usedInNonpriv;
    }

    public void incrementProcessMem() {
        this.processMem++;
    }

}
