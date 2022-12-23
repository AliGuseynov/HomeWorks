package File;

import java.io.*;
import java.time.LocalDate;

public class NewFile {
    public static void main(String[] args) throws Exception {
        File file=new File("C:\\Users\\user\\Documents\\FileCode\\file.txt");
        LocalDate date=LocalDate.now();
        InputFIle in=new InputFIle(123224,"Samir","Ahmadov",date,"10AB432");
        writeIntoFile(in,file);

        InputFIle ff=readFromFile(file);
        System.out.println(ff);
    }

    public static void writeIntoFile(InputFIle object,File file) throws Exception {

        FileOutputStream fs=new FileOutputStream(file);
        ObjectOutputStream os=new ObjectOutputStream(fs);
        os.writeObject(object);
        os.flush();
    }

    public static InputFIle readFromFile(File file) throws Exception{
        InputFIle f=null;
        FileInputStream fi=new FileInputStream(file);
        ObjectInputStream os=new ObjectInputStream(fi);
        f=(InputFIle) os.readObject();
        return f;
    }
}