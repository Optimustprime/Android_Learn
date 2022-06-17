package com.optiapp.androidlearn.data

import com.optiapp.androidlearn.R
import com.optiapp.androidlearn.model.Declaration

class DataSource {
    fun loadDelarations():List<Declaration>{
        return listOf<Declaration>(
            Declaration(R.drawable.programming),
            Declaration(R.drawable.androidstudio),
            Declaration(R.drawable.androidcomponents),
            Declaration(R.drawable.simpleuidesign),
            Declaration(R.drawable.complexuidesign),
            Declaration(R.drawable.storage),
            Declaration(R.drawable.threading),
            Declaration(R.drawable.debugging),
            Declaration(R.drawable.memoryleaks),
            Declaration(R.drawable.partylibraries),
            Declaration(R.drawable.androidjetpack),
            Declaration(R.drawable.architecture)

            )
    }
}