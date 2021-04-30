package school.cactus.succulentshop


class SignUpPasswordValidator : Validator {
    private val specialCharacters = "-@%\\[\\}+'!/#$^?:;,\\(\"\\)~`.*=&\\{>\\]<_"
    private val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$specialCharacters])(?=\\S+$).{8,39}$"

    override fun validate(field: String) =
            when {
                field.isEmpty() -> R.string.password_is_required
                field.length < 7 -> R.string.password_is_too_short
                field.length > 40 -> R.string.password_is_too_long
                passwordPattern.toRegex().matches(field).not() -> R.string.password_must_contain_one_digit_etc
                else -> null
            }
 }