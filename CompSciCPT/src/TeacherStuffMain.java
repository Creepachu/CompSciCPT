public class TeacherStuffMain {
    static Teacher[] teachers = new Teacher[12];
    public static void main(String[] args) {
        System.out.println("I'm going to be a big boy program one day!");
        generateTeachers();
    }
    static void generateTeachers(){
        for (int i = 0; i < teachers.length; i++) {
            teachers[i] = new Teacher("Teacher " + i, 0);
        }
    }
    static void printNames(){
        for (Teacher teacher: teachers) {
            System.out.println(teacher.name);
            System.out.println(teacher.periodOff);
        }
    }
}
