public class TeacherStuffMain {
  static Teacher[] teachers = new Teacher[12];
  public static void main(String[] args) {
    System.out.println("I'm going to be a big boy program one day!");
    generateTeachers();
    printNames();
  }
  static void generateTeachers(){
    teachers[0] = new Teacher("Romero", 0, "3a");
    teachers[1] = new Teacher("Tuppin", 0, "3b"); 
    teachers[2] = new Teacher("Brace", 0, "3c");
    teachers[3] = new Teacher("Tenoso", 0, "3a");
    teachers[4] = new Teacher("DiLorenzo", 0, "3b");
    teachers[5] = new Teacher("Ragno", 0, "3c");
    teachers[6] = new Teacher("Ficele", 0, "3a");
    teachers[7] = new Teacher("Johnston", 0, "3b");
    teachers[8] = new Teacher("Sciulli", 0, "3c");
    teachers[9] = new Teacher("Fastro", 0, "3a");
    teachers[10] = new Teacher("Gawlik", 0, "3b");
    teachers[11] = new Teacher("Tarsi", 0, "3c");
    
  }
  static void printNames(){
    for (Teacher teacher: teachers) {
      System.out.println(teacher.name + " " + teacher.periodOff + " " + teacher.lunch);
    }
  }
}
