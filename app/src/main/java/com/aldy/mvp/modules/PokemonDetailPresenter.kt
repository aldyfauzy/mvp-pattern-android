package com.aldy.mvp.modules

import com.aldy.mvp.base.BasePresenter
import com.aldy.mvp.data.model.response.GetPokemonResp
import com.aldy.mvp.network.ApiServices
import com.aldy.mvp.network.NetworkClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference

class PokemonDetailPresenter(activity: PokemonDetailActivity)
    : BasePresenter<PokemonDetailContract.ViewAction>(), PokemonDetailContract.Presenter{

    private val weakActivity = WeakReference(activity)
    private var lastRequest: Disposable? = null

    override fun getPokemon(nameId: String) {
        if (!isViewAttached()) return
        lastRequest?.dispose()
        mView?.showLoading(true)

        val observable = weakActivity.get()?.applicationContext?.let {
            NetworkClient().getRxInstance(it)
                .create(ApiServices::class.java)
                .getPokemon(nameId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
        }

        observable?.subscribe(object : Observer<GetPokemonResp>{
            override fun onSubscribe(d: Disposable) {
                lastRequest = d
            }

            override fun onNext(t: GetPokemonResp) {
                if (!isViewAttached()) return
                mView?.setPokeData(t)
            }

            override fun onError(e: Throwable) {
                mView?.showLoading(false)
                mView?.showError("not found")
            }

            override fun onComplete() {
                mView?.showLoading(false)
            }

        })
    }

    override fun doCleanupResources() {
        lastRequest?.dispose()
    }
}