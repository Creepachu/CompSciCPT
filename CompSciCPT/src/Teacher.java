class Teacher {

Boolean isLunchSupervisor = false; 
Boolean isAbsent = false;
String name;
int periodOff;
String lunch;
 
 Teacher(String n, int p, String l)//Constructor
 {
   name = n;
   periodOff = p;
   lunch = l;
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
   return lunch;
 }
 
 Boolean getAbsent()
 {
   return isAbsent;
 }
 
}//End of teacher
