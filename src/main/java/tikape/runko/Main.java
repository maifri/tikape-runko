package tikape.runko;

import java.util.HashMap;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import tikape.runko.database.AnnosDao;
import tikape.runko.database.Database;
import tikape.runko.database.RaakaAineDao;
import tikape.runko.domain.RaakaAine;

public class Main {

    public static void main(String[] args) throws Exception {
        Database database = new Database("jdbc:sqlite:arkisto.db");
        database.init();

        RaakaAineDao raakaAineDao = new RaakaAineDao(database);
        AnnosDao annosDao = new AnnosDao(database);

        get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("viesti", "tervehdys");

            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());

        get("/raakaaineet", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("raakaAineet", raakaAineDao.findAll());

            return new ModelAndView(map, "raakaAineet");
        }, new ThymeleafTemplateEngine());
        
        post("/raakaaineet", (req, res) -> {
            RaakaAine raakaAine = new RaakaAine(-1, req.queryParams("Raaka-aineen nimi:"));
            raakaAineDao.save(raakaAine);

            res.redirect("/raakaaineet");
            return "";
        });

        get("/annokset/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("annos", AnnosDao.findOne((req.params("id"))));

            return new ModelAndView(map, "annos");
        }, new ThymeleafTemplateEngine());
        
        
    }
}
