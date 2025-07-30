package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ProfileViewModelTest {

    // This rule swaps the background executor used by Architecture Components
    // with a different one which executes each task synchronously.
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `getWelcomeMessage formats name correctly`() {
        // Given: Create an instance of our ViewModel
        val viewModel = ProfileViewModel()
        val testName = "Shubham"

        // When: Call the function we want to test
        viewModel.updateUSer(testName)

        // Then: Assert that the LiveData value is what we expect
        val welcomeMessage = viewModel.welcomeMsg.value
        assertEquals("Welcome, Shubham!", welcomeMessage)
    }
}