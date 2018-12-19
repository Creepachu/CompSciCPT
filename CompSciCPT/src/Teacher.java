class Teacher {

    Boolean isLunchSupervisor = false;
    Boolean isAbsent = false;

    String name;
    int periodOff;
    String lunchPeriod;
    Teacher(String n)//Constructor
    {
        name = n;
    }

    String getName()
    {
        return name;
    }

    int getPeriodOff()
    {
        return periodOff;
    }

    Boolean getAbsent()
    {
        return isAbsent;
    }

    void setPeriodOff(int period)
    {
        periodOff = period;
    }

    String getLunch()
    {
        return lunchPeriod;
    }
}
