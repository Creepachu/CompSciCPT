/* THUNDERONIA ABSENCE AND ON-CALL HANDLER V0.85
 * DEVELOPED BY GIANFRANCO DILORENZO, _, _
 *
 * THIS VERSION IS BEING WORKED ON WITH SWING
 * BE GENTLE
 * KICK ASS AND CHEW BUBBLEGUM o7
 * */

import javax.swing.*;

public class TeacherStuffMain {
    static Day day = new Day();
    static JFrame appFrame = new JFrame("Thunderonia Absence Handler V1");

    public static void main(String[] args) {

        boolean input = day.initialize();
        day.generateTeachers();

        while (input) {
            day.makeSomeoneAbsent();
            day.checkAbsent(); // Checks to see who is absent and finds replacements.  The meat of things are here.
            day.resetAbsentTeacher();
            day.daysPassed++;
            day.timesRun++;
            input = day.initialize();
        }
    } // end of main
} // end of main class
