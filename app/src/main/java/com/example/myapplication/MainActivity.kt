package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    var nilai:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavHost(navController = navController, startDestination = Routes.HALAMAN_1){
                        composable(Routes.HALAMAN_1){
                            Hal1(navigation = navController)
                        }
                        composable(Routes.HALAMAN_2+"/{inputNama}",
                            arguments = listOf(navArgument("inputNama"){
                                type = NavType.StringType
                            })
                            ){backStackEntry ->
                            Hal2(navigation = navController, backStackEntry.arguments?.getString("inputNama"))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun tes(){
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var namaArray: Array<String> = arrayOf("ani", "budi", "ira", "widi", "ana", "rhey", "bibib")
    var textUpdate:String = "Hello"
    val nilai = remember {
        mutableStateOf(0)
    }
    var namapilihan = remember {
        mutableStateOf("")
    }
    val clr = remember{
        mutableStateOf(0)
    }

    fun generatedRandomValue(): Int {
     
        var rndmint:Int = (0 until 255).random()
        return rndmint
    }

    fun getRandomNama():String{
        var nama: String = namaArray[(0 until namaArray.size-1).random()]
        return nama
    }


    Row(
    horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(text = namapilihan.value.toString(),
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold,
            )
            Text(text = "Test",
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold,
            )

        }

        Button(

            onClick = {
                namapilihan.value = getRandomNama()
            }) {
            Text(text = "click me")
        }
        Button(

            onClick = {
                nilai.value = nilai.value - 1
            }) {
            Text(text = "kurang")
        }

    }



}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Greeting("Android")
//
//    }
//}