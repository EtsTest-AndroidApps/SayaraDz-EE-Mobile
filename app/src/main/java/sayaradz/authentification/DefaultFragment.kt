package sayaradz.authentification

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DefaultFragment: Fragment() {
    companion object {
        fun getInstance() = DefaultFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.default_fragment, container, false)

        return rootView
    }
}