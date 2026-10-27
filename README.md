# TP6 Mini Project — Agenda Tugas Siswa

**Nama siswa:** Wienju

## Deskripsi masalah
Siswa sering lupa tugas yang belum selesai karena pencatatan tidak teratur. Program console Kotlin ini membantu mencatat, mencari, mengubah status, dan menghapus tugas, serta menyimpannya ke berkas agar tidak hilang saat program ditutup.
Program Kotlin berbasis console untuk mencatat tugas siswa.

## Fitur
- Menampilkan daftar tugas
- Menambahkan tugas dengan ID unik dan judul yang tidak boleh kosong
- Mencari tugas berdasarkan ID
- Mengubah status selesai/belum selesai
- Menghapus tugas berdasarkan ID
- Menampilkan statistik tugas
- Menyimpan data ke `data/tugas.txt` agar tetap tersedia saat program dijalankan kembali

## Struktur berkas
- `src/Model.kt`: model data tugas
- `src/TugasService.kt`: operasi dan aturan pengelolaan tugas
- `src/Penyimpanan.kt`: baca/tulis data
- `src/Main.kt`: menu dan interaksi pengguna

## Persyaratan
IntelliJ IDEA dengan plugin Kotlin dan JDK 17 atau lebih baru.

## Menjalankan
1. Buka project di IntelliJ IDEA.
2. Buka `src/Main.kt`.
3. Klik tombol Run di samping `fun main()`, lalu pilih `Run 'MainKt'`.

Data disimpan relatif terhadap folder kerja saat program dijalankan, di `data/tugas.txt`.