package ua.training.controller.creator;

import ua.training.GlobalConstants;
import ua.training.model.Applicant;


public class MathApplacantCreator extends ApplicantCreatorImp {

    public Applicant createDefaultApplicant(String name) {
        return super.createApplicant(name, GlobalConstants.MATH_CERTIFICATE);
    }

}
