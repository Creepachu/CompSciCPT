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
    boolean input = initialize();
    
    while (input == true){
      generateTeachers();
      printNames();
      makeSomeoneAbsent();
      checkAbsent();
      input = initialize();
    }
  }
  
  static boolean initialize() {
            do {
            System.out.println();
            System.out.println("A new day! Run program? Y/N");
            boolean runProgram = TextIO.getlnBoolean();

            if (runProgram) return true

            else{
                System.out.println("This will close the program and restart the semester. Continue? 1 yes 0 no");
                boolean yesImSure = TextIO.getlnBoolean();
                if (yesImSure) return false;
                else continue;
            }
            return false;
        }while (true);
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
        if (Integer.parseInt(value) == 0) teachers[i].periodOff = (j + 1);
      }
      i++;
    }
  }
  
  static void checkAbsent() {
    Teacher temp;
    
    for (Teacher teacher : teachers) {
      if (teacher.getAbsent()) {
        System.out.println();
        System.out.println(teacher.getName() + " is absent");
        System.out.println();
        temp = teacher;
        
        findReplacements(temp);
        //check for booleans
      }
    }
  }//End of checkAbsent
  
  static void findReplacements(Teacher absentee) {
    
    if (absentee.periodOff != 1){
      int p1fill = 0;
      for (int i = 0; i < teachers.length; i++) {
        if (p1fill == 2) break;
        if (teachers[i].periodOff == 1){
          System.out.println(teachers[i].getName() + " can replace " + absentee.getName() + " for period 1.");
          p1fill++;
        }
      }
    }
    
    if (absentee.periodOff != 2){
      int p2fill = 0;
      for (int i = 0; i < teachers.length; i++) {
        if (p2fill == 2) break;
        if (teachers[i].periodOff == 2){
          System.out.println(teachers[i].getName() + " can replace " + absentee.getName() + " for period 2.");
          p2fill++;
        }
      }
    }
    
    if (absentee.periodOff != 3){
      int p3fill = 0;
      for (int i = 0; i < teachers.length; i++) {
        if (p3fill == 2) break;
        if (teachers[i].periodOff == 3){
          System.out.println(teachers[i].getName() + " can replace " + absentee.getName() + " for period 3.");
          p3fill++;
        }
      }
    }
    
    if (absentee.periodOff != 4){
      int p4fill = 0;
      for (int i = 0; i < teachers.length; i++) {
        if (p4fill == 2) break;
        if (teachers[i].periodOff == 4){
          System.out.println(teachers[i].getName() + " can replace " + absentee.getName() + " for period 4.");
          p4fill++;
        }
      }
    }
  }
  
  static void printNames() {
    for (Teacher teacher : teachers) {
      System.out.println(teacher.name + " " + teacher.periodOff + " " + teacher.isAbsent);
    }
  }
  
  static void makeSomeoneAbsent() {
    boolean teacherFound = false;
    System.out.println(" ");
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
  }
  
  static int randomWithRange(int min, int max) {
    int range = (max - min) + 1;
    return (int) (Math.random() * range) + min;
  }
}
