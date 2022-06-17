package com.optiapp.androidlearn.Fragments

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.optiapp.androidlearn.R
import com.optiapp.androidlearn.adapter.itemAdapter
import com.optiapp.androidlearn.data.DataSource
import com.optiapp.androidlearn.databinding.FragmentRoadmapBinding

class RoadmapFragment : Fragment() {
    private var _binding: FragmentRoadmapBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon: NavController
    private lateinit var recyclerView: RecyclerView
    private var isGridLayoutManager=true

    var myDataSource= DataSource().loadDelarations()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRoadmapBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.foodlist
//        recyclerView.adapter=itemAdapter(this,myDataSource)
        change()
    }

    private fun change() {
        if(isGridLayoutManager){
            recyclerView.layoutManager= GridLayoutManager(requireContext(),1)

        }
        else{
            recyclerView.layoutManager= StaggeredGridLayoutManager(3, LinearLayoutManager.HORIZONTAL)
            var toast= Toast.makeText(requireContext(),"StaggaredGrid: Swipe Left", Toast.LENGTH_LONG)
            toast.show()

        }
        recyclerView.adapter= itemAdapter(requireContext(),myDataSource)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
    private fun seticon(menuItem: MenuItem){
        if(menuItem==null){
            return
        }
        menuItem.icon=
            if(isGridLayoutManager)
                ContextCompat.getDrawable(requireContext(),R.drawable.ic_baseline_view_quilt_24)

            else{
                ContextCompat.getDrawable(requireContext(),R.drawable.ic_baseline_view_list_24)
            }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.layout_menu,menu)
        val layoutButton= menu?.findItem(R.id.action_switch)
        if (layoutButton != null) {
            seticon(layoutButton)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_switch ->{
                isGridLayoutManager= !isGridLayoutManager
                change()
                seticon(item)
                return true

            }
            R.id.contact->{
                view?.let { Navigation.findNavController(it).navigate(R.id.action_roadmapFragment_to_contactFragment) };
                return true
            }
            R.id.about->{
                view?.let { Navigation.findNavController(it).navigate(R.id.action_roadmapFragment_to_aboutFragment) };
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}