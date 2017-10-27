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

}
