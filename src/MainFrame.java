import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import net.lingala.zip4j.exception.ZipException;

public class MainFrame extends JFrame{



    public void init(){
        //JTextField field = new JTextField();
        setLayout(new BorderLayout(10,5));
        setBackground(Color.GREEN);
        setTitle("ZipAndTar");
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(10, 1, 300, 0));
        //JPanel p = new JPanel(new BorderLayout(5,5));
        
        //p.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        p.setBackground(Color.GREEN);

        
        add(p, BorderLayout.CENTER);
  


        JLabel topLabel = new JLabel("This is used to unzip any zipped or tarred file", SwingConstants.CENTER);
        topLabel.setBounds(50,10, 290,30);  
        p.add(topLabel);
        
        
        
        
        JButton b = new JButton("<html>" +"Choose File to" + "<br>"+ "unzip or untar"+ "</html>");
        //b.setBounds(175,100,50,30);
        b.setForeground(Color.BLUE);
        b.setBackground(Color.GREEN);
        //b.setOpaque(true);
        //b.setBorderPainted(true);
        b.setFocusable(false);
        p.add(b);       
 

        JLabel errorLabel = new JLabel("Please select zipped or gz folder", SwingConstants.CENTER);
        errorLabel.setForeground(Color.RED);
        //b.setContentAreaFilled(false);
        b.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            JFileChooser j = new JFileChooser();
            j.showSaveDialog(null);
            String filename = j.getSelectedFile().getAbsolutePath();
            //Check if filename ends with tar.gz or zip
            if (filename.endsWith(".zip")){
            try{Zip_and_tar.unzipstuff(filename);}
            catch (ZipException z){
                z.printStackTrace();
            }
            }
            else if (filename.endsWith(".tar.gz")){
                try {
                    Zip_and_tar.untarstuff(filename);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }                
            }
            else{
                errorLabel.setBounds(50,300, 290,30);
                p.add(errorLabel); 
                setVisible(true);
            }

          }
        });
     
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
}
