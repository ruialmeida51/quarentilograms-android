package com.ruialmeida.quarentilograms.shared.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.shared.viewmodel.BaseDataBindingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * A base data binding activity that abstracts the layout initialization and binding.
 */
abstract class BaseNavigationDataBindingActivity<Component : ViewDataBinding, ViewModel: BaseDataBindingViewModel> (@LayoutRes val defaultLayout: Int, @IdRes val navHostId: Int, viewModelClass: KClass<ViewModel>) : FragmentActivity() {

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
     * Provides easy access to the binding component, view model class and navigation host.
     *
     * Note: It's important to bind the view model to our data binding, if we declared it
     * our XML data tag.
     */
    abstract fun handleInteractions(binding: Component, viewModel: ViewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, defaultLayout)
        binding.lifecycleOwner = this

        handleInteractions(binding, viewModel)
    }

    /**
     * Returns our current nav host fragment.
     */
    fun getNavHostFragment() = supportFragmentManager.findFragmentById(navHostId) as NavHostFragment
}