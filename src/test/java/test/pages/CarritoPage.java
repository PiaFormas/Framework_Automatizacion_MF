package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.driverConfig.DriverContext;
import test.util.MetodosGenericos;

import static org.junit.Assert.fail;

public class CarritoPage {
    private WebDriver driver = DriverContext.getDriver();
    private static final Logger log = LoggerFactory.getLogger(CarritoPage.class);
    @FindBy(
            id = "add-to-cart-sauce-labs-backpack"
    )
    WebElement primerProducto;

    @FindBy(
            id = "shopping_cart_container"
    )
    WebElement btnCarrito;

    @FindBy(
           //xpath = "//div[@class='cart_item_label']//div[text()='Sauce Labs Backpack']"
    )
    WebElement productoEnCarro;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement btnRemove;


    public CarritoPage() {
        PageFactory.initElements(this.driver, this);
    }

    public void AgregarProductoAlCarro() {
        try {

            boolean validarBtnAdd = MetodosGenericos.visualizarObjeto(primerProducto, 15);
            if (validarBtnAdd) {
                primerProducto.click();

            } else {
                fail("no se logro visualizar el boton");
            }

        } catch (Exception e) {
            fail("no fue posible encontrar el elemento");
        }

    }

    public void seleccionarIconoCarrito() {
        try {
            boolean validarBtnCarrito = MetodosGenericos.visualizarObjeto(btnCarrito, 10);
            if (validarBtnCarrito) {
                btnCarrito.click();

            } else {
                fail("no se logro visualizar el boton");
            }

        } catch (Exception e) {
            fail("no fue posible encontrar el elemento");
        }

    }
    public boolean visualizarProductoEnCarro() {

        try {
            MetodosGenericos.visualizarObjeto(productoEnCarro, 10);
            return productoEnCarro.isDisplayed();

        } catch (Exception e) {
            fail("no fue posible visualizar el producto");
        }
        return false;
    }


    public void ClickBtnRemove() {
        try {
            boolean validarBtnRemove = MetodosGenericos.visualizarObjeto(btnRemove, 10);
            if (validarBtnRemove) {
                btnRemove.click();
            } else {
                fail("no se logro realizar el click");
            }


        } catch (Exception e) {
            fail("no fue posible visualizar el botón");
        }

    }




    }














