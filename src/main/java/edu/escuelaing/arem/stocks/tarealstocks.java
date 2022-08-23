package edu.escuelaing.arem.stocks;
import static spark.Spark.*;

public class tarealstocks {
    public static void main(String[] args) {
    port(getPort());
    staticFiles.location("/public");
    get("/hello", (req, res) ->  {
        String name = req.queryParams("name");
        return "helloheroku" + name;
    });
    get("/intraday",(req, res) -> {
        res.type("application/json");
        return HTTPconnection.getAPIAdvantage();
    });
}

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
