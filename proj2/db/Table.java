package db;

import java.util.*;

public class Table {
    private String name;
    private int nextRowIndex = 0;

    List <String> columns = new ArrayList();
    private List <String> rows = new ArrayList();

    /* Row first */
    LinkedHashMap<Integer,LinkedHashMap<String,String>> data = new LinkedHashMap();

    HashMap<String,String> columnType = new HashMap();


    public Table (String name, List columns){
        this.name = name;
        this.columns = columns;
    }

    public Table (String name, List columns, HashMap<String,String> columnType){
        this.name = name;
        this.columns = columns;
        this.columnType = columnType;

    }

    public String insertIntoTable (List<String> rowData) {
        for (int i = 0; i < getColumnNumber(); i ++) {
            if (i == 0){
            LinkedHashMap<String, String> tempElement = new LinkedHashMap();
            tempElement.put(getColumnName(i), rowData.get(i));
            data.put(nextRowIndex, tempElement);}
            else {
                data.get(nextRowIndex).put(getColumnName(i), rowData.get(i));
            }
        }
        nextRowIndex += 1;
        return "";
    }

    public String printTable () {
        for (Map.Entry<Integer,LinkedHashMap<String, String>> entry: data.entrySet()){
            String row ="";
            for (Map.Entry<String,String> entry2: entry.getValue().entrySet()) {
                row =row +  entry2.getValue() + ",";
            }
            row = row.substring(0,row.length() - 1);
            System.out.println(row);
        }
        return "";
    }


    private Table join(Table table){
        Join j = new Join(this,table);
        return j.conduct();
    }

    public void selectTable (String name) {
        /*write the table*/
        SelectTable.conduct(name);
    }

    private String getColumnName(int i){
        return columns.get(i);
    }

    private int getColumnNumber(){
        return columns.size();
    }

    /*
    private void makeColumnsList(){
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String,?> entry: data.entrySet()){
            result.add(entry.getKey());
        }
        columns = result;
    }
    */


}
