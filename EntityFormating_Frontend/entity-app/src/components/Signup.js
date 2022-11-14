import React, { useState,useEffect, useRef } from 'react'
import axios from 'axios';
import {useNavigate} from 'react-router-dom';

const Signup = ({isAuthenticated, setIsAuthenticated}) => {
  const SignupRef = useRef();
  const [firstname, setFirstname] = useState('');
  const [lastname, setLastname] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
  const [repeatPassword, setRepeatPassword] = useState('');
  const [message, setMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  function timeout(delay) {
    return new Promise( res => setTimeout(res, delay) );
  }

	const onSubmit = async (e) => {
    e.preventDefault();
    if(password === repeatPassword){
    try {
      const response = await axios.post('http://localhost:8080/api/auth/signup', {firstname,lastname,email, password});
      sessionStorage.setItem('token', response.data.token);
      sessionStorage.setItem('email', response.data.email);
      setIsAuthenticated(true);
    } catch(error){
      setMessage('');
      if (error.response) {
        setErrorMessage(error.response.data.message);
      } else {
        setErrorMessage('Error: something happened');
      }
      setIsAuthenticated(false);
      return;
    }
}else{
    <div>password doesn't match, check again</div>
}
    
    setFirstname('');
    setLastname('');
    setEmail('');
    setPassword('');
    setRepeatPassword('');
    setErrorMessage('');
    setMessage('Sign up successful');
    await timeout(1000);
    navigate('/login')
  }
  useEffect(() => {
    setMessage('')
  }, [firstname,lastname,email, password])

  const showMessage = () => {
    if(message === ''){
      return <div></div>
    }
    console.log(message);
  }

  const showErrorMessage = () => {
    if(errorMessage === ''){
      return <div></div>
    }

    console.log(errorMessage)
  }
  return (
    <section class="vh-100">
        {showErrorMessage}
        {showMessage}
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style={{borderRadius:'25px'}}>
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                <form class="mx-1 mx-md-4" onSubmit={onSubmit}>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" ref={SignupRef} id="form3Examplec" class="form-control" name='firstname' value={firstname}  onChange={(e)=>setFirstname(e.target.value)} required/>
                      <label class="form-label" for="form3Examplec">First Name</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" name='lastname' ref={SignupRef} class="form-control" value={lastname}
                      onChange={(e)=>setLastname(e.target.value)} required/>
                      <label class="form-label" for="form3Example1c">Last Name</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                      <input type="email" id="form3Example3c" class="form-control" value={email}
                      name='email' ref={SignupRef} onChange={(e)=>setEmail(e.target.value)} required/>
                      <label class="form-label" for="form3Example3c">Email</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                      <input type="password" id="form3Example4c" class="form-control" value={password}
                       name='password' ref={SignupRef} onChange={(e)=>setPassword(e.target.value)} required/>
                      <label class="form-label" for="form3Example4c">Password</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                      <input type="password" id="form3Example4cd" class="form-control" value={repeatPassword}
                      ref={SignupRef} onChange={(e)=>setRepeatPassword(e.target.value)}/>
                      <label class="form-label" for="form3Example4cd">Repeat your password</label>
                    </div>
                  </div>

                  <div class="form-check d-flex justify-content-center mb-5">
                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                    <label class="form-check-label" for="form2Example3">
                      I agree all statements in <a href="#!">Terms of service</a>
                    </label>
                  </div>

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" class="btn btn-primary btn-lg">Register</button>
                  </div>
                  <div class="mb-4">
                  {/*  */}
                    <a href="#" style={{marginRight:"1em"}}>Already registered?</a>
                    <a href='/login' className='btn btn-outline-primary'>Log in</a>
                  </div>

                </form>

              </div>
              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                  class="img-fluid" alt="Sample image"/>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
  )
}

export default Signup