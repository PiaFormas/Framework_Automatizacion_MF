
package test.controller;

import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.constants.Constant;


public class RecursosController {

    private static final Logger log = LoggerFactory.getLogger(RecursosController.class);


    static String data;
    public static String getData(String dataInput) {
        switch (dataInput) {
            case "Username":
                data = Constant.Username_Correcto;
                break;
            case "Password":
                data = Constant.Password;
                break;
            case "UsernameErroneo":
                data=Constant.Username_Erroneo;


            default:
                Assertions.fail("No se encontro el dato solicitado" + data);
                break;
        }
        return data;
    }


}