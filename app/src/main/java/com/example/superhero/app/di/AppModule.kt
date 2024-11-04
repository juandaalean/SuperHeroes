package com.example.superhero.app.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module


@Module
@ComponentScan("com.example.superhero.features.superheroes")
class AppModule {
}