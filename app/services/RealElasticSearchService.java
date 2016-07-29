package services;


import com.fasterxml.jackson.databind.JsonNode;
import play.Play;
import play.libs.F.Promise;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Result;

import javax.inject.Inject;

import static play.mvc.Results.ok;


public class ElasticSearchService implements SearchService {

  private String esUrl = Play.application().configuration().getString("elasticSearch.url");
  private String esIndex = Play.application().configuration().getString("elasticSearch.index");
  private String esType = Play.application().configuration().getString("elasticSearch.type");

  private WSClient ws;

  @Inject
  public RealElasticSearchService(WSClient ws) {
    this.ws = ws;
   }

  public Promise<Result> save(JsonNode json){
    Promise<WSResponse> jsonPromise = getWsRequest().post(json);
    return jsonPromise.map(jsonResult -> { return ok(jsonResult.asJson());});
  };

  public Promise<Result> list() {
    Promise<WSResponse> jsonPromise = getWsRequest("_search").get();
    return jsonPromise.map(jsonResult -> { return ok(jsonResult.asJson());});
  }

  private WSRequest getWsRequest(){
    return this.getWsRequest("");
  }

  private WSRequest getWsRequest(String command) {
    return this.ws.url(this.esUrl+ "/" + this.esIndex +"/" + this.esType +"/" + command).setHeader("Content-Type", "application/json");
  }

}
