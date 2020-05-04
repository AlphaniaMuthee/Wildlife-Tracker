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
                    Map<String,Object> model = new HashMap<>();
                    return new ModelAndView(model, "index.hbs");
                }, new HandlebarsTemplateEngine());
        // getting new animals
        get("/animal/", (request, response) -> {
                    Map<String,Object> model = new HashMap<>();
                    return new ModelAndView(model, "animals.hbs");
                }, new HandlebarsTemplateEngine());
        //posting new animals
        post("/animal/list/", (request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String Name = request.queryParams("name");
            Animal animal = new Animal(Name);
            request.session().attribute("Animal", animal.getName());
            return new ModelAndView(model, "animal-list.hbs");
        }, new HandlebarsTemplateEngine());

        // getting new endangered animals
        get("/endangered/", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());
        //posting new endangered animals
        post("/endangered/list/", (request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");

            Endangered endangered = new Endangered(name, health, age);
            request.session().attribute("Endangered", endangered.getName());
            request.session().attribute("Endangered", endangered.getHealth());
            request.session().attribute("Endangered", endangered.getAge());
            return new ModelAndView(model, "endangered-list.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
