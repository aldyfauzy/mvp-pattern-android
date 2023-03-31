package com.aldy.mvp

import com.aldy.mvp.modules.PokemonDetailActivity
import com.aldy.mvp.modules.PokemonDetailContract
import com.aldy.mvp.modules.PokemonDetailPresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class PokemonDetailPresenterTest {

    @Mock
    private lateinit var view: PokemonDetailContract.ViewAction
    @Mock
    val activity = PokemonDetailActivity()

    @Spy
    private var presenter: PokemonDetailPresenter = PokemonDetailPresenter(activity)

    @Before
    fun setUp() {
        presenter.attachView(view)
    }

    @Test
    fun test_getPokemonDetail_calls_onPokemonDetailReceived_on_positive_response() {
    }

    @Test
    fun test_getPokemonDetail_calls_onPokemonDetailReceived_on_exception() {
    }
}