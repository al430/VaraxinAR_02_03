import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class LogIn : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)





    }

    fun signin(view: View) {
        if(email.text.toString().isNullOrEmpty() && password.text.toString().isNotEmpty()) {

            val intent = Intent(this,Menu::class.java)
            startActivity(intent)

        }
        else {
            val alert = AlertDialog.Builder(this)
                .setTitle("ошибка!!!")
                .setMessage("у вас есть пустые поля")
                .setPositiveButton("ок", null)
                .create()
                .show()
        }

    }
}