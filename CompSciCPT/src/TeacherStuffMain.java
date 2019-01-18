/* THUNDERONIA ABSENCE AND ON-CALL HANDLER V0.99
 * DEVELOPED BY GIANFRANCO DILORENZO, _, _
 *
 * THIS VERSION IS BEING WORKED ON WITH SWING
 * BE GENTLE
 * KICK ASS AND CHEW BUBBLEGUM o7
 * */

public class TeacherStuffMain {
    static Day day = new Day();
    static MainPane mainPane;
    public static void main(String[] args) {

        boolean input = day.initialize();
        day.generateTeachers();

            if(mainPane == null) mainPane = new MainPane();
    } // end of main
} // end of main class
