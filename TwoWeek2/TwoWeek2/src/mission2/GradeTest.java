package mission2;

import java.io.*;
import java.util.ArrayList;

class ReadFile {
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void writetxt() throws IOException {
        BufferedWriter input = new BufferedWriter(new FileWriter("input.txt", false));
        input.write("Kim/1001/수학/100/100/ ");
        input.newLine();
        input.write("Lee/1002/국어/55/55/100");
        input.close();
    }

    public static void readFileAddList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            while(true) {
                String text = reader.readLine();
                if(text == null) break;
                String[] strArray = text.split("/");
                studentList.add(new Student(strArray[0], strArray[2], strArray[3]
                        , strArray[4], strArray[5]));
            }
        } catch(IOException fe) {
            fe.printStackTrace();
        }
    }
}

class Student {
    private static int serialNum = 1000;
    int studentID;
    String studentName;
    String majorSubject;
    ArrayList<Subject> subjectList = new ArrayList<>();

    public Student(String studentName, String majorSubject, String score1, String score2, String score3) {
        this.studentName = studentName;
        this.majorSubject = majorSubject;
        serialNum++;
        studentID = serialNum;
        this.subjectList.add(new Subject("국어", score1));
        this.subjectList.add(new Subject("수학", score2));
        this.subjectList.add(new Subject("영어", score3));
    }

    public void addSubject(String name, int score) {
        Subject subject = new Subject(name, score);
        subjectList.add(subject);
    }

    public static void showStudentInfo(Student student) {
        int total = 0;
        int subjectNum = 0;
        for(Subject subject: student.subjectList) {
            total += subject.score;
            if(subject.score != 0) {
                subjectNum++;
            }
        }
        int average = total / subjectNum;
        System.out.println(student.studentName + " 학생은 "+ subjectNum + "과목을 수강했습니다.");
        System.out.println("총점은 "+ total + "점이고 평균은 " + average + "점입니다.");
    }
}

class Subject {
    int score;
    String subjectName;

    public Subject(String subjectName, int score) {
        this.subjectName = subjectName;
        this.score = score;
    }

    public Subject(String subjectName, String score) {
        this.subjectName = subjectName;
        try {
            this.score = Integer.parseInt(score);
        } catch (NumberFormatException e) {
            this.score = 0;
        }
    }
}

public class GradeTest {
    public static void main(String[] args) throws IOException {
        ReadFile.writetxt();
        ReadFile.readFileAddList();
        for(Student student: ReadFile.studentList) {
            Student.showStudentInfo(student);
        }
    }
}
