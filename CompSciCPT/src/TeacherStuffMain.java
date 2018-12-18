import java.lang.Math;
public class TeacherStuffMain {
    static Teacher[] teachers = new Teacher[12];
    public static void main(String[] args) {
        Day today = new Day();

        today.setPeriods();
        generateTeachers();
        today.setTeachersOff(teachers);
        makeSomeoneAbsent();
        printNames();
    }

    static void generateTeachers(){
        teachers[0] = new Teacher("Romero", 1, "3a");
        teachers[1] = new Teacher("Tuppin", 2, "3b");
        teachers[2] = new Teacher("Brace", 3, "3c");
        teachers[3] = new Teacher("Tenoso", 4, "3a");
        teachers[4] = new Teacher("DiLorenzo", 1, "3b");
        teachers[5] = new Teacher("Ragno", 2, "3c");
        teachers[6] = new Teacher("Ficele", 3, "3a");
        teachers[7] = new Teacher("Johnston", 4, "3b");
        teachers[8] = new Teacher("Sciulli", 1, "3c");
        teachers[9] = new Teacher("Fastro", 2, "3a");
        teachers[10] = new Teacher("Gawlik", 3, "3b");
        teachers[11] = new Teacher("Tarsi", 4, "3c");

    }
    static void printNames(){
        for (Teacher teacher: teachers) {
            System.out.println(teacher.name + " " + teacher.periodOff + " " + teacher.isAbsent);
        }
    }
    static void makeSomeoneAbsent(){ teachers[randomWithRange(0,11)].isAbsent = true; }

    static int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
}
