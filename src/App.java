import java.io.File;

import javax.swing.BorderFactory;

import org.apache.pdfbox.pdmodel.PDDocument;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.awt.Color;


import net.lingala.zip4j.exception.ZipException;

public class App {
    public static void main(String[] args) throws Exception, ZipException {
        //System.out.println("Hello, World!");
        MainFrame myFrame = new MainFrame();
        //myFrame.getContentPane().setBackground( Color.red );
        myFrame.init();
    }
}
