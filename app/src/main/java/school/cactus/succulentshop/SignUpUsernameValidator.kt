package school.cactus.succulentshop

import java.util.regex.Pattern

class SignUpUsernameValidator : Validator {
    private val usernamePattern = "[a-z0-9_]+"

    override fun validate(field: String) =
        when {
            field.isEmpty() -> R.string.username_is_required
            field.length < 2 -> R.string.username_is_too_short
            field.length > 20 -> R.string.username_is_too_long
            usernamePattern.toRegex().matches(field).not() -> R.string.username_must_not_consist_characters_except_az_09_
            else -> null
        }
}

