package com.segared.controlviviendas.core.di

import android.content.Context
import androidx.room.Room
import com.segared.controlviviendas.core.data.DatabaseRepository
import com.segared.controlviviendas.core.data.SegaredDatabase
import com.segared.controlviviendas.core.data.SegaredDatabaseDao
import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.advertisements.data.network.AdvertisementsClient
import com.segared.controlviviendas.usecases.dashboard.data.network.DashboardClient
import com.segared.controlviviendas.usecases.login.data.network.LoginClient
import com.segared.controlviviendas.usecases.signup.data.network.SignupClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideSegaredDao(segaredDatabase: SegaredDatabase): SegaredDatabaseDao =
        segaredDatabase.segaredDao()

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SegaredDatabase =
        Room.databaseBuilder(
            context,
            SegaredDatabase::class.java,
            "segared_database"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideDatabaseRepository(dao: SegaredDatabaseDao) = DatabaseRepository(dao)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.KREA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginClient(retrofit: Retrofit): LoginClient {
        return retrofit.create(LoginClient::class.java)
    }

    @Singleton
    @Provides
    fun provideDashboardClient(retrofit: Retrofit): DashboardClient {
        return retrofit.create(DashboardClient::class.java)
    }

    @Singleton
    @Provides
    fun provideAdvertisementsClient(retrofit: Retrofit): AdvertisementsClient {
        return retrofit.create(AdvertisementsClient::class.java)
    }

    @Singleton
    @Provides
    fun providesSignupClient(retrofit: Retrofit): SignupClient {
        return retrofit.create(SignupClient::class.java)
    }
}