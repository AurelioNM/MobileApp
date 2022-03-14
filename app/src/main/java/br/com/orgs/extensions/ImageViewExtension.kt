package br.com.orgs.extensions

import android.widget.ImageView
import br.com.orgs.R
import coil.load

fun ImageView.tentaCarregarImagem(url: String? = null) {
    load(url) {
        fallback(R.drawable.imagem_padrao)
        error(R.drawable.imagem_padrao)
        placeholder(R.drawable.imagem_padrao)
    }
}