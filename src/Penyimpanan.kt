import java.io.File
import java.util.Base64

object Penyimpanan {
    // Penanda format baru. Tanpa penanda, judul dianggap teks biasa (format lama),
    // sehingga judul seperti "Test" tidak keliru didekode sebagai Base64.
    private const val PREFIKS = "b64:"

    fun muat(file: File): MutableList<Tugas> {
        val hasil = mutableListOf<Tugas>()
        if (!file.exists()) return hasil
        file.forEachLine { baris ->
            // Format: id;judul;selesai -> id = sebelum ';' pertama, status = setelah ';' terakhir.
            val awal = baris.indexOf(';')
            val akhir = baris.lastIndexOf(';')
            if (awal < 0 || akhir <= awal) return@forEachLine
            val id = baris.substring(0, awal).trim()
            val mentah = baris.substring(awal + 1, akhir)
            val judul = if (mentah.startsWith(PREFIKS)) {
                try {
                    String(Base64.getDecoder().decode(mentah.removePrefix(PREFIKS)), Charsets.UTF_8)
                } catch (e: IllegalArgumentException) {
                    return@forEachLine
                }
            } else {
                mentah // format lama: teks biasa
            }
            val selesai = baris.substring(akhir + 1).trim().toBooleanStrictOrNull() ?: return@forEachLine
            if (id.isNotBlank() && judul.isNotBlank() && hasil.none { it.id.equals(id, true) }) {
                hasil.add(Tugas(id, judul, selesai))
            }
        }
        return hasil
    }

    fun simpan(file: File, data: List<Tugas>) {
        file.parentFile?.mkdirs()
        val teks = data.joinToString("\n") {
            val judulEncoded = Base64.getEncoder().encodeToString(it.judul.toByteArray(Charsets.UTF_8))
            "${it.id};$PREFIKS$judulEncoded;${it.selesai}"
        }
        file.writeText(teks)
    }
}
