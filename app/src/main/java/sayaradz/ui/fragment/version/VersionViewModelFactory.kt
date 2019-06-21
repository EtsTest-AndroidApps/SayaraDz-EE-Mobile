package sayaradz.ui.fragment.version

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sayaradz.ui.fragment.model.ModelViewModel
import java.lang.IllegalArgumentException

class VersionViewModelFactory(val modelId: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VersionViewModel::class.java)){
            return VersionViewModel(modelId) as T
        }else
            throw IllegalArgumentException("Unknown ViewModel class")
    }
}