package db;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    HashMap<String,Table> tables = new HashMap<String,Table>();
    Parse parse = new Parse(this);

    public Database() {
        // YOUR CODE HERE
    }

    public String transact(String query) {
        return parse.eval(query);
    }

    public void createTable (String name, List columns){
        Table newTable = CreateTable.conduct(name, columns);
        tables.put(newTable.name, newTable);
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

    public Table getTable (String name){
        return tables.get(name);
    }
}


