<details>
<summary>Tutorial 1</summary>
  
# **Reflection 1**
pada pengembangan fitur saya sudah menerapkan standarisasi clean code mulai dari menggunakan nama variabel dan metode yag deskriptif, memecah kode menjadi komponen modular dan menerapkan fungsionalitas sesuai kebutuhan, tidak melakukan duplikasi kode dan mengunakan format yang konsisten.

Namun pada saat pengembangan fitur delete thymeleaf saya tidak bisa mendeteksi metode DELETE  sehingga saya menambahkan konfigurasi **spring.mvc.hiddenmethod.filter.enabled=true** pada berkas **application.properties** agar fitur tersebut dapat berfungsi dengan baik.

# **Reflection 2**
Setelah menulis unit test, saya merasa kode saya menjadi berfungsi sesuai dengan bagaimana mestinya kode tersebut harus berjalan karena saya bisa mengetahui bug tersebut secara lebih awal dan dapat memperbaikinya sebelum error-error yang lain.Namun, saya merasa bahwa tidak ada jumlah exact untuk banyak unit test yang harus dibuat untuk satu kelas.Namun, berdasarkan literatur yang saya baca bahwa sekitar 80% dari kode seharusnya tercakup oleh unit test. selain itu, Agar unit test cukup untuk mengecheck fungsionallitas fiturnya saya perlu menguji semua fitur dalam program sehingga tidak ada kasus yang tidak tertangani.Meskipun mencapai 100% code coverage memberikan suatu keyakinan pada code bahwa sudah benar, hal itu tidak menjamin bahwa kode kita bebas dari bug atau kesalahan.

Setelah saya meninjau kode dari file **CreateProductFunctionalTest.java** saya menyadari bahwa masih terdapat kode yang tidak menerapkan prinsip clean code karena kesamaan pengujian fungsional seperti pada function **simulation_createProduct_isCorrect(ChromeDriver driver)** terdapat penggunaan duplikasi code yang digunakan untuk memeriksa detail produk dan jumlah product dalam daftar. Solusi yang bisa dilakukan yaitu dengan membuat methode untuk baris kode yang serupa.
</details>
<details>
<summary>Tutorial 2</summary>

my app url : https://eshop-shirin-shirin.koyeb.app/product/list
  
# **Reflection 1**
i have three issue 
1. Unnecessary modifier "public" on method , di resolvenya dengan cara meremove public modifier.
2. Swap these 2 arguments so they are in the correct order: expected value, actual value, di resolve dengan cara swap 2 argument dalam assertEquals. 
# **Reflection 2**
Saya menggunakan GitHub Action untuk menjalankan workflow yang saya buat, seperti ci.yml, scorecard.yml, dan sonarcloud.yml. Workflow yang disebutkan tersebut berjalan secara otomatis ketika ada push atau pull request ke suatu branch, sehingga saya telah berhasil menerapkan continuous integration (CI). Selain itu, untuk continuous deployment (CD), saya memanfaatkan platform Koyeb. Platform ini bekerja otomatis dengan men-deploy aplikasi saya setiap kali terjadi push atau pull request ke suatu branch. Gabungan CI/CD ini memberikan keuntungan dalam otomatisasi proses pengujian dan penyebaran aplikasi, meningkatkan efisiensi pengembangan dan keandalan aplikasi secara keseluruhan. Dengan implementasi ini, tim dapat lebih fokus pada pengembangan fitur dan perbaikan tanpa harus terlalu khawatir tentang proses pengujian dan deployment yang memakan waktu.
  
</details>
<details>
<summary>Tutorial 3</summary>
  
1. Explain what principles you apply to your project!
   1. single Responsibility Principle (SRP) memisahkan CarController pada pada productController ke file baru yaitu CarController.java.
   2. Liskov Substitution Principle (LSP) model car extends dari model product dan di model car menambahkan carColor.
   3. Liskov Substitution Principle (LSP) and Interface Segregation Principle (ISP) Membuat satu interface yaitu ProductService dengan type generic setelah itu CarServiceImpl dan ProductServiceImpl extends Product Service.
   4. Dependency Inversion Principle (DIP) yaitu dengan membuat abstraksiRepository dan carRepository, ProductRepository Extends AbstractRepository
2. Explain the advantages of applying SOLID principles to your project with examples.
   1. SRP : meningkatkan keterbacaan kode.
      contoh : memisahkan suatu file CarController dan ProductController.
   2. LSP : Memastikan kekonsistensian dalam menggunakan kelas turunan.
      contoh : Car model extend dari Product model dengan nambahin color di car model.
   3. ISP : menghindari implementasi yang tidak relevan pada kelas kelas yg ngga membutuhkannya.
      contoh : pengunaan interface pada productService dan CarServiceImpl,ProductServiceImpl mengimplementasi interface tsb.
   4. DIP : meningkatkan fleksibilitas dan mudahnya penggantian implementasi
      dengan nambahin abstractRepository class, productRepository dan CarRepository nge Extends.
3. Explain the disadvantages of not applying SOLID principles to your project with examples.
   1. SRP : kesulitan pemeliharaan kalo misalnya ngga gunain SRP soalnya bingung bug nya dimana kalo digabung gabung.
      contoh : seperti kode pada before solid saat CarController dan ProductController dalam 1 file.
   Selain itu, kode bisa jadi ngga flexible dan extensible karena ga gunain LSP sama ISP contohnya di LSP kita mau menambahkan suatu implementasi karena implementasi yang ada sangat spesifik makanya ngga bisa dimodifikasi.
</details>
<details>
<summary>Tutorial 4</summary>
1. TDD flow ini membantu saya dengan membuat alur pengembangan program menjadi lebih terarah karena saya menjadi tau apa saja yg harus include di implementasi nanti. Namun, saya mengalami kesulitan ketika membuat test seperti ada "argument was not thrown" padahal saya sudah mencantumkanya, setelah itu masih ada kebingungan dengan mock. Oleh karena itu saya merasa harus mempelajari lebih dalam
2. 
Fast: saya sudah memenuhi prinsip fast dengan memisahkan setiap test sehingga sehingga pengujian saya tidak bergantung pada pengujian lainnya.

Isolated: saya sudah memenuhi prinsip isolasi. Penggunaan mock objects dan setUp untuk mencegah duplikasi objek sudah diimplementasikan.

Repeatable: saya sudah memenuhi prinsip pengulangan. Dengan memastikan isolasi, setiap kali pengujian dilakukan, data yang digunakan di dalam test tetap konsisten.

Self-Validating: saya hanya menggunakan assert untuk validasi hasil, Saya menyadari bahwa masih banyak test yang memiliki banyak assert di dalamnya. Untuk memenuhi prinsip ini lebih baik, saya harus memisahkan setiap assert ke dalam test yang berbeda.

Thorough: Test saya sudah mencakup prinsip ini. Testnya mencakup semua kondisi happy dan unhappy, serta mencoba menginclude semua kemungkinan error.
</details>


