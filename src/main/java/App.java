import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/", (request, response) ->
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<title>Wildlife tracking app</title>" +
                        "<link rel='stylesheet' + href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
                        "</head>" +
                        " <div class=\"row\">"+
                        "<div class=\"col-md-5\">"+
                        "<a href=\"/animal/\"><button>Add animal</button></a>" +
                        "</div>"+
                        "<div class=\"col-md-5\">"+
                        "<a href=\"/endangered/\"><button>Add endangered animal</button></a>" +
                        "</div>"+
                        "</div>"+
                        "</body>" +
                        "</html>"
    );
        get("/animal/", (request, response) ->
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<title>Animals entry</title>" +
                        "<link rel='stylesheet' + href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
                        "</head>" +
                        "<body>" +
                        "<h1>ANIMALS ENTRY FORM</h1>" +
                        "<form action=\"/animal/list/\" method=\"post\">"+

                        "<div class=\"form-group\">" +
                        "<input type=\"text\" id=\"name\" placeholder=\"Name of Animal spotted\" >" +
                        "</div>" +
                        "<div class=\"form-group\">" +
                        "<label for=location>Location where animal was spotted</label>" +
                        "<select name=location>"+
                        "<option>Make a selection</option>"+
                        "<option>NE Quadrant</option>"+
                        "<option>SE Quadrant</option>"+
                        "<option>SW Quadrant</option>" +
                        "<option>NW Quadrant</option>" +
                        "</select>" +
                        "</div>" +

                        "<div class=\"form-group\">" +
                        "<input type=\"text\" id=\"rangername\" placeholder=\"Name of the ranger in charge of the sighting\" >" +
                        "</div>" +

                        "<button type=\"submit\" class=\"btn btn-success\">Add Animal</button>" +

                        "</form>" +
                        "</body>" +
                        "</html>"

        );
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

        get("/endangered/", (request, response) ->
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<title>Endangered animals entry</title>" +
                        "<link rel='stylesheet' + href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
                        "</head>" +
                        "<body>" +
                        "<h1>ENDANGERED ANIMALS ENTRY FORM</h1>" +
                        "<form action=\"/endangered/list\" method=\"post\">"+

                        "<div class=\"form-group\">" +
                        "<input type=\"text\" id=\"name\" placeholder=\"Name of Animal spotted\" >" +
                        "</div>" +

                        "<div class=\"form-group\">" +
                        "<label for=health>What is the animal's state of health</label>" +
                        "<select name=health>"+
                        "<option>Make a selection</option>"+
                        "<option>Ill</option>"+
                        "<option>Okay</option>"+
                        "<option> Healthy</option>" +
                        "</select>" +
                        "</div>" +

                        "<div class=\"form-group\">" +
                        "<label for=age>How old is the animal?</label>" +
                        "<select name=age>"+
                        "<option>Make a selection</option>"+
                        "<option>Newborn</option>"+
                        "<option>Young</option>"+
                        "<option>Adult</option>" +
                        "</select>" +
                        "</div>" +

                        "<div class=\"form-group\">" +
                        "<label for=location>Location where animal was spotted</label>" +
                        "<select name=location>"+
                        "<option>Make a selection</option>"+
                        "<option>NE Quadrant</option>"+
                        "<option>SE Quadrant</option>"+
                        "<option>SW Quadrant</option>" +
                        "<option>NW Quadrant</option>" +
                        "</select>" +
                        "</div>" +

                        "<div class=\"form-group\">" +
                        "<input type=\"text\" id=\"rangername\" placeholder=\"Name of the ranger in charge of the sighting\" >" +
                        "</div>" +

                        "<button type=\"submit\" class=\"btn btn-success\">Add Animal</button>" +

                        "</form>" +
                        "</body>" +
                        "</html>"
        );
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
