package com.ruialmeida.quarentilograms.shared.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ruialmeida.quarentilograms.shared.viewmodel.BaseDataBindingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * A base data binding fragment that abstracts the layout initialization.
 */
abstract class BaseDataBindingFragment<Component : ViewDataBinding, ViewModel: BaseDataBindingViewModel> (@LayoutRes val defaultLayout: Int, viewModelClass: KClass<ViewModel>) : Fragment() {

    /**
     * Lazily inject our view model using [viewModel] by koin.
     *
     * @see <a href="https://stackoverflow.com/questions/48777536/how-to-initialize-inject-generic-viewmodel-in-baseactivity-by-koin-injection-on">Generic View Model Injection using Koin</a>
     */
    private val viewModel: ViewModel by viewModel(clazz = viewModelClass)

    /**
     * Save a reference to our binding component.
     */
    private lateinit var binding: Component

    /**
     * Provides easy access to the binding component and the view model class.
     *
     * Note: It's important to bind the view model to our data binding, if we declared it
     * our XML data tag.
     */
    abstract fun handleInteractions(binding: Component, viewModel: ViewModel)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, defaultLayout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        handleInteractions(binding, viewModel)

        return binding.root
    }
}