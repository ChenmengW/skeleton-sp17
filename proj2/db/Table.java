package db;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    String name;
    List<Column> columns = new ArrayList<Column>();
    HashMap <String, Column> chm = new HashMap<String, Column>();
    List<Row> rows = new ArrayList<Row>();

    private HashMap<String, Column> makeHashMap (){
        HashMap <String, Column> chm = new HashMap<String, Column>();
        for(Column column : columns){
            chm.put(column.name, column);
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
                    newRow.add(c.name + " " + c.type,c.name + " " + c.type );
                }
            }
            else {
                for (Column c : columns) {
                    newRow.add(c.name + " " + c.type,"'" + c.get(j - 1) + "'" + ",");
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

    public Table replicate(){
        Table result = new Table(name, columns);
        return result;
    }

    Column getColumn(String columnName){
        return chm.get(columnName);
    }

    Row findRow(Column column, String rowElement){
        String rowName = column.elements.get(rowElement);
        return
    }

}
