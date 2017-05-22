package ua.training;


import ua.training.model.Certificate;

public interface GlobalConstants {

    int MAX_SIZE_OF_QUEUE = 50;
    int LOWER_LIMIT_APPLICANTS_IN_QUEUE = 25;
    int NUMBER_OF_MATH_APPLICANTS = 250;
    int NUMBER_OF_BIOLOGY_APPLICANTS = 200;
    int MAX_APPLICANTS_AT_A_TIME = 5;
    int NORMAL_SCORE = 100;
    int APPRORIATE_SCORE = 120;
    int GREATE_SCORE = 150;
    int WAIT_WHEN_FIRST_APPLICANTS_WILL_COME = 1000;

    Object GLOBAL_MONITOR = new Object();

    Certificate MATH_CERTIFICATE = new Certificate(NORMAL_SCORE,GREATE_SCORE,GREATE_SCORE,NORMAL_SCORE,NORMAL_SCORE);

    Certificate BIOLOGY_CERTIFICATE = new Certificate(NORMAL_SCORE,NORMAL_SCORE,NORMAL_SCORE,GREATE_SCORE,GREATE_SCORE);
}
