package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId, view)

        // ✅ Back button goes back to ListFragment
        val backButton = view.findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun setCoffeeData(coffeeId: Int, view: View) {
        val title = view.findViewById<TextView>(R.id.coffee_title)
        val desc = view.findViewById<TextView>(R.id.coffee_description)

        when (coffeeId) {
            R.id.affogato -> {
                title.text = "Affogato"
                desc.text = "Espresso poured over vanilla ice cream."
            }
            R.id.americano -> {
                title.text = "Americano"
                desc.text = "Espresso diluted with hot water."
            }
            R.id.latte -> {
                title.text = "Latte"
                desc.text = "Espresso with steamed milk and foam."
            }
            R.id.espresso -> {
                title.text = "Espresso"
                desc.text = "Strong, concentrated coffee shot."
            }
            R.id.cappuccino -> {
                title.text = "Cappuccino"
                desc.text = "Espresso with steamed milk and a thick layer of foam."
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
