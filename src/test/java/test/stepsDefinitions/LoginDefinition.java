package test.stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.pages.SauceDemoPage;

public class LoginDefinition {
    SauceDemoPage sauceDemoPage = new SauceDemoPage();

    @When("me logueo en Saucedemo introduciendo {string} y {string}")
    public void me_logueo_en_sauce_demo_introduciendo(String usuario, String pass) throws Throwable {
        sauceDemoPage.IngresarUsername(usuario);
        sauceDemoPage.IngresarPassword(pass);
        sauceDemoPage.ClickBtnIngresar();


    }

    @Then("visualizo los productos en venta")
    public void visualizoEnSauceDemo(){
        sauceDemoPage.visualizarProductos();

    }

    @Then("visualizo mensaje de error en login")
    public void visualizo_mensaje_error(){
        sauceDemoPage.visualizarMensajeError();

    }


}