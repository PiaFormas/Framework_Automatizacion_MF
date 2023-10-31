Feature: Loguearse en la página de SauceDemo y visualizar los productos


  Background:
  Given Ingresar a SauceDemo

  @test
  Scenario: Loguearse exitosamente en SauceDemo
    When me logueo en Saucedemo introduciendo "Username_Correcto" y "Password"
    Then visualizo los productos en venta


  @test1
  Scenario: Loguearse erroneamente en SauceDemo
    When me logueo en Saucedemo introduciendo "Username_Erroneo" y "Password"
    Then visualizo mensaje de error en login


