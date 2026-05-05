package rs.ac.ftn.todov1.ui.listazadataka

import rs.ac.ftn.todov1.Zadatak

data class ListaZadatakaUiState(
    val zadaci: List<Zadatak> = emptyList()
)

