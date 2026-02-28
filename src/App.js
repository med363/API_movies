import './App.css';
import api from './api/axiosConfig';
import { useState, useEffect } from 'react';
import Layout from './components/layout';
import {  Routes, Route } from 'react-router-dom';
import Home from './components/home/Home';
import Header from './components/header/header';
import Trailer from './components/trailer/Trailer';
function App() {
  const [movies, setMovies] = useState();

  const getMovies = async () => {
    try {
      const res = await api.get("/api/v1/movies");
      /*show console*/
      console.log(res.data);
      
      setMovies(res.data);
    } catch (err) {
      console.log(err);
    }
  }
  /*fct is executed when the component is mounted, it calls the getMovies function to fetch the movies data from the API and update the state with the retrieved data.*/
  useEffect(() => {
    getMovies();
  }, []);
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Layout />} >
          <Route path="/" element={<Home  movies={movies}/>} ></Route>
          <Route path="/trailer/:ytTrailerId" element={<Trailer />} ></Route>
        
        </Route>
      </Routes>
    </div>
  );
}

export default App;
