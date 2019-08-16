package com.dkkovalev.ctowt.utils

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : AppCompatActivity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

fun <T : ViewModel> Fragment.getViewModel(
    modelClass: Class<T>,
    viewModelFactory: ViewModelProvider.Factory? = null
): T = viewModelFactory?.let { ViewModelProviders.of(this, it).get(modelClass) }
    ?: ViewModelProviders.of(this).get(modelClass)

inline fun <reified VM : ViewModel> Fragment.activityViewModelProvider(
    provider: ViewModelProvider.Factory
) =
    ViewModelProviders.of(this, provider).get(VM::class.java)

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.inTransaction {
        add(frameId, fragment, tag)
    }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.inTransaction {
        replace(frameId, fragment, tag)
        addToBackStack(tag)
    }
}

fun Fragment.replaceFragment(fragment: Fragment, frameId: Int, tag: String) {
    activity?.supportFragmentManager?.inTransaction {
        replace(frameId, fragment, tag)
    }
}

fun Fragment.replaceChildFragment(fragment: Fragment, frameId: Int, tag: String) {
    childFragmentManager.beginTransaction()
        .replace(frameId, fragment, tag)
        .commit()
}