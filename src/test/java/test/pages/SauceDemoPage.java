package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.constants.Constant;
import test.driverConfig.DriverContext;
import test.util.MetodosGenericos;

import static org.junit.Assert.fail;

public class SauceDemoPage {
    private WebDriver driver = DriverContext.getDriver();
    private static final Logger log = LoggerFactory.getLogger(SauceDemoPage.class);
    @FindBy(
            id = "user-name"
    )
    WebElement Username;

    @FindBy(
            id = "password"
    )
    WebElement Password;

    @FindBy(
            id = "login-button"
    )
    WebElement btnIngresar;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement labelProducts;
    @FindBy(xpath = " //h3[text()='Epic sadface: Username and password do not match any user in this service']")
    WebElement msjeError;

    public SauceDemoPage() {
        PageFactory.initElements(this.driver, this);
    }

    public void IngresarUsername(String user) {
        try {


            boolean validarUsername = MetodosGenericos.visualizarObjeto(Username, 15);
            if (validarUsername && user.equals("Username_Correcto")) {
                Username.sendKeys(Constant.Username_Correcto);
            } else if (user.equals("Username_Erroneo")) {
                Username.sendKeys(Constant.Username_Erroneo);
            } else {
                fail("no se logro visualizar el campo usuario");
            }

        } catch (Exception e) {
            fail("no fue posible ingresar el texto " + user + " en el campo de busqueda");
        }

    }

    public void IngresarPassword(String pass) {
        try {
            boolean validarPass = MetodosGenericos.visualizarObjeto(Password, 10);
            if (validarPass) {
                Password.sendKeys(Constant.Password);
            } else {
                fail("no se logro visualizar el campo de busqueda");
            }

        } catch (Exception e) {
            fail("no fue posible ingresar el texto " + pass + " en el campo de busqueda");
        }

    }

    public void ClickBtnIngresar() {
        try {
            boolean validarBtnIngresar = MetodosGenericos.visualizarObjeto(btnIngresar, 10);
            if (validarBtnIngresar) {
                btnIngresar.click();
            } else {
                fail("no se logro realizar el click");
            }


        } catch (Exception e) {
            fail("no fue posible visualizar el botón ");
        }

    }

    public void visualizarProductos() {
        try {
            MetodosGenericos.visualizarObjeto(labelProducts, 10);

        } catch (Exception e) {
            fail("no fue posible validar el inicio de sesion");
        }
    }


    public boolean visualizarMensajeError() {

        try {
            MetodosGenericos.visualizarObjeto(msjeError, 10);
            return msjeError.isDisplayed();

        } catch (Exception e) {
            fail("no fue posible validar el inicio de sesion");
        }
        return false;
    }

    }














