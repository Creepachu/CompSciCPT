public class Day {

    static Period[] periods = new Period[6];


    public static void setPeriods() {
        periods[0] = new Period(90, "1");
        periods[1] = new Period(90, "2");
        periods[2] = new Period(40, "3a");
        periods[3] = new Period(40, "3b");
        periods[4] = new Period(40, "3c");
        periods[5] = new Period(40, "4");
    }
}
class Period{
    static int length;
    static String periodName;
    Period(int periodLength, String name){
        length = periodLength;
        periodName = name;
    }
}