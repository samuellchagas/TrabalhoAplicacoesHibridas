package com.example.masterquizzfinal

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.masterquizzfinal.LoginFragment.Companion.BEARER
import com.example.masterquizzfinal.databinding.FragmentSubjectsBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import kotlin.random.Random

class SubjectFragment : Fragment() {

    private val binding: FragmentSubjectsBinding by lazy {
        FragmentSubjectsBinding.inflate(layoutInflater)
    }
    private val apiService = ApiService
        .getEndPointInstance("https://masterquizapi.herokuapp.com/")
    private val listButtons by lazy {
        listOf(binding.altA, binding.altB, binding.altC, binding.altD)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preference = requireContext().getSharedPreferences("preference", Context.MODE_PRIVATE)
        val bearerToken = preference.getString(BEARER, "") ?: ""

        viewLifecycleOwner.lifecycleScope.launch {
            oneRoundOfGame(
                bearerToken = bearerToken,
                view = view,
                scorePoins = 0,
                countRound = 0,
                randomAnt = -1
            )
        }

    }

    private fun selectButtom(id: Int) {
        listButtons.forEachIndexed { index, view ->
            if (id == index) {
                view.setBackgroundColor(Color.YELLOW)
            } else {
                view.setBackgroundColor(Color.parseColor("#FF03DAC5"))
            }
        }
    }

    suspend fun oneRoundOfGame(
        bearerToken: String,
        view: View,
        scorePoins: Int,
        countRound: Int,
        randomAnt: Int
    ) {
        selectButtom(-1)
        binding.pointsScoreText.text = scorePoins.toString()
        if (countRound == 10) {
            binding.apply {
                backgroundQuestion.visibility = View.GONE
                listButtons.forEach {
                    it.visibility = View.GONE
                }
                btnConfirm.visibility = View.GONE
            }
            AlertDialog
                .Builder(requireContext())
                .setTitle("Parabens")
                .setMessage("Vc acertou $scorePoins de 10")
                .show()
        } else {
            var randomNumber = 0
            var clickAnswer = 0
            var answerCorrect = 0
            val responseQuest = apiService.getQuestions("Bearer $bearerToken")
            if (responseQuest.isSuccessful) {
                responseQuest.body()?.let { listQuests ->
                    do {
                        randomNumber = Random.nextInt(0, listQuests.size)
                    } while (randomAnt == randomNumber)
                    binding.questText.text = listQuests[randomNumber].descricaoquestao
                    val responseAnswer = apiService
                        .getAnswerById("Bearer $bearerToken", listQuests[randomNumber].id)
                    if (responseAnswer.isSuccessful) {
                        responseAnswer.body()?.let { listAnswer ->
                            binding.apply {
                                altA.text = listAnswer[0].descricaoresposta
                                altA.setOnClickListener {
                                    selectButtom(0)
                                    clickAnswer = 1
                                }
                                altB.text = listAnswer[1].descricaoresposta
                                altB.setOnClickListener {
                                    selectButtom(1)
                                    clickAnswer = 2
                                }
                                altC.text = listAnswer[2].descricaoresposta
                                altC.setOnClickListener {
                                    selectButtom(2)
                                    clickAnswer = 3
                                }
                                altD.text = listAnswer[3].descricaoresposta
                                altD.setOnClickListener {
                                    selectButtom(3)
                                    clickAnswer = 4
                                }
                                listAnswer.forEachIndexed { index, answer ->
                                    if (answer.idtcorreta == 1) {
                                        answerCorrect = index + 1
                                    }
                                }
                                btnConfirm.setOnClickListener {
                                    if (clickAnswer == 0) {
                                        view.snackBar(
                                            message = "Selecione uma alternativa",
                                            colorText = Color.BLACK,
                                            colorBackground = Color.BLUE
                                        )
                                    } else if (clickAnswer == answerCorrect) {
                                        view.snackBar(
                                            message = "Vc acertou a resposta",
                                            colorText = Color.BLACK,
                                            colorBackground = Color.GREEN
                                        )
                                        viewLifecycleOwner.lifecycleScope.launch {
                                            oneRoundOfGame(
                                                bearerToken = bearerToken,
                                                view = view,
                                                scorePoins = scorePoins + 1,
                                                countRound = countRound + 1,
                                                randomAnt = randomNumber
                                            )
                                        }
                                    } else {
                                        view.snackBar(
                                            message = "Vc errou a resposta",
                                            colorText = Color.BLACK,
                                            colorBackground = Color.RED
                                        )
                                        viewLifecycleOwner.lifecycleScope.launch {
                                            oneRoundOfGame(
                                                bearerToken = bearerToken,
                                                view = view,
                                                scorePoins = scorePoins,
                                                countRound = countRound + 1,
                                                randomAnt = randomNumber
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        view.snackBar(
                            message = "Não foi possivel carregar as respostas",
                            colorText = Color.WHITE,
                            colorBackground = Color.BLACK
                        )
                    }
                }
            } else {
                view.snackBar(
                    message = "Não foi possivel carregar a pergunta",
                    colorText = Color.WHITE,
                    colorBackground = Color.BLACK
                )
            }
        }
    }

    fun View.snackBar(
        message: String,
        duration: Int = Snackbar.LENGTH_LONG,
        colorText: Int,
        colorBackground: Int
    ) {
        Snackbar.make(this, message, duration)
            .setTextColor(colorText)
            .setBackgroundTint(colorBackground)
            .show()
    }
}