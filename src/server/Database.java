package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    Database() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:userData.db");
            System.out.println("Database Opened...\n");
            stmt = c.createStatement();
            String sql = """
                    CREATE TABLE IF NOT EXISTS userinfo (
                    	username text,
                    	password text
                    );""";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Database Created Successfully.");
    }
}
