package com.android.virginmoney.ui.viewmodel

import com.android.virginmoney.TestDispatcherProvider
import com.android.virginmoney.domain.usecase.GetRoomsUseCase
import com.android.virginmoney.ui.screens.rooms.viewmodels.RoomUiState
import com.android.virginmoney.ui.screens.rooms.viewmodels.RoomsViewModel
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
class RoomsViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var underTest: RoomsViewModel

    private var dispatcherProvider = TestDispatcherProvider()

    @RelaxedMockK
    private lateinit var mockedGetRoomsUseCase: GetRoomsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = RoomsViewModel(
            getRoomsUseCase = mockedGetRoomsUseCase,
            dispatcherProvider = dispatcherProvider
        )
    }

    @Test
    fun `when get rooms is called, verify that the required data state is emitted`() = runTest {
        coEvery { mockedGetRoomsUseCase.execute() } returns GetRoomsUseCase.Data(null, listOf(MockUtils.createMockRoom("1")))

        /* List to collect the results */
        val roomsUiStates = mutableListOf<RoomUiState>()

        val job = launch(UnconfinedTestDispatcher()) {
            underTest.uiState.toList(roomsUiStates)
        }

        // Assert
        Assert.assertTrue(roomsUiStates.isNotEmpty())

        coVerify(exactly = 1) {
            mockedGetRoomsUseCase.execute()
        }

        job.cancel()
    }
}
