///////////////
////////////// sign-in sign up

const headerSignIn = document.querySelector('.header__sign-in');
const headerSignUp = document.querySelector('.header__sign-up');
const backgroundOpacity = document.querySelector('.background-opacity');
const sign = document.querySelector('.sign');
const signIn = document.querySelector('.sign-in');
const signUp = document.querySelector('.sign-up');
const signInClose = document.querySelector('.sign-in__close');
const signUpClose = document.querySelector('.sign-up__close');



headerSignIn.addEventListener('click',() => {
    backgroundOpacity.classList.remove('dp-n');
    setTimeout(() => {
        backgroundOpacity.style.opacity = 1;
    },0);

    sign.classList.remove('dp-n');
    sign.style.top = '100%';
    signIn.classList.remove('dp-n');

    setTimeout(() => {
        sign.style.top = '50%';
    });
});

signInClose.addEventListener('click',() => {
    sign.style.top = '120%';
    backgroundOpacity.style.opacity = 0;
    setTimeout(() => {
        backgroundOpacity.classList.add('dp-n');
    },400);
    setTimeout(() => {
        sign.classList.add('dp-n');
        signIn.classList.add('dp-n');
    },400);
});

headerSignUp.addEventListener('click',() => {
    backgroundOpacity.classList.remove('dp-n');
    setTimeout(() => {
        backgroundOpacity.style.opacity = 1;
    },0);

    sign.classList.remove('dp-n');
    sign.style.top = '100%';
    signUp.classList.remove('dp-n');

    setTimeout(() => {
        sign.style.top = '50%';
    });
});

signUpClose.addEventListener('click',() => {
    sign.style.top = '120%';
    backgroundOpacity.style.opacity = 0;
    setTimeout(() => {
        backgroundOpacity.classList.add('dp-n');
    },400);
    setTimeout(() => {
        sign.classList.add('dp-n');
        signUp.classList.add('dp-n');
    },400);
});

backgroundOpacity.addEventListener('click', () => {
    sign.style.top = '120%';
    backgroundOpacity.style.opacity = 0;
    setTimeout(() => {
        backgroundOpacity.classList.add('dp-n');
    },400);
    setTimeout(() => {
        sign.classList.add('dp-n');
        signIn.classList.add('dp-n');
        signUp.classList.add('dp-n');
    },400);
})

const signInFormInput = document.getElementsByClassName('sign-in__form-input');
const signInFormSubmit = document.querySelector('.sign-in__form-submit');
const signUpFormInput = document.getElementsByClassName('sign-up__form-input');
const signUpFormSubmit = document.querySelector('.sign-up__form-submit');

function addSignInPreventDefault(event){
    event.preventDefault();
}

function addSignUpPreventDefault(event){
    event.preventDefault();
}

/// preventDefault sign in

for(let j = 0; j < signInFormInput.length; ++j){
    if(signInFormInput[j].value === ""){
        signInFormSubmit.classList.remove('background-color-orange');
        signInFormSubmit.classList.remove('color-white');
        signInFormSubmit.addEventListener('click', addSignInPreventDefault);
        break;
    }
    if(j == signInFormInput.length - 1){
        signInFormSubmit.classList.add('background-color-orange');
        signInFormSubmit.classList.add('color-white');
        signInFormSubmit.removeEventListener('click', addSignInPreventDefault);
    }
}

for(let i = 0; i < signInFormInput.length; ++i){
    signInFormInput[i].addEventListener('input',() => {

        for(let j = 0; j < signInFormInput.length; ++j){
            if(signInFormInput[j].value === ""){
                signInFormSubmit.classList.remove('background-color-orange');
                signInFormSubmit.classList.remove('color-white');
                signInFormSubmit.addEventListener('click', addSignInPreventDefault);
                break;
            }
            if(j == signInFormInput.length - 1){
                signInFormSubmit.classList.add('background-color-orange');
                signInFormSubmit.classList.add('color-white');
                signInFormSubmit.removeEventListener('click', addSignInPreventDefault);
            }
        }
    })
}

/// preventDefault sign up

for(let j = 0; j < signUpFormInput.length; ++j){
    if(signUpFormInput[j].value === ""){
        signUpFormSubmit.classList.remove('background-color-orange');
        signUpFormSubmit.classList.remove('color-white');
        signUpFormSubmit.addEventListener('click', addSignUpPreventDefault);
        break;
    }
    if(j == signUpFormInput.length - 1){
        signUpFormSubmit.classList.add('background-color-orange');
        signUpFormSubmit.classList.add('color-white');
        signUpFormSubmit.removeEventListener('click', addSignUpPreventDefault);
    }
}

for(let i = 0; i < signUpFormInput.length; ++i){
    signUpFormInput[i].addEventListener('input',() => {
        for(let j = 0; j < signUpFormInput.length; ++j){
            if(signUpFormInput[j].value === "" || signUpFormInput[1].value !== signUpFormInput[2].value){
                signUpFormSubmit.classList.remove('background-color-orange');
                signUpFormSubmit.classList.remove('color-white');
                signUpFormSubmit.addEventListener('click', addSignUpPreventDefault);
                break;
            }
            if(j == signUpFormInput.length - 1 && signUpFormInput[1].value === signUpFormInput[2].value){
                signUpFormSubmit.classList.add('background-color-orange');
                signUpFormSubmit.classList.add('color-white');
                signUpFormSubmit.removeEventListener('click', addSignUpPreventDefault);
            }
        }
    })
}

function redirectToPageRooms(){
	window.location.href = "http://localhost:8080/javaWeb-hms-pbl3/rooms";
}

///////////////
//////////////