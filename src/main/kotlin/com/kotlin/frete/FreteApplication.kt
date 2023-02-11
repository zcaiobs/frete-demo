package com.kotlin.frete

fun main(args: Array<String>) {

	val list = getEstados()

	while(true) {
		list.shuffle()
		Thread.sleep(500)
		val estado = list.first()

		println("Local de entrega ${estado.first} cep ${getCep(estado.first)}" )
		println(frete(estado.first, getCep(estado.first)))
	}
}

fun frete(estado: String, cep: Int): String {
	return when(true){
		getFretePago30ByEstados(estado) -> "FRETE R$30,00"
		getFretePago30ByRangeCep(estado, cep) -> "FRETE R$30,00"
		getFretePago40ByEstados(estado) -> "FRETE R$40,00"
		else -> "FRETE GRÁTIS"
	}
}

fun getCep(estado: String): Int {
	return when(estado){
		"Ceará" -> (60000000..63999999).random()
		"Goiás" -> ( 72800000..76799999).random()
		"Pernambuco" -> ( 50000000..56999999).random()
		else -> 0
	}
}

fun getFretePago30ByRangeCep(estado: String, cep: Int): Boolean {
	return when(estado){
		"Ceará" -> (61901000..63999999).contains(cep)
		"Goiás" -> ( 74895000..76799999).contains(cep)
		"Pernambuco" -> (55000000..56999999).contains(cep)
		else -> false
	}
}

fun getFretePago30ByEstados(estado: String): Boolean {
	return mutableListOf(
			"Acre",
			"Alagoas",
			"Mato Grosso",
			"Mato Grosso do Sul",
			"Paraíba",
			"Piauí",
			"Rio Grande do Norte",
			"Rondônia",
			"Sergipe",
			"Tocantins").contains(estado)
}

fun getFretePago40ByEstados(estado: String): Boolean {
	return mutableListOf(
			"Amazonas",
			"Amapá",
			"Maranhão",
			"Pará",
			"Roraima").contains(estado)
}

fun getEstados(): MutableList<Pair<String, String>> {
	return mutableListOf(
			Pair("Acre", "AC"),
			Pair("Alagoas", "AL"),
			Pair("Amapá", "AP"),
			Pair("Amazonas", "AM"),
			Pair("Bahia", "BA"),
			Pair("Ceará", "CE"),
			Pair("Espírito Santo", "ES"),
			Pair("Goiás", "GO"),
			Pair("Maranhão", "MA"),
			Pair("Mato Grosso", "MT"),
			Pair("Mato Grosso do Sul", "MS"),
			Pair("Minas Gerais", "MG"),
			Pair("Pará", "PA"),
			Pair("Paraíba", "PB"),
			Pair("Paraná", "PR"),
			Pair("Pernambuco", "PE"),
			Pair("Piauí", "PI"),
			Pair("Rio de Janeiro", "RJ"),
			Pair("Rio Grande do Norte", "RN"),
			Pair("Rio Grande do Sul", "RS"),
			Pair("Rondônia", "RO"),
			Pair("Roraima", "RR"),
			Pair("Santa Catarina", "SC"),
			Pair("São Paulo", "SP"),
			Pair("Sergipe", "SE"),
			Pair("Tocantins", "TO"),
			Pair("Distrito Federal", "DF")
	)
}