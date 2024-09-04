package com.hedrich.wishlistapp

import android.app.Application
import com.hedrich.wishlistapp.data.Graph

class WishListApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}