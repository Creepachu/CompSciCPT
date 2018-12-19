import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class TeacherStuffMain {
    static Teacher[] teachers = new Teacher[100];
    static File teacherFile = new File("TEACHERS.txt");
    static Scanner teacherScanner;

    public static void main(String[] args) {
        try {
            teacherScanner = new Scanner(teacherFile);
        } catch (FileNotFoundException e) {
        }

        Day today = new Day();


        today.setPeriods();
        generateTeachers();
        //today.setTeachersOff(teachers);
        //makeSomeoneAbsent();
        //printNames();
    }

    static void generateTeachers() {
        String currentLine = "";
        while (currentLine != null) {
            currentLine = teacherScanner.nextLine();
            System.out.println(currentLine);
        }
    }

    static void checkAbsent() {
        Teacher[] temp = new Teacher[1];
        for (int i = 0; i < 12; i++) {
            if (teachers[i].getAbsent() == true) {
                System.out.println();
                System.out.println(teachers[i].getName() + " is absent");
                System.out.println();
                temp[0] = teachers[i];

                for (int j = 0; j < 12; j++) {
                    if (teachers[j].getPeriodOff() != temp[0].getPeriodOff()) {
                        System.out.println(teachers[j].getName() + " can replace " + temp[0].getName() + " for period " + teachers[j].getPeriodOff());
                    }
                }
                //check for booleans
                //add suggestions for replacements
            }
        }
    }

    static void printNames() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher.name + " " + teacher.periodOff + " " + teacher.isAbsent);
        }
    }

    static void makeSomeoneAbsent() {
        teachers[randomWithRange(0, 11)].isAbsent = true;
    }

    static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
