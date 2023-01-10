package az.code.FactoryDesignPattern;

public class Main {
    public static void main(String[] args) {

        String file = FileExporterFactory.getInstance(FileType.EXCEL).export("blah.xlsx");

        System.out.println(file);
    }
}
