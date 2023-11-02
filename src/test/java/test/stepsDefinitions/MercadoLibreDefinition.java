package test.stepsDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import test.util.Servicio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class MercadoLibreDefinition {

    @Given("Ingresar a Mercado Libre")
    public void ingresarAMercadoLibre() throws URISyntaxException, IOException, InterruptedException {
        String respuestaServicio = Servicio.doRequestAndGetResponse("http://www.mercadolibre.com.ar/menu/departments", "GET", HttpRequest.BodyPublishers.noBody());

    }

    @Then("verifico que existan departamentos")
    public void verificoQueExistanDepartamentos() {

       /* String respuestaServicio = Servicio.doRequestAndGetResponse("http://www.mercadolibre.com.ar/menu/departments", "GET", HttpRequest.BodyPublishers.noBody());
        JsonParser parser = new JsonParser();
        JsonElement respuestaElement = parser.parse(respuestaServicio);
        JsonArray departments = respuestaElement.getAsJsonArray();
        for (int i = 0; i < departments.size(); i++) {
            JsonObject department = departments.get(i).getAsJsonObject();
            Assert.assertTrue("No se encontró elemento", department.get("Celulares y Smartphones").getAsBoolean());*/
            }
        }





