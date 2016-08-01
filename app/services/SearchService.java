package services;


import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;
import play.libs.F.Promise;
import play.mvc.Result;


@ImplementedBy(RealElasticSearchService.class)
public interface SearchService {

  public Promise<Result> save(JsonNode json);

  public Promise<Result> list();

}
