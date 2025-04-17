package com.example.news_app.Presentation_layer.Screens

import android.graphics.ColorFilter
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.news_app.Presentation_layer.ViewModel.NewsViewModel
import com.example.news_app.R
import com.example.news_app.ui.theme.LightPink
import com.example.news_app.ui.theme.lightGray
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalDrawerScreen(newsViewModel : NewsViewModel = hiltViewModel()) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val urlHandler = LocalUriHandler.current
    val context = LocalContext.current

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet (
                drawerContainerColor = LightPink
            ){
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(250.dp)
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.newss),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .size(110.dp)
                            .align(Alignment.CenterHorizontally)

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider()
                    NavigationDrawerItem(
                        label = {
                            Text(
                            text = "Home",
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        ) },
                        selected = false,
                        //icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.home),
                                contentDescription = "Home",
                                modifier = Modifier.size(24.dp),
                                tint = Color.Unspecified
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    Divider()
                    NavigationDrawerItem(
                        label = {
                            Text("Top News",
                                color = Color.Black,
                                fontWeight = FontWeight.Medium) },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.topnews),
                                contentDescription = "Top News",
                                modifier = Modifier.size(24.dp),
                                tint = Color.Unspecified
                            )
                        },
                        onClick = {   coroutineScope.launch {
                            drawerState.close()
                        }
                            Toast.makeText(context, "Top News", Toast.LENGTH_SHORT).show()

                        }
                    )
                    Divider()
                    NavigationDrawerItem(
                        label = {
                            Text("World" ,
                                color = Color.Black,
                                fontWeight = FontWeight.Medium
                            ) },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.world),
                                contentDescription = "World",
                                modifier = Modifier.size(24.dp),
                                tint = Color.Unspecified
                            )
                        },
                        onClick = { coroutineScope.launch {
                            drawerState.close()
                        }
                        }
                    )
                    Divider()
                    NavigationDrawerItem(
                        label = {
                            Text("Technology",
                                color = Color.Black,
                                fontWeight = FontWeight.Medium
                            ) },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.technology),
                                contentDescription = "Technology",
                                modifier = Modifier.size(24.dp),
                                        tint = Color.Unspecified
                            )
                        },
                        onClick = { coroutineScope.launch {
                            drawerState.close()
                        } }
                    )
                    Divider()
                    NavigationDrawerItem(
                        label = {
                            Text("About Us" ,
                                color = Color.Black,
                                fontWeight = FontWeight.Medium
                            ) },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.aboutus),
                                contentDescription = "About Us",
                                modifier = Modifier.size(24.dp),
                                tint = Color.Unspecified
                            )
                        },
                        onClick = {  urlHandler.openUri("http://arbabshaikh.tech/") }
                    )
                }
            }
        }
    ) {

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            containerColor = lightGray,
            topBar = {

                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = LightPink // apna custom ya Material color yahan use karo
                    ),
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "PAK News",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Open Drawer"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                NewsTabs(newsViewModel)

//                if (viewModel.res.value == null) {
//                    Column {
//                        repeat(10) {
//                            AnimatedShimmer()
//                        }
//                    }
//                } else {
//                    Column {
                        HomeUI(newsViewModel)
                    //}
                }
            }
        }

    }

