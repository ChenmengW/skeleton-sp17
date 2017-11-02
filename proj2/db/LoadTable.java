package db;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class LoadTable implements Command{

    public static String conduct(Database db, String fileName){
        Table table = loadTableFromFile(fileName);
        db.tables.put(table.name,table);
        return "";
    }

    private static Table loadTableFromFile(String fileName){
        try {List<String> lines = Files.readAllLines(Paths.get(fileName));
        } catch (Exception e){
            System.out.println("Reading file error");
        }

    };

    private static Row makeRowFromString(){

    }
}
