package db;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Row {
    LinkedHashMap<String,String> elements = new LinkedHashMap<String,String>();

    public void add (String columnName, String element){
        elements.put(columnName,element);
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
}
