package ph.com.globe.gomo.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ph.com.globe.gomo.databinding.FragmentShopBinding
import ph.com.globe.gomo.ui.base.BaseFragment

@AndroidEntryPoint
class ShopFragment : BaseFragment() {
    private var _binding: FragmentShopBinding? = null
    private val shopViewModel: ShopViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shopViewModel.text.observe(viewLifecycleOwner) {
            binding.tvCardboard.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
