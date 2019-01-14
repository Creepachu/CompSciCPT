import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class TeacherSwing extends JFrame implements ActionListener
{
  JButton bChange = new JButton("Click for absences");
  JPanel     Panel1  = new JPanel();
   
   
  JPanel     dataPanel = new JPanel();
   
   
  JPanel     MTWPanel  = new JPanel();
  JPanel     RFSPanel  = new JPanel();
  JPanel     SunPanel  = new JPanel();
  JPanel     butPanel  = new JPanel();
  
   public TeacherSwing()  
  { 
    setTitle( "Teacher Absences" );
   
    Panel1.add( lData1 );
    Panel2.add( lData2 ); 
    Panel3.add( lData3 ); 
    Panel4.add( lData4 ); Panel1.add( bchange );
  
    MTWPanel.add( Panel1 );  
    MTWPanel.add( Panel2 ); 
    MTWPanel.add( Panel3 );
    RFSPanel.add( Panel4 );  
    
     
    dataPanel.setLayout( new BoxLayout( dataPanel, BoxLayout.Y_AXIS ) ); 
    dataPanel.add( MTWPanel );
    dataPanel.add( RFSPanel );
    dataPanel.add( SunPanel );
 
    setLayout( new FlowLayout()  ); 
    add( dataPanel );
    add( butPanel );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
   
  }
    
  public void actionPerformed( ActionEvent evt) 
  {
    repaint();                 
  }
  class MyTeacher implement TeacherSwing {
   
   public void bchange()  { 
      System.out.println("Hi"); 
   }
  }
    
  public static void main ( String[] args )
  {
    TeacherSwing mnn  = new TeacherSwing() ;
       
    mnn.setSize(1650 , 1080 );    
    mnn.setResizable( false );
    mnn.setVisible( true );        
  }
  
   
}
