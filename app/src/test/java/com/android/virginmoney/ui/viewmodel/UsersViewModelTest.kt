package com.android.virginmoney.ui.viewmodel

import com.android.virginmoney.TestDispatcherProvider
import com.android.virginmoney.domain.usecase.GetUsersUseCase
import com.android.virginmoney.ui.screens.users.viewmodels.UsersUiState
import com.android.virginmoney.ui.screens.users.viewmodels.UsersViewModel
import com.android.virginmoney.utils.CoroutineTestRule
import com.android.virginmoney.utils.MockUtils
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class UsersViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var underTest: UsersViewModel

    private var dispatcherProvider = TestDispatcherProvider()

    @RelaxedMockK
    private lateinit var mockedGetUsersUseCase: GetUsersUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = UsersViewModel(
            getUsersUseCase = mockedGetUsersUseCase,
            dispatcherProvider = dispatcherProvider
        )
    }

    @Test
    fun `when get rooms is called, verify that the required data state is emitted`() = runTest {
        coEvery { mockedGetUsersUseCase.execute() } returns GetUsersUseCase.Data(null, listOf(MockUtils.createMockUser("1")))

        /* List to collect the results */
        val usersUiStates = mutableListOf<UsersUiState>()

        val job = launch(UnconfinedTestDispatcher()) {
            underTest.uiState.toList(usersUiStates)
        }

        // Assert
        Assert.assertTrue(usersUiStates.isNotEmpty())

        coVerify(exactly = 1) {
            mockedGetUsersUseCase.execute()
        }

        job.cancel()
    }
}
