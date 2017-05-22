package ua.training.model.university;


import ua.training.GlobalConstants;
import ua.training.model.Applicant;

public class BiologyUniversity extends University {

    private int passingBiologyTestScore = GlobalConstants.APPRORIATE_SCORE;
    private int passingChemistryTestScore= GlobalConstants.APPRORIATE_SCORE;

    public boolean checkIfApplicantAdequateRequirements(Applicant applicant) {
        return (checkBiologyAdequacy(applicant.getCertificate().getScoreOnBiologyTest()) &&
                checkChemistryAdequacy(applicant.getCertificate().getScoreOnChemistryTest()));
    }

    private boolean checkBiologyAdequacy(int mark){
        return mark >= passingBiologyTestScore;
    }

    private boolean checkChemistryAdequacy(int mark){
        return mark >= passingChemistryTestScore;
    }

}
