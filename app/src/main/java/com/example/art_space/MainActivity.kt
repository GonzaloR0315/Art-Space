import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art_space.R
import com.example.art_space.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
            ArtSpaceTheme {
                ArtSpaces()

            }
        }
    }
}

@Composable
fun printImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var image = painterResource(R.drawable.las_meninas_01)
    var titl = ""
    var artis = ""
    var dat = 0

    when (result) {
        1 -> {
            image = painterResource(R.drawable.las_meninas_01)
            titl = stringResource(R.string.title1)
            artis = stringResource(R.string.artist1)
            dat = 1656
        }
        2 -> {
            image = painterResource(R.drawable.persistencia_2)
            titl = stringResource(R.string.title2)
            artis = stringResource(R.string.artist2)
            dat = 1931
        }
        3 -> {
            image = painterResource(R.drawable.licensed_image)
            titl = stringResource(R.string.title3)
            artis = stringResource(R.string.artist3)
            dat = 1506
        }
    }

    val buttonSpacing = dimensionResource(R.dimen.button_spacing)

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(625.dp)
        )

        Text(
            text = titl,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )

        Row() {
            Text(
                text = artis,
                fontSize = 12.sp,
            )
            Text(
                text = " $dat",
                fontStyle = FontStyle.Italic,
                fontSize = 12.sp,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = buttonSpacing),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (result >= 1) {
                        result--
                        if (result < 1) {
                            result = 3
                        }
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.anterior))
            }

            Spacer(modifier = Modifier.width(buttonSpacing))

            Button(
                onClick = {
                    if (result <= 3) {
                        result++
                        if (result > 3) {
                            result = 1
                        }
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.siguiente))
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ArtSpaces() {
        printImage( modifier = Modifier
            //.fillMaxSize()
            .wrapContentSize(Alignment.Center) )

}