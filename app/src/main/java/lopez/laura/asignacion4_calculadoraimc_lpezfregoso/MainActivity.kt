package lopez.laura.asignacion4_calculadoraimc_lpezfregoso

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(){

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Variables
        //val nombreVariable: TipoElemento = findViewById(R.id.idElemento) as TipoElemento
        val weight : EditText = findViewById(R.id.weight) as EditText
        val height : EditText = findViewById(R.id.height) as EditText

        val imc : TextView = findViewById(R.id.imc) as TextView
        val range : TextView = findViewById(R.id.range) as TextView

        val button: Button = findViewById(R.id.btnCalcular) as Button

        //Evento button
        button.setOnClickListener { view ->
            val a = calcularIMC(weight.text.toString().toDouble(), height.text.toString().toDouble())
            val categoria = calcularCategoria(a)
            imc.setText(a.toString())
            range.setText(categoria)

            when(categoria) {
                "Bajo peso" -> range.setBackgroundColor(R.color.colorBrown)
                "Normal" -> range.setBackgroundColor(R.color.colorGreen)
                "Sobrepeso" -> range.setBackgroundColor(R.color.colorGreenish)
                "Obesidad grado 1" -> range.setBackgroundColor(R.color.colorOrange)
                "Obesidad grado 2" -> range.setBackgroundColor(R.color.colorYellow)
                "Obesidad grado 1" -> range.setBackgroundColor(R.color.colorRed)
            }
        }
    }
    //funcion
    fun calcularIMC(w: Double, h:Double) = w/(h*h)


    fun calcularCategoria(imc: Double): String {
        if (imc < 18.5) {
            return "Bajo peso"
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Normal"
        } else if (imc >= 25 && imc <= 29.9) {
            return "Sobrepeso"
        } else if (imc >= 30 && imc <= 34.9){
            return "Obesidad grado 1"
        } else if (imc >= 35 && imc <= 39.9){
            return "Obesidad grado 1"
        }
        return "Obesidad grado 3"
    }
}