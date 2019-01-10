class Teacher {

    int onCallsWorked = 0;
    Boolean isLunchSupervisor = false;
    Boolean isAbsent = false;

    String name;
    int periodOff;

    Teacher(String n)//Constructor
    {
        name = n;
    }

    String getName() {
        return name;
    }

    Boolean getAbsent() {
        return isAbsent;
    }

    void workedAnOnCall(){
        onCallsWorked++;
    }
}
