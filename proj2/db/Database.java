package db;

public class Database {
    Table[] tables;

    public Database() {
        // YOUR CODE HERE
    }

    public String transact(String query) {
        return "YOUR CODE HERE";
    }

    public void createTable (String name, Row[] rows){
        CreateTable.conduct(name, rows);
        /*Table newTable = new Table (name, rows);
        add to the list*/
    }

    public void loadTable (String name){
        LoadTable.conduct(name);
        /*read the file
        Table newTable = new Table (name, rows);*/

    }

    public void storeTable (String name){
        /*write the table*/
        StoreTable.conduct(name);
    }

    public void dropTable (String name){
        /*write the table*/
        dropTable.conduct(name);
    }
}


