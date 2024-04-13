<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="views/user/assets/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
<script crossorigin
	src="https://unpkg.com/react@17/umd/react.development.js"></script>
<script crossorigin
	src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"></script>
<script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>
<script src="views/user/index.js"></script>
<title>Trang chu</title>
</head>
<body class="container">
</body>

<script type="text/babel">

function App() {
  const { useState } = React;
  const { useEffect } = React;

  const [stateSignInInput,setStateSignInInput] = useState(false);
  const [signInAccount,setSignInAccount] = useState('');
  const [signInPassword,setSignInPassword] = useState('');
  const [stateSignUpInput,setStateSignUpInput] = useState(false);
  const [signUpAccount,setSignUpAccount] = useState('');
  const [signUpPassword,setSignUpPassword] = useState('');
  const [signUpPasswordConfirm,setSignUpPasswordConfirm] = useState('');

  useEffect(() => {
    checkSignInInput();
  },[signInAccount,signInPassword]);

  useEffect(() => {
    checkSignUpInput();
  },[signUpAccount,signUpPassword,signUpPasswordConfirm]);

  const checkSignInInput = () => {
    (signInAccount === '' || signInPassword === '') ? setStateSignInInput(false) : setStateSignInInput(true);
  }

  const checkSignUpInput = () => {
    (signUpAccount === '' || signUpPassword === '' || signUpPasswordConfirm === '') ? setStateSignUpInput(false): setStateSignUpInput(true);
  }

  const preventDefault = (event) => {
    event.preventDefault();
  }

  return (
    <div className="App">
      <header className='header'>
        <div className='header__logo'>
          <p className='header__logo-text'>Trevalokue</p>
          <i className="header__logo-img fas fa-hotel"></i>
        </div>
        <div className='header__sign'>
          <button className='header__sign-in header__sign-button'>Đăng nhập</button>
          <button className='header__sign-up header__sign-button'>Đăng kí</button>
        </div>
      </header>
      <section className='background-opacity dp-n'></section>
      <article className='sign dp-n'>
        <div className='sign-in sign-item dp-n'>
          <i class="sign-in__close sign-item__close fas fa-times"></i>
          <p className='sign-in__title sign-item__title'>Đăng nhập</p>
          <form action="" class="sign-in__form sign-item__form" method="">
            <input value={signInAccount} onChange={e => setSignInAccount(e.target.value) } type="text" className="sign-in__form-input sign-item__form-input" placeholder=" Nhập tài khoản" name=""/>
            <input value={signInPassword} onChange={e => setSignInPassword(e.target.value) } type="password" className="sign-in__form-input sign-item__form-input" placeholder=" Nhập mật khẩu" name=""/>
            <input onClick={e => stateSignInInput?"":preventDefault(e)} className={`sign-in__form-submit sign-item__form-submit ${stateSignInInput?"background-color-orange":""}`} type="submit" value="Đăng nhập"/>
          </form>
        </div>
        <div className='sign-up sign-item dp-n'>
          <i class="sign-up__close sign-item__close fas fa-times"></i>
          <p className='sign-up__title sign-item__title'>Đăng ký</p>
          <form action="" class="sign-up__form sign-item__form" method="">
            <input value={signUpAccount} onChange={e => setSignUpAccount(e.target.value) } type="text" class="sign-up__form-input sign-item__form-input" placeholder=" Nhập tài khoản" name=""/>
            <input value={signUpPassword} onChange={e => setSignUpPassword(e.target.value) } type="password" class="sign-up__form-input sign-item__form-input" placeholder=" Nhập mật khẩu" name=""/>
            <input value={signUpPasswordConfirm} onChange={e => setSignUpPasswordConfirm(e.target.value) } type="password" class="sign-up__form-input sign-item__form-input" placeholder=" Xác nhận lại mật khẩu" name=""/>
            <input onClick={e => stateSignUpInput?"":preventDefault(e)} class={`sign-up__form-submit sign-item__form-submit ${stateSignUpInput?"background-color-orange":""}`} type="submit" value="Đăng ký"/>
          </form>
        </div>
      </article>
    </div>
  );
}

ReactDOM.render(<App/>, document.querySelector('.container'));

</script>
</html>