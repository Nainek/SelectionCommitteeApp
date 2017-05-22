package ua.training.controller;

import ua.training.GlobalConstants;
import ua.training.controller.committee.SelectionCommittee;
import ua.training.model.GlobalDBOfApplicants;
import ua.training.view.View;

public class Controller {

    public void processUser(){

        GlobalDBOfApplicants globalDBOfApplicants = new GlobalDBOfApplicants();
        QueueController queueController = new QueueController(globalDBOfApplicants);
        SelectionCommittee selectionCommittee = new SelectionCommittee(globalDBOfApplicants, queueController);

        Thread queueThread = new Thread(queueController);
        Thread selectionCommitteeThread = new Thread(selectionCommittee);


        View.printMessage(View.THREAD_STARTS_MESSAGE + "  "+ Thread.currentThread());
        queueThread.start();
        try {
            Thread.sleep(GlobalConstants.WAIT_WHEN_FIRST_APPLICANTS_WILL_COME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectionCommitteeThread.start();
        View.printMessage(View.THREAD_ENDS_MESSAGE + "  "+ Thread.currentThread());

    }

}
