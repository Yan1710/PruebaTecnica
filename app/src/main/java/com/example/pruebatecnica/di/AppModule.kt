package com.example.pruebatecnica.di

import android.app.Application
import androidx.room.Room
import com.example.pruebatecnica.data.local.AppDatabase
import com.example.pruebatecnica.data.local.LocalDataSource
import com.example.pruebatecnica.data.local.dao.CommentDao
import com.example.pruebatecnica.data.local.dao.PostDao
import com.example.pruebatecnica.data.remote.ApiService
import com.example.pruebatecnica.data.remote.PostRemoteDataSource
import com.example.pruebatecnica.data.repository.PostRepositoryImpl
import com.example.pruebatecnica.domain.repository.PostRepository
import com.example.pruebatecnica.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideRemoteDataSource(api: ApiService) = PostRemoteDataSource(api)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "pruebatecnica_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun providePostDao(db: AppDatabase): PostDao = db.postDao()

    @Provides
    fun provideCommentDao(db: AppDatabase): CommentDao = db.commentDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(postDao: PostDao, commentDao: CommentDao) =
        LocalDataSource(postDao, commentDao)

    @Provides
    @Singleton
    fun providePostRepository(remote: PostRemoteDataSource, local: LocalDataSource): PostRepository =
        PostRepositoryImpl(remote, local)

    // UseCases
    @Provides fun provideSyncPostsUseCase(repo: PostRepository) = SyncPostsUseCase(repo)
    @Provides fun provideGetPostsUseCase(repo: PostRepository) = GetPostsUseCase(repo)
    @Provides fun provideInsertCommentUseCase(repo: PostRepository) = InsertCommentUseCase(repo)
    @Provides fun provideGetCommentsUseCase(repo: PostRepository) = GetCommentsUseCase(repo)
}
