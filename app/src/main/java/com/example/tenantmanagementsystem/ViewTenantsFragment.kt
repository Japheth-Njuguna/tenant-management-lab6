package com.example.tenantmanagementsystem

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tenantmanagementsystem.databinding.FragmentViewTenantsBinding

class ViewTenantsFragment : Fragment() {

    private var _binding: FragmentViewTenantsBinding? = null
    private val binding get() = _binding!!

    // SAFE ARGS: reads the arguments sent with the action
    private val args: ViewTenantsFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onCreateView")
        _binding = FragmentViewTenantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onViewCreated")

        // The tenant sent from Add Tenant, or null if we came from the Dashboard/menu
        val newTenant = args.newTenant

        // DATA BINDING: feeds @{tenant.summary()} in the layout
        binding.tenant = newTenant

        // No new tenant? Hide "Just added", the box and the Call button together
        if (newTenant == null) {
            binding.newTenantGroup.visibility = View.GONE
        }

        // CALL TENANT: implicit Intent to open the dialer
        binding.callButton.setOnClickListener {
            if (newTenant != null) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${newTenant.phone}"))
                startActivity(intent)
            }
        }

        // Show every saved tenant
        val tenants = TenantRepository.tenants
        if (tenants.isEmpty()) {
            binding.allTenantsTextView.text = "No tenants yet. Add one from the Dashboard."
        } else {
            binding.allTenantsTextView.text = tenants.joinToString("\n\n") { it.summary() }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TENANT_LIFECYCLE", "   ViewTenantsFragment: onDetach")
    }
}
