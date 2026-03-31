package dev.toothlonely.starwarsapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.toothlonely.starwarsapp.data.BASE_URL
import dev.toothlonely.starwarsapp.data.character.CharacterService
import dev.toothlonely.starwarsapp.data.film.FilmService
import dev.toothlonely.starwarsapp.data.planet.PlanetService
import dev.toothlonely.starwarsapp.data.species.SpeciesService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProvidesModule {

    @Provides
    fun provideJson() = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    fun provideInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideClient(interceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, json: Json) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides
    @Singleton
    fun provideCharacterService(retrofit: Retrofit) = retrofit.create(CharacterService::class.java)

    @Provides
    @Singleton
    fun provideFilmService(retrofit: Retrofit) = retrofit.create(FilmService::class.java)

    @Provides
    @Singleton
    fun providePlanetService(retrofit: Retrofit) = retrofit.create(PlanetService::class.java)

    @Provides
    @Singleton
    fun provideSpeciesService(retrofit: Retrofit) = retrofit.create(SpeciesService::class.java)
}