package Main;

import java.sql.Statement;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by adamfranzen on 11/9/16.
 */
public class PomoService {
    public List<Tasks> getAllTasks() {
        Map<String, Tasks> tasks1 = new HashMap<String, Tasks>();

        try {
            Connection dbConnect = Db.Db();
            Statement stmt = dbConnect.createStatement();
            ResultSet rs = stmt.executeQuery(" SELECT * FROM tasks");
            while (rs.next()) {

                Integer id = rs.getInt("id");
                String stringedId = Integer.toString(id);
                String name = rs.getString("name");
                Integer pomodoros = rs.getInt("pomodoros");
                String stringedPomodoros = Integer.toString(pomodoros);
                Boolean complete = rs.getBoolean("complete");
                String status = rs.getString("status");

                Tasks task1 = new Tasks(stringedId, name, stringedPomodoros, complete, status);
                tasks1.put(stringedId, task1);
            }
            stmt.close();
            dbConnect.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
//            return "Connection Failed";
            e.printStackTrace();
        }
        return new ArrayList<Tasks>(tasks1.values());
    }

    public Tasks createTask(String name, Integer pomodoros, Boolean complete, String status) {
        Integer id = 0;
        String stringedId = "0";
        String stringedPomodoros = "";

        try {
            Connection conn = Db.Db();
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO tasks (name, pomodoros, complete, status)" + " VALUES ('" + name + "', " + Integer.toString(pomodoros) + ", " + Boolean.toString(complete)+ ", '" + status + "') RETURNING *;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                id = rs.getInt("id");
                stringedId = Integer.toString(id);
                name = rs.getString("name");
                pomodoros = rs.getInt("pomodoros");
                stringedPomodoros = Integer.toString(pomodoros);
                complete = rs.getBoolean("complete");
                status = rs.getString("status");
            }

            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return new Tasks(stringedId, name, stringedPomodoros, complete, status);

    }
}
