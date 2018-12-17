class Teacher {
  
String name;
int periodOff;
String lunch;
 
 Teacher(String n, int p, String l)//Constructor
 {
   name = n;
   periodOff = p;
   lunch = l;
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
}
