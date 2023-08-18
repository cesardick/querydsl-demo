package com.example.querydsl4.dto

import com.example.querydsl4.entities.Gender

class PersonFilter(
        val name: String? = null,
        val gender: Gender? = null,
        val email: String? = null,
)
