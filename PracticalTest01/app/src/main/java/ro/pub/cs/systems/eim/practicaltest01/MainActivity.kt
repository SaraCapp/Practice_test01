package ro.pub.cs.systems.eim.practicaltest01

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variabile care retin numarul de apasari
    private var count1 = 0
    private var count2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Gasim elementele din XML
        val firstButton = findViewById<Button>(R.id.firstButton)
        val secondButton = findViewById<Button>(R.id.secondButton)

        val firstCounter = findViewById<TextView>(R.id.firstCounter)
        val secondCounter = findViewById<TextView>(R.id.secondCounter)

        // 2. Cand apasam primul buton
        firstButton.setOnClickListener {

            // Crestem primul contor cu 1
            count1++

            // Actualizam textul de pe ecran
            firstCounter.text = count1.toString()
        }

        // 3. Cand apasam al doilea buton
        secondButton.setOnClickListener {

            // Crestem al doilea contor cu 1
            count2++

            // Actualizam textul de pe ecran
            secondCounter.text = count2.toString()
        }
    }
}
