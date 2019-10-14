import java.util.*;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<Double>();

    Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        examScores.addAll(Arrays.asList(testScores));
    }

    public void addExamScore(double score) {
        examScores.add(score);
    }

    public double getAverageExamScore(){
        double sum = 0;
        for(double d : examScores)
            sum += d;
        return sum/examScores.size();
    }

    public void takeExam(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }

    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber-1, newScore);
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public String getExamScoresString() {
        String s = "Exam scores: \n";
        for(int i = 0; i < examScores.size(); i++)
            s += ("Exam" + " " + (i+1) + " -> " + examScores.get(i) + "\n");
        return s;
    }

    @Override
    public String toString() {
        return "Student Name: " + firstName + " " + lastName + '\n' +
                "> Average Score: " + getAverageExamScore() + '\n' +
                "> " + getExamScoresString() + '\n' +
                " ";
    }

}
