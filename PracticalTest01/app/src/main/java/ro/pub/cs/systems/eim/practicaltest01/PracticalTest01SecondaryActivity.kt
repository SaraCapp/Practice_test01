package ro.pub.cs.systems.eim.practicaltest01

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_secondary)

        // 1. Primim suma din prima activitate
        val total = intent.getIntExtra("TOTAL_CLICKS", 0)

        // 2. Gasim elementele din XML
        val totalText = findViewById<TextView>(R.id.totalText)
        val okButton = findViewById<Button>(R.id.okButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)

        // 3. Afisam suma primita
        totalText.text = total.toString()

        // 4. Cand apasam OK
        okButton.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        // 5. Cand apasam CANCEL
        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
