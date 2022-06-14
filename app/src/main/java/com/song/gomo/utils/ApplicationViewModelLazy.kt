package com.song.gomo.utils

import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.song.gomo.GomoApplication
import kotlin.reflect.KClass


@MainThread
inline fun <reified VM : ViewModel> ComponentActivity.applicationViewModels(
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = null
): Lazy<VM> = createViewModelLazy(
    VM::class, { (application as GomoApplication).viewModelStore },
    factoryProducer ?: { (application as GomoApplication).getDefaultFactory() }
)

@MainThread
inline fun <reified VM : ViewModel> Fragment.applicationViewModels(
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = null
): Lazy<VM> = createViewModelLazy(
    VM::class, { (requireActivity().application as GomoApplication).viewModelStore },
    factoryProducer ?: { (requireActivity().application as GomoApplication).getDefaultFactory() }
)

@MainThread
fun <VM : ViewModel> ComponentActivity.createViewModelLazy(
    viewModelClass: KClass<VM>,
    storeProducer: () -> ViewModelStore,
    factoryProducer: (() -> ViewModelProvider.Factory)? = null
): Lazy<VM> {
    val factoryPromise = factoryProducer ?: {
        (application as GomoApplication).getDefaultFactory()
    }
    return ViewModelLazy(viewModelClass, storeProducer, factoryPromise)
}

@MainThread
fun <VM : ViewModel> Fragment.createViewModelLazy(
    viewModelClass: KClass<VM>,
    storeProducer: () -> ViewModelStore,
    factoryProducer: (() -> ViewModelProvider.Factory)? = null
): Lazy<VM> {
    val factoryPromise = factoryProducer ?: {
        (requireActivity().application as GomoApplication).getDefaultFactory()
    }
    return ViewModelLazy(viewModelClass, storeProducer, factoryPromise)
}
