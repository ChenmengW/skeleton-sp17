package db;

import java.util.*;

public class Table {
    private String name;

    List <String> columns = new ArrayList();
    private List <String> rows = new ArrayList();

    /* Row first */
    LinkedHashMap<String,LinkedHashMap<String,String>> data = new LinkedHashMap();

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
        String firstRowData = rowData.get(0);
        for (int i = 0; i < getColumnNumber(); i ++) {
            LinkedHashMap<String, String> tempElement = new LinkedHashMap();
            tempElement.put(getColumnName(i), rowData.get(i));
            data.put(firstRowData, tempElement);
        }
        return "";
    }

    public String printTable () {
        for (Map.Entry<String,LinkedHashMap<String, String>> entry: data.entrySet()){
            String row ="";
            for (Map.Entry<String,String> entry2: entry.getValue().entrySet()) {
                row +=  entry.getKey() + ",";
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
