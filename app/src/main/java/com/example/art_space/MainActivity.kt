import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
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
//
//@Composable
//fun printImage(option: Int){
//    var result by remember { mutableStateOf(option) }
//    var image = painterResource(R.drawable.las_meninas_01)
//    var titl = ""
//    var artis = ""
//    var dat = 0
//    when(option){
//        1 ->{
//            image = painterResource(R.drawable.las_meninas_01)
//            titl =  stringResource(R.string.title1)
//            artis = stringResource(R.string.artist1)
//            dat = 1656}
//        2 ->{
//            image = painterResource(R.drawable.persistencia_2)
//            titl = stringResource(R.string.title2)
//            artis = stringResource(R.string.artist2)
//            dat = 1931}
//        3 ->{
//            image = painterResource(R.drawable.licensed_image)
//            titl = stringResource(R.string.title3)
//            artis = stringResource(R.string.artist3)
//            dat = 1506}
//    }
//
//    Column(
//        modifier = Modifier.padding(40.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
////        verticalArrangement = Arrangement.Center
//    ) {
//        Image(
//            painter = image,
//            contentDescription = null,
//        )
//    }
//    Button(onClick = { result = (1..6).random() }) {
//        Text(stringResource(R.string.roll))
//
//    }
//    artSpace( titl, artis, dat)
//}
//
//


@Composable
fun printImage(modifier: Modifier){
    var result by remember { mutableStateOf(1) }
    var image = painterResource(R.drawable.las_meninas_01)
    var titl = ""
    var artis = ""
    var dat = 0
    when(result){
        1 ->{
            image = painterResource(R.drawable.las_meninas_01)
            titl =  stringResource(R.string.title1)
            artis = stringResource(R.string.artist1)
            dat = 1656}
        2 ->{
            image = painterResource(R.drawable.persistencia_2)
            titl = stringResource(R.string.title2)
            artis = stringResource(R.string.artist2)
            dat = 1931}
        3 ->{
            image = painterResource(R.drawable.licensed_image)
            titl = stringResource(R.string.title3)
            artis = stringResource(R.string.artist3)
            dat = 1506}
    }

    Column(
        modifier = Modifier.padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
        )

        Text(
            text = titl,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Row(){
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

    Button(onClick = { result = (1..3).random() }, modifier = Modifier) {
        Text(stringResource(R.string.roll))

    }}
}


//@Composable
//fun artSpace( title: String, artist: String, fecha: Int, modifier: Modifier = Modifier) {
//    Column(
//        modifier = Modifier.padding(40.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Bottom
//    ) {
//
//        Text(
//            text = title,
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            modifier = modifier
//        )
//        Row(){
//            Text(
//                text = artist,
//                fontSize = 12.sp,
//                modifier = modifier
//            )
//            Text(
//                text = " $fecha",
//                fontStyle = FontStyle.Italic,
//                fontSize = 12.sp,
//                modifier = modifier
//            )
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun ArtSpaces() {
        printImage( modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center) )

}