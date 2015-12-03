/*

package gui;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sdk.ServerConnection;
import sdk.User;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Objects;


*/
/**
 * Created by Jacky on 29/11/15.
 *//*


public class OpponentTable extends AbstractTableModel {

    private ServerConnection sc;
    //private ArrayList<User> userData;
    private String[] columns = {"email", "user"};
    private int numberOfRows;

    public OpponentTable() {
        sc = new ServerConnection();
    }


    public int getColumnCount() {
        return columns.length;
    }

    public Class<?> getColumnClass( int columnIndex){
        return super.getColumnClass(columnIndex);
    }

    public int getRowCount() {
        return sc.userData().size();
    }

    public String getColumnName(int columnIndex){
          return columns[columnIndex];
        }

    public Object getValueAt(int rowIndex, int coloumnIndex) {
        userData().get(rowIndex);
        switch (coloumnIndex) {
            case 0:
                return userData().get(rowIndex).getEmail();
            case 1:
                return userData().get(rowIndex).getUsername();
        }
        return null;
    }
}


*/
