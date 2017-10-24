package db;

public class Table {
    String name;
    Row[] rows;

    public Table (String name){
        this.name = name;
    }

    public Table (String name, Row[] rows){
        this.name = name;
        this.rows = rows;
    }

    public void insertIntoTable (String name, Row row) {
        /*write the table*/
        InsertIntoTable.conduct(name, row);
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
