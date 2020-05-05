import static spark.Spark.*;
import java.util.HashMap;
import spark.ModelAndView;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;

import spark.template.handlebars.HandlebarsTemplateEngine;


public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
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

        get("/animal/list/", (request, response) -> {
            Map<String,Object>model = new HashMap<>();
                    List<Animal>animalList = Animal.all();
                    model.put("animalList",animalList);
                    return new ModelAndView(model, "animal-list.hbs");
                }, new HandlebarsTemplateEngine());
        //posting new animals
        post("/animal/list/", (request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String Name = request.queryParams("name");
//            String location = request.queryParams("location");
//            String rangername = request.queryParams("rangername");
            Animal animal = new Animal(Name);
            animal.save();
            response.redirect("/animal/list/");
            return null;
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
