package com.hedrich.receipeapp

data class Category(
    val idCategory:String,
    val strCategory:String,
    val strCategoryThumb:String,
    val strCategoryDescription:String
)

data class CategoryList(
    val categories:List<Category>
)
