package fr.opc.practice.p9a11y

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.accessibility.AccessibilityEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import fr.opc.practice.p9a11y.databinding.ActivityCase3Binding
import fr.opc.practice.p9a11y.utils.toast

class Case3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCase3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCase3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.pseudoEdit.doOnTextChanged { text, _, _, _ ->
            text?.length?.let { textLength ->
                val isValid = textLength > 2
                binding.validateButton.isEnabled = isValid
                if (isValid) {
                    messageAccessibility(getString(R.string.username_valid, text))
                    returnToEdit()
                }
                binding.pseudoEdit.backgroundTintList = if (textLength > 2) {
                    ColorStateList.valueOf(resources.getColor(R.color.green400, theme))
                } else {
                    ColorStateList.valueOf(resources.getColor(R.color.red400, theme))
                }
            }
        }
        binding.validateButton.isEnabled = false

        binding.validateButton.setOnClickListener{
            messageAccessibility(getString(R.string.connected))
        }

    }

    private fun returnToEdit() {
        binding.pseudoEdit.post {
            binding.pseudoEdit.requestFocus()
            binding.pseudoEdit.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
        }
    }

    private fun messageAccessibility(message: String) {
        this@Case3Activity.toast(message)
    }

}
