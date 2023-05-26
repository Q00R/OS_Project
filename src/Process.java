import java.io.*;
import java.util.Scanner;

public class Process {
    PCB pcb;
    static int heapMaxSize=100;
    static String [] heapVarName=new String[heapMaxSize];
    static Object [] heap=new Object[heapMaxSize];

    public Process() {
        this.pcb = new PCB();
    }

    //print
    public static void print(Object o){
        System.out.println(o);
    }

    //assign
    public static void assign(String x,Object y){
        if(heap.length==heapMaxSize){
            System.out.println("Heap is full");
            return;}
        if(y instanceof String){
            for(int i=0;i<heap.length;i++)
                if(heap[i]==null){
                    heap[i]= y;
                    heapVarName[i]="S "+x; }
        }
        else{
            for(int i=0;i<heap.length;i++)
                if(heap[i]==null){
                    heap[i]= y;
                    heapVarName[i]="I "+x; }
        }
        System.out.println("Input y is now assigned to variable x");
    }

    //writefile
    public static void writeFile(String fileName,String data) throws IOException {
            FileWriter fileWriter=new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(data);
            writer.close();
        System.out.println("File has been updated with the new data");
    }

    //readfile
    public static String readFile(String fileName){
        String value="";
        try {
            File myObj = new File(fileName+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                value+=data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("File has been read");
        return value;
    }

    //processA
    public static void ProcessA(){
        System.out.println("Process A created");
        Process a=new Process();
        a.pcb.processState=States.Running;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter file name : ");
        String fileName=sc.next();
        String s= readFile(fileName);
        print(s);
        a.pcb.processState=States.Finished;
        System.out.println("Process A Finished");
    }

    //processB
    public static void ProcessB() throws IOException {
        System.out.println("Process B created");
        Process b=new Process();
        b.pcb.processState=States.Running;
        System.out.println("Enter file name : ");
        Scanner sc=new Scanner(System.in);
        String fileName=sc.next();
        System.out.println("Enter data to be written in file "+fileName+" : ");
        String data=sc.next();
        writeFile(fileName,data);
        b.pcb.processState=States.Finished;
        System.out.println("Process B Finished");
    }

    public static void main(String[] args) {



    }
}
