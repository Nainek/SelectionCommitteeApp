package ua.training.controller.creator;

import ua.training.model.Applicant;
import ua.training.model.Certificate;


public abstract class ApplicantCreatorImp implements ApplicantCreator {

    public abstract Applicant createDefaultApplicant(String name);

    public Applicant createApplicant(String name, Certificate certificate) {
        return new Applicant(name, certificate);
    }
}


