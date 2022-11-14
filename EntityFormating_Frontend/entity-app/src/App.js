import { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import Signup from './components/Signup';
import Login from './components/Login';
import Homepage from './components/Homepage';
import Dashboard from './components/Dashboard';
function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    if(sessionStorage.getItem('token') !== null){
      setIsAuthenticated(true);
    }
  }, [])
  return (
  <Router>
    <Homepage/>
    <Routes>
      <Route path='/login' element={<Login isAuthenticated={isAuthenticated} setIsAuthenticated = {setIsAuthenticated}/>}/>
      <Route path='/' element = {<Signup isAuthenticated={isAuthenticated} setIsAuthenticated = {setIsAuthenticated}/>}/>
      <Route path='/homepage' element={<Dashboard isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated}/>}/>
    </Routes>
  </Router>
  );
}
export default App;
