package com.example.pr19

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CrimeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CrimeFragment : Fragment() {
     lateinit var crime: Crime
      lateinit var titleField:EditText
      lateinit var DateButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime,container,false)
        titleField = view.findViewById(R.id.editTextText)
        DateButton = view.findViewById(R.id.button)
        DateButton.apply { text = crime.date.toString()
        isEnabled=false}

        return view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher
        {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int, count: Int,
                after: Int
            ) {
// Это пространство оставлено пустым

            }
            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int, before: Int,
                count: Int
            ) {
                crime.title = sequence.toString()
            }
            override fun
                    afterTextChanged(sequence: Editable?) {
// И это
            }
        }
        titleField.addTextChangedListener(titleWatcher)
    }
}

//    companion object {
//
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            CrimeFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
//}