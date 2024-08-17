package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {
    
    public FlightInfo(){
        // Setting the background color and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        // Create a JTable
        JTable table = new JTable();
        
        // Try to fetch the flight data and set the table model
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Add the JTable to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Set JFrame properties
        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new FlightInfo();
    }
}
