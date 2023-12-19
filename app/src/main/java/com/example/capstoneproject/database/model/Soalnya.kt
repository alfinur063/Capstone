package com.example.capstoneproject.database.model

    data class Question(
        val question: String,
        val listOpstions : List<String>
    )

    val questionsWithOptions = listOf(
        Question("Apa jenis kelamin Anda?", listOf("Laki - laki", "Perempuan")),
        Question("Berapa usia Anda?", listOf("Umur Anda")),
        Question("Apakah Anda pernah menikah?", listOf("Pernah", "Tidak", "tidak ingin memberitahu")),
        Question("Jenis pekerjaan Anda?", listOf("Tidak ingin memberitahu", "Wiraswasta", "Asisten Rumah Tangga", "Pegawai Pemerintah", "Tidak Bekerja")),
        Question("Tipe tempat tinggal Anda?", listOf("Kota", "Desa", "lain")),
        Question("Bagaimana indeks massa tubuh (BMI) Anda?", listOf("Normal", "Underweight", "Obese")),
        Question("Apakah Anda pernah merokok?", listOf("Tidak pernah merokok", "Tidak ingin memberitahu", "Pernah Merokok", "Perokok", "lain")),
        Question("apakah anda pernah melakukan aktifitas fisik seperti olahraga ringan?", listOf("Tidak", "Iya", "lain"))
    )

fun getAnswerIndex(questionIndex: Int, answer: String): Int? {
    return when(questionIndex){
        0 ->when (answer){
            "Laki - laki"-> 0
            "Perempuan"-> 1
            else -> null
        }
        1 -> answer.toIntOrNull()
        2 -> when(answer){
            "Pernah" -> 0
            "Tidak Pernah" -> 1
            "Tidak ingin memberitahu" -> 2
            else -> null
        }
        3 -> when(answer){
            "Tidak ingin memberitahu" -> 0
            "Wiraswasta" -> 1
            "Asisten Rumah Tangga" ->2
            "Pegawai Pemerintah"->3
            "Tidak Bekerja"->4
            else -> null
        }
        4 -> when(answer){
            "Kota"->0
            "Desa"->1
            "Lain"->2
            else -> null
        }
        5 -> when(answer){
            "Normal"->0
            "Underweight"->1
            "Obese"->2
            else -> null
        }
        6 -> when(answer){
            "Tidak pernah merokok"-> 0
            "Tidak ingin memberitahu"->1
            "Pernah Merokok"->2
            "Perokok"->3
            "lain-lain"->4
            else -> null
        }
        7 -> when(answer){
            "Tidak"->0
            "Iya"->1
            "Lain"->2
            else -> null
        }
        else -> null
    }
}
