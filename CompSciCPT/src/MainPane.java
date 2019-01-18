import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class MainPane extends JFrame implements ActionListener{

    MainPane(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1024,768);
        JPanel mainPanel = new JPanel();
        add(mainPanel);

        mainPanel.setLayout(null);
        JLabel label = new JLabel("What teacher is absent today?");
        label.setBounds(50, 50, 500, 50);
        mainPanel.add(label);

        JTextField teacherToBeAbsentField = new JTextField(20);
        teacherToBeAbsentField.setBounds(50,100,400,25);
        teacherToBeAbsentField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teacherToBeAway = teacherToBeAbsentField.getText();
                label.setText("Searching for " + teacherToBeAway);
                try { Thread.sleep(1000); }
                catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
                label.setText(TeacherStuffMain.day.makeSomeoneAbsent(teacherToBeAbsentField.getText()));
                if (TeacherStuffMain.day.teacherFound) TeacherStuffMain.day.runTheDay();
            }
        });
        mainPanel.add(teacherToBeAbsentField);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

    }
}
