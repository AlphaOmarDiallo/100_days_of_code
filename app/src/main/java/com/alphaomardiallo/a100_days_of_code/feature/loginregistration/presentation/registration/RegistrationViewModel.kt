package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.registration

import android.app.Activity
import com.alphaomardiallo.a100_days_of_code.common.domain.destination.BottomNavDestination
import com.alphaomardiallo.a100_days_of_code.common.presentation.base.BaseViewModel
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.destination.LoginRegistrationNavigationDestination
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.CreateUserWithPasswordAndEmailUseCase
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.SignInOrRegisterWithGithubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val createUserWithPasswordAndEmailUseCase: CreateUserWithPasswordAndEmailUseCase,
    private val signInOrRegisterWithGithubUseCase: SignInOrRegisterWithGithubUseCase,
) : BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // State
    ///////////////////////////////////////////////////////////////////////////

    private val _registrationState = MutableStateFlow(RegistrationUiState())
    val registrationState: StateFlow<RegistrationUiState> = _registrationState.asStateFlow()

    ///////////////////////////////////////////////////////////////////////////
    // Public functions
    ///////////////////////////////////////////////////////////////////////////

    fun createUserWithEmailAndPassword(email: String, password: String) {
        if (createUserWithPasswordAndEmailUseCase.invoke(email = email, password = password)){
            navigateTo(BottomNavDestination.Home.route)
        } else {
            Timber.w("message erreur")
        }

    }

    fun registerWithGithub(activity: Activity) {
        val result = signInOrRegisterWithGithubUseCase.invoke(activity = activity, ::navigateToApp)
        updateRegistrationState(result)
    }

    fun navigateToLoginScreen() = navigateTo(LoginRegistrationNavigationDestination.Login.route)

    ///////////////////////////////////////////////////////////////////////////
    // Private functions
    ///////////////////////////////////////////////////////////////////////////

    private fun updateRegistrationState(result: Boolean) {
        _registrationState.value = _registrationState.value.copy(isLoggedIn = result)
    }
}
