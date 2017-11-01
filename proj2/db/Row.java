package db;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Row {
    List<String> elementsList = new ArrayList<String>();
    LinkedHashMap<String,String> elements = new LinkedHashMap<String,String>();
    int length;

    public void add (String columnName, String element){
        elementsList.add(element);
        elements.put(columnName,element);
        length += 1;
    }

    public String toString(){
        String result = "";
        for (Map.Entry<String,String> entry:elements.entrySet()){
            result = result + entry.getKey() + ",";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    public String findElement(String columnName){
        return elements.get(columnName);
    }

    void append(Row row){
        for (Map.Entry<String,String> entry:row.elements.entrySet()){
            String columnName = entry.getKey();
            String element = entry.getValue();
            elements.put(columnName,element);
            length += 1;
        }
    }

    public String getByIndex(int i){
        return elementsList.get(i - 1);
    }
}
