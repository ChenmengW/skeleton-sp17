package db;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    String name;
    List<Column> columns = new ArrayList<Column>();
    HashMap <String, List> chm = new HashMap<String, List>();
    List<Row> rows = new ArrayList<Row>();

    private HashMap<String, List> makeHashMap (){
        HashMap <String, List> chm = new HashMap<String, List>();
        for(Column column : columns){
            chm.put(column.name, column.elements);
        }
        return chm;
    }

    List<Row> makeRows(){
        List<Row> result = new ArrayList<Row>();
        int i = columns.get(0).length;
        for (int j = 0; j < i +1 ; j ++){
            Row newRow = new Row();
            if (j == 0){
                for (Column c : columns) {
                    newRow.add(c.name + " " + c.type );
                }
            }
            else {
                for (Column c : columns) {
                    newRow.add("'" + c.get(j - 1) + "'" + ",");
                }
            }
            j += 1;
            result.add(newRow);
        }
        return result;
    }

    public Table (String name, List<Column> columns){
        this.name = name;
        this.columns = columns;
        this.chm = makeHashMap();
        this.rows = makeRows();
    }

    public void insertIntoTable (Table table, Column column) {

        InsertIntoTable.conduct(table, column);
    }

    public void printTable () {
        /*write the table*/
        PrintTable.conduct(this);
    }

    public void selectTable (String name) {
        /*write the table*/
        SelectTable.conduct(name);
    }

    public boolean equals (Object o){
        if (o instanceof Table){
            Table t = (Table) o;
            return this.name == t.name & this.chm.equals(t.chm);
        }
        else {return false;}
    }

    public String toString(){
        String result = "";
        for (Row row:rows){
            result = result  + row.toString() + "\n";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
