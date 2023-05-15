package com.mshabiola.database.di

import com.mshabiola.database.TempDatabase
import com.mshabiola.database.dao.modeldao.IModelDao
import com.mshabiola.database.dao.modeldao.ModelDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val databaseModule :Module


internal val daoModules=module{
    single {
        get<TempDatabase>().modelQueries
    }
     single { Dispatchers.IO } bind CoroutineDispatcher::class
    singleOf(::ModelDao) bind IModelDao::class
 }
