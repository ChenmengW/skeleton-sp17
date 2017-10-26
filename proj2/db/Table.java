package db;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    private String name;
    private HashMap <String, List> chm = new HashMap<String, List>();

    private static HashMap<String, List> makeHashMap (List<Column> columns){
        HashMap <String, List> chm = new HashMap<String, List>();
        for(Column column : columns){
            chm.put(column.name, column.elements);
        }
        return chm;
    }


    public Table (String name, List<Column> columns){
        this.name = name;
        chm = makeHashMap(columns);
    }

    public void insertIntoTable (String name, Column column) {
        /*write the table*/
        InsertIntoTable.conduct(name, column);
    }

    public void printTable () {
        /*write the table*/
        PrintTable.conduct();
    }

    public void selectTable (String name) {
        /*write the table*/
        SelectTable.conduct(name);
    }

}
