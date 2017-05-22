package ua.training.controller.creator;

import ua.training.model.Applicant;
import ua.training.model.Certificate;


public interface ApplicantCreator {

    Applicant createApplicant(String name, Certificate certificate);
    Applicant createDefaultApplicant(String name);

}
