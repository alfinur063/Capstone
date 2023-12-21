package com.example.capstoneproject.database.dummy

import com.example.capstoneproject.R

object ListRekomendasiDummy {

    private var data = arrayOf(
arrayOf(
    R.drawable.pepesikangabus,
    "Pepes Ikan Gabus",
    "Pepes ikan gabus tidak hanya lezat tetapi juga bergizi karena ikan gabus kaya akan protein dan omega-3. Selain itu, cara pengolahannya yang dikukus membuat pepes ikan gabus menjadi pilihan makanan yang lebih sehat karena tidak menggunakan minyak untuk memasaknya.",
    "250 gr ikan gabus, 1/2 Bawang Bombay, 2 siung Bawang merah, 1 siung Bawang putih, Jahe, Kunyit, Lengkuas, Sereh, Kemiri, Lada, Ketumbar, Cabai merah, cabai rawit sesuai selera, Garam secukupnya, Penyedap rasa sekucupnya",
    "1. Potong ikan lalu cuci hingga bersih. 2. Siapkan bumbu kemudian di uleg hingga halus. 3. Geprek lengkuas, jahe dan serai. 4. Aduk bumbu yang telah halus dengan ikan diamkan beberapa saat untuk marinasi bumbu. 5. Siapkan daun pisang untuk membungkus ikan. 6. Kukus hingga matang selama 20-30 menit. 7. Pepes sudah matang dan siap dinikmati.",
    "Seperti yang dipaparkan dalam penelitian Jurnal Gizi Klinik Indonesia (2016), albumin yang terkandung dalam ikan gabus memiliki fungsi sebagai antioksidan, mempertahankan kondisi integritas mikrovaskular, memodulasi inflamasi, dan sebagai antikoagulan ternyata memiliki hubungan bermakna dengan peningkatan gizi pasien stroke.",
),
  arrayOf(
      R.drawable.tunatahukukusfotoreseputama,
      "Tuna Tahu Kukus",
      "Tuna adalah salah satu jenis ikan berlemak yang memiliki kandungan omega-3 yang tinggi, selain itu Tuna Tahu Kukus ini sangat mudah untuk dibuat.",
      "1/2 kaleng tuna, 1 wortel parut, 1 batang daun bawang iris, 2 kotak tahu yang dihancurkan, 1 butir telur ayam, 3 siung bawang putih halus, Lada dan garam secukupnya",
      "1. Campur tahu yang sudah dihancurkan dengan wortel yang sudah diparut, daun bawang, bawang putih halus, garam, lada, dan ikan tuna kaleng. 2. Aduk rata dan cicipi rasa. 3. Masukkan telur yang sudah dikocok, aduk rata. Kukus hingga matang dengan api kecil. 4. Hidangkan. Mudah, ya! Selamat mencoba.",
      "Berkat kandungan asam lemak omega-3 yang tinggi, ikan tuna dapat bermanfaat untuk menjaga kesehatan jantung, mengurangi risiko terjadinya demensia, menjaga kesehatan tulang, mencegah anemia, membantu penurunan berat badan, mencegah kanker.",
  ),
        arrayOf(
            R.drawable.empaldaginggiling,
            "Empal Daging Giling",
            "Empal daging giling bisa menjadi salah satu menu yang sesuai karena mudah untuk ditelan dan empuk, dalam pembuatannya juga tidak perlu banyak bumbu tambahan yang berlebih karena daging sudah menghasilkan rasa yang gurih.",
            "200gr Daging giling, 1/2 butir telur, 5 butir bawang merah, 2 butir bawang putih, 2 butir kemiri, 1/2 sdt ketumbar, 1/2 cm jahe, 30 gr gula merah, 1/4 sdt air asam jawa, 1/2 sdt garam, 1/2 cm lengkuas, 1 lembar daun salam",
            "1. Campur daging giling dan telur. 2. Masukkan ke dalam food processor, giling sampai tercampur rata. 3. Rebus dalam air mendidih sampai mengapung, tiriskan, angkat. 4. Tumis bumbu halus sampai harum, masukkan daun salam, lengkuas. 5. Tambahkan air, masukkan daging giling, masak sampai matang dan kuah tinggal sedikit. 6. Angkat dan sajikan.",
            "Daging sapi giling adalah sumber protein hewani yang kaya akan nutrisi penting seperti zat besi, zinc, vitamin B12, dan protein tinggi. Protein diperlukan untuk memelihara dan memperbaiki jaringan tubuh, termasuk otot, dan juga dapat membantu dalam proses penyembuhan.",

        )
    )

    val listData: ArrayList<Fooddummy>
        get() {
            val list = ArrayList<Fooddummy>()
            for (Data in data){
                val foods = Fooddummy()
                foods.photo = Data[0] as Int
                foods.name = Data[1] as String
                foods.bahan = Data[2] as String
                foods.step = Data[3] as String
                foods.khasiat = Data[4] as String

                list.add(foods)
                }
            return list
            }
        }
