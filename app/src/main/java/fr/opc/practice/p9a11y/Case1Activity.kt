package fr.opc.practice.p9a11y

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.opc.practice.p9a11y.databinding.ActivityCase1Binding
import fr.opc.practice.p9a11y.utils.toast
import androidx.core.view.ViewCompat
import android.view.accessibility.AccessibilityEvent

class Case1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCase1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCase1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var quantity = 0

        binding.quantityText.text = "$quantity"

        binding.addButton.setOnClickListener {
            quantity++
            binding.quantityText.text = "$quantity"
            accessibilityQuantity(quantity)
        }

        binding.removeButton.setOnClickListener {
            if (quantity > 0) {
                quantity--
                binding.quantityText.text = "$quantity"
                accessibilityQuantity(quantity)
            } else {
                this@Case1Activity.toast(getString(R.string.impossible_d_avoir_une_quantit_n_gative))
            }
        }
    }

    private fun accessibilityQuantity(quantity: Int) {
//            val description = getString(R.string.quantity_description, quantity)
//            ViewCompat.setStateDescription(binding.quantityText, description)
//            binding.quantityText.requestFocus()
//            binding.quantityText.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED)
        val message: String = getString(R.string.quantity_accessibility, quantity)
        this@Case1Activity.toast(message)
    }
}
