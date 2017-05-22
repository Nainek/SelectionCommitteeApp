package ua.training.controller;


import ua.training.GlobalConstants;
import ua.training.controller.creator.*;
import ua.training.model.Applicant;
import ua.training.model.GlobalDBOfApplicants;
import ua.training.model.QueueOfApplicants;
import ua.training.view.View;

import java.util.*;


public class QueueController implements Runnable{

    private GlobalDBOfApplicants globalDBOfApplicants;
    private QueueOfApplicants queueOfApplicants = new QueueOfApplicants();


    public void run() {
        View.printMessage(View.THREAD_STARTS_MESSAGE + "  "+ Thread.currentThread());
        addApplicantsToTheQueue();
        View.printMessage(View.THREAD_ENDS_MESSAGE + "  "+ Thread.currentThread());
    }

    public void addApplicantsToTheQueue(){
        synchronized (GlobalConstants.GLOBAL_MONITOR){
            while (globalDBOfApplicants.hasNext()) {
                    for(int i = 0; i < GlobalConstants.LOWER_LIMIT_APPLICANTS_IN_QUEUE; i++ ){ // Need to change variable name
                        queueOfApplicants.addToTheQueue(globalDBOfApplicants.next());
                    }
                    GlobalConstants.GLOBAL_MONITOR.notify();// TO DO
                    try {
                        GlobalConstants.GLOBAL_MONITOR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
            GlobalConstants.GLOBAL_MONITOR.notify();
        }
    }

    public QueueController(GlobalDBOfApplicants globalDBOfApplicants) {
        this.globalDBOfApplicants = globalDBOfApplicants;
    }

    public int numberOfApplicantsInQueue(){
        return queueOfApplicants.size();
    }

    public Applicant getApplicantForInterview(){
        return queueOfApplicants.getApplicantForInterview();
    }

    public Applicant getApplicant(){
        return queueOfApplicants.getApplicant();
    }

    public boolean isQueueEmpty(){
        return queueOfApplicants.getQueueInAdmissions().isEmpty();
    }



}
