package db;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class MyTest {

    @Test
    public void testCreateTable(){
        Column column1 = new Column("name1","type1");
        Column column2 = new Column("name2","type2");
        List<Column> columnList = new ArrayList<Column>();
        columnList.add(column1);
        columnList.add(column2);
        Table actualTable = CreateTable.conduct("Table",columnList);
        Table expectedTable = new Table ("Table", columnList);
        assertEquals(actualTable,expectedTable);
    }

    @Test
    public void testPrintTable(){
        Column column1 = new Column("name1","type1");
        Column column2 = new Column("name2","type2");
        List<Column> columnList = new ArrayList<Column>();
        columnList.add(column1);
        columnList.add(column2);
        Table actualTable = CreateTable.conduct("Table",columnList);
        String expectedString = "name1 type1,name2 type2";
        assertEquals(expectedString,PrintTable.conduct(actualTable));
    }

    @Test
    public void testInsertIntoTable(){
        Column column1 = new Column("name1","type1");
        Column column2 = new Column("name2","type2");
        Column column3 = new Column("name3","type3");
        List<Column> columnList = new ArrayList<Column>();
        columnList.add(column1);
        columnList.add(column2);
        Table actualTable = CreateTable.conduct("Table",columnList);
        actualTable.insertIntoTable(actualTable,column3);
        columnList.add(column3);
        Table expected = CreateTable.conduct("Table",columnList);
        assertEquals(expected,actualTable);
    }

}
