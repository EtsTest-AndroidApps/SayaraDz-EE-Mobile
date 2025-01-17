package sayaradz.ui.fragment.editMyAnnonce

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EditAnnonceViewModelFactory(val annonceId: String, val token: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditAnnonceViewModel::class.java)) {
            return EditAnnonceViewModel(annonceId, token) as T
        } else
            throw IllegalArgumentException("Unknown ViewModel class")
    }


}