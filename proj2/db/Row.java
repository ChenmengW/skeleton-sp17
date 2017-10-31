package db;

import java.util.List;
import java.util.ArrayList;

public class Row {
    List<String> elements = new ArrayList<String>();

    public void add (String s){
        elements.add(s);
    }

    public String toString(){
        String result = "";
        for (String e:elements){
            result = result + e + ",";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
