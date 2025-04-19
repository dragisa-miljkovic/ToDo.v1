package rs.ac.ftn.todov1

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class ListaZadatakaViewModel : ViewModel() {

    val zadaci = mutableListOf<Zadatak>()

    init {
        for (i in 0 until 100) {
            val zadatak = Zadatak(
                id = UUID.randomUUID(),
                naslov = "Zadatak #$i",
                datum = Date(),
                daLiJeResen = i % 2 == 0
            )

            zadaci += zadatak
        }
    }
}