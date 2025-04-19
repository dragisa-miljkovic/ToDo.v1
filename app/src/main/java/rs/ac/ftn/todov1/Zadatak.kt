package rs.ac.ftn.todov1

import java.util.Date
import java.util.UUID

data class Zadatak(
    val id: UUID,
    val naslov: String,
    val datum: Date,
    val daLiJeResen: Boolean
)
