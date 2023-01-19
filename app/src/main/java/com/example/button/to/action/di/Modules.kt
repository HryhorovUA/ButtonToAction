package com.example.button.to.action.di

import com.example.button.to.action.common.NetworkConstants
import com.example.button.to.action.data.repository.ActionsRepositoryImpl
import com.example.button.to.action.data.retrofit.ActionsService
import com.example.button.to.action.domain.repository.ActionsRepository
import com.example.button.to.action.ui.actions.ActionsViewModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Modules {

    val main = module {
        viewModel { ActionsViewModel(get()) }
    }

    val data = module {
        single { GsonBuilder().setLenient().create() }
        single {
            OkHttpClient()
                .newBuilder()
                .build()
        }

        single {
            Retrofit.Builder()
                .client(get())
                .baseUrl(NetworkConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(get()))
                .build()
        }

        single { get<Retrofit>().create(ActionsService::class.java) }
        single<ActionsRepository> { ActionsRepositoryImpl(get()) }
    }
}