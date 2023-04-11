import java.io.IOException;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import java.io.File;
import org.rauschig.jarchivelib.*;


public class Zip_and_tar {

    public static void unzipstuff(String filenames) throws ZipException{
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




       public static void untarstuff(String filenames) throws IOException{
        File archive = new File(filenames);
        String filenamewithoutextension = filenames.replaceFirst("[.][^.]+$", "");
        File destination = new File(filenamewithoutextension);
        if (!destination.exists()){
            destination.mkdir();
        }
        Archiver archiver = ArchiverFactory.createArchiver("tar", "gz");
        archiver.extract(archive, destination);
    
       }





    
}
