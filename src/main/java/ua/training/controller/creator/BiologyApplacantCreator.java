package ua.training.controller.creator;

import ua.training.GlobalConstants;
import ua.training.model.Applicant;


public class BiologyApplacantCreator extends ApplicantCreatorImp {

    public Applicant createDefaultApplicant(String name) {
        return super.createApplicant(name, GlobalConstants.BIOLOGY_CERTIFICATE);
    }

}