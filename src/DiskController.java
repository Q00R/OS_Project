public class DiskController
{
    private DiscState state;
    private Operation oper;
    private int length;

    public DiskController()
    {
        state =  DiscState.BUSY;
        length = (int)(Math.random()*1000);
    }

    public DiscState getState() {
        return state;
    }

    public Operation getOper() {
        return oper;
    }

    public int getLength() {
        return length;
    }

    public void setRandomOper()
    {
        int num = (int) (Math.random()*2) + 1;
        switch(num)
        {
            case 1:
                this.oper = Operation.Read;
                break;
            case 2:
                this.oper = Operation.Write;
                break;
        }
    }

    public void setState(DiscState state) {
        this.state = state;
    }
}
