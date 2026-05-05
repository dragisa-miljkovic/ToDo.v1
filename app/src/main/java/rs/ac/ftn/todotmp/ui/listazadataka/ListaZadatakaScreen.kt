package rs.ac.ftn.todotmp.ui.listazadataka

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaZadatakaScreen(
    uiState: ListaZadatakaUiState,
    onZadatakClick: (String) -> Unit,
    onDodajClick: () -> Unit,
    onPromeniStatus: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ToDo") },
                colors = TopAppBarDefaults.topAppBarColors()
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onDodajClick) {
                Text("+")
            }
        }
    ) { innerPadding ->
        if (uiState.zadaci.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Нема задатака")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(items = uiState.zadaci, key = { it.id }) { zadatak ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onZadatakClick(zadatak.id) }
                        ) {
                            Text(zadatak.naslov, style = MaterialTheme.typography.titleMedium)
                            if (zadatak.opis.isNotBlank()) {
                                Text(zadatak.opis, style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                        Checkbox(
                            checked = zadatak.daLiJeResen,
                            onCheckedChange = { onPromeniStatus(zadatak.id) }
                        )
                    }
                }
            }
        }
    }
}
