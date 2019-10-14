import java.lang.reflect.Array;
import java.util.*;

public class Classroom {
    private Student[] students;

    public Classroom() { this(new Student[20]);}

    public Classroom(int maxNumberofStudents) { this(new Student[maxNumberofStudents]);}

    public Classroom(Student[] students) {
        this.students = students;
    }

    public double getAverageExamScore(){
        double sum = 0;
        ArrayList<Double> scores = new ArrayList<Double>();
        for(Student s : students)
            scores.add(s.getAverageExamScore());
        for(Double d : scores)
            sum += d;
        return sum/students.length;
    }

    public void addStudent(Student student){
        for(int i = 0; i < students.length; i++)
            if (students[i]==null)
                students[i] = student;
            else
                System.out.println("Error: Students list full.");
    }

    public void removeStudent(String firstName, String lastName){
        for(int i = 0; i < students.length; i++)
            if(students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName))
                students[i]=null;
            else
                System.out.println("Could not find student to remove.");
    }

    public Student[] getStudentsByScore() {
        double[] grades = new double[students.length];
        Student[] sortedStudents = new Student[students.length];

        for(int i = 0; i < students.length; i++)
            grades[i] = students[i].getAverageExamScore();
        Arrays.sort(grades);

        for(int i = 0; i < students.length; i++){
            for (int x = 0; x < grades.length; x++){
                if(grades[x] == students[i].getAverageExamScore())
                    sortedStudents[i] = students[i];
            }
        }
        return sortedStudents;
    }

    public Map<Character, Student> getGradeBook() {
        Map<Character, Double> letterScale = new HashMap<Character, Double>();
        Map<Character, Student> grades = new HashMap<Character, Student>();
        double highestScore = 0.0;
        for(int i = 0; i < students.length; i++){
            if(students[i].getAverageExamScore() > highestScore)
                highestScore = students[i].getAverageExamScore();
        }
        letterScale.put('A', highestScore*0.90);
        letterScale.put('B', highestScore*0.71);
        letterScale.put('C', highestScore*0.50);
        letterScale.put('D', highestScore*0.11);
        letterScale.put('F', 0.00);

        for(int i = 0; i < students.length; i++){
            double sScore = students[i].getAverageExamScore();
            for (Map.Entry<Character, Double> entry : letterScale.entrySet()) {
                Double value = entry.getValue();
                if(sScore >= value)
                {
                    grades.put(entry.getKey(), students[i]);
                    break;
                }
            }
        }
        return grades;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
