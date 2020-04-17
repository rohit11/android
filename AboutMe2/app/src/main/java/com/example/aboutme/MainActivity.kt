package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private val myName: MyName = MyName("Rohit Nisal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            clickHandlerFunction(it)
        }

        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun clickHandlerFunction(viewThatIsClicked : View){
        addNickName(viewThatIsClicked)
    }

    private fun addNickName(view : View){
        binding.apply {
            myName?.nickname = binding.nicknameEdit.text.toString()
            binding.nicknameText.visibility = View.VISIBLE
            view.visibility = View.GONE
            binding.nicknameEdit.visibility = View.GONE
            invalidateAll()
        }
        hideKeyBoard(view)
    }

    private fun updateNickname (view: View) {
        binding.apply {
            binding.nicknameEdit.visibility = View.VISIBLE
            done_button.visibility = View.VISIBLE
            view.visibility = View.GONE
        }
        // Set the focus to the edit text.
        binding.nicknameEdit.requestFocus()
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput( binding.nicknameEdit, 0)
    }

    private fun hideKeyBoard(view : View) {
        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
