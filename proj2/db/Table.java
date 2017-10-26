package db;

import java.util.List;
import java.util.ArrayList;

public class Table {
    private String name;
    private List <Column> columns = new ArrayList<Column>();


    public Table (String name, List columns){
        this.name = name;
        this.columns = columns;
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
