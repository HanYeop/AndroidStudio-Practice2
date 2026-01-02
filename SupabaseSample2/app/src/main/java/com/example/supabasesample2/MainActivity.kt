package com.example.supabasesample2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.supabasesample2.ui.theme.SupabaseSample2Theme
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    private val supabase = createSupabaseClient(
        supabaseUrl = BuildConfig.supabaseUrl,
        supabaseKey = BuildConfig.supabaseKey
    ) {
        install(Postgrest)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            SupabaseSample2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var instruments by remember { mutableStateOf<List<Instrument>>(emptyList()) }
                    val scope = rememberCoroutineScope()
                    val context = LocalContext.current

                    Column(modifier = Modifier.padding(innerPadding)) {
                        Button(onClick = {
                            scope.launch {
                                Log.d("MainActivity", "데이터 가져오기 시작...")
                                val fetchedInstruments = withContext(Dispatchers.IO) {
                                    try {
                                        val result = supabase.from("instruments").select().decodeList<Instrument>()
                                        Log.d("MainActivity", "데이터 가져오기 성공. 개수: ${result.size}")
                                        result
                                    } catch (e: Exception) {
                                        Log.e("MainActivity", "데이터 가져오기 오류", e)
                                        emptyList<Instrument>()
                                    }
                                }
                                instruments = fetchedInstruments
                                Log.d("MainActivity", "현재 목록 크기: ${instruments.size}")
                            }
                        }) {
                            Text("데이터 가져오기")
                        }

                        Button(onClick = { context.startActivity(Intent(context, ComposeActivity2::class.java)) }) {
                            Text("새 액티비티 열기")
                        }

                        InstrumentsList(instruments = instruments, modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun InstrumentsList(instruments: List<Instrument>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(
            items = instruments,
            key = { instrument -> instrument.id },
        ) { instrument ->
            Text(
                instrument.name,
                modifier = Modifier.padding(8.dp),
            )
        }
    }
}
