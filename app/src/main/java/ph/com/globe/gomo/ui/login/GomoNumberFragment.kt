package ph.com.globe.gomo.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ph.com.globe.gomo.databinding.FragmentGomoNumberBinding
import ph.com.globe.gomo.ui.base.ToolbarFragment

class GomoNumberFragment : ToolbarFragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentGomoNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGomoNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
    }
}
