package com.mikhail.gosporttestquest.domain.interactors

import com.mikhail.gosporttestquest.data.repositories.MealRepository
import javax.inject.Inject

class MealInteractor @Inject constructor(
    private val mealRepository: MealRepository
) {
}