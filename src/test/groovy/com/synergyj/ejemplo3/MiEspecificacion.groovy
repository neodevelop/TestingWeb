package com.synergyj.ejemplo3

import spock.lang.Specification

class MiEspecificacion extends Specification {

  // Una especificación muy simple
  def "calcula el máximo de dos números"(){
    expect:
      Math.max(a,b) == c
    where:
      a << [4,9,10]
      b << [7,3,50]
      c << [7,9,50]
      //c << [0,0,0]
  }

  // Especificando a Spock
  def "mostrar el ciclo de ejecución de Spock"(){
    setup: "Aqui puedes inicializar recursos que necesites para la especificacion"
      println "Inicializando recursos para\t\t${a}\t\t${b}\t\t${tamanio}"
    and: "Y algo más si lo deseas"
    //given: "O bien contextualizarlo como un feature con given-when-then, es un alias de setup"
    when: "Ejecutas acciones concretas, incluso de objetos no definidos aún"
      a.toLowerCase()
    then: "Evaluas los resultados de las acciones, por lo generla ocurrió algún efecto colateral"
      a.size() == tamanio
    expect: "Similar a when-then juntos, pero se usa para métodos pruamente funcionales"
      a.toLowerCase() == b
    cleanup: "Aqui puedes inicializar recursos que necesites para la especificacion"
      println "Limpiando recursos para\t\t\t\t${a}\t\t${b}\t\t${tamanio}"
    where: "Condiciones varias que serán evaluadas tantas veces como valores tengamos"
      a       | b       | tamanio
      "HOLA"  | "hola"  | 4
      "MUNDO" | "mundo" | 5
  }

}
