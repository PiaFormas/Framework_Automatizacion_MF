package test.stepsDefinitions;

import io.cucumber.java.en.Given;
import test.constants.Navegador;
import test.driverConfig.DriverContext;
import test.pages.SauceDemoPage;
import test.util.MetodosGenericos;

import static org.junit.Assert.assertEquals;
import static test.constants.Constant.URL_SAUCE;

public class BackgroundSauceCarrito {
    SauceDemoPage SauceDemo = new SauceDemoPage();

    @Given("Ingresar a SauceDemo")
    public void ingresar_a_sauce_demo() {
        DriverContext.setUp(Navegador.Chrome, URL_SAUCE);
        MetodosGenericos.esperar(2);
        String url = DriverContext.getDriver().getCurrentUrl();
        assertEquals(URL_SAUCE, url);



    }
}