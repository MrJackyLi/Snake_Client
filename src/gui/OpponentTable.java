package gui;

import sdk.ServerConnection;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Jacky on 29/11/15.
 */
public class OpponentTable extends JTable {

    private ServerConnection sc;

    public OpponentTable() {
        sc = new ServerConnection();
    }

    public int getColumnCount() {
        return 5;
    }

    public int getRowCount() {
        return sc.getUsers().size();
    }
/*
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0:
                return "users";
        }
        return null;
    }*/
/*
    public Objects getValueAt() {
        sc.getUsers().get(rowIndex);
        switch (coloumnIndex) {
            case 0:
                return sc.getUsers().get("users/");
        }
        return getValueAt(rowIndex, coloumnIndex);*//*
    }*/
}

