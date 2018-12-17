public class TeacherStuffMain {
    static Teacher[] teachers = new Teacher[12];
    public static void main(String[] args) {
        System.out.println("I'm going to be a big boy program one day!");
        generateTeachers();
        printNames();
    }
    static void generateTeachers(){
      teachers[0] = new Teacher("Romero", 0);
      teachers[1] = new Teacher("Tuppin", 0); 
      teachers[2] = new Teacher("Brace", 0);
      teachers[3] = new Teacher("Tenoso", 0);
      teachers[4] = new Teacher("DiLorenzo", 0);
      teachers[5] = new Teacher("Ragno", 0);
      teachers[6] = new Teacher("Ficele", 0);
      teachers[7] = new Teacher("Johnston", 0);
      teachers[8] = new Teacher("Sciulli", 0);
      teachers[9] = new Teacher("Fastro", 0);
      teachers[10] = new Teacher("Gawlik", 0);
      teachers[11] = new Teacher("Tarsi", 0);
        
    }
    static void printNames(){
        for (Teacher teacher: teachers) {
            System.out.println(teacher.name + " " + teacher.periodOff);
        }
    }
}
