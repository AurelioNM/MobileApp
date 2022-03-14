package br.com.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.orgs.databinding.FormularioImagemBinding
import br.com.orgs.extensions.tentaCarregarImagem

class FormularioImagemDialog(
    private val context: Context
) {

    fun show(
        urlPadrao: String? = null,
        quandoImagemCarregada: (imagem: String) -> Unit
    ) {
         FormularioImagemBinding
             .inflate(LayoutInflater.from(context)).apply {

                urlPadrao?.let {
                    formularioImagemImageview.tentaCarregarImagem(it)
                    formularioImagemUrl.setText(it)
                }

                 formularioImagemBotaoCarregar.setOnClickListener {
                     val url = formularioImagemUrl.text.toString()
                     formularioImagemImageview.tentaCarregarImagem(url)
                 }

                 AlertDialog.Builder(context)
                     .setView(root)
                     .setPositiveButton("Confirmar") { _, _ ->
                         val url = formularioImagemUrl.text.toString()
                         quandoImagemCarregada(url)
                     }
                     .setNegativeButton("Cancelar") {_, _ ->

                     }
                     .show()
            }



    }

}