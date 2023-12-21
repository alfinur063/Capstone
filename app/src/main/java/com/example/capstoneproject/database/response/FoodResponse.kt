package com.example.capstoneproject.database.response

import com.google.gson.annotations.SerializedName

data class FoodResponse(

	@field:SerializedName("result")
	val result: List<ResultItem>?,

	@field:SerializedName("totalPage")
	val totalPage: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("totalRows")
	val totalRows: Int? = null
)

data class ResultItem(

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
