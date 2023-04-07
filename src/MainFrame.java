import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.awt.Color;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
//import org.apache.commons.compress.*;
import java.util.zip.*;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import java.io.File;
import org.rauschig.jarchivelib.*;

//import org.apache.commons.io.FilenameUtils;

// import net.lingala.zip4j.io.outputstream.ZipOutputStream;
// import net.lingala.zip4j.model.ZipParameters;
// import net.lingala.zip4j.model.enums.AesKeyStrength;
// import net.lingala.zip4j.model.enums.CompressionMethod;
// import net.lingala.zip4j.model.enums.EncryptionMethod;


public class MainFrame extends JFrame{

   public void unzipstuff(String filenames) throws ZipException{
    try{
    ZipFile zipname = new ZipFile(filenames);
    String filenamewithoutextension = filenames.replaceFirst("[.][^.]+$", "");
    File destination = new File(filenamewithoutextension);
    if (!destination.exists()){
        destination.mkdir();
    }
    zipname.extractAll(filenamewithoutextension);
    System.out.println("Finished");
       }
    catch (ZipException e){
        e.printStackTrace();
    }
   }
    
   
   public void untarstuff(String filenames) throws IOException{
    File archive = new File(filenames);
    String filenamewithoutextension = filenames.replaceFirst("[.][^.]+$", "");
    File destination = new File(filenamewithoutextension);
    if (!destination.exists()){
        destination.mkdir();
    }
    Archiver archiver = ArchiverFactory.createArchiver("tar", "gz");
    archiver.extract(archive, destination);

   }







    public void init(){
        //JTextField field = new JTextField();
        JPanel p = new JPanel();
        JButton b = new JButton("Choose File to \n unzip or untar");
        JLabel topLabel = new JLabel("This is used to unzip any zipped or tarred file", SwingConstants.CENTER);
        JLabel errorLabel = new JLabel("Please select zipped or gz folder", SwingConstants.CENTER);
        b.setBounds(175,100,240,30);
        b.setForeground(Color.RED);
        b.setBackground(Color.WHITE);
        b.setOpaque(true);
        b.setBorderPainted(false);
        //b.setContentAreaFilled(false);
        
        setBackground(Color.GREEN);
        setTitle("Welcome");
        setSize(500, 400);



        b.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            JFileChooser j = new JFileChooser();
            j.showSaveDialog(null);
            String filename = j.getSelectedFile().getAbsolutePath();
            //Check if filename ends with tar.gz or zip
            if (filename.endsWith(".zip")){
            try{unzipstuff(filename);}
            catch (ZipException z){
                z.printStackTrace();
            }
            }
            else if (filename.endsWith(".tar.gz")){
                try {
                    untarstuff(filename);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }                
            }
            else{
                errorLabel.setBounds(50,300, 290,30);
                add(errorLabel); 

            }

          }
        });
        p.setBackground(Color.GREEN);
        topLabel.setBounds(50,10, 290,30);  
        //field.setText("This is a text");

        add(topLabel);
        add(b);
        add(p);        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
}
