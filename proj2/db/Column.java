package db;
import java.util.ArrayList;
import java.util.List;



public class Column {
    String name;
    String type;
    int length;
    List<String> elements = new ArrayList<String>();

    public Column(String name, String type){
        this.name = name;
        this.type = type;
        this.length = 0;
    }

    public String toString(){
        String result = name + " " + type;
        for (String e:elements){
            result = "\n" + e;
        }
        return result;
    }

    public void add(String s){
        length += 1;
        elements.add(s);
    }

    public String get(int i){
        return elements.get(i - 1);
    }
}
