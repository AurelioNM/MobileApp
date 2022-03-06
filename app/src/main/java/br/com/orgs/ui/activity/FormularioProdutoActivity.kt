package br.com.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.orgs.R
import br.com.orgs.dao.ProdutosDao
import br.com.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)

        val campoNome = findViewById<EditText>(R.id.nome)
        val campoDescricao = findViewById<EditText>(R.id.descricao)
        val campoValor = findViewById<EditText>(R.id.valor)

        val dao = ProdutosDao()

        botaoSalvar.setOnClickListener {
            val nome = campoNome.text.toString()
            val descricao = campoDescricao.text.toString()
            val valorEmTexto = campoValor.text.toString()

            val valor = if (valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            dao.adiciona(produtoNovo)
            finish()
        }
    }

}