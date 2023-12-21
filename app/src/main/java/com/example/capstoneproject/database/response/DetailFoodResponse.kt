package com.example.capstoneproject.database.response

import com.google.gson.annotations.SerializedName

data class DetailFoodResponse(

	@field:SerializedName("result")
	val result: Result? = null
)

data class Result(

	@field:SerializedName("food_name")
	val foodName: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("khasiat")
	val khasiat: String? = null,

	@field:SerializedName("ingredients")
	val ingredients: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("steps")
	val steps: String? = null,

	@field:SerializedName("id_food")
	val idFood: Int? = null
)
