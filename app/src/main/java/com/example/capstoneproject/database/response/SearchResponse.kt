package com.example.capstoneproject.database.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(

	@field:SerializedName("result")
	val result: List<ResultItem>,

	@field:SerializedName("totalPage")
	val totalPage: Int,

	@field:SerializedName("limit")
	val limit: Int,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("totalRows")
	val totalRows: Int
)

data class ResultItem(

	@field:SerializedName("food_name")
	val foodName: String,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("khasiat")
	val khasiat: String,

	@field:SerializedName("ingredients")
	val ingredients: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String,

	@field:SerializedName("steps")
	val steps: String,

	@field:SerializedName("id_food")
	val idFood: Int
)
