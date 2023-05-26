public class PCB {
    //PCB1
static int processID;
int parentID;
int userID;
//PCB2
String userVisibleRegister[];
String controlAndStatusRegisters[];
String stackPointers[];
States processState;
int priority;
String SchedulingRelatedInformation;
String events;
//PCB3
String interprocessCommunication;
String processPriviliges;
String memoryManagement;
String resourceOwnershipAndUtilization;

    public PCB() {
        processID++;
        parentID=(int) (Math.random()*10000);
        userID=0;
        processState= States.New;
        priority=(int) (Math.random()*10);
    }

    public static void main(String[] args) {

        }

}
