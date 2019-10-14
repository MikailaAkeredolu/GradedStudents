public class Main {
    public static void main(String[] args) {
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        System.out.println(student.getExamScoresString());

        student.addExamScore(100.0);
        System.out.println(student.getExamScoresString());

        student.setExamScore(1, 85.0);
        System.out.println(student.getExamScoresString());

        System.out.println("Average exam score: " + student.getAverageExamScore() + "\n");

        System.out.println(student.toString());


        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        double output = classroom.getAverageExamScore();

        System.out.println("Average exam score: " + output);

        System.out.println(classroom.getGradeBook());
    }
}
