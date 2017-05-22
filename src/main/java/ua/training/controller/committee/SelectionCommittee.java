package ua.training.controller.committee;


import ua.training.GlobalConstants;
import ua.training.controller.QueueController;
import ua.training.model.GlobalDBOfApplicants;
import ua.training.model.university.*;
import ua.training.view.View;


public class SelectionCommittee implements Runnable{


    private GlobalDBOfApplicants globalDBOfApplicants;
    private QueueController queueController;

    private University mathUniversity = new MathUniversity();
    private University biologyUniversity = new BiologyUniversity();
    private University polytechnicUniversity = new PolytechnicUniversity();

    private University currentUniversityWhichReceiveApplicants = biologyUniversity;

    public SelectionCommittee(GlobalDBOfApplicants globalDBOfApplicants,QueueController queueController) {
        this.globalDBOfApplicants = globalDBOfApplicants;
        this.queueController = queueController;
    }

    public void run() {
        View.printMessage(View.THREAD_STARTS_MESSAGE + "  "+ Thread.currentThread());
        synchronized (GlobalConstants.GLOBAL_MONITOR){
            while ( !(queueController.isQueueEmpty()) ){
                if(currentUniversityWhichReceiveApplicants.isInterviewForApplicantSuccess(queueController.getApplicantForInterview())){
                    currentUniversityWhichReceiveApplicants.addAdmittedApplicant(queueController.getApplicant());

                } else {
                    switchCurrentUniversity();
                }
                if( queueController.numberOfApplicantsInQueue() <= GlobalConstants.LOWER_LIMIT_APPLICANTS_IN_QUEUE && globalDBOfApplicants.hasNext()){
                    GlobalConstants.GLOBAL_MONITOR.notifyAll();
                    try {
                        GlobalConstants.GLOBAL_MONITOR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            GlobalConstants.GLOBAL_MONITOR.notify();
        }

        View.printMessage(View.THREAD_ENDS_MESSAGE + "  "+ Thread.currentThread());
    }

    private void switchCurrentUniversity(){
        if(currentUniversityWhichReceiveApplicants instanceof MathUniversity){
            currentUniversityWhichReceiveApplicants = biologyUniversity;
        }
        else{
            if(currentUniversityWhichReceiveApplicants instanceof BiologyUniversity){
                currentUniversityWhichReceiveApplicants = polytechnicUniversity;
            }
            else {
                if(currentUniversityWhichReceiveApplicants instanceof PolytechnicUniversity){
                    currentUniversityWhichReceiveApplicants = mathUniversity;
                }
            }
        }
    }
}
