package com.example.kasir

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPelanggan = findViewById<EditText>(R.id.editNamapelanggan)
        val namaBarang = findViewById<EditText>(R.id.editNamabarang)
        val jumlahBeli = findViewById<EditText>(R.id.editJumlahbeli)
        val hargaSatuan = findViewById<EditText>(R.id.editHargasatuan)
        val uangBayar = findViewById<EditText>(R.id.editUangbayar)
        val btnProses = findViewById<Button>(R.id.btnProses)

        val textHargaTotal= findViewById<TextView>(R.id.textHargatotal)
        val textUangkembali = findViewById<TextView>(R.id.textUangkembali)
        val textBonus = findViewById<TextView>(R.id.textbonus)
        val textketerangan = findViewById<TextView>(R.id.textketerangan)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnProses.setOnClickListener{
            var hargaBarang = Integer.parseInt(hargaSatuan.text.toString())
            var jmlBarang = Integer.parseInt(jumlahBeli.text.toString())
            var hargaTotal = hargaBarang * jmlBarang
            var Uangbayar = Integer.parseInt(uangBayar.text.toString())
            var Kembalian = Uangbayar - hargaTotal

            textHargaTotal.text = "Harga Total Rp." + hargaTotal
            textUangkembali.text = "Kembalian: " + if (Kembalian <=0) "Tidak Ada" else Kembalian

            if(hargaTotal >= 200000) {
                textBonus.text = "Bonus: Mouse"
            } else if (hargaTotal >= 400000) {
                textBonus.text = "Bonus: Keyboard"
            } else if (hargaTotal >=600000) {
                textBonus.text = "Bonus: Hardisk"
            } else {
                textBonus.text = "Bonus: Tidak Ada"
            }

            if (Kembalian == 0) {
                textketerangan.text = "Keterangan Uang Pas"
            } else if (Kembalian > 0) {
                textketerangan.text = "Keterangan: Menunggu Kembalian"
            } else {
                textketerangan.text = "Keterangan: Uang Kurang" + abs(Kembalian)
            }
        }

        btnReset.setOnClickListener {
            namaPelanggan.setText("")
            namaBarang.setText("")
            jumlahBeli.setText("")
            hargaSatuan.setText("")
            uangBayar.setText("")
            textHargaTotal.text = ("Harga Total:")
            textUangkembali.text = ("Kembalian:")
            textBonus.text = ("Bonus:")
            textketerangan.text = ("Keterangan:")
        }
    }
}