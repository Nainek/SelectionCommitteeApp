package ua.training.model.university;

import ua.training.GlobalConstants;
import ua.training.model.Applicant;


public class MathUniversity extends University {

    private int passingMathTestScore = GlobalConstants.APPRORIATE_SCORE;
    private int passingPhysicsTestScore = GlobalConstants.APPRORIATE_SCORE;

    public boolean checkIfApplicantAdequateRequirements(Applicant applicant) {
        return (checkMathAdequacy(applicant.getCertificate().getScoreOnMathTest()) &&
                checkPhysicsAdequacy(applicant.getCertificate().getScoreOnPhysicsTest()));
    }

    private boolean checkMathAdequacy(int mark){
        return mark >= passingMathTestScore;
    }

    private boolean checkPhysicsAdequacy(int mark){
        return mark >= passingPhysicsTestScore;
    }



}