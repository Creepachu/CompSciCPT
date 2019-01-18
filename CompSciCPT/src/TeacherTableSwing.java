import javax.swing.*;
import java.awt.*;

public class TeacherTableSwing extends JPanel {

    public TeacherTableSwing(Teacher[] teachers) { // Constructor
        super(new GridLayout(1, 0));
        String[] columnNames = {"Teacher Name", "Period 1", "Period 2", "Period 3", "Period 4"
        };
        Object[][] data = new Object[4][3];


        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(900, 600));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        showTable();
    }

    private static void showTable() {
        JFrame frame = new JFrame("Teacher Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TeacherTableSwing newContentPane = new TeacherTableSwing();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
