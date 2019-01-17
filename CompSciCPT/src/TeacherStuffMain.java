/* THUNDERONIA ABSENCE AND ON-CALL HANDLER V0.9
 * DEVELOPED BY GIANFRANCO DILORENZO, _, _
 *
 * THIS VERSION IS BEING WORKED ON WITH SWING
 * BE GENTLE
 * KICK ASS AND CHEW BUBBLEGUM o7
 * */

import javax.swing.*;
import java.awt.event.*;

public class TeacherStuffMain {
    static Day day = new Day();
    static JFrame appFrame = new JFrame("Thunderonia Absence Handler V1");

    public static void main(String[] args) {

        boolean input = day.initialize();
        day.generateTeachers();

        while (input) {
            new MainPane();
            day.makeSomeoneAbsent();
            day.checkAbsent(); // Checks to see who is absent and finds replacements.  The meat of things are here.
            day.resetAbsentTeacher();
            day.daysPassed++;
            day.timesRun++;
            input = day.initialize();
        }
    } // end of main
} // end of main class
