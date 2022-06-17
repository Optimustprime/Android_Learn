package com.optiapp.androidlearn.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.optiapp.androidlearn.R
import com.optiapp.androidlearn.databinding.FragmentDetailsBinding
import kotlin.properties.Delegates

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon: NavController
    private lateinit var letterId:String
    private var letterCode by Delegates.notNull<Int>()


    companion object{
        const val CODE="code"
        const val LETTER="letter"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var image=binding.imageView
        var text=binding.textView2
//        Log.v("test",letterId.toString())

        arguments?.let{
            letterCode=it.getInt(CODE)
            letterId=it.getString(LETTER).toString()
        }

//        var item = listOf<String>(List<Declaration>)
//        Log.v("test1",item.stringResource.toString())

//        val code = intent?.extras?.getInt("code")
//        Log.v("test1",code.toString())
//
        if (letterCode != null) {
            image.setImageResource(letterCode)
        }
        Log.v("test1",letterId.toString())

        if(letterId.toString()=="0"){
            text.setText("Android software development is the process by which applications are created for devices running the Android operating system. Google states that \"Android apps can be written using Kotlin, Java, and C++ languages\" using the Android software development kit, while using other languages is also possible")

        }
        if(letterId=="1"){
            text.setText("Android Studio is the official integrated development environment for Google's Android operating system, built on JetBrains' IntelliJ IDEA software and designed specifically for Android development.")
        }
        if(letterId=="2"){
            text.setText("Application components are the essential building blocks of an Android application. These components are loosely coupled by the application manifest file AndroidManifest.xml that describes each component of the application and how they interact.")
        }


    }

}