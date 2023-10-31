package test.pages;

import driverConfig.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.MetodosGenericos;

public class SauceDemoPage {
    private WebDriver driver = DriverContext.getDriver();
    private static final Logger log = LoggerFactory.getLogger(TsoftPage.class);
    @FindBy(
            xpath = "//a[text()='CLIENTES']"
    )
    WebElement BtnCliente;

    public TsoftPage() {
        PageFactory.initElements(this.driver, this);
    }

    public void clickBtnClientes() {
        MetodosGenericos.waitExplicit(this.BtnCliente, 10);
        this.BtnCliente.click();
    }

    public void isVisibleCliente(String[] cliente) {
        String[] var2 = cliente;
        int var3 = cliente.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String element = var2[var4];
            By visualizarCliente = By.xpath("//img[@alt='" + element + "']");
            WebElement var7 = DriverContext.getDriver().findElement(visualizarCliente);
        }

    }
}
