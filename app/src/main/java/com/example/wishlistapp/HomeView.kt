package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.data.DummyWish
import com.example.wishlistapp.data.Wish

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
) {
    val context = LocalContext.current
    Scaffold(
        topBar = { AppBarView(title = " WishList ")
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(20.dp),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                onClick = {
                    navController.navigate(Screen.AddScreen.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(DummyWish.wishList){
                wish -> WishItem(wish = wish) {

            }
            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit){
    Card (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ){
        Column (
            modifier = Modifier
                .padding(16.dp)
        ){
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
    }
}