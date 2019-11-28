package com.vikisoft.pinview_otpview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class OTPViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        setDisable()
        onOtpEntered(otp_et1)
    }

    private fun setDisable() {
        disableEditText(otp_et2)
        disableEditText(otp_et3)
        disableEditText(otp_et4)
        disableEditText(otp_et5)
        disableEditText(otp_et6)
    }

    fun disableEditText(editText: EditText?) {
        if (editText != null) {
            editText.isEnabled = false
        }

    }
    
    private fun onOtpEntered(editText: EditText?) {


        editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().isEmpty()) {
                    editText.setOnKeyListener { view, i, keyEvent ->
                       /* if (keyEvent.keyCode == KeyEvent.KEYCODE_DEL) {
                            when(editText) {
                                otp_et2 -> enablePrevious(otp_et2, otp_et1)
                                otp_et3 -> enablePrevious(otp_et3, otp_et2)
                                otp_et4 -> enablePrevious(otp_et4, otp_et3)
                                otp_et5 -> enablePrevious(otp_et5, otp_et4)
                                otp_et6 -> enablePrevious(otp_et6, otp_et5)

                            }
                        }*/
                        true
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when(editText) {
                    otp_et1 -> disablePrevious(otp_et1, otp_et2)
                    otp_et2 -> disablePrevious(otp_et2, otp_et3)
                    otp_et3 -> disablePrevious(otp_et3, otp_et4)
                    otp_et4 -> disablePrevious(otp_et4, otp_et5)
                    otp_et5 -> disablePrevious(otp_et5, otp_et6)

                }
            }
        })
    }


    private fun enablePrevious(currentEditText: EditText, previousEditText : EditText?) {
        disableEditText(currentEditText)
        if (previousEditText != null) {
            previousEditText.isEnabled = true
            previousEditText.requestFocus()
        }

    }

    private fun disablePrevious(currentEditText: EditText, nextEditText : EditText?) {

        onOtpEntered(nextEditText)

        disableEditText(currentEditText)
        if (nextEditText != null) {
            nextEditText.isEnabled = true
            nextEditText.requestFocus()
        }
    }
}
