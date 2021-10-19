package com.example.vip

import android.content.Intent
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "LoginScreen"
            ) {

                composable(route = "LoginScreen"){
                    LoginScreen(navController = navController)
                }
                composable(route = "ScheduleScreen"){
                    ScheduleScreen(navController = navController)
                }

            }
        }
    }
    @Composable
    fun ScheduleScreen(navController: NavController){
        var intent = Intent(this,ScheduleActivity::class.java)
        startActivity(intent)
    }

}

@Composable
fun LoginScreen(navController: NavController){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }



    Scaffold(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.k2wide),
            contentDescription = "Жёлтый чел",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize().offset(200.dp),
            alpha = 0.2f
        )
        Image(
            painter = painterResource(id = R.drawable.k1),
            contentDescription = "Синий чел",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize().offset(-200.dp),
            alpha = 0.2f
        )//Stuff for basic UI stuff which is big
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 50.dp, vertical = 16.dp)

        ){

            Box(modifier = Modifier
                .width(120.dp)
                .height(120.dp)){
                Image(painter = painterResource(id = R.drawable.login_logo),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))


            Text("Мой ученик",
                color = Color(120, 0, 255),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(60.dp))
            TextField(

                value = email,
                label = {Text("E-mail")},
                onValueChange = {
                    email = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(50.dp),
//                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Black)

            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(

                value = password,
                label = {Text("Пароль")},
                onValueChange = {
                    password = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(50.dp),
//                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Black)


            )
            Spacer(modifier = Modifier.height(20.dp))
            Text("Забыл пароль", textAlign = TextAlign.Center, modifier = Modifier.clickable{
                // TODO Экран забыл пароль
                navController.navigate("RestorePasswordScreen")
            })
            Spacer(modifier = Modifier.height(40.dp))

            GradientButton(
                text = "ВХОД",
                gradient = Brush.linearGradient(colors = listOf(Color(102, 100, 173),Color(229, 154, 241))),
                onClick = {

                    navController.navigate("ScheduleScreen")}, // change to MainScreen
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(40.dp))
            Text("Регистрация", textAlign = TextAlign.Center, modifier = Modifier.clickable{
                // TODO Экран регистрация
                navController.navigate("RegisterScreen")
            })



            //support
        }
    }



//        TextField(
//            value = email,
//            onValueChange = {
//            email = it
//        }, modifier = Modifier
//                .fillMaxWidth())
}

@Composable
fun LoadingScreen(navController: NavController){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
//            .background(Color.Green)
        ,


        ){
        Text("Loading...", textAlign = TextAlign.Center, modifier = Modifier.clickable{
            navController.navigate("LoginScreen")
        })

    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable() {},
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ){
        Box(modifier = Modifier.height(200.dp)) {
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop)

        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 300f
                )
            ))
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
            contentAlignment = Alignment.BottomStart
        ){
            Text(title, style = TextStyle(color=Color.White,fontSize = 16.sp))
        }
    }
}

@Composable
fun GradientButton(
    text: String,
    gradient : Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Button(
        modifier = modifier.height(40.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .height(40.dp)
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = text)
        }
    }
}