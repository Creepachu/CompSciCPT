/*
Mama mia that's a spicy meatball!
Most of the stuff that makes the program tick is in here. Put helper methods/mechanical stuff not directly related to structuring the runtime in HERE!
<3
 */

import java.io.*;
import java.util.*;

class Day {

    static Teacher[] teachers = new Teacher[51];
    static File teacherFile = new File("TEACHERS.txt");
    static Scanner teacherScanner;
    int timesRun = 0;
    int daysPassed = 0;
    boolean teacherFound = false;

    Day() {
        try {
            teacherScanner = new Scanner(teacherFile);
        } catch (FileNotFoundException e) {
        }
    }

    void runTheDay() {
        checkAbsent(); // Checks to see who is absent and finds replacements.  The meat of things are here.
        resetAbsentTeacher();
        daysPassed++;
        timesRun++;
    }

    String makeSomeoneAbsent(String name) { // This is the version to use in the swing variant!

        String user = name;
        for (int i = 0; i < teachers.length; i++) {
            if (user.equalsIgnoreCase(teachers[i].getName())) { // If a match is found, the associated teacher is made to be absent.
                teachers[i].isAbsent = true;
                teacherFound = true;
                return "Success! " + teachers[i].getName() + " has been confirmed to be absent.";
            }
        }

        return "Error! No such teacher exists!";
    }

    void resetAbsentTeacher() {
        for (Teacher teacher : teachers) {
            teacher.chosenToWork = false;
            teacher.isAbsent = false;
        }
    } // end of resetAbsentTeacher

    void checkAbsent() {
        Teacher temp;

        for (Teacher teacher : teachers) {
            if (teacher.getAbsent()) {
                System.out.println();
                System.out.println(teacher.getName() + " is absent");
                System.out.println();

                teacher.isPriority = true;
                temp = teacher;

                findReplacements(temp); // Finds teachers to do on-calls for the absentee
            }
        }
    }//End of checkAbsent

    void printNames() { // Prints all the teachers and their associated information
        for (Teacher teacher : teachers) {
            if (teacher.isAbsent)
                System.out.println("Name: " + teacher.name + " | Period off: " + teacher.periodOff + " | THIS TEACHER IS ABSENT!");
            System.out.println("Name: " + teacher.name + " | Period off: " + teacher.periodOff);
        }
    }// end of printNames

    boolean initialize() {
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
    } // end of initialize

    void generateTeachers() {
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
    } // end of generateTeachers

    void findReplacements(Teacher absentee) {
        int teachersAdded = 0;
        Teacher temp = null;
        Teacher[] temps = new Teacher[6];

        for (int i = 1; i <= 4; i++) {

            if (absentee.periodOff != i) { // If the teacher usually teaches period i, find replacements for period one.
                for (int k = 0; k < 2; k++) {
                    for (Teacher teacher : teachers) {

                        if (temp == null) temp = teacher;
                        else if (teacher.periodOff == i && !teacher.chosenToWork && teacher.onCallsWorked < temp.onCallsWorked && !teacher.isLunchSupervisor && teacher.onCallsWorked < 20 || teacher.periodOff == i && !teacher.chosenToWork && teacher.isPriority && !teacher.isLunchSupervisor && teacher.onCallsWorked < 20)
                            temp = teacher;
                    }
                    temps[teachersAdded] = temp;
                    teachersAdded++;

                    System.out.println(temp.getName() + " will replace " + absentee.getName() + " for half of period " + i + " - " + temp.onCallsWorked);
                    temp.workedAnOnCall();
                    temp.chosenToWork = true;
                    temp.isPriority = false;
                }
            }
        }
    }
}
