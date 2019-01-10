/* THUNDERONIA ABSENCE AND ON-CALL HANDLER V0.5
* DEVELOPED BY GIANFRANCO DILORENZO, _, _
*
* TO DO: START SWING INTEGRATION
* CLEAN UP AND COMMENT CODE
* ASSIGN TEACHERS TO ON-CALLS EQUALLY (TEACHERS WITH FEWER ON CALLS WORKED GET HIGHER PRIORITY)
* KICK ASS AND CHEW BUBBLEGUM o7
* */

import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class TeacherStuffMain {
    static Teacher[] teachers = new Teacher[51];
    static File teacherFile = new File("TEACHERS.txt");
    static Scanner teacherScanner;
    static int daysPassed = 0;
    static Day day = new Day();

    public static void main(String[] args) {
        try {
            teacherScanner = new Scanner(teacherFile);
        } catch (FileNotFoundException e) {
        }
        boolean input = initialize();

        while (input == true) {
            generateTeachers();
            makeSomeoneAbsent();
            checkAbsent(); // Checks to see who is absent and finds replacements.  The meat of things are here.
            daysPassed++;
            day.timesRun++;
            input = initialize();
        }
        
        int numTimesRun = day.timesRun;
    }

    static boolean initialize() {
        do {
            System.out.println();
            System.out.println("A new day! Run program? Y/N");
            boolean runProgram = TextIO.getlnBoolean();

            if (runProgram) return true;

            else {
                System.out.println("This will close the program and restart the semester. Continue? Y/N");
                boolean yesImSure = TextIO.getlnBoolean();
                if (yesImSure) return false;
            }
        } while (true);
    }

    static void generateTeachers() {
        String currentLine;
        int supervisorsAssigned = 0;
        int i = 0;
        while (teacherScanner.hasNext()) {
            currentLine = teacherScanner.nextLine();

            Scanner lineScanner = new Scanner(currentLine);
            teachers[i] = new Teacher(lineScanner.next());
            for (int j = 0; j < 4; j++) {
                String value = lineScanner.next();
                if (value.equalsIgnoreCase("L")) {
                    teachers[i].periodOff = 3;

                    if (supervisorsAssigned < 3) {
                        teachers[i].isLunchSupervisor = true;
                        supervisorsAssigned++;
                    }
                    break;
                }
                if (Integer.parseInt(value) == 0) teachers[i].periodOff = (j + 1);
            }
            i++;
        }
        printNames();
    }

    static void checkAbsent() {
        Teacher temp;

        for (Teacher teacher : teachers) {
            if (teacher.getAbsent()) {
                System.out.println();
                System.out.println(teacher.getName() + " is absent" + " and has period " + teacher.getPeriodOff() + " off!");
                System.out.println();
                temp = teacher;

                findReplacements(temp); // Finds teachers to do on-calls for the absentee
            }
        }
    }//End of checkAbsent

    static void findReplacements(Teacher absentee) {

        if (absentee.periodOff != 1) { // If the teacher usually teaches period 1, find replacements for period one.
            int p1fill = 0;
            for (int i = 0; i < teachers.length; i++) {
                if (p1fill == 2) break;
                if (teachers[i].periodOff == 1 && !teachers[i].isLunchSupervisor) {
                    System.out.println(teachers[i].getName() + " can replace " + absentee.getName() + " for period 1.");
                    p1fill++;
                }
            }
        }

        if (absentee.periodOff != 2) { // If the teacher usually teaches period two, find a replacement period two. Etc.
            int p2fill = 0;
            for (int i = 0; i < teachers.length; i++) {
                if (p2fill == 2) break;
                if (teachers[i].periodOff == 2 && !teachers[i].isLunchSupervisor) {
                    System.out.println(teachers[i].getName() + " can replace " + absentee.getName() + " for period 2.");
                    p2fill++;
                }
            }
        }

        if (absentee.periodOff != 3) {
            int p3fill = 0;
            for (int i = 0; i < teachers.length; i++) {
                if (p3fill == 2) break;
                if (teachers[i].periodOff == 3 && !teachers[i].isLunchSupervisor) {
                    System.out.println(teachers[i].getName() + " can replace " + absentee.getName() + " for period 3.");
                    p3fill++;
                }
            }
        }

        if (absentee.periodOff != 4) {
            int p4fill = 0;
            for (int i = 0; i < teachers.length; i++) {
                if (p4fill == 2) break;
                if (teachers[i].periodOff == 4 && !teachers[i].isLunchSupervisor) {
                    System.out.println(teachers[i].getName() + " can replace " + absentee.getName() + " for period 4.");
                    p4fill++;
                }
            }
        }
    }

    static void printNames() { // Prints all the teachers and their associated information
        for (Teacher teacher : teachers) {
            if (teacher.isAbsent) System.out.println("Name: " + teacher.name + " | Period off: " + teacher.periodOff + " | THIS TEACHER IS ABSENT!");
            System.out.println("Name: " + teacher.name + " | Period off: " + teacher.periodOff);
        }
    }

    static void makeSomeoneAbsent() {
        boolean teacherFound = false;
        System.out.println(" ");
        System.out.print("Make someone absent:");
        System.out.println();

        do {
            String user = TextIO.getln(); // the user string is taken as input from the user, and the teacher array is scanned for a match.
            for (int i = 0; i < teachers.length; i++) {
                if (user.equalsIgnoreCase(teachers[i].getName())) { // If a match is found, the associated teacher is made to be absent.
                    teachers[i].isAbsent = true;
                    teacherFound = true;
                }
            }
            if (!teacherFound) {
                System.out.println("Error: No such teacher exists!");
            }
        } while (!teacherFound);
    }

    static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
