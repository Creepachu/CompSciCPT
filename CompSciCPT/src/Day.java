import java.util.*;

class Day {

    static Period[] periods = new Period[6];
    int timesRun = 0;
    int daysPassed = 0;

    public static void setPeriods() {
        periods[0] = new Period(90, "1");
        periods[1] = new Period(90, "2");
        periods[2] = new Period(40, "3a");
        periods[3] = new Period(40, "3b");
        periods[4] = new Period(40, "3c");
        periods[5] = new Period(90, "4");
    }
    public static void setTeachersOff(Teacher[] teachers){
        for (Teacher teacher: teachers) {
            if (teacher.periodOff == 1) periods[0].teachersOff.add(teacher);
            if (teacher.periodOff == 2) periods[1].teachersOff.add(teacher);
            if (teacher.periodOff == 3) teacher.isLunchSupervisor = true;
            if (teacher.periodOff == 4) periods[5].teachersOff.add(teacher);
        }
    }

  
  int getTimesRun()
  {
    return timesRun;
  }
  
  int getDaysPassed()
  {
    return daysPassed;
  }
  
  void setTimesRun()
  {
    timesRun = 0;
  }
  
  void setDaysPassed()
  {
    daysPassed = 0;
  }
    
}
class Period{
    static LinkedList<Teacher> teachersOff = new LinkedList<Teacher>();
    static int length;
    static String periodName;

    Period(int periodLength, String name){
        length = periodLength;
        periodName = name;
    }
}
