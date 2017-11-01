package db;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class Column {
    String name;
    String type;
    int length;
    List<String> elementsList = new ArrayList<String>();
    LinkedHashMap<String,Row> elements = new LinkedHashMap<String,Row>();

    public Column(String name, String type){
        this.name = name;
        this.type = type;
        this.length = 0;
    }

    public String toString(){
        String result = name + " " + type;
        for (Map.Entry<String,Row> entry:elements.entrySet()){
            result = "\n" + entry.getKey();
        }
        return result;
    }

    public void add(String element, Row row){
        length += 1;
        elements.put(element,row);
        elementsList.add(element);
    }

    public String getByIndex(int i){
        return elementsList.get(i - 1);
    }
}
