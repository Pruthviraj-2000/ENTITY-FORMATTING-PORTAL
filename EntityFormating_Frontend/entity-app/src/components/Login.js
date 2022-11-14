import React, { useState,useEffect, useRef } from 'react'
import {useNavigate} from 'react-router-dom';
import axios from 'axios';

const Login = ({isAuthenticated, setIsAuthenticated}) => {
    const Loginref = useRef();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const navigate = useNavigate();
    function timeout(delay) {
        return new Promise( res => setTimeout(res, delay) );
      }
    // if(!isAuthenticated){
    //   navigate('/')
    // }
       const onSubmit = async (e) => {
        e.preventDefault();
    
        try {
          const response = await axios.post('http://localhost:8080/api/auth/signin', {email, password});
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
        setEmail('');
        setPassword('');
        setErrorMessage('');
        setMessage('Sign in successful');
        await timeout(1000);
        navigate('/homepage')
    }
    useEffect(() => {
        setMessage('')
      }, [email, password])
    
      const showMessage = () => {
        if(message === ''){
          return <div></div>
        }
        return <div className="alert alert-success" role="alert">
          {message}
        </div> 
      }
    
      const showErrorMessage = () => {
        if(errorMessage === ''){
          return <div></div>
        }
    
        return <div className="alert alert-danger" role="alert">
          {errorMessage}
        </div>
      }
  return (
  <section class="vh-100">
    {showErrorMessage}
    {showMessage}
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
          class="img-fluid" alt="Phone image"/>
      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
        <h1>Sign In.</h1>
        <br/>
        <form onSubmit={onSubmit}>
          {/* <!-- Email input --> */}
          <div class="form-outline mb-4">
            <input type="email" id="form1Example13" class="form-control form-control-lg"
            value={email} name='email' ref={Loginref} onChange={(e)=>setEmail(e.target.value)} required/>
            <label class="form-label" for="form1Example13">Email address</label>
          </div>

          {/* <!-- Password input --> */}
          <div class="form-outline mb-4">
            <input type="password" id="form1Example23" class="form-control form-control-lg"
            value={password} name='password' ref={Loginref} onChange={(e)=>setPassword(e.target.value)} required/>
            <label class="form-label" for="form1Example23">Password</label>
          </div>

          {/* <!-- Submit button --> */}
          <button type="submit" class="btn btn-primary btn-lg btn-block mb-3">Sign in</button>

          <div class="mb-4">
            {/*  */}
            <a href="#" style={{marginRight:"1em"}}>Not yet registered?</a>
            <a href='/' className='btn btn-outline-primary'>Sign Up</a>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>
  )
}

export default Login