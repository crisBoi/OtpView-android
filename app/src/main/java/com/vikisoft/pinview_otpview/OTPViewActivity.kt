package com.vikisoft.pinview_otpview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import androidx.annotation.RequiresApi
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

        editText!!.setOnKeyListener { view, i, keyEvent ->
           /* if (editText.text.isEmpty())
            {*/
                if (keyEvent.keyCode == KeyEvent.KEYCODE_DEL) {
                    if (editText.text.isEmpty())
                    when(editText) {
                        otp_et2 -> enablePrevious(otp_et2, otp_et1)
                        otp_et3 -> enablePrevious(otp_et3, otp_et2)
                        otp_et4 -> enablePrevious(otp_et4, otp_et3)
                        otp_et5 -> enablePrevious(otp_et5, otp_et4)
                        otp_et6 -> enablePrevious(otp_et6, otp_et5)

                    }
                }

                else if(!editText.text.isEmpty()){

                    when(editText) {
                        otp_et1 -> disablePrevious(otp_et1, otp_et2)
                        otp_et2 -> disablePrevious(otp_et2, otp_et3)
                        otp_et3 -> disablePrevious(otp_et3, otp_et4)
                        otp_et4 -> disablePrevious(otp_et4, otp_et5)
                        otp_et5 -> disablePrevious(otp_et5, otp_et6)

                    }
//                }
            }
            false
        }




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
