package ua.training.model.university;


import ua.training.model.Applicant;

import java.util.ArrayList;
import java.util.List;

public abstract class University {

    private List<Applicant> scoreUpApplicants = new ArrayList<Applicant>();

    public boolean isInterviewForApplicantSuccess (Applicant applicant){
        return checkIfApplicantAdequateRequirements(applicant);
    }

    public abstract boolean checkIfApplicantAdequateRequirements(Applicant applicant);

    public void addAdmittedApplicant(Applicant applicant) {
        scoreUpApplicants.add(applicant);
    }

    @Override
    public String toString() {
        return "University{" +
                "Type" + this.getClass().getSimpleName() +
                '}';
    }

}
