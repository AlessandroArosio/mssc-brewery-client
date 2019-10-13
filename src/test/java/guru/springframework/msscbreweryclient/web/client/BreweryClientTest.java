package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * All the tests in this class will require the mssc-brewery application up and running.
 */
@SpringBootTest
class BreweryClientTest {

  @Autowired
  BreweryClient breweryClient;

  @Test
  void getBeerById() {

    BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());

    assertNotNull(dto);
  }

  @Test
  public void saveNewBeer() {
    // given
    BeerDto beerDto = BeerDto.builder().beerName("New beer").build();

    URI uri = breweryClient.saveNewBeer(beerDto);

    assertNotNull(uri);

    System.out.println(uri.toString());
  }

  @Test
  public void updateBeer() {
    // given
    BeerDto beerDto = BeerDto.builder().beerName("New beer").build();

    breweryClient.updateBeer(UUID.randomUUID(), beerDto);
  }

  @Test
  public void testDeleteBeer() {
    breweryClient.deleteBeer(UUID.randomUUID());
  }


  @Test
  void getCustomerById() {

    CustomerDto dto = breweryClient.getCustomerById(UUID.randomUUID());

    assertNotNull(dto);
  }

  @Test
  public void saveNewCustomer() {
    // given
    CustomerDto customerDto = CustomerDto.builder().name("Alessandro").build();

    URI uri = breweryClient.saveNewCustomer(customerDto);

    assertNotNull(uri);

    System.out.println(uri.toString());
  }

  @Test
  public void updateCustomer() {
    // given
    CustomerDto customerDto =  CustomerDto.builder().name("Alessandro").build();

    breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
  }

  @Test
  public void testDeleteCustomer() {
    breweryClient.deleteCustomer(UUID.randomUUID());
  }
}