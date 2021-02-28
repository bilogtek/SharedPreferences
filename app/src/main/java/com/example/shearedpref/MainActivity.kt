package com.example.shearedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sp=getSharedPreferences("deneme_bilogtek",Context.MODE_PRIVATE)
        /*
        * MODE_APPEND : Yeni kaydedilen verileri mevcut verilen üzerine yazar.
MODE_ENABLE_WRITE_AHEAD_LOGGING : Veritabanı açık bayrağı. Ayarlandığında, varsayılan olarak önceden yazma günlük kaydını etkinleştirir
MODE_MULTI_PROCESS : Bu yöntem, paylaşılan tercih örneği zaten yüklenmiş olsa bile tercihlerde değişiklik olup olmadığını kontrol edecektir.
MODE_PRIVATE : Verilerin tutulduğu dosyaya sadece uygulamamız erişebilir.
MODE_WORLD_READABLE : Verilerin tutulduğu dosyayı cihazdaki tüm uygulamalar okuyabilir.
MODE_WORLD_WRITEABLE : Verilerin tutulduğu dosyayı cihazdaki tüm uygulamalar okuyabilir ve yazabilir.
* clear()Editor’daki tüm verileri siler.
remove(key:String)Anahtar değerini vererek dosyadan bir veriyi siler.
apply()Editor’daki verileri dosyaya yazar.
commit()Editor’daki verileri dosyaya  yazar.
putLong(key:String, value:Long )Editor’e Long tipinde bir veri kaydeder. Birinci parametre anahtar, ikinci parametre ise değerdir.
putInt(key:String, value:Int )
putFloat( key:String, value:Float )
putString( key:String, value:String )
putBoolean( key:String, value:Boolean )
* */
        var isim="Mehmet"
        var soyisim="Bilogtek"
        yaz.setOnClickListener(View.OnClickListener {
        isim=ad.text.toString()
        soyisim=soyad.text.toString()
            if (onay.isChecked==true){
                /* KAyıt yapılacak*/
                val yazar=sp.edit()
                yazar.putString("1.anahtar1",isim)
                yazar.putString("2.anahtar1",soyisim)
                yazar.apply()

                Toast.makeText(applicationContext,"Kayıt Başarılı Bir şekilde Gerçekleşti",Toast.LENGTH_LONG).show()
            }else{Toast.makeText(applicationContext,"Onay Seçilmedi",Toast.LENGTH_LONG).show()}

        })
        oku.setOnClickListener(View.OnClickListener {
            val spnisim=sp.getString("1.anahtar1","defİsim kayıtlı değil")
            val spsoyisim=sp.getString("2.anahtar1","defsoyisim kayıtlı değil")
            val metintext="KAyıtlı olan isim :$spnisim ve Kayıtlı olan Soyisim : $spsoyisim"
            tahta.setText(metintext)

        })


    }
}