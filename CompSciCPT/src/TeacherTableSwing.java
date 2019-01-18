import javax.swing.*;
import java.awt.*;

public class TeacherTableSwing extends JPanel {
  
  public TeacherTableSwing() { // Constructor
        super(new GridLayout(1,0));
        String[] columnNames = {"Teacher Name","Period 1", "Period 2", "Period 3", "Period 4"
        };
         
        Object[][] data = {}; 
  
  
  final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(900, 600));
        table.setFillsViewportHeight(true);
  
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
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
      public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showTable();
   }
        });
    }
}
