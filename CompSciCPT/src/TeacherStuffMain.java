import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class TeacherStuffMain {
    static Teacher[] teachers = new Teacher[51];
    static File teacherFile = new File("TEACHERS.txt");
    static Scanner teacherScanner;

    public static void main(String[] args) {
        try {
            teacherScanner = new Scanner(teacherFile);
        } catch (FileNotFoundException e) {
        }

        generateTeachers();
        makeSomeoneAbsent();
        printNames();
        checkAbsent();
    }

    static void generateTeachers() {
        String currentLine;
        int i = 0;
        while (teacherScanner.hasNext()) {
            currentLine = teacherScanner.nextLine();

            Scanner lineScanner = new Scanner(currentLine);
            teachers[i] = new Teacher(lineScanner.next());
            for (int j = 0; j < 4; j++) {
                String value = lineScanner.next();
                if (value.equalsIgnoreCase("L")) {
                    teachers[i].periodOff = 3;
                    teachers[i].isLunchSupervisor = true;
                    break;
                }
                if (Integer.parseInt(value) == 0) teachers[i].periodOff = (j+1);
            }
            i++;
        }
    }

     static void checkAbsent() {
      Teacher[] temp = new Teacher[1];
      int a = 0;
      for (Teacher teacher: teachers) {
        if (teacher.getAbsent()) {
          System.out.println();
          System.out.println(teacher.getName() + " is absent");
          temp[0] = teacher;
          System.out.println(temp[0].getName() + " has period " + temp[0].getPeriodOff() + " off ");
          System.out.println();
          
          for (int j = 0; j < teachers.length; j++) {
            if (teachers[j].getPeriodOff() != temp[0].getPeriodOff()) {
              //add suggestions for replacements
              System.out.println(teachers[j].getName() + " can replace " + temp[0].getName() + " for period " + teachers[j].getPeriodOff());
              a++;
              if(a == 3)
              {
                break;
              }
            }
          }
          //check for booleans
        }
      }
    }//End of checkAbsent

    static void printNames() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher.name + " " + teacher.periodOff + " " + teacher.isAbsent);
        }
    }

    static void makeSomeoneAbsent() {
        boolean teacherFound = false;
        System.out.print("Make someone absent:");
        System.out.println();

        do {
            String user = TextIO.getln();
            for (int i = 0; i < teachers.length; i++) {
                if (user.equalsIgnoreCase(teachers[i].getName())) {
                    teachers[i].isAbsent = true;
                    teacherFound = true;
                }
            }
            if (!teacherFound) {
                System.out.println("Error: No such teacher exists!");
            }
        } while (!teacherFound);
        //teachers[randomWithRange(0,teachers.length)].isAbsent = true;
    } // end of makesomeoneabsent
    static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
