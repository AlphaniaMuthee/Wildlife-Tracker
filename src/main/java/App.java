import static spark.Spark.*;
import java.util.HashMap;
import spark.ModelAndView;
import org.sql2o.Sql2o;
import java.util.Map;

import spark.template.handlebars.HandlebarsTemplateEngine;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        // homepage creation
        get("/", (request, response) -> {
                    return new ModelAndView(new HashMap(), "index.hbs");
                }, new HandlebarsTemplateEngine());
        // getting new animals
        get("/animal/", (request, response) -> {
                    return new ModelAndView(new HashMap(), "animals.hbs");
                }, new HandlebarsTemplateEngine());
        //posting new animals
        post("/animal/list/", (request, response) -> {
            return new ModelAndView(new HashMap(), "animal-list.hbs");
        }, new HandlebarsTemplateEngine());

        // getting new endangered animals
        get("/endangered/", (request, response) -> {
            return new ModelAndView(new HashMap(), "endangered.hbs");
        }, new HandlebarsTemplateEngine());
        //posting new endangered animals
        post("/endangered/list/", (request, response) -> {
            return new ModelAndView(new HashMap(), "endangered.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
