public class OS
{
    static Events currentEvent[] = Events.values();
    static Memory memory;
    static char keyPressed;
    static int cellAccessing;
    static DiskController disk;
    static PCB currentProcess;

    public OS()
    {
        memory = new Memory();
        disk = new DiskController();
        currentProcess = new PCB();
        currentProcess.processState = States.Running;
    }

    public static Events generateRandomEvent()
    {
        disk.setRandomOper();
        int eventIndex = (int) (Math.random()*5);
        return currentEvent[eventIndex];
        /*
    USER_PRESS_KEYBOARD_KEY index 0
    ISK_DONE_READING_DATA, index 1
    MORE_HEAP_REQUEST, index 2
    TRIES_INT_DIVISION_BY0, index 3
    TRIES_TO_ACCESS_PRIVILEGED_MEM index 4
     */
    }

    public void randomAllocateMemStack()
    {
        int noOfItemsS = (int) (Math.random()*14);
        memory.increaseUsedInStack(noOfItemsS);
    }

    public void randomAllocateMemNP()
    {
        int noOfItemsNP = (int) (Math.random()*29);
        memory.increaseUsedInNonpriv(noOfItemsNP);
    }

    public static void pressKey()
    {
        int num = (int) (Math.random()*26) + 1;
        keyPressed = (char) (97+num);
    }

    public void handler(Events e)
    {
        switch(e)
        {
            case USER_PRESS_KEYBOARD_KEY:
            {
                System.out.println("Key pressed.");
                pressKey();
                memory.addIntoList(keyPressed);
                break;
            }
            case MORE_HEAP_REQUEST:
            {
                System.out.println("Heap requested.");
                randomAllocateMemStack();
                if(memory.getUsedInStack() < memory.getStackEnd())
                {
                    memory.decrementStackEnd();
                }
                else
                {
                    randomAllocateMemNP();
                    if(memory.getUsedInNonpriv() < memory.getPrivilageStart())
                    {
                        memory.incrementProcessMem();
                    }
                    else
                    {
                        System.out.println("Request denied. Can't allocate more heap");
                    }
                }
                break;
            }
            case DISK_DONE_READING_DATA:
            {
                disk.setState(DiscState.IDEL);
                System.out.println("Finished reading data.");
                System.out.println("Length read: " + disk.getLength());
                break;
            }
            case TRIES_INT_DIVISION_BY0:
            {
                System.out.println("Cannot divide integer by 0!");
                currentProcess.processState = States.Finished;
                System.out.println("Process terminated for violation.");
                break;
            }
            case TRIES_TO_ACCESS_PRIVILEGED_MEM:
            {
                System.out.println("Privileged Memory Ahead! Directing to accessible area.");
                do {
                    cellAccessing = (int) (Math.random() * 29) + 30;
                }while (cellAccessing < memory.getPrivilageStart());
                break;
            }
        }

    }

    public static void printKeys()
    {
        memory.display();
    }

    public static void main (String args[])
    {
        OS os = new OS();
        Events event = generateRandomEvent();
        os.handler(event);
    }
}
