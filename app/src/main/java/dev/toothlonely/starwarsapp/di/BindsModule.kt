package dev.toothlonely.starwarsapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.toothlonely.starwarsapp.data.character.CharacterRepositoryImpl
import dev.toothlonely.starwarsapp.data.film.FilmRepositoryImpl
import dev.toothlonely.starwarsapp.data.planet.PlanetRepositoryImpl
import dev.toothlonely.starwarsapp.data.species.SpeciesRepositoryImpl
import dev.toothlonely.starwarsapp.domain.character.CharacterRepository
import dev.toothlonely.starwarsapp.domain.film.FilmRepository
import dev.toothlonely.starwarsapp.domain.planet.PlanetRepository
import dev.toothlonely.starwarsapp.domain.species.SpeciesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BindsModule {

    @Binds
    @Singleton
    fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository

    @Binds
    @Singleton
    fun bindFilmRepository(impl: FilmRepositoryImpl): FilmRepository

    @Binds
    @Singleton
    fun bindPlanetRepository(impl: PlanetRepositoryImpl): PlanetRepository

    @Binds
    @Singleton
    fun bindSpeciesRepository(impl: SpeciesRepositoryImpl): SpeciesRepository

}