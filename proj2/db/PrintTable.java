package db;
import java.util.List;
import java.util.ArrayList;
public class PrintTable implements Command{

    public static String conduct(Table t){
        String result = t.toString();
        return result;
    };
}
