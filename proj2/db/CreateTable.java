package db;
import java.util.List;
import java.util.ArrayList;
public class CreateTable implements Command{

    public static Table conduct(String name, List columns){

        Table newTable = new Table(name, columns);

        return newTable;
    };
}
