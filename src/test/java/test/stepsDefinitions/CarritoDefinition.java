package test.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.pages.CarritoPage;
import test.pages.SauceDemoPage;


public class CarritoDefinition {
    CarritoPage carritoPage = new CarritoPage();
    SauceDemoPage sauceDemoPage = new SauceDemoPage();


    @When("agrego al carro el producto que me interesa")
    public void agrego_al_aarro_el_producto_que_me_interesa() {
        carritoPage.AgregarProductoAlCarro();
    }

    @And("selecciono el icono del carro")
    public void hagoClickEnElIconoDelCarro() {
        carritoPage.seleccionarIconoCarrito();
    }

    @Then("visualizo el producto en mi carro de compras")
    public void visualizoElProductoEnMiCarroDeCompras() {
        carritoPage.visualizarProductoEnCarro();
    }

    @Then("remuevo el producto del carro")
    public void remuevoElProductoDelCarro() {
        carritoPage.ClickBtnRemove();
    }
}
