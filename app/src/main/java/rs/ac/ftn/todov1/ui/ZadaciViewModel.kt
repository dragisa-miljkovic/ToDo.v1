package rs.ac.ftn.todov1.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import rs.ac.ftn.todov1.Zadatak
import rs.ac.ftn.todov1.ui.detaljizadatka.DetaljiZadatkaUiState
import rs.ac.ftn.todov1.ui.listazadataka.ListaZadatakaUiState
import java.util.UUID

class ZadaciViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ListaZadatakaUiState(zadaci = pocetniZadaci()))
    val uiState: StateFlow<ListaZadatakaUiState> = _uiState.asStateFlow()

    fun promeniStatus(zadatakId: String) {
        _uiState.update { state ->
            state.copy(
                zadaci = state.zadaci.map { zadatak ->
                    if (zadatak.id == zadatakId) {
                        zadatak.copy(daLiJeResen = !zadatak.daLiJeResen)
                    } else {
                        zadatak
                    }
                }
            )
        }
    }

    fun nadjiZadatak(zadatakId: String): Zadatak? =
        _uiState.value.zadaci.firstOrNull { it.id == zadatakId }

    fun sacuvaj(detalji: DetaljiZadatkaUiState) {
        if (detalji.naslov.isBlank()) return

        val zadatak = Zadatak(
            id = detalji.id ?: UUID.randomUUID().toString(),
            naslov = detalji.naslov,
            opis = detalji.opis,
            daLiJeResen = detalji.daLiJeResen
        )

        _uiState.update { state ->
            val postoji = state.zadaci.any { it.id == zadatak.id }
            state.copy(
                zadaci = if (postoji) {
                    state.zadaci.map { if (it.id == zadatak.id) zadatak else it }
                } else {
                    listOf(zadatak) + state.zadaci
                }
            )
        }
    }

    fun obrisi(zadatakId: String) {
        _uiState.update { state ->
            state.copy(zadaci = state.zadaci.filterNot { it.id == zadatakId })
        }
    }

    private fun pocetniZadaci(): List<Zadatak> = listOf(
        Zadatak(
            id = "1",
            naslov = "Припремити вежбе",
            opis = "Проверити примере и задатке за термин.",
            daLiJeResen = false
        ),
        Zadatak(
            id = "2",
            naslov = "Обновити Compose state",
            opis = "remember, rememberSaveable и state hoisting.",
            daLiJeResen = true
        ),
        Zadatak(
            id = "3",
            naslov = "Написати домаћи",
            opis = "Задатак из ToDo блока.",
            daLiJeResen = false
        )
    )
}

