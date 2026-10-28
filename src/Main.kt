import java.io.File
fun main() {
    tampilkanNamaProyek()

    val file = File("agenda_tugas_tp6.txt")
    val daftar = Penyimpanan.muat(file)
    val service = TugasService(daftar)
    var pilihan: Int
    do {
        println("\n=== AGENDA TUGAS ===")
        println("1. Tambah tugas")
        println("2. Tampilkan tugas")
        println("3. Cari tugas")
        println("4. Ubah status")
        println("5. Simpan data")
        println("6. Hapus data")
        println("7. Statistik tugas")
        println("0. Keluar")
        print("Pilihan: ")
        pilihan = readln().toIntOrNull() ?: -1
        when (pilihan) {
            1 -> {
                print("ID tugas: ")
                val id = readln()
                print("Judul tugas: ")
                val judul = readln()
                println(if (service.tambah(id, judul))
                    "Tugas ditambahkan" else "Data tidak valid atau ID duplikat")
            }
            2 -> service.tampilkan()
            3 -> {
                print("ID yang dicari: ")
                val hasil = service.cari(readln())
                println(
                    if (hasil == null) "Tugas tidak ditemukan"
                    else "${hasil.id} | ${hasil.judul} | ${if (hasil.selesai) "Selesai" else "Belum selesai"}"
                )
            }
            4 -> {
                print("ID tugas: ")
                println(if (service.ubahStatus(readln()))
                    "Status diubah" else "Tugas tidak ditemukan")
            }
            5 -> {
                Penyimpanan.simpan(file, daftar)
                println("Data disimpan")
            }
            6 -> {
                print("ID tugas yang dihapus: ")
                println(if (service.hapus(readln())) "Tugas dihapus" else "Tugas tidak ditemukan")
            }
            7 -> {
                val (selesai, belum) = service.statistik()
                println("Selesai: $selesai | Belum selesai: $belum | Total: ${selesai + belum}")
            }
            0 -> {
                Penyimpanan.simpan(file, daftar)
                println("Program selesai")
            }
            else -> println("Pilihan tidak tersedia")
        }
    } while (pilihan != 0)
}
