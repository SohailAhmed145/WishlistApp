package com.example.wishlistapp.data

class WishRepository(private val wishDao: WishDao) {


    suspend fun addWish(wish: Wish) {
        wishDao.addAWish(wish)
    }
}