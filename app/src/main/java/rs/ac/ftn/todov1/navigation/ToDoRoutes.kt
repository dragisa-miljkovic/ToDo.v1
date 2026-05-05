package rs.ac.ftn.todov1.navigation

object ToDoRoutes {
    const val LISTA = "lista_zadataka"
    const val NOVI = "novi_zadatak"
    const val DETALJI = "detalji_zadatka/{zadatakId}"

    fun detaljiRoute(zadatakId: String): String = "detalji_zadatka/$zadatakId"
}

