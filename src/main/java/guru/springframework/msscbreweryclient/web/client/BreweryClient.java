package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

  public final String BEER_PATH_V1 = "/api/v1/beer/";
  private String apihost;

  private final RestTemplate restTemplate;

  @Autowired
  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public void setApihost(String apihost) {
    this.apihost = apihost;
  }

  public BeerDto getBeerById(UUID uuid) {
    return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
  }
}
