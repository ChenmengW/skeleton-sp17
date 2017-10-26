package db;
import java.util.List;
import java.util.ArrayList;
public class Database {
    Table[] tables;

    public Database() {
        // YOUR CODE HERE
    }

    public String transact(String query) {
        return Parse.eval(query);
    }

    public void createTable (String name, List columns){
        CreateTable.conduct(name, columns);
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


