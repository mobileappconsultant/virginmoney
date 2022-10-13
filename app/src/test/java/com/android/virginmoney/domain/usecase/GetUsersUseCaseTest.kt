package com.android.virginmoney.domain.usecase

import com.android.virginmoney.data.repository.local.LocalRepository
import com.android.virginmoney.data.repository.remote.RemoteRepository
import com.android.virginmoney.domain.mapper.UserMapper
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

class GetUsersUseCaseTest {

    private lateinit var underTest: GetUsersUseCase

    @MockK
    private lateinit var localRepository: LocalRepository

    @MockK
    private lateinit var remoteRepository: RemoteRepository

    private val mapper = UserMapper()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = GetUsersUseCase(
            localRepository = localRepository,
            remoteRepository = remoteRepository,
            userMapper = mapper
        )
    }

    @Test
    fun `given when remoteRepository getUsers is successful, then the required methods should be executed `() = runTest {
        coEvery { remoteRepository.getUsers() } returns ApiResult.Success(mockk(relaxed = true))
        coEvery { localRepository.insertUsers(any()) } returns Unit

        val actual = underTest.execute()
        coVerify {
            remoteRepository.getUsers()
        }
        coVerify {
            localRepository.insertUsers(any())
        }
        coVerify(exactly = 0) {
            localRepository.getUsers()
        }
        assertEquals(null, actual.errorMessage)
        assertNotEquals(null, actual.data)
    }

    @Test
    fun `given when remoteRepository getUsers is not successful and localRepository is not empty, then the required methods should be executed `() = runTest {
        val errorMessage = "An error occurred"
        val mockedUser1 = MockUtils.createMockUserEntity("1")
        val mockedUser2 = MockUtils.createMockUserEntity("2")

        coEvery { remoteRepository.getUsers() } returns ApiResult.NetworkError(Exception(errorMessage))
        coEvery { localRepository.getUsers() } returns listOf(mockedUser1, mockedUser2)

        val actual = underTest.execute()
        coVerify {
            remoteRepository.getUsers()
        }
        coVerify(exactly = 0) {
            localRepository.insertUsers(any())
        }
        coVerify {
            localRepository.getUsers()
        }
        assertEquals(errorMessage, actual.errorMessage)
        assertEquals(2, actual.data?.size)
    }

    @Test
    fun `given when remoteRepository getUsers is not successful and localRepository is empty, then the required methods should be executed `() = runTest {
        val errorMessage = "An error occurred"

        coEvery { remoteRepository.getUsers() } returns ApiResult.NetworkError(Exception(errorMessage))
        coEvery { localRepository.getUsers() } returns listOf()

        val actual = underTest.execute()
        coVerify {
            remoteRepository.getUsers()
        }
        coVerify(exactly = 0) {
            localRepository.insertUsers(any())
        }
        coVerify() {
            localRepository.getUsers()
        }
        assertEquals(errorMessage, actual.errorMessage)
        assertEquals(0, actual.data?.size)
    }
}
