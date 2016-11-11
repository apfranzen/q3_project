package Main;

    import Main.Db;
    import java.sql.Connection;
    import java.util.*;
    import java.sql.Statement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    import static Main.JsonUtil.json;
    import static spark.Spark.*;

/**
 * Created by adamfranzen on 11/8/16.
 */

public class PomoController {
    public PomoController(PomoService pomoService) {

        get("/hello", (req, res) -> {
            return "Hello World";
        });

        get("/tasks", (req, res) ->  pomoService.getAllTasks(), json());

        post("/tasks", (req, res) -> pomoService.createTask(
                req.queryParams("name"),
                Integer.parseInt(req.queryParams("pomodoros")),
                Boolean.valueOf(req.queryParams("complete")),
                req.queryParams("status")
        ), json());

        get("/test", (req, res) -> "Test");
    }
}
