package db;
import java.util.ArrayList;
import java.util.List;



public class Column {
    String name;
    String type;
    List<String> elements = new ArrayList<String>();

    public Column(String name, String type){
        this.name = name;
        this.type = type;
    }
}
