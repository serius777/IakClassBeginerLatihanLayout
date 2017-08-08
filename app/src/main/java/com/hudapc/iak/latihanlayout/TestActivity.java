package com.hudapc.iak.latihanlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity
{
    static final String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        /** ini baris komentar pada java, diabaikan oleh compiler saat dicompile
         * TODO 2.1 Akses Widget/View
         * Buat Objek untuk mengakses widget atau EditText yang ada di layout
         * Untu mengakses Widget/View yang ada di layout ikuti langkah berikut :
         * 1. Buat Objek terlebih dahulu.
         *      JenisWidget namaObjekWidget;
         * Contoh:
         *     EditText editText;
         * 2. berikan refrensi objek yang ada di layout ke objek yang barusan dibuat
         *    dengan menggunakan method findViewById(int id). Contoh
         *    editText = (EditText) findViewById(R.id.etName);
         * penjelasan:
         * setiap kita membuat objek dari class tertentu, objek itu berisi nilai kosong.
         * proses asignment (=) atau pemberian nilai pada ke objek merupakan memberi alamat memori
         * objek asli, ke objek yang baru dibuat.
         */

        /**
         * menggunakan method findViewById(int id)
         * method ini memerlukan 1 parameter integer (int) ketika dipanggil.
         * widget/view yang diambil dengan method ini harus di-Casting ke bentuk class-nya terlebih dahulu.
         * jadi format pemhanggilannya
         * namaObjekWidget = (JenisWidget) findViewById(R.id.id_yang_diset_di_layout_untuk_widget);
         */
        EditText etName = (EditText) findViewById(R.id.etName);
        // cara di atas sama saja dengan cara yang ada pada contoh.
        // kode di atas membuat objek untuk widget EditText dengan nama objek etName, lalu diambil
        // dari layout dengan id etName.

        /**
         * TODO 2.2 memanipulasi isi content dari widget/view
         * panggil method yang dimiliki oleh objek.
         * Widget EditText, Button, TextView, CheckBox, RadioButton memiliki method setText(String teks)
         * yang berguna untuk mengisi teks yang akan ditampilkan ke pengguna.
         * mehod setText(String teks) memerlukan 1 parameter String ketika dipanggil.
         *      namaObjekWidget.setText("tulis teks di sini");
         */
        etName.setText("Halo IAK");
        // kode di atas memanipulasi objek etName dengan memanggil method setText(String teks)-nya.
        // teks yang diberikan adalah Halo IAK

        /**
         * setiap widget yang memiliki method setText(String teks) juga memiliki method getText().
         * method getText() akan memberikan teks apa yang sedang ditampilkan oleh widget tersebut.
         * teks yang diberikan belum berupa objek String. Untuk mengubah teks yang diambil ke bentuk
         * objek String, panggil method toString() setelah method getText().
         *     String namaObjekString = namaObjekWidget.getText().toString();
         */

        /**
         * Setiap widget/view memiliki method setEnabled(boolean enable) yang berguna untuk mengatur
         * apakah widget itu dapat digunakan oleh pengguna atau tidak.
         *      namaObjek.setEnabled(true/false)
         * true berarti widget dapat diakses oleh pengguna.
         * false berarti widget tidak dapat diakses oleh pengguna.
         *
         * Dasar akses dan manipulasi widget/view di layout sudah selesai, silahkan jalankan aplikasi.
         * sebagai tambahan, coba lakukan beberapa percobaan untuk memanipulasi widget sebelum lanjut ke poin 3.
         */
        TextView tvSummary = (TextView) findViewById(R.id.tvSummary);
        tvSummary.setText("Detail PEsanan");

        /**
         * TODO 4.3 memberikan objek Button kemampuan untuk menghandle Event Click
         * 1. akses widget Button pada layout yang akan diberikan interaksi kemmapuan interaksi
         *    (ingat lagi cara mengakses widget pada layout).
         * 2. buat sebuah objek dari inner class yang sudah kita buat sebelumnya
         *      nama_inner_class objekInnerClass;
         * 3. berikan nilai ke objek inner class yang baru dibuat tadi
         *       objekInnerClass = new nama_inner_class();
         *    kata kunci new berarti kita mnciptakan sebuah objek baru dari sebuah class. setelah itu
         *    objek memori objek baru itu akan diberikan ke objek yabg kita buat.
         * 4. panggil method setOnClickListener(OnClickListener listener) dari objek Button yang sudah dibuat pada
         *    langkah nomor 1. lalu masukkan objek inner class yang sudah dibuat tadi sebagai paremeter sebagai
         *    masukkan parameter method itu.
         *      objekWidgetButton.setOnClickListener(objekInnerClass);
         */
        Button bOrder = (Button) findViewById(R.id.bOrder);
        OnClickHandler handler = new OnClickHandler();
        // cara di atas sama dengan contoh nomor 2 dan 3.
        bOrder.setOnClickListener(handler);

        // sampai sini poin 4 sudah selesai. kita bisa lanjut ke poin nomor 5. atau sebagai tambahan
        // kita bisa melakukan manipulasi widget ketika Button di klik, atau memanggil method
        // yang sudah dibuat pada poin 3 di dalam badan method onClick(View view) yang ada pada inner class.
        // contoh
        //     public void onClick(View a){
        //          nama_fungsi_di_poin_3(a); // cukup tambahkan baris ini saja. hamya bisa berhasil kalau
        //                                    // metthod pada poin nomor 3 belum dihapus.
        //     }

        Toast.makeText(this, "APlikasi Dibuka", Toast.LENGTH_LONG).show();
    }

    /** TODO 3.2 membuat fungsi yang akan dipanngil ketika Button diklik
     * setelah menulis nama method yang akan dipanggil pada XML, saatnya untuk membuat method itu di Activity.
     * Kita harus membuat method itu agar bisa dieksekusi ketika user menekan tombol.
     * Method itu harus dibuat dengan format seperti ini
     *      public void nama_method(View v){
     *          ...badan fungsi...
     *      }
     * setelah itu tulis perintah yang akan dieksekusi di dalam method tersebut untuk dieksekusi
     * ketika Button diklik.
     */
    public void bOrderClicked(View view)
    {
        Toast.makeText(this, "Horeee diklik", Toast.LENGTH_LONG).show();
        // Objek Toast adalah salah semacam notifikasi yang muncul pada layar perangkat bagian bawah
        // dengan latar berwarna hitam, serta akan hilang setelah muncul beberapa saat.
        // Class Toast memiliki method static yang dapat menciptakan objek Toast.
        // method itu adalah makeText(Context context, String teks, int durasi).
        // durasi yang diperlukan adalah Toast.LENGTH_LONG atau Toast.LENGTH_SHORT
        // method show() digunakan untuk menampilkan Objek Toast ke layar.
        // cara di atas sama dengan
        //    Toast nama_objek; //ingat pertama objek ini baru dibuat dan bernilai null
        //    nama_objek = Toast.makeText(this, "Horeee diklik", Toast.LENGTH_LONG); // berikan alamat
        //                 memori Objek Toast yang baru di buat ke Objek Toast kita.
        //    nama_objek.show(); // tampilkan

        // kata kunci this berarti memanggil alamat memori Objek diri sendiri.
        // setiap objek yang berbeda dari class yang sama memiliki data alamat yang berbeda.
        // untuk itu kata kunci this digunakan untuk merujuk memori objek diri mereka masing-masing
        // dalam kasus ini this berarti alamat memori dari objek Activity ini (class TestActivity).

        // poin 3 selesai. silahkan compile dan jalankan aplikasi ini, lalu coba apakah ada toast yang muncul
        // di layar bawah (seharusnya ada). Sebagai tambahan jika berhasil, silahkan lakukan beberapa manipulasi Widget,
        // seperti setText, ataupun getText.
        // silahkan lanjut ke poin 4
    }

    /**
     * TODO 4.2 membuat Inner Class yang menggunakan Interface View.OnClickListener
     * pada dasarnya Event klik di tangani oleh Interface View.OnClickListener. Interface adalah Class
     * yang seluruh methodnya bersifat abstrak (tidak memiliki badan method)
     *      public void onClick(View v); //contoh dalah satu abstrack method
     * hal ini dimungkinkan karena implementasi fungsi diserahkan ke Class yang menggunakannya untuk diisi.
     * Perbedaan Interface drngan Class adalah
     * - Interface semua methodnya bersifat abstrak, sedangkan Class beberapa methodnya dapat berupa
     *    abstrak, sehingga Class itu menjadi abstract Class
     * - Class yang ingin mewarisi Method dari sebuah Interface, harus menggunakan kata kunci implements.
     *    sedangkan untuk mewarisi Class atau abstract Class harus menggunakan kata kunci extends.
     * - sebuah Class dapat mengimplementasi lebih dari satu Interface
     *      Class A implements InterfaceA, InterfaceB, InterfaceC{
     *          ....
     *      }
     *    sedangkan Class hanya dapat men-extends 1 Class untuk dijadikan induknya
     */

    /**
     * buat Class yang dan implementasikan Interface View.OnClickListener pada Class itu
     *      public class nama_inner_class implements View.OnClickListener{
     *          ....
     *      }
     */
    public class OnClickHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            // Interface View.OnClickListener hanya memiliki 1 method yang harus diisi ketika diimpementasikan
            // pada sebuah class. method itu harus sama persis penulisannya dan tidak boleh berbeda
            //      public void onClick(View view)  // nama parameter tidak apa2 berbeda asalkan Objek
            //           parameternya sama, dalam kasus ini adalah Objek View
            // method ini akan dipanggil oleh sistem ketika Tombol di tekan

            Toast.makeText(TestActivity.this, "Horeee diklik", Toast.LENGTH_LONG).show();
            // coba kita munculkan objek Toast dulu
            // ada yang lain dengan kata kunci this?
            // seperti yang kita ketahui kata kunci this berarti merujuk ke memori objek itu sendiri.
            // Lalu karena kita menggunakan kata kunci this pada Class nama_inner_class yang merupakan
            // inner Class di dalam Class dalam kasus ini Class TestActivity, maka komputer tetap memperlakukan
            // objek mereka seperti Class pada umumnya, yaitu diletakkan pada memori yang berbeda.
            // Jadi kata kunci this pada inner class akan merujuk ke memori objek inner class itu sendiri.
            //
            // Inner class dapat memanggil memori objek class tempatnya bernaung dengan cara
            //      class_luar.this
            // dalam kasus ini adalah
            //      TestActivity.this
            // yang berarti merujuk ke memori objek TestActivity itu sendiri.
            //
            // kenapa tidak Toast tidak bisa menggunakan this di dalam objek ini?
            // class nama_inner_class ini merupakan class turunan dari class Object secara langsung
            // (semua class yang tidak melakukan extends merupakan turunan class Object). Untuk
            // class_luar tidak langsung menjadi turunan dari class Object tetapi dari class Activity sebagai
            // class parent-nya. class Activity masih memiliki parent class lagi, dan parent class tersebut juga memilki
            // parent class lagi, terus seperti itu, hingga terakhir ke sebuah class Context (tentu class Context
            // juga turunan dari class Object).
            // yang diperlukan oleh method
            //    makeText(Context, context, String teks, int surasi)
            // pada parameter pertama adalah objek Context, dan Class Activity adalah turunan dari class Context
            // yang diturunkan dari parent class Activity.
            // berbeda dengan class nama_inner_class yang langsung berupa turunan dari class Object, tentu
            // memiliki garis keturunan yang berbeda (kita bisa asumsikan beda spesies).
            //
            // silakan lanjut ke poin 4 selanjutnya
        }
    }
}
