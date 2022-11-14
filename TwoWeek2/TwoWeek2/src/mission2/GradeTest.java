package mission2;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class File {
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void check() {
        while(true) {
            System.out.println("원하는 기능의 번호를 눌러주세요. 1.조회 2.추가 3.수정 4.종료");
            Scanner scanner = new Scanner(System.in);
            int answer1 = scanner.nextInt();
            int exitCode = 0;
            switch (answer1) {
                case 1:
                    for(Student student: File.studentList) {
                        Student.showStudentInfo(student);
                    }
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    System.out.println("수정 원하시는 정보를 골라주세요. 1.학생 정보 2. 성적");
                    int answer2 = scanner.nextInt();
                    switch (answer2) {
                        case 1 -> reviseStudent();
                        case 2 -> Student.reviseSubjectScore();
                        default -> System.out.println("잘못된 답변입니다.");
                    }
                case 4:
                    exitCode = 1;
                    break;
                default:
                    System.out.println("잘못된 답변입니다.");
                    break;
            }
            if(exitCode == 1) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
        }
    }

    public static void writeTXT() throws IOException {
        BufferedWriter input = new BufferedWriter(new FileWriter("input.txt", false));
        input.write("Kim/1001/수학/100/100/ ");
        input.newLine();
        input.write("Lee/1002/국어/55/55/100");
        input.newLine();
        input.close();
    }

    public static void readFileAddList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            while(true) {
                String text = reader.readLine();
                if(text == null) break;
                String[] strArray = text.split("/");
                studentList.add(new Student(strArray[0], Integer.parseInt(strArray[1]), strArray[2]
                        , strArray[3], strArray[4], strArray[5]));
            }
        } catch(IOException fe) {
            fe.printStackTrace();
        }
    }

    public static void save() {
        int count=0;

        try {
            BufferedWriter save = new BufferedWriter(new FileWriter("input.txt", false));
            while(File.studentList.size() > count) {
                save.write(File.studentList.get(count).studentName+ "/"
                        + File.studentList.get(count).studentID + "/"
                        + File.studentList.get(count).majorSubject + "/"
                        + File.studentList.get(count).subjectList.get(0).score + "/"
                        + File.studentList.get(count).subjectList.get(1).score + "/"
                        + File.studentList.get(count).subjectList.get(2).score);
                save.newLine();
                count++;
            }
            save.close();
        } catch (IOException fe) {
            fe.printStackTrace();
        }
    }

    public static void addStudent() {
        System.out.println("추가할 학생 이름, 전공 과목, 국어, 수학, 영어 성적을 /로 구분하여 순서대로 작성해주세요.");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] strArray = text.split("/");
        studentList.add(new Student(strArray[0], strArray[1], strArray[2], strArray[3], strArray[4]));
        System.out.println((File.studentList.get(File.studentList.size()-1)).studentName+ "/"
                + File.studentList.get(File.studentList.size()-1).studentID + "/"
                + File.studentList.get(File.studentList.size()-1).majorSubject + "/"
                + File.studentList.get(File.studentList.size()-1).subjectList.get(0).score + "/"
                + File.studentList.get(File.studentList.size()-1).subjectList.get(1).score + "/"
                + File.studentList.get(File.studentList.size()-1).subjectList.get(2).score);
        System.out.println("추가할 내용이 맞습니까? 1.네 2.아니요");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1 -> save();
            case 2 -> addStudent();
            default -> System.out.println("잘못된 답변입니다.");
        }
        save();
    }

    public static void reviseStudent() {
        System.out.println("수정할 학생의 이름과 바꿀 이름을 /로 구분하여 순서대로 작성해주세요.");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] strArray = text.split("/");
        String studentName = strArray[0];
        String reviseStudentName = strArray[1];
        for(Student student: File.studentList) {
            if(Objects.equals(student.studentName, studentName)) {
                student.studentName = reviseStudentName;
            }
        }
        for(Student student: File.studentList) {
            Student.showStudentInfo(student);
        }
        System.out.println("수정할 내용이 맞습니까? 1.네 2.아니요");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1 -> save();
            case 2 -> reviseStudent();
            default -> System.out.println("잘못된 답변입니다.");
        }
    }
}

class Student {
    int studentID;
    String studentName;
    String majorSubject;
    ArrayList<Subject> subjectList = new ArrayList<>();

    public Student(String studentName, int studentID, String majorSubject, String score1, String score2, String score3) {
        this.studentName = studentName;
        this.majorSubject = majorSubject;
        this.studentID = studentID;
        this.subjectList.add(new Subject("국어", score1));
        this.subjectList.add(new Subject("수학", score2));
        this.subjectList.add(new Subject("영어", score3));
    }

    public Student(String studentName, String majorSubject, String score1, String score2, String score3) {
        this.studentName = studentName;
        this.majorSubject = majorSubject;
        this.studentID = File.studentList.get(File.studentList.size()-1).studentID + 1;
        this.subjectList.add(new Subject("국어", score1));
        this.subjectList.add(new Subject("수학", score2));
        this.subjectList.add(new Subject("영어", score3));
    }

    public static void showStudentInfo(Student student) {
        int total = 0;
        int subjectNum = 0;
        int score;
        for(Subject subject: student.subjectList) {
            if(subject.score.equals(" ")) {
                score = -1;
            }else {
                score = Integer.parseInt(subject.score);
            }
            if(score >= 0) {
                total += score;
                subjectNum++;
            }
        }
        int average = total / subjectNum;
        System.out.println(student.studentName + " 학생은 "+ subjectNum + "과목을 수강했습니다.");
        System.out.println("총점은 "+ total + "점이고 평균은 " + average + "점입니다.");
        System.out.println("------------------------------------------");
    }

    public static void reviseSubjectScore() {
        System.out.println("성적을 수정하고 싶은 학생 이름, 과목 그리고 수정할 성적을 /로 구분하여 순서대로 작성해주세요.");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] strArray = text.split("/");
        String studentName = strArray[0];
        String subjectName = strArray[1];
        String score = strArray[2];
        for(Student student: File.studentList) {
            if(Objects.equals(student.studentName, studentName)) {
                for(Subject subject: student.subjectList) {
                    if(Objects.equals(subject.subjectName, subjectName)) {
                        subject.score = score;
                    }
                }
            }
        }
        for(Student student: File.studentList) {
            Student.showStudentInfo(student);
        }
        System.out.println("수정할 내용이 맞습니까? 1.네 2.아니요");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1 -> File.save();
            case 2 -> reviseSubjectScore();
            default -> System.out.println("잘못된 답변입니다.");
        }
    }
}

class Subject {
    String score;
    String subjectName;

    public Subject(String subjectName, String score) {
        this.subjectName = subjectName;
        this.score = score;
    }
}

public class GradeTest {
    public static void main(String[] args) throws IOException {
        File.writeTXT();
        File.readFileAddList();
        File.check();
    }
}
