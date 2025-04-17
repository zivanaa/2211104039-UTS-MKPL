 UTS MKPL - Refactoring TaxCalculator

NIM: 2211104039 
Nama: Zivana Afra Yulianto  
Mata Kuliah: Manajemen Kualitas Perangkat Lunak  
Tanggal Pengerjaan: 17 April 2025

 Deskripsi Proyek
Proyek ini merupakan bagian dari Ujian Tengah Semester (UTS) mata kuliah Manajemen Kualitas Perangkat Lunak. Tujuan utama adalah melakukan refactoring pada aplikasi TaxCalculator untuk memperbaiki berbagai "bad smells" yang teridentifikasi dalam kode.

 Struktur Proyek
- `Employee.java` - Kelas yang mengelola data karyawan dan perhitungan pajak
- `TaxFunction.java` - Kelas utilitas untuk perhitungan pajak

 Daftar Bad Smells yang Diperbaiki

 1. PerhitunganGajiTidakKonsisten-Employee
Branch: `PerhitunganGajiTidakKonsisten-Employee`  
Masalah: Perhitungan gaji untuk karyawan asing tidak konsisten  
Solusi: Memastikan gaji dasar yang benar digunakan untuk karyawan asing di semua grade  

 2. KesalahanPenetapanIdPasangan-Employee 
Branch: `KesalahanPenetapanIdPasangan-Employee`  
Masalah: ID karyawan ditugaskan ke ID pasangan  
Solusi: Memperbaiki pemetaan variabel yang benar untuk ID pasangan  

 3. AngkaMagis-EmployeeTaxFunction
Branch: `AngkaMagis-EmployeeTaxFunction`  
Masalah: Banyak "magic numbers" dalam kode  
Solusi: Mengganti angka-angka dengan konstanta bernama yang deskriptif  

 4. LogikaBooleanTidakKonsisten-Employee
Branch: `LogikaBooleanTidakKonsisten-Employee`  
Masalah: Logika boolean untuk status pernikahan tidak konsisten  
Solusi: Menggunakan logika yang lebih jelas untuk menentukan status pernikahan  

 5. PerbaikanVariableTidakJelas-Employee.gender
Branch: `PerbaikanVariableTidakJelas-Employee-gender`  
Masalah: Variabel `gender` tidak deskriptif  
Solusi: Mengganti nama variabel menjadi `isLakiLaki` untuk dokumentasi diri yang lebih baik  

 6. KesalahanJumlahPotonganAnak-TaxFunction
Branch: `KesalahanJumlahPotonganAnak-TaxFunction`  
Masalah: Nilai potongan pajak untuk anak tidak sesuai (1,5 juta seharusnya 4,5 juta)  
Solusi: Memperbaiki nilai konstanta `PENGHASILAN_TIDAK_KENA_PAJAK_ANAK`  

 7. ImportTidakDigunakan-Employee
Branch: `ImportTidakDigunakan-Employee`  
Masalah: Import `java.time.Month` tidak digunakan  
Solusi: Menghapus import yang tidak terpakai  

 8. DuplikasiKode-Employee.setMonthlySalary
Branch: `DuplikasiKode-Employee-setMonthlySalary`  
Masalah: Duplikasi logika dalam penentuan gaji berdasarkan grade  
Solusi: Menggunakan struktur switch untuk mengurangi duplikasi  

 9. PenangananErrorTidakTepat-TaxFunction
Branch: `PenangananErrorTidakTepat-TaxFunction`  
Masalah: Menggunakan `System.err.println` untuk penanganan error  
Solusi: Mengganti dengan exception handling yang tepat (`IllegalArgumentException`)  

 Manfaat Refactoring
1. Peningkatan Keterbacaan: Penggunaan konstanta bernama membuat kode lebih mudah dibaca
2. Pengurangan Bug: Memperbaiki beberapa kesalahan logika dan perhitungan
3. Pemeliharaan Lebih Mudah: Struktur kode yang lebih bersih dan terorganisir
4. Performa yang Lebih Baik: Menghilangkan kode yang tidak perlu dan import yang tidak digunakan
5. Penanganan Error yang Lebih Baik: Menggunakan exception alih-alih output ke console

 Catatan Pengembangan
- Setiap refactoring dilakukan pada branch terpisah sesuai dengan nama bad smell
- Pull request dibuat untuk setiap refactoring agar bisa direview secara independen
- Perubahan dilakukan secara bertahap untuk memastikan kode tetap berfungsi dengan baik
- Pengujian manual dilakukan setelah setiap refactoring untuk memverifikasi fungsionalitas
