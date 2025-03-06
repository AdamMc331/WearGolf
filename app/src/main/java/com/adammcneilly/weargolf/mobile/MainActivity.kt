package com.adammcneilly.weargolf.mobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.wear.remote.interactions.RemoteActivityHelper
import com.adammcneilly.weargolf.mobile.theme.WearGolfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()

            WearGolfTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Button(
                        onClick = {
                            val remoteActivityHelper = RemoteActivityHelper(this)
                            val uri = "weargolf://openfromphone".toUri()
                            val intent = Intent(Intent.ACTION_VIEW)
                                .addCategory(Intent.CATEGORY_BROWSABLE)
                                .setData(uri)
                            remoteActivityHelper.startRemoteActivity(intent)
                        },
                        modifier = Modifier
                            .padding(top = 24.dp),
                    ) {
                        Text(
                            text = "Launch WearOS",
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
