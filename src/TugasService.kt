class TugasService(private val daftar: MutableList<Tugas>) {
    fun tambah(id: String, judul: String): Boolean {
        val idBersih = id.trim()
        val judulBersih = judul.trim()
        if (idBersih.isBlank() || judulBersih.isBlank()) return false
        // ';' dipakai sebagai pemisah di berkas penyimpanan, jadi tidak boleh ada di ID.
        if (';' in idBersih) return false
        if (daftar.any { it.id.equals(idBersih, ignoreCase = true) }) return false
        daftar.add(Tugas(idBersih, judulBersih))
        return true
    }

    fun tampilkan() {
        if (daftar.isEmpty()) {
            println("Belum ada tugas")
            return
        }
        for ((indeks, tugas) in daftar.withIndex()) {
            val status = if (tugas.selesai) "Selesai" else "Belum selesai"
            println("${indeks + 1}. ${tugas.id} | ${tugas.judul} | $status")
        }
    }

    fun cari(id: String): Tugas? = daftar.find { it.id.equals(id.trim(), ignoreCase = true) }

    fun ubahStatus(id: String): Boolean {
        val tugas = cari(id) ?: return false
        tugas.selesai = !tugas.selesai
        return true
    }

    // Fitur tambahan sesuai jobsheet: menghapus tugas berdasarkan ID.
    fun hapus(id: String): Boolean {
        val tugas = cari(id) ?: return false
        return daftar.remove(tugas)
    }

    fun statistik(): Pair<Int, Int> = daftar.count { it.selesai } to daftar.count { !it.selesai }
}
