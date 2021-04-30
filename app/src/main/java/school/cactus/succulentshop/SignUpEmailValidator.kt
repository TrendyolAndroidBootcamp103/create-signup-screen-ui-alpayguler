package school.cactus.succulentshop

import java.util.regex.Pattern

class SignUpEmailValidator : Validator {
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun validate(field: String) =
        when {
            field.isEmpty() -> R.string.email_is_required
            field.length < 5 -> R.string.identifier_is_too_short
            field.length > 50 -> R.string.email_is_too_longer
            emailPattern.toRegex().matches(field).not() -> R.string.email_must_contain_at_sign_and_dot
            else -> null
        }

}


