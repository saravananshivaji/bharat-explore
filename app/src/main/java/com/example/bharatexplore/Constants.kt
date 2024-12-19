package com.example.bharatexplore

import com.example.bharatexplore.R

object Constants {
    val USER_NAME: String = "user_name"
    val TOTAL_QUESTIONS: String = "total_questions"
    val SCORE: String = "score"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val questionOne = Question(
            1,
            "Which Indian festival is known as the \"Festival of Lights\"?",
            R.drawable.festival_of_lights,
            arrayListOf("Holi", "Diwali", "Pongal", "Eid"),
            1,
        )
        questionsList.add(questionOne)

        // 2
        val questionTwo = Question(
            2,
            "The harvest festival of Kerala is called",
            R.drawable.harvest,
            arrayListOf("Lohri", "Bihu",
            "Onam", "Makar Sankranti"),
            2
        )
        questionsList.add(questionTwo)

        // 3
        val questionThree = Question(
            3,
            "Bharatanatyam, a classical dance form, originated in which Indian state?",
            R.drawable.bharatham,
            arrayListOf("Karnataka", "Tamil Nadu",
            "Kerala", "Andhra Pradesh"),
            1
        )
        questionsList.add(questionThree)

        // 4
        val questionFour = Question(
            4,
            "\"Thirukkural,\" a celebrated Tamil literary work, was written by",
            R.drawable.tk,
            arrayListOf("Kambar", "Thiruvalluvar",
            "Avvaiyar", "Bharathiar"),
            1
        )
        questionsList.add(questionFour)

        // 5
        val questionFive = Question(
            5,
            "The Sun Temple, a UNESCO World Heritage Site, is located in",
            R.drawable.suntemple,
            arrayListOf("Rajasthan", "Gujarat",
            "Odisha", "Karnataka"),
            2
        )
        questionsList.add(questionFive)

        // 6
        val questionSix = Question(
            6,
            "Which Mughal emperor built the Taj Mahal?",
            R.drawable.tajmahal,
            arrayListOf("Akbar", "Shah Jahan",
            "Jahangir", "Aurangzeb"),
            1
        )

        questionsList.add(questionSix)

        // 7
        val questionSeven = Question(
            7,
            "Which of the following rivers is considered sacred in Indian culture?",
            R.drawable.river,
            arrayListOf("Ganga", "Yamuna",
            "Saraswati", "All of the above"),
            3
        )
        questionsList.add(questionSeven)

        // 8
        val questionEight = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            arrayListOf("Ireland", "Iran",
            "Hungary", "India"),
            3
        )
        questionsList.add(questionEight)

        // 9
        val questionNine = Question(
            9,
            "The Golden Temple, a sacred site for Sikhs, is located in",
            R.drawable.golden,
            arrayListOf("Amritsar", "Chandigarh",
            "Ludhiana", "Jalandhar"),
            0
        )
        questionsList.add(questionNine)

        // 10
        val questionTen = Question(
            10,
            "Banarasi sarees are traditionally made in which Indian state?",
            R.drawable.banarasi,
            arrayListOf("Rajasthan", "Uttar Pradesh",
            "Gujarat", "Maharashtra"),
            1
        )
        questionsList.add(questionTen)

        return questionsList
    }
}