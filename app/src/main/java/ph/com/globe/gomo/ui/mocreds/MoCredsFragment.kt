package ph.com.globe.gomo.ui.mocreds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ph.com.globe.gomo.databinding.FragmentCredsBinding
import ph.com.globe.gomo.ui.base.BaseFragment

@AndroidEntryPoint
class MoCredsFragment : BaseFragment() {
    private var _binding: FragmentCredsBinding? = null
    private val moCredsViewModel: MoCredsViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCredsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moCredsViewModel.text.observe(viewLifecycleOwner) {
            binding.textDashboard.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
