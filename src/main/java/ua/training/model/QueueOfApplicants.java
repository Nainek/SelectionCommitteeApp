package ua.training.model;


import java.util.LinkedList;
import java.util.Queue;

public class QueueOfApplicants {

    private Queue <Applicant> queueInAdmissions = new LinkedList<Applicant>();


    public Applicant getApplicant(){
        return queueInAdmissions.remove();
    }

    public void addToTheQueue(Applicant applicant){
        queueInAdmissions.add(applicant);
    }

    public Applicant getApplicantForInterview(){
        return queueInAdmissions.element();
    }

    public int size(){
        return queueInAdmissions.size();
    }

    public Queue<Applicant> getQueueInAdmissions() {
        return queueInAdmissions;
    }
}
