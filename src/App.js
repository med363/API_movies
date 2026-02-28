import './App.css';
import api from './api/axiosConfig';
import { useState, useEffect } from 'react';
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
<h1>Welcome to my React App!</h1>
    </div>
  );
}

export default App;
