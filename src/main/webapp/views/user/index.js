///////////////
////////////// sign-in sign up

setTimeout(() => {
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

},100);

///////////////
//////////////