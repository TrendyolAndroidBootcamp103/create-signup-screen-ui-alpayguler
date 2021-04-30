package school.cactus.succulentshop

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.navigateActivity(cls: Class<*>) {
    startActivity(Intent(this, cls))
}

fun Int.resolveAsString(context: Context) = context.getString(this)
