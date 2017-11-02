package db;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Row {
    List<String> elementsList = new ArrayList<String>();
    LinkedHashMap<String,Column> elements = new LinkedHashMap<String,Column>();
    LinkedHashMap<Column,String> columnToElement = new LinkedHashMap<Column,String>();
    int length;

    public void add (Column column, String element){
        elementsList.add(element);
        elements.put(element,column);
        columnToElement.put(column,element);
        /*
        elementsColumn.put(element,column);
        */
        length += 1;
    }

    public String toString(){
        String result = "";
        for (Map.Entry<String,Column> entry:elements.entrySet()){
            result = result + entry.getKey() + ",";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    public String findElement(Column column){

        return columnToElement.get(column);
    }

    void append(Row row){
        for (Map.Entry<String,Column> entry:row.elements.entrySet()){
            String element = entry.getKey();
            Column column = entry.getValue();
            elements.put(element,column);
            columnToElement.put(column,element);
            length += 1;
        }
    }

    public String getByIndex(int i){

        return elementsList.get(i - 1);
    }
}
