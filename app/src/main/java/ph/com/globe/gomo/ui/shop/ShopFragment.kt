package ph.com.globe.gomo.ui.shop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import ph.com.globe.gomo.databinding.FragmentShopBinding
import ph.com.globe.gomo.ui.base.BaseFragment

@AndroidEntryPoint
class ShopFragment : BaseFragment() {

    private var _binding: FragmentShopBinding? = null
    private val shopViewModel : ShopViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentShopBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvCardboard
        shopViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}