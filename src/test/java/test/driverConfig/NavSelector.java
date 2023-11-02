package test.driverConfig;

import test.constants.Navegador;

import static test.constants.Navegador.*;

public class NavSelector {


    static Navegador nav;

    public static Navegador seleccionNavegador(String navegador) {
        switch (navegador.trim()) {
            case "Chrome" -> {
                nav = Chrome;
                return nav;
            }
            case "Edge" -> {
                nav = Edge;
                return nav;
            }
            case "Firefox" -> {
                nav = Firefox;
                return nav;
            }
            case "Safari" -> {
                nav = Safari;
                return nav;
            }

        }
        return Chrome;
    }

}
