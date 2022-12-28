package Task5;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/*
1 try ichinde bir neche ferqli checked exception atan methodlari chagirin(custom ve IO ) ve ardicilliq ile catch edin
logger qoshub, hem file-a hem de console-a log edin
 */
public class task5 {
    private static Logger logger1 = LogManager.getLogger(task5.class);
//    static Logger logger2 = LogManager.getLogger(task5.class.);
     
    public static void main(String[] args) {
//        FileHandler fh;
       try{
           test("Session");
//           fh = new FileHandler("C:/temp/test/MyLogFile.log");
//           logger2.addHandler(fh);
//           SimpleFormatter formatter = new SimpleFormatter();
//           fh.setFormatter(formatter);
//           logger2.info("My first log");
       }catch (IOException ex){
           logger1.warn("File not found");
       }catch (CustomCheckedException e){
           logger1.info("info");
           System.out.println(e.getCode());
       }
    }
    public static void test(String name) throws CustomCheckedException, IOException {
      // test for ioexception  BufferedReader rd=new BufferedReader(new FileReader("html.txt"));
        BufferedReader rd=new BufferedReader(new FileReader("C:\\Users\\user\\Documents\\nihadosi.txt"));
        List<String> list= rd.lines().toList();
        for (String s:list){
            System.out.println(s);
        }
        if (list.toString().contains(name)){
            throw new CustomCheckedException("Unwanted line",list.toString().indexOf(name));
        }

    }


}
