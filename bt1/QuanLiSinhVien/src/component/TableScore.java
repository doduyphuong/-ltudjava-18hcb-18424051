/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

/**
 *
 * @author CPU12407-local
 */
public class TableScore {

    private Student sd = new Student();
    private double scoreMiddleTest;
    private double scoreFinalTest;
    private double scoreDifferent;
    private double finalScore;

    public TableScore() {
        this.sd = null;
        this.scoreMiddleTest = 0;
        this.scoreFinalTest = 0;
        this.scoreDifferent = 0;
        this.finalScore = 0;
    }

    public Student getSd() {
        return sd;
    }

    public void setSd(Student _sd) {
        this.sd = _sd;
    }

    public double getScoreMiddleTest() {
        return scoreMiddleTest;
    }

    public void setScoreMiddleTest(double scoreMiddleTest) {
        this.scoreMiddleTest = scoreMiddleTest;
    }

    public double getScoreFinalTest() {
        return scoreFinalTest;
    }

    public void setScoreFinalTest(double scoreFinalTest) {
        this.scoreFinalTest = scoreFinalTest;
    }

    public double getScoreDifferent() {
        return scoreDifferent;
    }

    public void setScoreDifferent(double scoreDifferent) {
        this.scoreDifferent = scoreDifferent;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalSrore(double finalSrore) {
        this.finalScore = finalSrore;
    }

    public String getResult() {
        if (this.finalScore >= 5) {
            return "Đậu";
        }
        return "Rớt";
    }
}
