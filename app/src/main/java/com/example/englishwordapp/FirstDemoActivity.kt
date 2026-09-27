package com.example.englishwordapp

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.englishwordapp.databinding.ActivityFirstDemoBinding

import java.io.Serializable

class FirstDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val word = ExtraWord(
            "galaxy",
            "галактика"
        )
        binding.btnOpenSecond.setOnClickListener {
            val intent = Intent(this@FirstDemoActivity, SecondDemoActivity::class.java).apply {
                putExtra("EXTRA_KEY_TEXT", "don't panic")
                putExtra("EXTRA_KEY_NUMBER", 42)
                putExtra("EXTRA_KEY_WORD", word)
            }

//            val bundle = Bundle()
//            bundle.putString("EXTRA_KEY_TEXT", "don't panic")
//            bundle.putInt("EXTRA_KEY_NUMBER", 42)
//            bundle.putSerializable("EXTRA_KEY_WORD", word)
            intent.putExtras(
                bundleOf(
                    "EXTRA_KEY_TEXT" to "don't panic",
                    "EXTRA_KEY_NUMBER" to 42,
                    "EXTRA_KEY_WORD" to word
                )
            )
            startActivity(intent)
        }
    }

    data class ExtraWord(
        val original: String,
        val translate: String,
        var learned: Boolean = false,
    ) : Serializable
//    data class ExtraWord(
//        val original: String,
//        val translate: String,
//        var learned: Boolean = false,
//    ): Parcelable {
//        override fun describeContents(): Int {
//        return 0
//        }
//
//        override fun writeToParcel(p0: Parcel, p1: Int) {
//p0.writeString(original)
//p0.writeString(translate)
//p0.writeByte(if (learned)1 else 0)
//        }
//        constructor(parcel: Parcel) : this(
//            original = parcel.readString().toString(),
//            translate = parcel.readString().toString(),
//            learned = parcel.readByte() !=0.toByte()
//        )
//        companion object CREATOR :  Parcelable.Creator<ExtraWord> {
//            override fun createFromParcel(p0: Parcel): ExtraWord? {
//               return ExtraWord(p0)
//            }
//
//            override fun newArray(p0: Int): Array<out ExtraWord?>? {
//return  arrayOfNulls(p0)
//            }
//        }
//    }
}