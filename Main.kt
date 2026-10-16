fun main() {
    // Factores de conversion de divisas
    val dolar = 1.08
    val libra = 0.86
    val yen = 163.0
    val francoSuizo = 0.95

    var opcion: Int

    do {
        println("CONVERSOR DE UNIDADES")
        println("1. Conversor de divisas")
        println("2. Conversor de distancias")
        println("3. Conversor de temperaturas")
        println("4. Salir")
        print("Selecciona una opcion: ")

        opcion = readln().toIntOrNull() ?: -1

        when (opcion) {
            1 -> {
                println("CONVERSOR DE DIVISAS")
                println("1. Euros a dolares")
                println("2. Euros a libras esterlinas")
                println("3. Euros a yenes")
                println("4. Euros a francos suizos")
                print("Selecciona una conversion: ")

                val conversion = readln().toIntOrNull() ?: -1

                if (conversion in 1..4) {
                    print("Introduzca la cantidad en euros: ")
                    val euros = readln().toDoubleOrNull()

                    if (euros == null) {
                        println("Hay q introducir una cantidad numerica.")
                    } else if (euros < 0) {
                        println("La cantidad no puede ser negativa.")
                    } else {
                        val resultado = when (conversion) {
                            1 -> euros * dolar
                            2 -> euros * libra
                            3 -> euros * yen
                            4 -> euros * francoSuizo
                            else -> 0.0
                        }

                        val moneda = when (conversion) {
                            1 -> "dolares"
                            2 -> "libras esterlinas"
                            3 -> "yenes"
                            4 -> "francos suizos"
                            else -> ""
                        }

                        println("$euros euros equivalen a %.2f %s."
                            .format(resultado, moneda))
                    }
                } else {
                    println("Opcion no valida.")
                }
            }

            2 -> {
                println("CONVERSOR DE DISTANCIAS")
                println("1. Kilometros a metros")
                println("2. Metros a kilometros")
                println("3. Kilometros a millas")
                println("4. Millas a kilometros")
                println("5. Centimetros a metros")
                print("Selecciona una conversion: ")

                val conversion = readln().toIntOrNull() ?: -1

                if (conversion in 1..5) {
                    print("Escribe la distancia: ")
                    //Convierte lo q escriba el usuario en un num decimal por si el usuario escribe algo mal
                    val distancia = readln().toDoubleOrNull()

                    if (distancia == null) {
                        println("Tienes q poner una cantidad numerica.")
                    } else if (distancia < 0) {
                        println("La cantidad no puede ser negativa.")
                    } else {
                        val resultado = when (conversion) {
                            1 -> distancia * 1000
                            2 -> distancia / 1000
                            3 -> distancia * 0.621371
                            4 -> distancia * 1.609344
                            5 -> distancia / 100
                            else -> 0.0
                        }

                        val unidadOrigen = when (conversion) {
                            1, 3 -> "kilometros"
                            2 -> "metros"
                            4 -> "millas"
                            5 -> "centimetros"
                            else -> ""
                        }

                        val unidadDestino = when (conversion) {
                            1 -> "metros"
                            2, 5 -> "metros"
                            3, 4 -> "kilometros"
                            else -> ""
                        }

                        println("$distancia $unidadOrigen equivalen a " +
                                "%.4f %s.".format(resultado, unidadDestino))
                    }
                } else {
                    println("Opcion no valida.")
                }
            }

            3 -> {
                println("CONVERSOR DE TEMPERATURAS")
                println("1. Celsius a Fahrenheit")
                println("2. Fahrenheit a Celsius")
                println("3. Celsius a Kelvin")
                println("4. Kelvin a Celsius")
                print("Selecciona una conversion: ")

                val conversion = readln().toIntOrNull() ?: -1

                if (conversion in 1..4) {
                    print("Escribe una temperatura: ")
                    val temperatura = readln().toDoubleOrNull()

                    if (temperatura == null) {
                        println("Hay q escribir una temperatura numerica.")
                    } else if (conversion == 4 && temperatura < 0) {
                        println("La temperatura en Kelvin no puede ser inferior a 0.")
                    } else {
                        //Formulas de conversión
                        val resultado = when (conversion) {
                            1 -> temperatura * 9 / 5 + 32
                            2 -> (temperatura - 32) * 5 / 9
                            3 -> temperatura + 273.15
                            4 -> temperatura - 273.15
                            else -> 0.0
                        }
                        //Temperatura
                        val unidadOrigen = when (conversion) {
                            1, 3 -> "°C"
                            2 -> "°F"
                            4 -> "K"
                            else -> ""
                        }
                        //Temperatura convertifa
                        val unidadDestino = when (conversion) {
                            1 -> "°F"
                            2, 4 -> "°C"
                            3 -> "K"
                            else -> ""
                        }

                        println("%.2f %s equivalen a %.2f %s."
                            .format(temperatura, unidadOrigen, resultado, unidadDestino))
                    }
                } else {
                    println("No vale.")
                }
            }

            4 -> {
                println("Saliendo.")
            }

            else -> {
                println("No vale.")
            }
        }

    } while (opcion != 4)
}