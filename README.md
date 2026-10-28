# TP6 Mini Project — Agenda Tugas Siswa

**Nama siswa:** Wienju
**Kelas:** XI RPL

## Latar Belakang dan Masalah
Siswa sering lupa tugas yang belum selesai karena pencatatan tidak teratur. Program ini membantu mencatat dan memantau tugas sekolah beserta statusnya.

## Pengguna dan Tujuan
- Pengguna: siswa.
- Tujuan: mencatat, mencari, mengubah status, menghapus, dan melihat statistik tugas, serta menyimpan data agar tidak hilang saat program ditutup.

## Fitur Utama
1. Tambah tugas (ID unik, judul tidak boleh kosong)
2. Tampilkan daftar tugas
3. Cari tugas berdasarkan ID
4. Ubah status selesai / belum selesai
5. Simpan data ke berkas
6. Hapus tugas berdasarkan ID
7. Statistik tugas
0. Keluar (data otomatis disimpan)

## Teknologi dan Struktur Berkas
- Bahasa: Kotlin (aplikasi console), IntelliJ IDEA, Git dan GitHub.

| Berkas | Tanggung jawab |
|---|---|
| `src/Model.kt` | Data class `Tugas` |
| `src/TugasService.kt` | Operasi tambah, tampil, cari, ubah status, hapus, statistik |
| `src/Penyimpanan.kt` | Baca dan tulis data ke berkas |
| `src/InfoProyek.kt` | Menampilkan nama proyek |
| `src/Main.kt` | Menu, input pengguna, dan pemanggilan fitur |

Data disimpan di `agenda_tugas_tp6.txt` dengan format `id;judul;selesai`.

## Cara Menjalankan
1. Buka proyek di IntelliJ IDEA (JDK 17 atau lebih baru, plugin Kotlin).
2. Buka `src/Main.kt`.
3. Klik tombol Run di samping `fun main()`, lalu pilih `Run 'MainKt'`.

## Contoh Penggunaan atau Output
```
Proyek: TP6_MiniProject_Wienju
=== AGENDA TUGAS ===
1. Tambah tugas
2. Tampilkan tugas
...
Pilihan: 2
1. T01 | Membuat laporan | Selesai
```
[ISI: ganti dengan output nyata dari layar Anda]

## Hasil Pengujian

| No | Skenario | Hasil |
|---|---|---|
| 1 | Mulai tanpa berkas | Program dimulai dengan daftar tugas kosong. |
| 2 | Tambah tugas valid | Tugas berhasil ditambahkan jika ID unik dan judul tidak kosong. |
| 3 | ID duplikat | Program menolak penambahan tugas dengan ID yang sudah digunakan. |
| 4 | Judul kosong | Program menolak penambahan tugas karena judul tidak boleh kosong. |
| 5 | Cari ID ada / tidak ada | Program menampilkan tugas jika ditemukan dan pesan jika tugas tidak ditemukan. |
| 6 | Ubah status | Status tugas berhasil diubah menjadi selesai atau belum selesai. |
| 7 | Pilihan menu salah | Program menampilkan pesan pilihan tidak valid dan meminta input kembali. |
| 8 | Simpan dan buka ulang | Data tugas tetap tersimpan dan dapat ditampilkan kembali setelah program dijalankan ulang. |
| 9 | Berkas rusak | Perlu diuji untuk memastikan program dapat menangani data yang tidak valid tanpa berhenti secara tiba-tiba. |
| 10 | Hapus tugas dan statistik | Tugas berhasil dihapus dan statistik diperbarui sesuai jumlah tugas yang tersisa. |

**Catatan:** Hasil di atas merupakan hasil yang diharapkan berdasarkan fitur program. Lakukan pengujian langsung di IntelliJ IDEA untuk memastikan setiap skenario benar-benar berhasil.

## Pembagian Tugas dan Branch
Proyek dikerjakan individu.
- `main`: branch utama (stabil)
- `fitur-hapus`: fitur hapus tugas, digabung ke `main`
- `fitur-statistik`: fitur statistik tugas, digabung ke `main`

## Riwayat Pengembangan Ringkas
Total 7 commit: struktur awal, README (`docs`), nama proyek (`feat`), perbaikan teks status (`fix`), menu hapus (`feat`), perbaikan tampilan menu 6 (`fix`), dan menu statistik (`feat`).

## Keterbatasan dan Rencana Pengembangan
- Belum ada tanggal tenggat atau pengingat.
- Belum ada tampilan grafis dan hanya untuk satu pengguna.
- Rencana: fitur edit judul, filter berdasarkan status, dan pengurutan.