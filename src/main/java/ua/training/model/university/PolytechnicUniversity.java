package ua.training.model.university;


import ua.training.GlobalConstants;
import ua.training.model.Applicant;

public class PolytechnicUniversity extends University {

    int counterOfReceivedApplicants = 0;

    public boolean checkIfApplicantAdequateRequirements(Applicant applicant) {
        if(counterOfReceivedApplicants++ < GlobalConstants.MAX_APPLICANTS_AT_A_TIME){
            return true;
        }
        counterOfReceivedApplicants = 0;
        return false;
    }

}