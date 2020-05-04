import static spark.Spark.*;
import java.util.HashMap;
import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;


public class App {
    public static void main(String[] args) {
        get("/", (request, response) -> {
                    return new ModelAndView(new HashMap(), "index.hbs");
                }, new HandlebarsTemplateEngine());

        get("/animal/", (request, response) -> {
                    return new ModelAndView(new HashMap(), "animals.hbs");
                }, new HandlebarsTemplateEngine());

        get("/animal/list/", (request, response) ->
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<title>Endangered animals entry</title>" +
                        "<link rel='stylesheet' + href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
                        "</head>" +
                        "<body>" +
                        "<a href=\"/\">Home</a>" +
                        "{{#if animals}}" +
                        "{{#each animals}}" +
                        "<p>Name : {{name}}</p>" +
                        "{{/each}}" +
                        "{{else}}" +
                        "<p>No animals have been added</p>" +
                        "{{/if}}" +
                        "</body>" +
                        "</html>"
        );

        get("/endangered/", (request, response) -> {
            return new ModelAndView(new HashMap(), "endangered.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered/list/", (request, response) ->
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<title>Hello Friend!</title>" +
                        "<link rel='stylesheet' + href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
                        "</head>" +
                        "<body>" +
                        "<h1>ENDANGERED ANIMALS<h1>" +
                        "{{#if animals}}" +
                        "{{#each animals}}</p>" +
                        "<p>Name:{{name}}</p>" +
                        "<p>Health: {{health}}</p>" +
                        "<p>Age: {{age}}</p>" +
                        "{{/each}}" +
                        " {{else}}" +
                        "<p>No endangered animals</p>" +
                        " {{/if}}" +
                        "</body>" +
                        "</html>"
        );

    }
}
