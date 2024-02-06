<details>
<summary>Tutorial 1</summary>
## Reflection 1
'''
pada pengembangan fitur saya sudah menerapkan standarisasi clean code mulai dari menggunakan 
nama variabel dan metode yag deskriptif, memecah kode menjadi komponen modular dan menerapkan 
fungsionalitas sesuai kebutuhan, tidak melakukan duplikasi kode dan mengunakan format yang konsisten.

Namun pada saat pengembangan fitur delete thymeleaf saya tidak bisa mendeteksi metode DELETE  sehingga saya 
menambahkan konfigurasi **spring.mvc.hiddenmethod.filter.enabled=true** pada berkas **application.properties**
agar fitur tersebut dapat berfungsi dengan baik.
'''
## Reflection 2
'''
Setelah menulis unit test, saya merasa kode saya menjadi berfungsi sesuai dengan bagaimana mestinya kode tersebut
harus berjalan karena saya bisa mengetahui bug tersebut secara lebih awal dan dapat memperbaikinya sebelum error-error
yang lain.Namun, saya merasa bahwa tidak ada jumlah exact untuk banyak unit test yang harus dibuat untuk satu kelas, 
Namun, berdasarkan literatur yang saya baca bahwa sekitar 80% dari kode seharusnya tercakup oleh unit test. selain itu, 
Agar unit test cukup untuk mengecheck fungsionallitas fiturnya saya perlu menguji semua fitur dalam program sehingga tidak ada kasus yang tidak tertangani. 
Meskipun mencapai 100% code coverage memberikan suatu keyakinan pada code bahwa sudah benar, hal itu tidak menjamin bahwa kode kita bebas dari bug atau kesalahan.

Setelah saya meninjau kode dari file **CreateProductFunctionalTest.java** saya menyadari bahwa masih terdapat kode yang tidak
menerapkan prinsip clean code karena kesamaan pengujian fungsional seperti pada function **simulation_createProduct_isCorrect(ChromeDriver driver)**
terdapat penggunaan duplikasi code yang digunakan untuk memeriksa detail produk dan jumlah product dalam daftar. Solusi yang bisa dilakukan yaitu dengan
membuat methode untuk baris kode yang serupa.
'''
</details>

