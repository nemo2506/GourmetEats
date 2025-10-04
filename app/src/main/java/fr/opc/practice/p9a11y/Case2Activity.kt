package fr.opc.practice.p9a11y

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.opc.practice.p9a11y.databinding.ActivityCase2Binding
import fr.opc.practice.p9a11y.utils.toast

class Case2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCase2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCase2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var isFavourite = false
        setFavouriteButtonIcon(isFavourite)
        val product = getString(R.string.demo_cookie_text)
        binding.favouriteButton.setOnClickListener {
            isFavourite = !isFavourite
            setFavouriteButtonIcon(isFavourite)
            accessibilityFavorite(isFavourite, product)
        }

        binding.addRecipeToBasket.setOnClickListener {
            this@Case2Activity.toast(getString(R.string.recette_ajout_au_panier))
        }

        binding.recipeCard.setOnClickListener {
            // TODO navigate to recipe screen
        }
    }

    private fun setFavouriteButtonIcon(isFavourite: Boolean) {
        if (isFavourite) {
            binding.favouriteButton.setImageResource(R.drawable.ic_favourite_on)
        } else {
            binding.favouriteButton.setImageResource(R.drawable.ic_favourite_off)
        }
    }

    private fun accessibilityFavorite(isActivated: Boolean, product: String) {
        val message = getString(
            if (isActivated) R.string.favorite_added else R.string.favorite_removed,
            product
        )
        this@Case2Activity.toast(message)
    }
}
