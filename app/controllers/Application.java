package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import play.*;
import play.libs.F.RedeemablePromise;
import play.libs.F.Promise;
import play.mvc.*;

import services.ElasticSearchService;
import views.html.*;

public class Application extends Controller {


    private final ElasticSearchService es;

    @Inject
    public Application(ElasticSearchService es) {
        this.es = es;
    }


    public Result index() {
        return ok("No service here.");
    }

    public Promise<Result> addNotification() {


        JsonNode json = request().body().asJson();
        if(json == null) {
            return  Promise.<Result>pure(badRequest("Expecting Json data"));
        } else {
            return es.save(json);
        }
    }

    public Promise<Result> getNotifications() {
        return es.list();
    }

}

