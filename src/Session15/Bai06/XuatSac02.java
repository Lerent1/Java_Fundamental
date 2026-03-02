package Session15.Bai06;

import java.util.*;

class Patient {
    String id, name;
    int age;
    String gender;

    public Patient(String id,String name,int age,String gender){
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    public String toString(){
        return id+" - "+name;
    }
}

class PatientWaitingQueue{
    Queue<Patient> queue=new LinkedList<>();

    void addPatient(Patient p){
        queue.offer(p);
    }

    Patient callNext(){
        return queue.poll();
    }
}

class EditAction{
    String description,editedBy,time;

    EditAction(String d,String by,String t){
        description=d;
        editedBy=by;
        time=t;
    }

    public String toString(){
        return time+" - "+description;
    }
}

class MedicalRecordHistory{
    Stack<EditAction> editStack=new Stack<>();

    void addEdit(EditAction e){
        editStack.push(e);
    }

    void undoEdit(){
        if(!editStack.isEmpty())
            System.out.println("Undo Edit: " +editStack.pop());
    }
}

class Ticket{
    int number;

    Ticket(int n){
        number=n;
    }

    public String toString(){
        return "So "+number;
    }
}

class TicketSystem{
    Queue<Ticket> ticketQueue=new LinkedList<>();
    int current=0;

    void issueTicket(){
        ticketQueue.offer(new Ticket(++current));
    }
    void callNext(){
        System.out.println("Moi: "
                +ticketQueue.poll());
    }
}

class InputAction{
    String field,oldValue,newValue;
    InputAction(String f,String o,String n){
        field=f;
        oldValue=o;
        newValue=n;
    }
}

class UndoManager{
    Stack<InputAction> undoStack=new Stack<>();

    void addAction(InputAction a){
        undoStack.push(a);
    }
    void undo(){
        if(!undoStack.isEmpty()){
            undoStack.pop();
            System.out.println("Undo input");
        }
    }
}

public class XuatSac02{
    public static void main(String[] args){
        PatientWaitingQueue pq= new PatientWaitingQueue();

        pq.addPatient(new Patient("BN01","An",30,"Nam"));
        pq.addPatient(new Patient("BN02","Binh",25,"Nu"));
        System.out.println("Dang kham: " +pq.callNext());
        MedicalRecordHistory history= new MedicalRecordHistory();
        history.addEdit(new EditAction("Sua chan doan", "BS A","08:00"));
        history.undoEdit();

        TicketSystem ts=new TicketSystem();
        ts.issueTicket();
        ts.issueTicket();
        ts.callNext();

        UndoManager undo=new UndoManager();
        undo.addAction(new InputAction("Ten","An","Anh"));
        undo.undo();
    }
}
