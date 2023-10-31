Feature: Agregar y visualizar productos en el carrito de compras


  Background:
    Given Ingresar a SauceDemo
    When me logueo en Saucedemo introduciendo "Username_Correcto" y "Password"

  @test @agregarCarro
  Scenario: Agregar producto al carro
    When agrego al carro el producto que me interesa
    And selecciono el icono del carro
    Then visualizo el producto en mi carro de compras


  @test1
  Scenario: Remover producto desde el carro
    When agrego al carro el producto que me interesa
    And selecciono el icono del carro
    Then remuevo el producto del carro



