package de.jensklingenberg.jkdaggerexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import de.jensklingenberg.jkdaggerexample.model.Post
import de.jensklingenberg.jkdaggerexample.network.TestApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var testApi: TestApi

    private fun initializeDagger() = App.appComponent.inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeDagger()

        testApi.getPostList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<Response<List<Post>>>() {
                override fun onSuccess(response: Response<List<Post>>) {
                    val list = response.body()
                    Log.d("JKDaggerExample", list?.size.toString())
                }

                override fun onError(e: Throwable) {}
            })
    }
}

