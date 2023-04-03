package com.aldy.mvp.modules

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import com.aldy.mvp.base.BaseActivity
import com.aldy.mvp.data.model.response.GetPokemonResp
import com.aldy.mvp.databinding.PokemonDetailActivityBinding
import com.bumptech.glide.Glide

class PokemonDetailActivity : BaseActivity(), PokemonDetailContract.ViewAction {
    var presenter: PokemonDetailPresenter? = null
    private lateinit var binding: PokemonDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PokemonDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = PokemonDetailPresenter(this)
        presenter!!.attachView(this)
        initView()
    }

    override fun initView() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(nameId: String?): Boolean {
                if (nameId != null) {
                    presenter?.getPokemon(nameId)
                    hideKeyboard()
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })
    }

    override fun setPokeData(resp: GetPokemonResp) {
        binding.detailLayout.visibility = View.VISIBLE
        binding.tvError.visibility = View.GONE
        binding.tvPokeName.text = resp.name
        Glide.with(this).load(resp.sprites.frontDefault).into(binding.ivPokeDefault)
    }

    override fun showLoading(isShow: Boolean) {
        if (isShow) {
            binding.loading.visibility = View.VISIBLE
            binding.detailLayout.visibility = View.GONE
        } else {
            binding.loading.visibility = View.GONE
            binding.detailLayout.visibility = View.VISIBLE
        }
    }

    override fun showError(message: String) {
        binding.detailLayout.visibility = View.GONE
        binding.tvError.visibility = View.VISIBLE
        binding.tvError.text = message
    }

    override fun onDestroy() {
        presenter?.doCleanupResources()
        presenter?.detachView()
        super.onDestroy()
    }
}