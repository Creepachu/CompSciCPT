class Teacher {

    Boolean isLunchSupervisor = false;


    String name;
    int periodOff;
    String lunchPeriod;
    Teacher(String n, int p, String lunch)//Constructor
    {
        lunchPeriod = lunch;
        name = n;
        periodOff = p;
        if (p == 3) isLunchSupervisor = true;
    }

    String getName()
    {
        return name;
    }

    int getPeriodOff()
    {
        return periodOff;
    }

    String getLunch()
    {
        return lunchPeriod;
    }
}
