import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherTableSwing extends JPanel {
 
  private boolean DEBUG = false;
  
  public TeacherTableSwing() {
        super(new GridLayout(1,0));
 
        String[] columnNames = {"Teacher",
                                "Period Off"};
        Object[][] data = {}; 
  
  
  final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(900, 600));
        table.setFillsViewportHeight(true);
  
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
  }
   private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
        for (int i=0; i < numRows; i++) {
            System.out.print( i);
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
        }
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
