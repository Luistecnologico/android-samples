package com.nippontic.unnittesting.basicsample

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class EmailValidator : TextWatcher {

    internal var isValid = false

    override fun afterTextChanged(ediatbleText: Editable) {
        isValid = isValidEmail(ediatbleText)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

    companion object {

        /**
         * Email validation pattern.
         */
        private val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        /**
         * Validates if the given input is a valid email address.
         *
         * @param email     The mail to validate.
         * @return `true`   if the input is a valid email, `false` otherwise.
         */
        fun isValidEmail(email: CharSequence): Boolean {
            return email != null && EMAIL_PATTERN.matcher(email).matches()
        }

    }
}