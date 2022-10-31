package io.github.sabbib.chowdhury.base.network.di

import io.github.sabbib.chowdhury.base.network.connection.ConnectionManager
import io.github.sabbib.chowdhury.base.network.interceptor.RequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.sabbib.chowdhury.base.network.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(
        connectionManager: ConnectionManager,
    ): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor(connectionManager))

        if (BuildConfig.DEBUG) {
            val httpLogging = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            okHttpBuilder.addInterceptor(httpLogging)
        }
        return okHttpBuilder.build()
    }
}
