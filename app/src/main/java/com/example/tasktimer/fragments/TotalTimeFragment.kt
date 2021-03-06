package com.example.tasktimer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimer.R
import com.example.tasktimer.TotalTimeRecyclerView
import com.example.tasktimer.viewmodel.TaskViewModel

class TotalTimeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_total_time, container, false)

        val taskViewModel by lazy { TaskViewModel(requireActivity().application) }

        val rvMain = view.findViewById<RecyclerView>(R.id.rvMain)
        val adapter = TotalTimeRecyclerView(requireActivity().application, requireContext())
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(requireContext())

        taskViewModel.getAllTasks().observe(viewLifecycleOwner, {
            allTasks -> adapter.update(allTasks)
        })

        return view
    }

}