package school.cactus.succulentshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    private val signUpUsernameValidator = SignUpUsernameValidator()
    private val signUpEmailValidator = SignUpEmailValidator()
    private val signUpPasswordValidator = SignUpPasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBarTitle()
        initClickEvents()
    }

    private fun initClickEvents() {
        binding.apply {
            signUpActivitySignUpButton.setOnClickListener {
                checkValidation()
            }
            signUpActivityAlreadyHaveAnAccountButton.setOnClickListener {
                navigateActivity(LoginActivity::class.java)
            }
        }
    }

    private fun setSupportActionBarTitle() {
        supportActionBar?.title = getString(R.string.sign_up)
    }

    private fun TextInputLayout.validate() {
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString(context)
        isErrorEnabled = errorMessage != null
    }

    private fun TextInputLayout.validator() = when (this) {
        binding.signUpActivityMailInputLayout -> signUpEmailValidator
        binding.signUpActivityUsernameInputLayout -> signUpUsernameValidator
        binding.signUpActivityPasswordInputLayout -> signUpPasswordValidator
        else -> throw IllegalArgumentException(getString(R.string.cannot_find_any_validator_message))
    }

    private fun checkValidation() {
        binding.apply {
            signUpActivityMailInputLayout.validate()
            signUpActivityUsernameInputLayout.validate()
            signUpActivityPasswordInputLayout.validate()
        }
    }
}