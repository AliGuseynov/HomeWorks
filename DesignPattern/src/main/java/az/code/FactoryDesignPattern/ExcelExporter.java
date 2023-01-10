package az.code.FactoryDesignPattern;

public class ExcelExporter implements FileExporter {
    @Override
    public String export(String file) {
        return "Excel " + file;
    }
}
