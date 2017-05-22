package ua.training.model;


import ua.training.GlobalConstants;

public class Applicant {

    String name;
    private Certificate certificate;

    public Applicant(String name, Certificate certificate) {
        this.name = name;
        this.certificate = certificate;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public String getNameOfSpecialization(){
        if(certificate.equals(GlobalConstants.MATH_CERTIFICATE)){
            return "Math";
        }
        else {
            return "Biology";
        }
    }

    @Override
    public String toString() {
        return "Applicant {" +
                "name = \"" + name + "\" ," +
                " specialization = " + getNameOfSpecialization() +
                '}';
    }
}
