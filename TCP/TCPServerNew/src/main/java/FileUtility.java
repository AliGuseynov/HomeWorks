import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtility {
    public static void writebyte(String fileName, byte[] data) throws Exception {

//        File file = new File(fileName);
        FileOutputStream fop = new FileOutputStream(fileName);

//        byte[] contentInBytes = content.getBytes();
        fop.write(data);
        fop.flush();
        fop.close();

    }
    public static byte[]readbytes(String fileName)  {
        File file =new File(fileName);
        try(FileInputStream fis=new FileInputStream(file);){
            byte[] byteArray = new byte[(int)file.length()];

            fis.read(byteArray);
            return byteArray;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }finally{
            System.out.println("method isini xeta bas versede vermesede bitirdi");
        }
    }
}
