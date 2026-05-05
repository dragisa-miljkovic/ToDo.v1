package rs.ac.ftn.todotmp.ui.detaljizadatka

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetaljiZadatkaScreen(
    uiState: DetaljiZadatkaUiState,
    onNazadClick: () -> Unit,
    onNaslovChange: (String) -> Unit,
    onOpisChange: (String) -> Unit,
    onResenChange: (Boolean) -> Unit,
    onSacuvajClick: () -> Unit,
    onObrisiClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (uiState.id == null) "Нови задатак" else "Детаљи") },
                navigationIcon = {
                    IconButton(onClick = onNazadClick) {
                        Text("←")
                    }
                },
                actions = {
                    if (uiState.id != null) {
                        IconButton(onClick = onObrisiClick) {
                            Text("✕")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = uiState.naslov,
                onValueChange = onNaslovChange,
                label = { Text("Наслов") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.opis,
                onValueChange = onOpisChange,
                label = { Text("Опис") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            Row(modifier = Modifier.padding(top = 8.dp)) {
                Checkbox(checked = uiState.daLiJeResen, onCheckedChange = onResenChange)
                Text("Завршен", modifier = Modifier.padding(top = 12.dp))
            }

            Button(
                onClick = onSacuvajClick,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Сачувај")
            }
        }
    }
}
