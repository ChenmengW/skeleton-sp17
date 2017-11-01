package db;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Column {
    String name;
    String type;
    int length;
    LinkedHashMap<String,Row> elements = new LinkedHashMap<String,Row>();

    public Column(String name, String type){
        this.name = name;
        this.type = type;
        this.length = 0;
    }

    public String toString(){
        String result = name + " " + type;
        for (Map.Entry<String,String> entry:elements.entrySet()){
            result = "\n" + entry.getKey();
        }
        return result;
    }

    public void add(String element, Row row){
        length += 1;
        elements.put(element,row);
    }

    public String get(int i){
        return elements.get(i - 1);
    }
}
