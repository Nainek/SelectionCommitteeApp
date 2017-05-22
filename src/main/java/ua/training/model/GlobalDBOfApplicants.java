package ua.training.model;


import ua.training.GlobalConstants;
import ua.training.controller.creator.*;

import java.util.*;

public class GlobalDBOfApplicants {

    List<Applicant> listOfAllApplicants = new ArrayList<Applicant>();

    Iterator<Applicant> iterator;

    public GlobalDBOfApplicants() {
        this.listOfAllApplicants = createAllApplacants();
        iterator = listOfAllApplicants.iterator();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Applicant next() {
        return iterator.next();
    }

    public Applicant getApplicantFromDB() {
        return iterator.next();
    }


    public void setListOfAllApplicants(List<Applicant> listOfAllApplicants) {
        this.listOfAllApplicants = listOfAllApplicants;
    }

    private ApplicantCreator applicantCreator = new BiologyApplacantCreator();

    private List<Applicant> createAllApplacants(){
        List<Applicant> list = new LinkedList<Applicant>();

        applicantCreator = new BiologyApplacantCreator();
        for(int i = 0; i < GlobalConstants.NUMBER_OF_BIOLOGY_APPLICANTS; i++){
            list.add(applicantCreator.createDefaultApplicant("" +i));
        }

        applicantCreator = new MathApplacantCreator();
        for(int i = 0; i < GlobalConstants.NUMBER_OF_MATH_APPLICANTS; i++){
            list.add(applicantCreator.createDefaultApplicant("" +i));
        }

        Collections.shuffle(list);
        return list;
    }

    public List<Applicant> getListOfAllApplicants() {
        return listOfAllApplicants;
    }
}

