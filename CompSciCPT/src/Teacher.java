class Teacher {

    int onCallsWorked = 0;
    Boolean chosenToWork = false;
    Boolean isLunchSupervisor = false;
    Boolean isAbsent = false;
    Boolean isPriority = false;

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
