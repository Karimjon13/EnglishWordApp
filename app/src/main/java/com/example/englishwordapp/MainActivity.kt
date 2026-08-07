package com.example.englishwordapp
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.englishwordapp.databinding.ActivityLearnWordBinding
class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityLearnWordBinding
    private var _binding : ActivityLearnWordBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityLearnWordBinding must not be null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLearnWordBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
            //нейтральный
            //корректный
            //некорректный
        binding.layoutAnswer3.setOnClickListener {
           markAnswerCorrect()
        }
    }
    fun markAnswerCorrect() {
    binding.layoutAnswer3.background = ContextCompat.getDrawable(
        this@MainActivity,
        R.drawable.shape_rounded_containers
    )
        binding.tvVariantNumber3.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants
        )
        binding.tvVariantNumber3.setTextColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.white
                )
            )
        binding.tvVariantValue3.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                        R.color.correctAnswerColor
            )
        )
    }
}