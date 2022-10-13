package com.android.virginmoney.domain.usecase

import com.android.virginmoney.data.repository.local.LocalRepository
import com.android.virginmoney.data.repository.remote.RemoteRepository
import com.android.virginmoney.domain.mapper.RoomMapper
import com.android.virginmoney.utils.ApiResult
import com.android.virginmoney.utils.MockUtils
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class GetRoomsUseCaseTest {

    private lateinit var underTest: GetRoomsUseCase

    @MockK
    private lateinit var localRepository: LocalRepository

    @MockK
    private lateinit var remoteRepository: RemoteRepository

    private val mapper = RoomMapper()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = GetRoomsUseCase(
            localRepository = localRepository,
            remoteRepository = remoteRepository,
            roomMapper = mapper
        )
    }

    @Test
    fun `given when remoteRepository getRooms is successful, then the required methods should be executed `() = runTest {
        coEvery { remoteRepository.getRooms() } returns ApiResult.Success(mockk(relaxed = true))
        coEvery { localRepository.insertRooms(any()) } returns Unit

        val actual = underTest.execute()
        coVerify {
            remoteRepository.getRooms()
        }
        coVerify {
            localRepository.insertRooms(any())
        }
        coVerify(exactly = 0) {
            localRepository.getRooms()
        }
        assertEquals(null, actual.errorMessage)
        assertNotEquals(null, actual.data)
    }

    @Test
    fun `given when remoteRepository getRooms is not successful and localRepository is not empty, then the required methods should be executed `() = runTest {
        val errorMessage = "An error occurred"
        val mockedRoom1 = MockUtils.createMockRoomEntity("1")
        val mockedRoom2 = MockUtils.createMockRoomEntity("2")

        coEvery { remoteRepository.getRooms() } returns ApiResult.NetworkError(Exception(errorMessage))
        coEvery { localRepository.getRooms() } returns listOf(mockedRoom1, mockedRoom2)

        val actual = underTest.execute()
        coVerify {
            remoteRepository.getRooms()
        }
        coVerify(exactly = 0) {
            localRepository.insertRooms(any())
        }
        coVerify() {
            localRepository.getRooms()
        }
        assertEquals(errorMessage, actual.errorMessage)
        assertEquals(2, actual.data?.size)
    }

    @Test
    fun `given when remoteRepository getRooms is not successful and localRepository is empty, then the required methods should be executed `() = runTest {
        val errorMessage = "An error occurred"

        coEvery { remoteRepository.getRooms() } returns ApiResult.NetworkError(Exception(errorMessage))
        coEvery { localRepository.getRooms() } returns listOf()

        val actual = underTest.execute()
        coVerify {
            remoteRepository.getRooms()
        }
        coVerify(exactly = 0) {
            localRepository.insertRooms(any())
        }
        coVerify() {
            localRepository.getRooms()
        }
        assertEquals(errorMessage, actual.errorMessage)
        assertEquals(0, actual.data?.size)
    }
}
