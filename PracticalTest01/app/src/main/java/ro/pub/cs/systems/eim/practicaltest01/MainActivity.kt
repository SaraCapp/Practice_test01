package ro.pub.cs.systems.eim.practicaltest01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    // Contoarele noastre
    private var count1 = 0
    private var count2 = 0

    // Primim raspunsul de la a doua activitate
    private val secondaryLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->

        if (result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "CANCEL", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Gasim elementele din XML
        val firstButton = findViewById<Button>(R.id.firstButton)
        val secondButton = findViewById<Button>(R.id.secondButton)

        val firstCounter = findViewById<TextView>(R.id.firstCounter)
        val secondCounter = findViewById<TextView>(R.id.secondCounter)

        val navigateButton = findViewById<Button>(R.id.navigateButton)

        // 2. Restauram contoarele dupa recrearea activitatii
        if (savedInstanceState != null) {
            count1 = savedInstanceState.getInt("count1", 0)
            count2 = savedInstanceState.getInt("count2", 0)
        }

        firstCounter.text = count1.toString()
        secondCounter.text = count2.toString()

        // 3. Primul buton
        firstButton.setOnClickListener {
            count1++
            firstCounter.text = count1.toString()
        }

        // 4. Al doilea buton
        secondButton.setOnClickListener {
            count2++
            secondCounter.text = count2.toString()
        }

        // 5. Navigam la a doua activitate
        navigateButton.setOnClickListener {

            // Calculam suma
            val total = count1 + count2

            // Pregatim Intent-ul
            val intent = Intent(
                this,
                PracticalTest01SecondaryActivity::class.java
            )

            // Trimitem suma
            intent.putExtra("TOTAL_CLICKS", total)

            // Deschidem activitatea si asteptam rezultatul
            secondaryLauncher.launch(intent)
        }
    }

    // 6. Salvam valorile contoarelor
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count1", count1)
        outState.putInt("count2", count2)

        super.onSaveInstanceState(outState)
    }
}
