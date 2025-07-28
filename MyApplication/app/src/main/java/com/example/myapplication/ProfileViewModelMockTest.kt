package com.example.myapplication
//
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.StandardTestDispatcher
//import kotlinx.coroutines.test.runTest
//import kotlinx.coroutines.test.setMain
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.mockito.kotlin.mock
//import org.mockito.kotlin.whenever
//
//@ExperimentalCoroutinesApi
//class ProfileViewModelMockTest {
//    @get:Rule
//val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    // Test dispatcher for coroutines
//    private val testDispatcher = StandardTestDispatcher()
//
//    // The mock repository and the ViewModel under test
//    private lateinit var mockRepository: ProfileRepository
//    private lateinit var viewModel: ProfileViewModel
//
//    @Before
//    fun setup() {
//        // Set the main dispatcher to our test dispatcher
//        Dispatchers.setMain(testDispatcher)
//
//        // Create the mock and the ViewModel before each test
//        mockRepository = mock()
//        viewModel = ProfileViewModel(mockRepository)
//    }
//
//    @Test
//    fun `fetchUpdatedUser uses repository and updates userName`() = runTest {
//        // Given: We tell our mock what to return when called
//        val fakeUserName = "Mocked User"
//        whenever(mockRepository.fetchUpdatedUserName()).thenReturn(fakeUserName)
//
//        // When: We call the function on the ViewModel
//        viewModel.fetchUpdatedUser()
//
//        // Then: Assert that the LiveData was updated with the mocked value
//        val result = viewModel.userName.value
//        assertEquals(fakeUserName, result)
//    }
//}