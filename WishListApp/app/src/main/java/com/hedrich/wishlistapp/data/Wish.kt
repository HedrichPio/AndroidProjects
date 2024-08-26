package com.hedrich.wishlistapp.data

data class Wish(
    val id:Long=0L,
    val title:String="",
    val description:String="")


object DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch 2", description = "Android Watch"),
        Wish(title = "DJI Mini 3 Pro", description = "4k Drone"),
        Wish(title = "Traxxas Defender", description = "RC rock crawler"),
    )
}