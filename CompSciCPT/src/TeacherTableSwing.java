import javax.swing.*;
import java.awt.*;

public class TeacherTableSwing extends JPanel {
    static JTable table;

    public TeacherTableSwing(Teacher[] teachers) { // Constructor
        super(new GridLayout(1, 0));
        String[] columnNames = {"Teacher Name", "Period 1", "Period 2", "Period 3", "Period 4"
        };
        Object[][] data = new Object[4][3];
        table.setPreferredScrollableViewportSize(new Dimension(900, 600));
        table.setFillsViewportHeight(true);

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        showTable();
    }

    private static void showTable() {
        JFrame frame = new JFrame("Teacher Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setOpaque(true);
        frame.setContentPane(table);
        frame.pack();
        frame.setVisible(true);
    }
}
