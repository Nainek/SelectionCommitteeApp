package ua.training.model;


public class Certificate {


    private int scoreOnLanguageTest;
    private int scoreOnMathTest;
    private int scoreOnPhysicsTest;
    private int scoreOnBiologyTest;
    private int scoreOnChemistryTest;

    public Certificate(int scoreOnLanguageTest, int scoreOnMathTest, int scoreOnPhysicsTest, int scoreOnBiologyTest, int scoreOnChemistryTest) {
        this.scoreOnLanguageTest = scoreOnLanguageTest;
        this.scoreOnMathTest = scoreOnMathTest;
        this.scoreOnPhysicsTest = scoreOnPhysicsTest;
        this.scoreOnBiologyTest = scoreOnBiologyTest;
        this.scoreOnChemistryTest = scoreOnChemistryTest;
    }

    public int getScoreOnMathTest() {
        return scoreOnMathTest;
    }

    public int getScoreOnLanguageTest() {
        return scoreOnLanguageTest;
    }

    public int getScoreOnPhysicsTest() {
        return scoreOnPhysicsTest;
    }

    public int getScoreOnBiologyTest() {
        return scoreOnBiologyTest;
    }

    public int getScoreOnChemistryTest() {
        return scoreOnChemistryTest;
    }

}
